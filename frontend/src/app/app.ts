import { CommonModule } from '@angular/common';
import { Component, DestroyRef, inject, signal } from '@angular/core';

type CellType = 'limite' | 'vazio' | 'fabrica' | 'carro' | 'caminhao' | 'moto';

interface EstadoSimulacao {
  ciclo: number;
  emExecucao: boolean;
  linhas: number;
  colunas: number;
  grade: CellType[][];
  estatisticas: {
    carros: number;
    caminhoes: number;
    motos: number;
    total: number;
  };
  veiculos: {
    tipo: 'carro' | 'caminhao' | 'moto';
    x: number;
    y: number;
    velocidade: number;
    cor: string;
    gerouEmFabrica: boolean;
  }[];
}

@Component({
  selector: 'app-root',
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  readonly refreshInterval = 500;
  readonly legendItems = [
    { type: 'carro', label: 'Carro', description: 'Move com velocidade 2 e remove motos em colisao.' },
    { type: 'caminhao', label: 'Caminhao', description: 'Sobrevive contra carros e motos em colisao.' },
    { type: 'moto', label: 'Moto', description: 'Veiculo mais veloz, com deslocamento 3.' },
    { type: 'fabrica', label: 'Fabrica', description: 'Gera um novo veiculo ao ser atravessada.' },
    { type: 'limite', label: 'Limite', description: 'Borda fixa do mapa.' }
  ] as const;

  private readonly apiBaseUrl = 'http://localhost:8080/api';
  private readonly destroyRef = inject(DestroyRef);
  private pollHandle: number | undefined;

  readonly state = signal<EstadoSimulacao | null>(null);
  readonly errorMessage = signal('');
  readonly isBusy = signal(false);

  constructor() {
    this.loadState();
    this.pollHandle = window.setInterval(() => this.loadState(false), this.refreshInterval);
    this.destroyRef.onDestroy(() => {
      if (this.pollHandle !== undefined) {
        window.clearInterval(this.pollHandle);
      }
    });
  }

  async loadState(markBusy = true): Promise<void> {
    await this.request('/state', 'GET', markBusy);
  }

  async pause(): Promise<void> {
    await this.request('/pause', 'POST');
  }

  async resume(): Promise<void> {
    await this.request('/resume', 'POST');
  }

  async step(): Promise<void> {
    await this.request('/step', 'POST');
  }

  async reset(): Promise<void> {
    await this.request('/reset', 'POST');
  }

  cellSymbol(type: CellType): string {
    switch (type) {
      case 'limite':
        return '#';
      case 'fabrica':
        return 'F';
      case 'carro':
        return 'C';
      case 'caminhao':
        return 'T';
      case 'moto':
        return 'M';
      default:
        return '';
    }
  }

  private async request(path: string, method: 'GET' | 'POST', markBusy = true): Promise<void> {
    if (markBusy) {
      this.isBusy.set(true);
    }

    try {
      const response = await fetch(`${this.apiBaseUrl}${path}`, {
        method,
        headers: {
          'Content-Type': 'application/json'
        }
      });

      if (!response.ok) {
        throw new Error(`Resposta inesperada do servidor: ${response.status}`);
      }

      const payload = (await response.json()) as EstadoSimulacao;
      this.state.set(payload);
      this.errorMessage.set('');
    } catch (error) {
      const message = error instanceof Error ? error.message : 'Falha desconhecida ao carregar a simulacao.';
      this.errorMessage.set(message);
    } finally {
      if (markBusy) {
        this.isBusy.set(false);
      }
    }
  }
}

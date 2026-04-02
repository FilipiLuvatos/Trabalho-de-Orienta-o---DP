package trabalho;

import java.util.List;

public final class JsonUtil {

    private JsonUtil() {
    }

    public static String paraJson(EstadoSimulacao estado) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"ciclo\":").append(estado.ciclo()).append(",");
        json.append("\"emExecucao\":").append(estado.emExecucao()).append(",");
        json.append("\"linhas\":").append(estado.linhas()).append(",");
        json.append("\"colunas\":").append(estado.colunas()).append(",");
        json.append("\"grade\":").append(gradeParaJson(estado.grade())).append(",");
        json.append("\"estatisticas\":").append(estatisticasParaJson(estado.estatisticas())).append(",");
        json.append("\"veiculos\":").append(veiculosParaJson(estado.veiculos()));
        json.append("}");
        return json.toString();
    }

    private static String gradeParaJson(String[][] grade) {
        StringBuilder json = new StringBuilder("[");

        for (int i = 0; i < grade.length; i++) {
            if (i > 0) {
                json.append(",");
            }
            json.append("[");
            for (int j = 0; j < grade[i].length; j++) {
                if (j > 0) {
                    json.append(",");
                }
                json.append(texto(grade[i][j]));
            }
            json.append("]");
        }

        json.append("]");
        return json.toString();
    }

    private static String estatisticasParaJson(EstatisticasSimulacao estatisticas) {
        return "{"
            + "\"carros\":" + estatisticas.carros() + ","
            + "\"caminhoes\":" + estatisticas.caminhoes() + ","
            + "\"motos\":" + estatisticas.motos() + ","
            + "\"total\":" + estatisticas.total()
            + "}";
    }

    private static String veiculosParaJson(List<VeiculoSnapshot> veiculos) {
        StringBuilder json = new StringBuilder("[");

        for (int i = 0; i < veiculos.size(); i++) {
            if (i > 0) {
                json.append(",");
            }

            VeiculoSnapshot veiculo = veiculos.get(i);
            json.append("{");
            json.append("\"tipo\":").append(texto(veiculo.tipo())).append(",");
            json.append("\"x\":").append(veiculo.x()).append(",");
            json.append("\"y\":").append(veiculo.y()).append(",");
            json.append("\"velocidade\":").append(veiculo.velocidade()).append(",");
            json.append("\"cor\":").append(texto(veiculo.cor())).append(",");
            json.append("\"gerouEmFabrica\":").append(veiculo.gerouEmFabrica());
            json.append("}");
        }

        json.append("]");
        return json.toString();
    }

    private static String texto(String valor) {
        if (valor == null) {
            return "null";
        }

        String escapado = valor
            .replace("\\", "\\\\")
            .replace("\"", "\\\"");

        return "\"" + escapado + "\"";
    }
}

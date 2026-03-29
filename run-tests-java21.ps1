$ErrorActionPreference = 'Stop'

$projectRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$jdkHome = Join-Path $env:USERPROFILE '.jdks\ms-21.0.10'
$javac = Join-Path $jdkHome 'bin\javac.exe'
$java = Join-Path $jdkHome 'bin\java.exe'
$buildDir = Join-Path $projectRoot 'build\classes'

if (!(Test-Path $javac) -or !(Test-Path $java)) {
    throw "JDK 21 nao encontrado em $jdkHome"
}

[Console]::OutputEncoding = [System.Text.UTF8Encoding]::new()
$env:JAVA_HOME = $jdkHome
$env:PATH = "$($jdkHome)\bin;$env:PATH"

New-Item -ItemType Directory -Force $buildDir | Out-Null

$sources = Get-ChildItem (Join-Path $projectRoot 'src\trabalho\*.java') | ForEach-Object { $_.FullName }
& $javac -encoding UTF-8 -d $buildDir $sources
if ($LASTEXITCODE -ne 0) {
    throw "Falha na compilacao."
}

& $java '-Dfile.encoding=UTF-8' -cp $buildDir trabalho.SimulacaoTest

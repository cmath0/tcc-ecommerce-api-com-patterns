@echo off
setlocal enabledelayedexpansion

REM Caminho base das classes compiladas (pasta onde começa a árvore a percorrer)
set BASE_PATH=C:\repositorio\ecommerce-api-com-patterns\target\classes\com\github\cmath0\ecommerce

REM Caminho do JAR da ferramenta CKJM e da pasta target\classes para o classpath
set CKJM_JAR=C:\repositorio\ecommerce-api-com-patterns\tools\ckjm_ext.jar
set TARGET_CLASSES=C:\repositorio\ecommerce-api-com-patterns\target\classes

echo Executando MetricsFilter para cada pasta que contenha arquivos .class em:
echo %BASE_PATH%
echo.

REM Percorre recursivamente todas as subpastas a partir de BASE_PATH
for /d /r "%BASE_PATH%" %%D in (*) do (
    REM Verifica se a pasta atual possui arquivos .class
    if exist "%%D\*.class" (
        echo Analisando pasta: %%D
        java -cp "%CKJM_JAR%;%TARGET_CLASSES%" gr.spinellis.ckjm.MetricsFilter -x "%%D\*.class"
    )
)

echo.
echo ====== Finalizado! ======
pause

```bat
@echo off
setlocal enabledelayedexpansion

REM Caminho base das classes compiladas
set BASE_PATH=C:\repositorio\ecommerce-api-com-patterns\target\classes\com\github\cmath0\ecommerce

REM Caminho da ferramenta CKJM
set CKJM_JAR=C:\repositorio\ecommerce-api-com-patterns\tools\ckjm_ext.jar

echo Executando CKJM para todos os arquivos .class em %BASE_PATH% ...

for /r "%BASE_PATH%" %%f in (*.class) do (
    echo Analisando: %%f
    java -jar "%CKJM_JAR%" -x "%%f"
)

echo.
echo ====== Finalizado! ======
pause
```

SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_201\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd E:\LENOVO-PC\Documents\NetBeansProjects\Compi 1\Proyecto1Compiladores1\src\analizador\guardar
java -jar C:\Users\LENOVO-PC\Downloads\java-cup-11a.jar -parser AnalizadorSintacticoG -symbols SimbolosG parserG.cup
pause


# PeriferiaIT Group
Marco controlado por palabras clave con Selenium + Java + TestNG.
Función de informes utilizando informes de extensión.
Tomar capturas de pantalla en casos de prueba fallidos y también al especificar el paso de prueba.

#Components

1. Driver class - clase principal para ejecutar el proyecto como una aplicación Java

2. TestSuites/FirstTestSuites.xls - Archivo de caso de prueba con cuatro columnas

    - Keyword (Acción a realizar)
    - identificador (Tipo de localizador)
    - Locator (Localizador de objetos)
    - Input Data - Datos de prueba
    
    
3. TestMethods class - Una biblioteca de palabras clave que contiene todos los métodos que se ejecutarán contra la palabra clave respectiva.

4. KeywordExecutor Class - Esta clase tomará la palabra clave como argumento y ejecutará el método de prueba respectivo.

5. Utility - Este paquete contiene todos los archivos de clase de utilidad necesarios.

6. Report Generator - Esta clase se usará para leer datos en cada paso y generar informes en consecuencia.  

    
Para usar este marco, edite el archivo FirstSuite.xls, proporcione el nombre del navegador en el cual se iniciara y la URL en el segundo paso e iniciará en el navegador proporcionado.

#Prerequisitos

1. Java version: 11.0.6

2. Apache Maven 3.6.3


#Ejecución

1. Abrir el archivo FirstSuite.xls

2. En la parte inferior encontrara una Hoja llamada Keywords la cual contiene los tipos de keyword, identificadores y inputData de navegadores que se deben usar.

3. En la hoja principal en primera columna llamada keyword debajo empezara ingresando OpenBrowser, ahora en la fila correspondiente pero en la columna inputData ingresara el navegador.

4. Ahora ingresara en la columna de keyword de manera secuencial bajo OpenBrowser, ingresar OpenWebSite y en la fila correspondiente en la columna inputData la URL del sitio web.

5. Con los keyword click y EnterText podra empezar a realizar en secuencia las acciones que realizara el test.

6. https://teams.microsoft.com/meet/23297022523709?p=78TqD9Dh8zwcLHITZE

7. Dentro de la columna inputData se ingresara la el texto que deba digitar las keyword EnterText.

8. Una vez finalizada se ejecutara un cmd dentro de la carpeta del framework y digitara mvn clean test para que el test se ejecute.

9. Al finalizarse el test dentro de la carpeta Reports se encontra un html el cual nos mostrara el resultado del test ejecutado.

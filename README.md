# Spring OAuth2 Custom Authorization Server Repository
This custom authorization repository uses authorization code flow.

## Guide to build and run
### build and run on Mac, Windows, Linux
* Need Java 17 or above to be installed in the device.
* Navigate to root directory of the repository eg:- oauth-spring-security.
* To build use: **mvn clean install**
* This command will create an executable jar file in the /target directory.
* To run the jar file use: **java -jar jar-filename-0.0.1.jar** 

## allowed origins:
* http://localhost:4200

## redirected-uri:
* http://127.0.0.1:8080/login/oauth2/code/client

## post logout redirected uri:
* http://127.0.0.1:8080/

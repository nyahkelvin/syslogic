## syslogic

Deploying the the application requires the following

- Database script must be run against a MYSQL instance.
- change database connection URL and login credentials to match existing configuration

Then run commands in this order from your terminal or command prompt

1. cd path/to/cloned/project
2. mvn clean install (to download all dependencies and create artefact)
3. cd to path/to/target directory
4. java -jar SystemicBoot-1.0.jar

use curl or any REST client such as Postman to test functionality (url and server port defaults found in application.properties file )

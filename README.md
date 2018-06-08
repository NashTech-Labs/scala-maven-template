# Scala maven template with Akka Http, Macwire, Slick and DynamocDB

## Steps to Application Execution

- Clone the project.
- Go to project home directory
- Execute command: `$ mvn scala:run`

## Make executeable jar

- Go to project home directory
- Execute command: `$ mvn clean package`
- Go to target folder
- Execute command: `$ java -jar scala-maven-template-1.0-SNAPSHOT-executable.jar`

## Commands for execute quality tools

- `$ mvn scala:compile`     **// Compile Scala Code**
- `$ mvn test`              **// Execute unit test cases**
- `$ mvn scoverage:report`  **// Scala test cases coverage report**
- `$ mvn scalastyle:check`  **// Execute scala style in our code**

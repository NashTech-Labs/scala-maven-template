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

## PREREQUISITE
- export AWS_ACCESS_KEY_ID=your_access_key_id
- export AWS_SECRET_ACCESS_KEY=your_secret_access_key

## COMMANDS

- `mvn clean test` for unit test
- `mvn clean test -Pintegration-test` for integration test

## Tables in DynamoDB

- `Employees` with name as primary key & id and sort key
- `asyncItems` with id as primary key

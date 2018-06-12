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
Make sure you have export *Access key* and *Secret key* before running the test cases. You can use any dummu/fake keys for testing purpose.
- export AWS_ACCESS_KEY_ID=your_access_key_id
- export AWS_SECRET_ACCESS_KEY=your_secret_access_key

## COMMANDS
- `mvn clean compile` for compilation
- `mvn clean test` for unit test
- `mvn clean test -Pintegration-test` for integration test

## Tables in DynamoDB

- `Employees` with name as partition key & id and sort key.
- `asyncItems` with id as partition key.

## References
##### -  [Scanamo Documentation](https://www.scanamo.org/)
##### -  [Blog on Querying DynamoDB from Scala](https://www.beyondthelines.net/databases/querying-dynamodb-from-scala/)
##### -  [Alpakka](https://developer.lightbend.com/docs/alpakka/current/dynamodb.html)
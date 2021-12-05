# Sample Kafka Producer/Consumer project

## Project Highlights
* Connects to local MySQL when ran in local
* Connects to in memory h2 database for test
* Containerized with logs mapped to local drive
* Connects to MySql Container when ran as a docker container
* Kafka producer produces JSON Message and Consumer consumes the message from kafka topic
* The Producer, Consumer can be run on local and in docker using the Docker Compose
* The Kafka Broker can be run local and in docker
* When run in local Producer and Consumer uses the kafka boostrap server configured in application.yaml
* When run in docker the bootstrap server provided in docker-compose.yaml file is used
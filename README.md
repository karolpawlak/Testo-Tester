# Testo Tester
A troubleshooting swiss-army knife application

---

## Installation
If you download the project, each microservice can be ran locally in the IDE or with the following command:
```
./mvnw clean spring-boot:run
```

To deploy it in the cloud, compile the code and package it to a JAR file using Maven wrapper:
```
./mvnw clean package
```
This will add the JAR file to the **target** folder, which can then be used to create a container or directly push it to Cloud Foundry. The `clean` option will delete the previously created **target** folder.

You can also compile and package the code, and also put it in your local repository so that other projects can refer to it. This can be done using the following command which will place all the needed components (dependencies) in a directory called **.m2** uder the user's folder.
```
./mvnw clean install
```
More information on Maven's application build lifecycle [here](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

Note. If you have Maven CLI installed on your local machine, the `./mvnw` can be substituted for `mvn`.

# Testo Tester
A troubleshooting swiss-army knife application

---

## Installation
If you download the project, each microservice can be ran locally in the IDE or with the following command:
```
./mvnw clean spring-boot:run
```

In order to deploy the app in the cloud, the code must be compiled and packaged to a JAR file using Maven wrapper:
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

## Selecting a profile
A Spring profile should be activated to choose the database provider that the application should use. The profile is selected by setting the system property `spring.profiles.active` when starting the app. By default, the application will start with `in-memory` profile. 

This property can be set programatically in the `application.properties` file or specified in Cloud Foundry deployment manifest `manifest.yml` in the format `spring.profiles.active=<PROFILE>` where `<PROFILE>` is one of the following available profiles:

* `in-memory` (no external database required)
* `mysql`
* `postgres`
* `redis`

## Cloud Foundry deployment
Prerequisites:
* [Command-Line Interface for Cloud Foundry](http://docs.cloudfoundry.org/cf-cli/)

Using the `cf push` command, the application will be pushed using settings in the provided `manifest.yml` file. The output from the command will show the URL that has been assigned to the application.


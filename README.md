# Java-Example
Java backend with react frontend.

## Setup

This project uses Maven for dependencies and will need to restore those before you can build it.

The Java section of the project contains a Test and an Application configuration. 

In order to run the unit tests, select the Test config and run or debug the application
In order to run the app, toggle the config to 'ExampleApplication' and run the application

### Client side
Navigate to the src/main/js/app/ folder in the project

To download needed dependencies, use the 'npm install' command.
Then, use 'npm run start' or 'npm run test' respectively. 
The application can be accessed on localhost:8080

The database is an in memory database (H2). I've decided to use this since it requires no installation or configuration of a separate database. The drawback is that you need to empty it yourself, since it will remember state between runs and there is no "delete" row in the user interface.

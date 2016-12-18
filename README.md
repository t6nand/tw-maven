# tw-maven
This is a simple maven java application which fetches tweets using [Twitter API](https://dev.twitter.com/docs) that have been retweeted atleast once and contains hashtag #custserv. 

# Setting Up.

1. Setting up maven 
    * [Install Maven](http://maven.apache.org/install.html). 
2. Clone [tw-maven git](https://github.com/t6nand/tw-maven) repository.
3. Set up a twitter app [here](https://apps.twitter.com/).
4. Create Oauth Access Token and Access Token Secret as they are needed for authenticating application.
5. Locate twitterconfiguration.properties file at src/main/resources/ location with structure as follows: 

```
oauth.consumerKey=
oauth.consumerSecret=
oauth.accessToken=
oauth.accessTokenSecret=
```

6. Enter details of consumerKey, consumerSecret, accessToken and accessTokenSecret generated in Step 4 in this file. 
7. Run :
    `mvn clean install`
    
    to install all dependencies. This step may take time when running for the first time.
    
8. Finally use deploy script provided at root folder of project by using your favourite shell. 
    For example in bash : `bash deploy.sh`
    If deploy script is not executable, do so by : `chmod +x deploy.sh`
    
9. Let the project load and interact with CLI to view tweets as per options provided. 

# Code Structure 
This is a maven java cli application with directory layout and code structure as:

```
|tw-maven(root)
|_src
|    |_main
|        |_java (All java classes goes here)
|             |_managers (Twitter oauth manager and search manager classes)
|             |        |_TWAuth.java
|             |        |_TWCustServ.java     
|             |_twconstants (Class to load configuraton)
|             |        |_LoadTwitterConfig.java
|             |
|             |_resources (All resource and application specific conf files goes here)
|             |        |_twitterconfig.properties
|             |
|             |_Main.java (Main class. Application starting point).
|
|_deploy.sh (Shell script to auto build and execute this maven project).
|_pom.xml (Maven application config file. Lists all plugins and dependencies required and assigns artifactID to project if     |         needed to be deployed on [central maven repository](http://search.maven.org/).
|_README.md (Application readme file.)
```
             
Refer to javaDocs in each class for details about how code works. 

# Executing/Deploying application. 
On linux based systems, deploy.sh can be executed to auto build and execute application. Otherwise, following command can be used to clean build and execute application :

`mvn clean install exec:java -Dexec.mainClass="Main" -q`

-q flag here is used to supress maven build logs. Only error logs are displayed if any. This will start the application which should produce results similar to as following: 

![alt tag](https://raw.githubusercontent.com/t6nand/tw-maven/master/src/main/resources/screen_shot_result.png)

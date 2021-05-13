# Philip_Sephton_Assessment_2
Pokemon CRUD application

This CRUD application is an application to assist with sorting pokemon inside a database. This application can help you manage your pokemon and compare the statistics of the pokemon you have. 

## Getting Started

To get a copy of the application working on your machine you will need windows 7 or higher, MySQL workbench and server installed and a copy of java installed, as well as an internet browser.

### Prerequisites

To get a copy of Java please visit https://java.com/en/download/help/windows_manual_download.html, and click on the download, then run the installer after the download is finished, it should install itself you just need to verify that everything on the page is good by clicking next until its installed.
To get a copy of MySQL please visit https://dev.mysql.com/downloads/workbench/, and click on the download link, it will ask you to sign in but you can just start the download straight away by clicking no thanks, just start my download,
after the download has finished you will have to run the application, you should then be prompted to choose installation type in shich you should click on Developer Default and press next,
complete the installation process by following the instructions making sure to install both MySQL Server and MySQL Workbench, if you configured MySQL as a service it will Automatically start whenever you system loads.
Now you need to add MySQL to environment variables, navigate to where you installed MySQL in either program files or program files (x86) depending on the version you installed, and cdomplete the path to MySQL server <ver>, then bin,
to find the mysql.exe file, make a note of where it is then go on to system properties, click on advanced settings, at the bottom of the window please click on environment variable, Select path environment variable and click edit,
please enter the vaiable name of Path and write the route to your mysql.exe file that you previously looked at.
Now enter the command prompt and enter "mysql --version", if the installation was sucessful you should be notified of a variable, if it was unsucessful try redoing the environmental variable section.

### Installing

A step by step series of examples that tell you how to get a development env running ECLIPSE AND MYSQL INSTALLATION
First you will need a copy of Eclipse to run all the tests:
Download the eclipse installer from  http://www.eclipse.org/downloads,
After the file has been download please run it, giving it permissions to run,
Then select the package to install, this will be Eclipse IDE for Java Developers,
Select where you would like to install it,
After this you will be able to launch Eclipse,
When eclipse loads up click on File-->Open Projects from File System and navigate to Assessment_2 and click open,
you should now be able to navigate through the whole project.


Secondly you will have to open up MySQL workbench and create a new schema,
on MySQL workbench navigate to the home screen and press the '+' icon next to MySQL Connections,
Call the Connection Name 'pokemon', set the connection method to Standard(TCP/IP), Keep the hostname at '127.0.01' and port '3306', username: 'root', password: 'root',
Press test connection, if everything apears ok click on ok, double click on the new Connection you have created to access it,
you will then have to create a new schema by clicking on the icon that looks like 2 cylindrical prisms on top of each other with a plus,
Call this new Schema `pokemon`.
You will then have to navigate to the project and you should be able to run the project if this fails stop the application and replace `prod` after "spring.profiles.active="
in `application.properties` to `create`, then run the application as a sprong boot project, you will then have to change it back to `prod` as your databases will be built.

When your application is running you can then go on your chosen internet browser and type in, `http://127.0.0.1:8080/index.html`, there you should be able to see the website.
You do not need an internet connection for this as it is locally instantiated.

You can now run your application and create a Pokemon then read it on the web page, whatever you create will then be saved to your database until you delete it with the function on the website.

## Running the tests

All the tests for this system are in the src/test/java file system, this mirrors the src/main/java filesystem, in its directories so that unit tests and integration tests for a particular class can be easily located and accessed. 

### Unit Tests 
All the unit tests test a particular functionality in the code in the service, I have done this because then its much easier to identify bugs that may be apparant in the code at the smallest level, which finds bugs early,
improves the quality of code, aids in debugging and makes the whole process agile.
I have also used mockito in the controller tests to mock functionality that the user inputs.


### Integration Tests
All the integration tests test how the controller acts with the repo to ensure full functionality, I have done this as it will help me in troubleshooting the controller and repo and to help me identify any bugs that may be apparant.

### Selenium Tests
The selenium tests verify full functionality of the front end application, to run them you have to find the right driver for your browser on `https://www.selenium.dev/documentation/en/webdriver/driver_requirements/` and download the driver, the driver that i have included is for google chrome version 90.0.4430.xxx, after you have downloaded your driver replace it with the current driver, i would reccommend chrome for this. You can then run as Junit test and it should successfully run.

## Jira
Link to my jira boards: https://philipsephton-qa.atlassian.net/jira/software/projects/A2/boards/4/backlog

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
Java 11
JUnit 5
Sql worbench 8.0
Spring Boot - https://spring.io/projects/spring-boot
Bootstrap - https://getbootstrap.com/

## Versioning

Version 0.0.1 (Alpha)

## Authors

Philip Sephton

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 


## Acknowledgments

Aswene Sivaraj and Savannah Vaithilingham, helped debug and correct code
D.S.Malik, Published JAVA Programming which i used to reference

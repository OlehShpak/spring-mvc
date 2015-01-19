# Spring (MVC + Security + Data) project (full java configured, without xml) 
This is not big, but pretty CRM system. It helps to practice some features in endless spring framework

Don't forget change your db properties (under src/main/resources) and add your JDBC Driver to POM  

Please, use script.sql under src/main/resources for populating some db data 

Entry point http://localhost:8080/spring-brightcrm

login: admin
password: 123456

Done:
- Authorization and authentication are provided by Spring Security
- Unauthorized users have access only to hello page, login and registration forms
- During registration user data is validating for uniqueness, password encoded by BCrypt
- Registered users receive role "user", hence access to all sections except chief section (needed role "chief")
- User(e.g. employee) can create,delete and search customers (new customers are validating for uniqueness)
- User can create,delete and search deals (search in custom date range by created date or deadline, by employee full name)
- Customer and deals are related One To Many, customer is deleted with deal collection (cascade)
- User can receive and view tasks from another users and accomplish it
- ORM framework is Hibernate, db properties are for Postgresql
- Repositories are created by Spring Data
- For validation model constraints is used Hibernate Validator
- Frontend provided by JSP, JSTL, HTML5, CSS3, Bootstrap 
- Controllers are tested by Mockito
- Added controller and service performance measuring with Spring AOP
- For logging is used SLF4J (console, file output path: ${catalina.home}/logs/shpak.log )
- Project is built by Maven, required web server for Servlet 3.0.1 (e.g. Tomcat 7 and higher)

TODO:
- Add more analytics reports 
- Implement global news for all users
- Deal forecasting

##Technologies used

* Spring Framework 4.1.4.RELEASE
* Spring Security 4.0.0.RC1 
* Spring Data 1.8.0.M1
* Hibernate 4.3.8.Final
* Junit 4.12, Mockito 1.10.19
* Hibernate Validator 5.1.3.Final
* Java 1.7
* Maven 
* Tomcat 7
* Servlet Api 3.0.1
* AspectJ 1.8.4
* Slf4j 1.7.9
* Bootstrap 3.3.1






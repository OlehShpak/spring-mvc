# Spring (mvc + security + data) project (full java configured, without xml) 
This is not big, but pretty crm system. It helps to practice some features from endless spring framework

Entry point http://localhost:8080/spring-brightcrm

Done:
- Authorization and authentication are provided by Spring Security
- Unauthorized users have acces only to hello page, login and registration forms
- During registration user data is validate for uniqueness, password encoded by BCrypt, default role 'ROLE_USER'
- Registered users can have different roles, hence access to different section 
- User(e.g. employee) can create,delete and search customers (new customers are validating for uniqueness)
- User can create,delete and search deals (search in custome date range by created date or deadline)
- Customer and deals are related One To Many, customer is deleted with deal collection (cascade)
- User can become and view tasks from another users and accomplish it
- ORM framework is Hibernate, db properties are for Postgresql
- Repositories are created by Spring Data
- For validation model constraints is used Hibernate Validator
- Frontend provided by JSP, JSTL, HTML5, CSS3, Bootstrap 
- Controllers are tested by Mockito
- For logging is used log4j (console and file output)
- Project is built by maven, required web server for servlet 3.0.1 (e.g. tomcat 7 and higher)

TODO:
- Add more analitics functions (implement some OLAP queries)
- Add new functionality and new entities
- Implement global news for all users



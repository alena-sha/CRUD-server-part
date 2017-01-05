# CRUD-server-part

Simple CRUD app which consists of server and client parts.
Server part demonstrates integration of popular JavaEE frameworks and technologies: Spring 4 (Spring Core, Spring Security, 
Spring MVC), Hibernate 5, Maven 4, SLF4J, REST WebService, JUnit 4.
Client part is developed with help of AngularJs 1.5, Angular Material.

This app has a login form, performs simple CRUD operations with employee module and allows

To build all the example applications run the Maven command:
mvn -e clean package in the project's root folder.  Maven 
will the build each module and create a .war file in the
target sub-folder of each module.

You can then copy the .war files to your Servlet container
(e.g. Tomcat, Jetty, GlassFish, etc).

There is a ReadMe.txt file in each module with instructions 
and the URL to view that application.

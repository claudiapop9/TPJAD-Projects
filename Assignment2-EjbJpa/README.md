### Requirement 2 ###

Assignment EjbJpa requires to implement an application which uses EJB, JPA, servlets and optional JSP. 
The application should contain a server which will manage at least 2 tables in a database. These tables must have at least a relation between them;
Moreover, the application should contain 2 clients: oe client for calling the server using JNDI and the other one using EJB. 
The application should be install on Wildfly and Glassfish;

### Proposed solution ###
A simple application which manages and displays data about people and their home town.The main functionality consists in displaying information about a certain person. 
In order to identify a certain person a filter can be made by providing his/hers social security number (CNP);
For a better data visualization , the cities can be filtered by name and by country;

### Configurations: ###
#### Datasource Configuration Wildfly: ####
1.	Download mysql-connector-java*.zip and extract mysql-connector-java-*.jar, change the name in mysql-connector-java.jar. Put it in $JBOSS_HOME/bin/mysql-connector-java.jar
2.	Start WildFly $JBOSS_HOME/bin/standalone and start MySql server; run jboss-cli.bat 
3.	In jboss-cli.bat window insert the following commands:
    1.	Connection module:
    `module add --name=com.mysql --resources=mysql-connector-java.jar --dependencies=javax.api,javax.transaction.api `
    
    2. Install a driver with: ,,mysql” name:
    `/subsystem=datasources/jdbc-driver=mysql: add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.jdbc.jdbc2.optional.MysqlXADataSource)`
    
    3. Define a data source ,,MySqlDS”:
    `data-source add --name=MySqlDS --driver-name=mysql --jndi-name=java:jboss/datasources/MySqlDS --connection-url=jdbc:mysql://localhost:3306/ tpjad_assig2--user-name=myuser --password=password --enabled=true`
    
    4. Delete $JBOSS_HOME/bin/mysql-connector-java.jar 

#### Datasource Configuration GlassFish: ####

1.	Download mysql-connector-java*.zip and extract mysql-connector-java-*.jar, change the name in mysql-connector-java.jar. Put it in $GLASSFISH_HOME/glassfish/lib/mysql-connector-java.jar.
2.	Start GlassFilsh: $GLASSFISH_HOME/glassfish/asadmin >start-domain and  start MySQL server,
    * In asadmin, create the connection pool by inserting the following command:

    ```
    create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --property "user=root:password=admin:url=jdbc\\:mysql\\://localhost\\:3306/tpjad_assig2" MySqlPool
    ```
    * In asadmin, create JNDI:

    ``` 
    create-jdbc-resource --connectionpoolid MySqlPool mysql 
    ```
- - - -

### How to deploy the application: ### 

----
#### ***Awarness: ####
Before building the solution:

	For Wildfly:
```<persistence-unit name="tpjad_assig2_ejb">
< jta-data-source>java:jboss/datasources/MySqlDS</jta-data-source>
.....
</persistence>
```

	For GlassFish:

o	In file persistence.xml (Assignment2/src/main/resources/META-INF) 

```
<persistence-unit name="tpjad_assig2_ejb">
<jta-data-source>mysql</jta-data-source>
.....
</persistence>
```

o	In entities classes (City and Person):
```
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQMYCLASSID")
 private int id;
```
----

1. Copy the war file as describes below:
#### Deploy for Wildfy: ####

    Copy the war archive in wildfly folder, standalone\deployments( C:\....\wildfly-servlet-18.0.1.Final\standalone\deployments)
    
    Start stadalone.bat (C:\...\wildfly-servlet-18.0.1.Final\bin\standalone.bat)
 
#### Deploy for Glassfish: ####
    Start asadmin from : C:\….\glassfishX\glassfish\bin\asadmin 
    Write : start-domain
    Write : deploy+<space> + the path to the war archive ( C:\....\Assignment1\ServletsAssignment\build\libs\ ServletsAssignment-1.0-SNAPSHOT.war)
    Write: stop-domain

2. Run the gradle build scripts:

    	autoDeployGlassFish
    
    
    	autoDeployWildfly

After the deploy the application can be access on : localhost:8080/Assign2War

#### For running the Glassfish Client: ####

`java -cp "$GLASSFISH_HOME/glassfish/lib/gf-client.jar;./build/libs/Assignment2GFClient.jar" com.tpjad.ejb.assig.clients.Client`


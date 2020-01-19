Servlet Assignment requires to install and configure servlet containers: Tomcat, Jetty and application servers (AS): WildFly and GlassFish. The application have to be portable and installable on each of the 4 continers mentioned above. The application have to be deployed in the following ways:
1.	Using war archive for Tomcat, Jetty, WildFly and GlassFish.
2.	Without war archive for Tomcat and Jetty(external context)
3.	Embedded applications for Tomcat and Jetty

### Proposed solution ###
A simple health system. The main functionality consists in displaying information about body mass index. The  body mass index is measured based on height and weight and it applies to adult men and women. 
The height and weight are dynamically set, i.e. after the user introduces the values for the height and weight in the form, the calculated bmi is automatically shown below the form.
 
Gradle is used as buildsystem for its flexibilty in configuring custom build pipelines. The war deployment is built from the ServletsAssignment project. The embedded jar deployments are build from the ServletTomcatEmbedded and ServletJettyEmbedded.

### Tomcat Deploy: ###
#### 1.	Using war archive: ####

**1.1**	Copy the war arhive in tomcat folder webapps (C:\....\apache-tomcat-9.0.29\webapps)

**1.2**	Start the server:

* From command line: 
   * cd PathToTomcat/bin  
   * startup
*	Go to Tomcat -> bin -> click on startup.bat

**1.3**	Open the browser at http://localhost:8080/ServletsAssignment/calculateServlet

**1.4**	Stop the server: click on shutdown.bat (or write in cmd shutdown)

#### 2.Using new context: ####

**2.1** In Tomcat folder

**2.2** Add in server.xml

    <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">
    <Context path="/ServletsAssignmentNew"   docBase="C:/…./ServletsAssignment/build/libs/ServletsAssignment-1.0-SNAPSHOT.war"/>
    …
    </Host>
 
**2.3** Open the browser at http://localhost:8080/ServletsAssignmentNew/calculateServlet

### Jetty Deploy: ###
#### 1.	Using war archive: ####

 **1.1**	Copy the war arhive in jetty folder webapps (C:\....\jetty-distribution-9.4.24.v20191120\webapps)

 **1.2** Start the server:

* Command line: cd pathToJettyFolder
* Write: java –jar start.jar

**1.3**	Open the browser at http://localhost:8080/ServletsAssignment/calculateServlet

**1.4**	Stop the server.

#### 2.	Using new context: ####
**2.1**	Create new xml file in jetty folder/webapps: (C:\tpjad\jetty-distribution-9.4.24.v20191120\webapps)

**2.2**	Xml file should contain:

    <?xml version="1.0"  encoding="ISO-8859-1"?>
    <!DOCTYPE Configure PUBLIC "-//Mort Bay Consulting//DTD Configure//EN"
                             "http://jetty.mortbay.org/configure.dtd">
    <Configure class="org.eclipse.jetty.webapp.WebAppContext">
      <Set name="contextPath">/ServletsAssignmentNew</Set>
      <Set name="war">C…./ServletsAssignment/build/libs/ServletsAssignment-1.0-SNAPSHOT.war</Set>
    </Configure>

**2.3** Open browser at : http://localhost:8080/ServletsAssignmentNew/calculateServlet

### Wildfy Deploy: ###

**1.**	Copy the war archive in wildfly folder, standalone\deployments( C:\....\wildfly-servlet-18.0.1.Final\standalone\deployments)

**2.**	Start stadalone.bat (C:\...\wildfly-servlet-18.0.1.Final\bin\standalone.bat)

### Glassfish Deploy: ###

**1.**	Start asadmin from : C:\….\glassfishX\glassfish\bin\asadmin 

**2.**	Write : start-domain

**3.**	Write : deploy+<space> + the path to the war archive ( C:\....\Assignment1\ServletsAssignment\build\libs\ ServletsAssignment-1.0-SNAPSHOT.war)

**4.**	Write: stop-domain

# DownloadData
To Download Data in to CSV file from a particular table.

mvn archetype:generate -DgroupId=com.javid -DartifactId=DownloadDataWebApp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

mvn eclipse:eclipse -Dwtpversion=2.0

Errors :- 

1. superclass "javax.servlet.http.HttpServlet" was not found on the Java Build Path
solution: Project->Properties->Target Runtimes->Apache Tomcat

2. java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoaderListener
solution : Project->Deployment Assembly->Add->Java Build Path Entries->Maven Dependencies

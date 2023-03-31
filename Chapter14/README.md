# Transitioning to Java
## Chapter 14 - Server-side coding with Jakarta

There are 2 projects for this chapter:

    BasicServlet
	HTMLServlet
	
You will need the Glassfish application server installed and running.

Open a terminal/console windows in the project folder and enter `mvn`. Maven will download any files it requires into a folder named .m2 in your home directory. You will find a folder in the project called `target`. In this folder you will find the `war` file for the project. Either use the server's console to add the `war` file to the server or copy the `war` file into the `glassfish7\glassfish\domains\domain1\autodeploy` folder.

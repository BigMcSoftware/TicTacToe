
Administration Manual
===================

To set up the project, you have to clone this repository to your machine.
To clone this repository on to your machine, fire up your preferred git client. 
Make your way to a directory you prefer to store the program locally. 
Then type 

```
	git clone git@github.com:BigMcSoftware/TicTacToe.git
```

Once that is done, you can run the bash script 
```
	./bin/InstallDev
```
Which will install the Java 8 and Gradle 2.8 which are essential programs to run this project, if they are not already installed on your machine.
Once that is done you can run the program as a Java Console version, Java Gui version or a Web based application with a Java backend. 
Please refer to the chapters below to get instructions on how to run the preferred version of the program. 

### Java Console
To build the Java Console version enter
```
	./bin/build
```
into the git shell. This will build the .Jar file for the Java Console program and puts it into ${app}/jar root folder.
To run the Java Console version enter
```
	./bin/runConsole
```
into the git shell. This will run the console version of the program.

### Java Gui
To build the Java Gui version enter
```
	.bin/build_gui
```
into the git shell. This will build the Gui version of the program.
To run the Java Gui version enter
```
	.bin/run_gui
```
into the git shell. This will run the Gui version of the program.

### Web based application with Java backend
To run the Web Based Application first enter
```
	.bin/package
```
into the git shell. This makes the install distribution for the deployment of the Web User Interface.
To deploy/run the Web Based Application enter
```
	gradle build
```
OR
```
	gradle run
```
Which will run the Web Application.


### More bin commands
* bin/build - Builds Jar file for the console version and puts it into ${app}/jar root folder
* bin/runConsole - Runs the jar file that came from bin/build
* bin/clean - Cleans all targets and deletes from ${app}/jar folder
* bin/compile - Compiles the code
* bin/package - Makes the install distribution for deployment of web ui.
* bin/deploy - Builds a spark Web User Interface and deploys it to /tmp and then runs it.
* bin/runWeb - Does the same as bin/deploy
* bin/build_gui - builds a Java Gui version (Windows, Linux, Mac OS x portable version)
* bin/runGui - Runs the Java Gui version.
* bin/unit_test - Performs unit tests
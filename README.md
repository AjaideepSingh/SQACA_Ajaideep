# Test coverage metric

### What is code coverage?
Code coverage is the percentage of code which is covered by automated tests. Code coverage measurement simply determines which statements in a body of code have been executed through a test run, and which statements have not. We can distinguish code that has been run through a test and code that hasnt based on if the code has a green or red block beside the line.
 
 - Green -> Lines of code are covered by a unit test
 - Red -> Lines of code are not covered by a unit test

To find out the code coverage of a java class you simply right click on the class and select "run "nameOfClass.main()" with coverage". You can also find out the code coverage of any given class without running them. This following technique is helpful when trying to find the code coverage of multiple classes without running them. For running the tests I used IntelliJs built in testing tool, you can also use third party plugins.

- Within the IntelliJ IDE use ctrl alt f6 to find code coverage of a given class
- Not this may vary based on the IDE you are using

#### Before writing any unit tests
![image info](./pictures/noCodeCoverage.png)


#### The gap closing after writing unit tests for POJOs
![image info](./pictures/POJOSafterTest.png)
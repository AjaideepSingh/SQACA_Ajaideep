# Test coverage metric
### What is code coverage?
Code coverage is the percentage of code which is covered by automated tests. Code coverage measurement simply determines which statements in a body of code have been executed through a test run, and which statements have not. We can distinguish code that has been run through a test and code that has not based on if the code has a green or red block beside the line.

 - Green -> Lines of code are covered by a unit test
 - Red -> Lines of code are not covered by a unit test

To find out the code coverage of a java class you simply right click on the class and select "run "nameOfClass.main()" with coverage". You can also find out the code coverage of any given class without running them. This following technique is helpful when trying to find the code coverage of multiple classes without running them. For running the tests, I used IntelliJs built in testing tool, you can also use third party plugins. Using this IDE tool helps identify the gaps in which lines of code are covered by a unit test or not. The figures below should help identify the gaps closed when running the code coverage tool without any test cases and with test cases.

- Within the IntelliJ IDE use ctrl alt f6 to find code coverage of a given class
- Note this may vary based on the IDE you are using

#### Before writing any unit tests
![image info](pictures/noCodeCoverage.PNG)
*The above figure shows the code coverage results before any unit tests have been written*


#### The gap closing after writing unit tests for POJOs
![image info](pictures/POJOSafterTest.PNG)
*The above figure shows the code coverage results after unit tests have been written, We can straight away note the gap closed*

#### The gap closing after writing unit tests for the Driver class
![image info](pictures/codecoverageaftertestswritten.PNG)

#### POJO tests passing
![image info](pictures/pojoTestsPassing.PNG)

#### Driver class tests passing
![image info](pictures/Driverunittestspassing.PNG)
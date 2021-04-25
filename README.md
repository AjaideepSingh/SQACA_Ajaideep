# Unit testing and Test-Driven development
I have followed a test-driven development approach where the approach is broken into test cases which are developed to specify and validate what the code will do.
[An example of a commit that follows a test driven development approach](https://github.com/AjaideepSingh/SQACA_Ajaideep/commit/a161b5942e0a8fd4ca358ef1b8973c30f6eedc22)
Within this commit I have created unit tests for all the POJOs. The three POJOs I have tested are ->
 - Student Object
 - Topic Object
 - Rubric Object

I have created test cases when developing the main functionality as well so there should be test cases along with majority of commits which can be seen within the GitHub repository.

In the POJO test cases I ensure that each Object is covered by a test. This is the ensure code correctness as in if the test is to pass the code logic is correct based on the dummy data, I have provided in the unit tests. I will cover the gap closed by writing unit tests in terms of code coverage later. You can note from the commit that the quality of the code is improved by following this approach. We can note that majority of the commits have supporting unit test cases. Following this approach now will save project costs in the future, remove code smells and grey areas.

Majority of my application is terminal print outs and scanning user input. I have only written unit tests to cover the main functionality of the app i.e., POJO test cases and summary calculation test cases.
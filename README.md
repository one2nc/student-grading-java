
# Problem statement
This repo contains an exercise related to grading the students from various universities. Your job is to fork the repository,
set it up locally, and make the test cases pass in your own repo.

Here are some more details about the problem statement.

The `student-grading-java/src/test/resources/grades.csv` contains student records. For each student, we know the following 
   - first name of the student (column `FirstName`)
   - last name of the student (column `LastName`)
   - university of the student (column `University`)
   - student's score in first test (column `Test1`)
   - student's score in second test (column `Test2`)
   - student's score in third test (column `Test3`)
   - student's score in fourth test (column `Test4`)

There are a total of 30 students in the csv. The first row in the csv file is a header row indicating the order of the fields in the csv.

We need to calculate the final score and grade for each of the students. The scoring is done as follows:

- Final score is the average of all test scores. i.e. if test1=50, test2=60, test3=65 and test4=45, then final score = (50 + 60 + 65 + 45)/4, i.e. 55
- Grade is based on the final score. 
   - If final score is < 35, then student is graded as F (failed)
   - If final score is >= 35 and < 50, then student is graded as C
   - If final score is >= 50 and < 70, then student is graded as B
   - If final score is >= 70, then student is graded as A
- Thus, for a student with final score as 55, the grade will be B

As part of this exercise, you need to find out answers to the three questions (written as test cases in `GraderTest.java` file). These questions are:
   1. Calculate each student's grade and final score
   2. Find out overall topper student
   3. Find out topper student for each university

For this, first, you must read and parse the `grades.csv` file into a `List<Student>` object. This is mentioned in the first test case in the `GraderTest.java` - `itShouldParseInputTestDataIntoStudents`.

# Instructions
1. You are expected to fork this repo
2. Set up the repo locally (check the pre-requisites section for software)
3. Write code under `src/main/java` directory such that each of the test cases pass. You are NOT supposed to modify any code in test case class (i.e. `GraderTest.java` class)
4. You are not supposed to modify the grades.csv file. The program should return appropriate results so that the test cases pass.
5. Once you write the code and all the test cases pass, push your code to your forked repo on GitHub. Reply to the email you have received from One2N with the following:

   i) Link to GitHub URL of your forked repo

   ii) A screenshot of the test cases passing (you can take the screenshot from an IDE or mvn command line)
6. For writing code, please use Java8 or above. If you can make use of Java's collection framework and Stream APIs, your solution will be much more elegant (you will also get extra points)
7. The test cases use JUnit 4.0+ and Hamcrest matchers for assertions. Please read the documentation of these libraries in case you are not familiar.
8. You will need to implement the appropriate behaviour for equals and hashcode method for Student class. Two students are considered same if they have same full name and are in the same university.
9. If something is unclear, try to figure out the solution, given the test cases. If something is still unclear, assume what you think is right and make a note in the readme.

# Prerequisites
Make your you have following prerequisite softwares installed on your laptop.

1. Java 8 or above (JDK setup)
2. JAVA_HOME set with appropriate value
3. [Apache Maven](https://maven.apache.org/) installed and configured
4. Please use any good code editor (VS Code, vim, etc) or an IDE (IntelliJIdea, or Eclipse) for working on this codebase

# Evaluation Criteria
1. All the test cases must pass (no modification done to the test cases code). Share a screenshot of a gif or a video demo (< 1min) showing that the test cases pass.
2. The code follows java coding naming conventions.
3. Bonus points if you can use Java8+ language features such as streams, lambdas to make the code more readable.
4. Your code is well formatted and documented. If there are any assumptions, please add them to the project readme. 

# Project structure
The project follows standard Maven based code convention. 
```
src
├── main
│  ├── java
│  │  └── in
│  │      └── one2n
│  │          └── exercise
│  │              ├── Grade.java
│  │              ├── Grader.java
│  │              └── Student.java
│  └── resources
└── test
    ├── java
    │  └── in
    │      └── one2n
    │          └── exercise
    │              └── GraderTest.java
    └── resources
        └── grades.csv
```

# Running the code
1. Clone this repository on your local machine
2. `cd` into the root directory of the project (i.e.`student-grading-java` directory)
3. Run `mvn clean test`
4. You should see an output similar to below
   ```shell
   student-grading-java git:(main) $ mvn clean test
   [INFO] Scanning for projects...
   [INFO]
   [INFO] -----------------< in.one2n.exercise:student-grading >------------------
   [INFO] Building student-grading 0.1.0
   [INFO] --------------------------------[ jar ]---------------------------------
   [INFO]
   [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ student-grading ---
   [INFO] Deleting /Users/chinmay/work/one2n/gitrepos/student-grading-java/target
   [INFO]
   [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ student-grading ---
   [WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
   [INFO] Copying 0 resource
   [INFO]
   [INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ student-grading ---
   [INFO] Changes detected - recompiling the module!
   [WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
   [INFO] Compiling 3 source files to /Users/chinmay/work/one2n/gitrepos/student-grading-java/target/classes
   [INFO]
   [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ student-grading ---
   [WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
   [INFO] Copying 1 resource
   [INFO]
   [INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ student-grading ---
   [INFO] Changes detected - recompiling the module!
   [WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
   [INFO] Compiling 1 source file to /Users/chinmay/work/one2n/gitrepos/student-grading-java/target/test-classes
   [INFO]
   [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ student-grading ---
   [INFO] Surefire report directory: /Users/chinmay/work/one2n/gitrepos/student-grading-java/target/surefire-reports
   
   -------------------------------------------------------
    T E S T S
   -------------------------------------------------------
   Running in.one2n.exercise.GraderTest
   Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.075 sec
   
   Results :
   
   Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
   
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   [INFO] ------------------------------------------------------------------------
   [INFO] Total time:  2.040 s
   [INFO] Finished at: 2022-03-13T21:52:20+05:30
   [INFO] ------------------------------------------------------------------------
   ```


# FAQs
1. I am unable to set up the project locally. What do I do?

You should check the pre-requisite section and ensure you have the necessary software installed and configured properly. If you are stuck in installing or configuring Java, Maven, or IntelliJIdea, please refer to official documentation.

2. How do I run test in maven?

You can use `mvn clean test` command from the project root directory

3. I forked the repo and set it up locally, but I am getting compile time error. What do I do?

You need to identify and fix the compiler errors. After fixing all the compiler errors, when you try running the test cases for the first time using `mvn clean test`, the tests will fail too. This means, you are on right track and you need to figure out how to write the code in various classes to make the test cases pass.

4. All my test cases are passing, how do I submit the solution to this exercise?

Create a short video demo (< 1min) demonstrating your code and the passing tests. Push the demo video in your forked repository and send us a link to your solution by email.
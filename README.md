# Sorting-Algorithms-Java
Repository for comparison based sorting algorithms in Java. This was implemented as part of data structures and algorithms coursework under Dr. Dewan Ahmed at UNC, Charlotte

## Prerequisites to run the code:
* Make sure you have java installed and added to your path. You can check the same by typing **```java --version```** in the terminal.
* Make sure you have maven installed in your system (Only required if you want to make any changes else zip file comes with the executable jar in the target folder). You can check if maven is installed on your system by typing **```mvn --version```** in the terminal.

## Steps to run the program:

1. Download the zip file and unzip the code at the desired location.


2. Inside the folder, you will see three things:
   * A pom.xml file having all the dependencies.
   * A target folder having the executable jar with dependencies and all the generated classes
   * A src folder having the code.


3. You can import the project in an IDE such as eclipse / IntelliJ or open each program in the notepad.


4. **Project Structure:**
   * The main method is in the src/main/java folder
   * The sorting algorithm codes are in the src/main/java/sortingAlgorithm package.
   * The utilities are present in the src/main/java/utils package.
   * The src/main/java/dataStructure package contains the vector based heap implementation code.


5. **Note:** To perform only if any change has been made. Else skip to step 7 to run the code.
     > If you have made any changes to the code or want to build the project, go to the folder where the pom.xml is present and run the following maven command:<br /> 
	   **```mvn clean install```**
     > This command will clean and build your jar with all the dependencies included.


6. If the build is successful, the dependency jar will get generated in the target folder with name:<br />
	**Project1-1.0-SNAPSHOT-jar-with-dependencies**


7. Now to run the jar, open a terminal in the main folder(which contains pom.xml) and run the following command:<br />
**```java -Xmx512m -Xss512m -jar target/Project1-1.0-SNAPSHOT-jar-with-dependencies.jar```**

   > This will run the main class and generate the graph base on the average execution times per data set per algorithm. If you get any error related to ClassLoader, you may have an older version of java. Please follow step 5 to rebuild the jar.


8. The above command runs the main class and just gives the execution time and graph as output. If you want to check the sorting algorithm works fine, you can run the main methods of the algorithms by using the following command:<br />
**```java -Xmx512m -Xss512m -cp target/Project1-1.0-SNAPSHOT-jar-with-dependencies.jar sortingAlgorithm.<Algorithm code file name>```**

   > For example, if you want to check Insertion sort code, you can run it as follows:<br /> 
**```java -Xmx512m -Xss512m -cp target/Project1-1.0-SNAPSHOT-jar-with-dependencies.jar sortingAlgorithm.InsertionSort```**

   > This command will call the main class of insertion sort code and give you the output as the original list and the sorted list printed based on the data size and the type of array given as input.


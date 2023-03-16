/**
 * Courses
 *
 * This class contains the methods that are used to manage the course being
 * housed as an ArrayList.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Courses {
  // ARRAYLIST OF SUBJECTS
  private static ArrayList<Course> courses = new ArrayList<Course>();
  private static double weightedQPI;
  private static String weightedLetterGrade = "N/A";

  // GETTERS AND SETTERS
  public static ArrayList<Course> getCourses() {
    return courses;
  }

  public static void setCourses(ArrayList<Course> course) {
    Courses.courses = course;
  }

  public static double getWeightedQPI() {
    return weightedQPI;
  }

  public static String getWeightedLetterGrade() {
    return weightedLetterGrade;
  }

  public static void computeWeightedQPI() {
    weightedQPI = GradeCalculations.computeQPI();
  }

  public static void computeLetterGrade() {
    if (GradeCalculations.computeLetterGrade(weightedQPI) == null){
      weightedLetterGrade = "N/A";
    } else {
      weightedLetterGrade = GradeCalculations.computeLetterGrade(weightedQPI);
    }
  }

  public static void setWeightedLetterGrade(String weightedLetterGrade) {
    Courses.weightedLetterGrade = weightedLetterGrade;
  }


  // ADD COURSE OBJECT TO ARRAYLIST
  public static void addCourse() {
    InterfaceUtil.printHeader("ADD COURSE");
    Scanner scanner = new Scanner(System.in);

    // Request for Course Details
    System.out.print("Assign a unique ID no.: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter course name: ");
    String courseName = scanner.nextLine();

    System.out.print("Enter number of units: ");
    int units = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter QPI: ");
    double gradePoints = parseGradeInput();

    Course course = new Course(id, courseName, units, gradePoints);
    courses.add(course);
    computeWeightedQPI();
    computeLetterGrade();
    GradesSummary.openMenu();
  }


  // Parse the input to check if it is a letter grade
  public static double parseGradeInput() {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.next().toUpperCase();

    // Check if the input is a letter grade
    if (GradeCalculations.isLetterGrade(input)) {
      return GradeCalculations.convertLetterGradeToGradePoints(input);
    } else {
      return Double.parseDouble(input);
    }
    
  }


  
  // REMOVE EMPLOYEE AND INFORM IF SUCCESSFUL
  public static void removeCourse() {
    InterfaceUtil.printHeader("REMOVE EMPLOYEE");
    Scanner scanner = new Scanner(System.in);

    System.out.print(GradesSummary.getGradesTable());
    System.out.println("");

    System.out.print("Enter ID of employee to remove: ");
    int id = scanner.nextInt();


    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getId() == id) {
        courses.remove(i);
        System.out.println("Course removed successfully.");
        UserInterface.openMenu();
      }
    }
  
    System.out.println("Course with ID " + id + " not found.");
    UserInterface.openMenu();
  }
  


  // Update an course information
  public static void updateCourse() {
    InterfaceUtil.printHeader("UPDATE EMPLOYEE");

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter ID of employee to update: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Course courseToUpdate = null;
  
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getId() == id) {
        courseToUpdate = courses.get(i);
        break;
      }
    }
  
    if (courseToUpdate == null) {
      System.out.println("Course with ID " + id + " not found.");
      UserInterface.openMenu();
      return;
    }
  
    System.out.print("Enter new course name (leave empty to keep current value '" + courseToUpdate.getCourseName() + "'): ");
    String courseName = scanner.nextLine();
    if (!courseName.isEmpty()) {
      courseToUpdate.setCourseName(courseName);
    }
  
    System.out.print("Change QPI (leave empty to keep current value '" + courseToUpdate.getGradePoints() + "'): ");
    double gradePoints = scanner.nextDouble();
    scanner.nextLine();
    if (gradePoints == 0) {
      courseToUpdate.setGradePoints(gradePoints);
    }

  
    computeWeightedQPI();
    computeLetterGrade();

    System.out.println("Course updated successfully.");
    UserInterface.openMenu();
  }

}

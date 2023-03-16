/**
 * Grade Calculations
 * 
 * This file contains the methods for calculating the grades of the user.
*/

public class GradeCalculations {
  public static String computeLetterGrade(double qpi) {
    if (qpi >= 4.0) {
        return "A";
    } else if (qpi >= 3.5) {
        return "B+";
    } else if (qpi >= 3.0) {
        return "B";
    } else if (qpi >= 2.5) {
        return "C+";
    } else if (qpi >= 2.0) {
        return "C";
    } else if (qpi >= 1.0) {
        return "D";
    } else {
        return "F";
    }
  }

  public static double computeQPI() {
    double totalGradePoints = 0;
    double totalUnits = 0;
    for (Course course : Courses.getCourses()) {
        totalGradePoints += course.getGradePoints() * course.getUnits();
        totalUnits += course.getUnits();
    }
    CSVHandler.writeCSV("data.csv", Courses.getCourses());
    return totalGradePoints / totalUnits;
  }

  public static boolean isLetterGrade(String input) {
    String[] letterGrades = {"A", "B+", "B", "C+", "C", "D", "F"};
    for (String letterGrade : letterGrades) {
        if (input.equals(letterGrade)) {
            return true;
        }
    }
    return false;
  }

  public static double convertLetterGradeToGradePoints(String letterGrade) {
    if (letterGrade.equals("A")) {
        return 4.0;
    } else if (letterGrade.equals("B+")) {
        return 3.5;
    } else if (letterGrade.equals("B")) {
        return 3.0;
    } else if (letterGrade.equals("C+")) {
        return 2.5;
    } else if (letterGrade.equals("C")) {
        return 2.0;
    } else if (letterGrade.equals("D")) {
        return 1.0;
    } else if (letterGrade.equals("F")) {
        return 0.0;
    } else {
        throw new IllegalArgumentException("Invalid letter grade: " + letterGrade);
    }
  }
}
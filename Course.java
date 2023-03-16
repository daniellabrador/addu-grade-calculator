/**
 * Course
 * 
 * This class is used to store the data of a subject.
*/

public class Course {
  // Attributes and Constructor
  private int id;
  private String courseName;
  private int units;
  private double gradePoints;

  public Course(int id, String courseName, int units, double gradePoints){
    this.id = id;
    this.courseName = courseName;
    this.units = units;
    this.gradePoints = gradePoints;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public int getUnits() {
    return units;
  } 

  public void setUnits(int units) {
    this.units = units;
  }

  public double getGradePoints() {
    return gradePoints;
  }

  public void setGradePoints(double gradePoints) {
    this.gradePoints = gradePoints;
  }

  public String computeLetterGrade(double qpi) {
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
  
}

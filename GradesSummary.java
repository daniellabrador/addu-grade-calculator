/**
 * Payroll Generator System
 * 
 * This file is responsible for creating the payroll table as seen in option
 * 2 of the Payroll System menu.
*/

public class GradesSummary {
  
  public static void openMenu() {
    Router gradesSummary = new Router("AdDU Student Grade Calculator".toUpperCase(),
        getGradesTable(), new String[] {
        "Add a Subject",
        "Edit a Subject",
        "Delete a Subject",
        "Exit"
      });

      gradesSummary.showOptions();
  }

  public static String getGradesTable() {
    String table = String.format("%-5s %-30s %-10s %-10s\n", "ID", "Course Name", "QPI", "Letter");
    for (Course course : Courses.getCourses()) {
        int id = course.getId();
        String courseName = course.getCourseName();
        double gradePoints = course.getGradePoints();
        String letterGrade = course.computeLetterGrade(gradePoints);
        table += String.format("%-5s %-30s %-10.2f %-10s\n", id, courseName, gradePoints, letterGrade);
        
    }

    return table;
}

  
  public static void main(String[] args){
    openMenu();
  }
}

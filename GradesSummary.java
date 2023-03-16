/**
 * Grade Summary
 * 
 * This file is responsible for creating the summary of the user's grades
 * sorted in a table.
 * 
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

      Courses.computeWeightedQPI();
      Courses.computeLetterGrade();
      gradesSummary.showOptions();
  }

  public static String getGradesTable() {
    String table = String.format("%-5s %-30s %-10s %-10s %-10s\n", "ID", "Course Name", "Units", "QPI", "Letter");
    for (Course course : Courses.getCourses()) {
        int id = course.getId();
        String courseName = course.getCourseName();
        double gradePoints = course.getGradePoints();
        String letterGrade = course.computeLetterGrade(gradePoints);
        int units = course.getUnits();
        table += String.format("%-5s %-30s %-10s %-10.2f %-10s\n", id, courseName, units, gradePoints, letterGrade);
        
    }

    return table;
}

  
  public static void main(String[] args){
    openMenu();
  }
}

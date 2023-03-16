/**
 * Go Payroll
 * 

 * 
 * @author  Thony Danielle Labrador
 *          Jemriz Advincula
 * @version 1.0
 * @since   2023-03-16
 */

public class AdDUGradeCalculator {
    public static void main(String[] args) {
        System.out.println("Loading data...");
        loadData();
        UserInterface.start();
    }

    public static void loadData() {
        Courses.setCourses(CSVHandler.readCSV("data.csv"));
    }
}
/**
 * AdDU Grade Calculator
 * 
 * This is the main class of the program. It is responsible for loading the data
 * from the CSV file and initializing the main menu of the program.
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
        GradesSummary.openMenu();
    }

    public static void loadData() {
        Courses.setCourses(CSVHandler.readCSV("data.csv"));
    }
}
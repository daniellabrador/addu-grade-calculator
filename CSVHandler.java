/**
 * CSV Handler
 * 
 * This class contains methods that are used to read and write CSV files.
 * The CSV file is used to store the courses' data. Data is loaded from
 * the CSV file when the application starts and is written to the CSV file
 * every time the user creates, edits, or deletes an course.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CSVHandler {
    
    private static final String CSV_SEPARATOR = ",";
    
    // Read CSV file and return ArrayList of Employee objects
    public static ArrayList<Course> readCSV(String fileName) {
        ArrayList<Course> courses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, CSV_SEPARATOR);
                int id = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                int units = Integer.parseInt(st.nextToken());
                double gradePoints = Double.parseDouble(st.nextToken());
                Course course = new Course(id, name, units, gradePoints);
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }
    
    // Write ArrayList of Employee objects to CSV file
    public static void writeCSV(String fileName, ArrayList<Course> courses) {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Course course : courses) {
                fw.append(Integer.toString(course.getId()));
                fw.append(CSV_SEPARATOR);
                fw.append(course.getCourseName());
                fw.append(CSV_SEPARATOR);
                fw.append(Integer.toString(course.getUnits()));
                fw.append(CSV_SEPARATOR);
                fw.append(Double.toString(course.getGradePoints()));
                fw.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

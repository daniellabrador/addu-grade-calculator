/**
 * Router
 * 
 * This class is responsible for routing the user to the appropriate menu
 * based on the user's choice. It is also responsible for displaying the menu
 * options and the menu header.
*/

import java.util.Scanner;

public class Router {
  // Set up instance variables and constructor
  private String menuTitle;
  private String menuInfo;
  private String[] menuOptions;
  
  public Router(String menuTitle, String menuInfo, String[] menuOptions) {
    this.menuTitle = menuTitle;
    this.menuOptions = menuOptions;
    this.menuInfo = menuInfo;
  }

  public String[] getMenuOptions() {
    return this.menuOptions;
  }

  // Menu actions
  public void showOptions() {
    // Write the header
    InterfaceUtil.printHeader(this.menuTitle);

    // Display menu info if available
    if (this.menuInfo != null){
      InterfaceUtil.printInfo(this.menuInfo);
    }

    

    // Get total units
    int totalUnits = 0;
    for (Course course : Courses.getCourses()) {
      totalUnits += course.getUnits();
    }

    // Display results
    String table = String.format("                                              AVG:  %-10s %-10.2f %-10s",
          totalUnits, Courses.getWeightedQPI(), Courses.getWeightedLetterGrade());
    System.out.println(table);

    // Display menu options
    InterfaceUtil.printMenu(this.menuOptions);

    // Ask user to be routed
    routeUser(5);
  }

  public void routeUser(int attempts) {
    // Base Case: Quit after x attempts
    if (attempts <= 0) {
        System.out.println("Too many invalid attempts. Exiting...");
        return;
    }
    
    // Ask user to choose an option
    System.out.print("Enter your choice: ");
    Scanner scanner = new Scanner(System.in);
  
    int choice = 0;
    try {
        choice = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {        
        askToTryAgain();
        routeUser(attempts - 1);
        return;
    }
  
    if (choice < 1 || choice > this.menuOptions.length) {
        askToTryAgain();
        routeUser(attempts - 1);
        return;
    }
  
    // Route user to the appropriate menu
    String choiceString = this.menuOptions[choice - 1];

    switch(choiceString) {
        // Universal
        case "Exit":
            System.out.println("Saving data to file...");
            System.out.println("Exiting...");
            System.exit(1000);
            break;

        case "View Grades Summary":
            GradesSummary.openMenu();
            break;

        // Subject
        case "Add a Subject":
            Courses.addCourse();
            break;
        case "Delete a Subject":
            Courses.removeCourse();
            break;
        case "Edit a Subject":
            Courses.updateCourse();
            break;
        case "Back to Main Menu":
            UserInterface.openMenu();
            break;
        
        // Handle invalid input
        default:
            System.out.println("Invalid choice. Check your input and try again.\n");
            InterfaceUtil.printMenu(this.menuOptions);
            routeUser(attempts - 1);
            return;
    }
  }

  public void askToTryAgain(){
    System.out.println("Invalid choice. Check your input and try again.\n");
    InterfaceUtil.printMenu(this.menuOptions);
  }


}

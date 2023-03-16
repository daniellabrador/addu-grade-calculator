/**
 * Payroll System
 * 
 * This file contains the main method of the Payroll System. It is responsible
 * for initializing the main menu of the system.
*/

public class UserInterface {
  //! Runs the menu prompt
  public static void openMenu() {
    String menuInfo = "Welcome to the AdDU Student Grade\nCalculator! This";
    menuInfo += " program allows you to \neasily compute your QPI and equivalent ";
    menuInfo += "\nletter grade based on your grades for\neach subject.\n\n";
    menuInfo += "Your Weighted QPI: ";


    Router mainMenu = new Router("AdDU Student Grade Calculator".toUpperCase(),
    menuInfo, new String[] {
      "Add a Course",
      "Edit a Course",
      "Delete a Course",
      "View Grades Summary",
      "Exit"
    });

    mainMenu.showOptions();
  }

  //! Start/Test the Payroll System
  public static void main(String[] args) {
    start();
  }

  public static void start(){
    openMenu();
  }
}

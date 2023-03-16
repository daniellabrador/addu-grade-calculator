/**
 * Interface Utility
 * 
 * This class contains methods that are used to print the interface.
*/

public class InterfaceUtil {
  public static void printHeader(String title) {
    StringBuilder s = new StringBuilder();
    s.append("\n=======================================================\n"); 

    int titleLength = title.length();
    int titlePadding = (s.length() - titleLength) / 2;
    int titlePaddingRemainder = (s.length() - titleLength) % 2;

    for (int i = 0; i < titlePadding - titlePaddingRemainder; i++) {
      s.append(" ");
    }

    s.append(title);

    for (int i = 0; i < titlePadding; i++) {
      s.append(" ");
    }

    printNewLines(40);
    s.append("\n======================================================="); 

    System.out.println("\n");
    System.out.println(s);
  }

  public static void printMenu(String[] menuOptions) {



    for (int i = 0; i < menuOptions.length; i++) {
      System.out.println("[" + (i + 1) + "] " + menuOptions[i]);
    }

    System.out.println();

  }

  public static void printInfo(String info) {
    System.out.println(info);
    System.out.println();
  }

  public static void printNewLines(int lines) {
    for (int i = 0; i < lines; i++) {
      System.out.println();
    }
  }
}

import java.util.*;
import java.io.*;
import javax.swing.*;
public class LeaguesMenu
{
    public static final String[] mainMenu = { "Create League", "Veiw League", "Log Out" };
    public static final String[] subMenu = { "Veiw Leaderboard", "Veiw Fixtures", "Add Results", "Back to Main Menu" };
      
    public static void main(String[] args) {
      boolean main = true;
      while (main) {
          boolean sub = true;
          String section = (String) JOptionPane.showInputDialog(null, "Menu","",JOptionPane.QUESTION_MESSAGE, null, mainMenu, mainMenu[0]);
          if(section=="Create League") {
              createLeague();
          }else if(section=="Veiw League") { 
            while (sub) {
                String subSection = (String) JOptionPane.showInputDialog(null, "Menu","",JOptionPane.QUESTION_MESSAGE, null, subMenu, subMenu[0]);
                if(subSection=="Veiw Leaderboard"){
                    veiwLeaderboard();
                }else if(subSection=="Veiw Fixtures"){
                    veiwFixtures();
                }else if(subSection=="add Results") {
                    addResults();
                }else {
                    sub = false;
                }
            }
          }else 
            main = false;
      }
      JOptionPane.showMessageDialog(null, "You have been logged out");
      System.exit(0);
    }
  
    public static void createLeague() {
      
    }
  
    public static void veiwLeaderboard() {
      
    }
    
    public static void veiwFixtures() {
        
    }
    
    public static void addResults() {
        
    }
}

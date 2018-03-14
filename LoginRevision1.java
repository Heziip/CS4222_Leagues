import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;

public class Login { 
    private static Scanner x;
    private static Scanner y;
    private static Scanner z;
    private static Scanner findAdminNum;
    public static int currentAdminNum;
    public static File accountInfo = new File ("userInfo.txt");
    //public Int newAdminNum = 0;
    public static void start() throws IOException { 
       int newAdminNum = 1;
       String userName,password,account,checkA,checkB;
       
       FileWriter outputStream = new FileWriter(accountInfo,true);//true appends file instead
       PrintWriter pw = new PrintWriter(outputStream);            //of overwriting
        account  = JOptionPane.showInputDialog(null,"Do you have an existing account?  Y/N");
        account = account.toLowerCase();
        System.out.println(account);
        checkA = "y";
        checkB = "n";
        
        int i = 0;
        /*pw.println("line 1,a");
        pw.println("line 2");
        pw.println("line 3");//I am not writing directly to the file,i am writing to the file
                             //writer which writes it to the file in one chunk
        pw.close();//indication to copy filewriter into text file */   
        while(!account.equals(checkA)&& !account.equals(checkB)) {
          JOptionPane.showMessageDialog(null,"Please enter either Y or N");
          account  = JOptionPane.showInputDialog(null,"Do you have an existing account?  Y/N");
          account = account.toLowerCase();                  
        }
        if (account.equals(checkA)){
          userName = JOptionPane.showInputDialog(null,"Enter username");
          password = JOptionPane.showInputDialog(null,"Enter pass");
          verifyLogin(userName,password);
        }else{ 
            userName = JOptionPane.showInputDialog(null,"Please enter your desired username");
            password = JOptionPane.showInputDialog(null,"Please enter your desired password");
            findAdminNum = new Scanner(accountInfo);
            while(findAdminNum.hasNext()) {
                 findAdminNum.next();
                 newAdminNum++;
            }
            findAdminNum.close();
            String accountDetails = newAdminNum + "," + userName +"," + password;
            pw.println(accountDetails);     
        }
        pw.close();
    }
    
    public static void verifyLogin(String userName, String password) {
        boolean found = false;
        String tempUser = "";
        String tempPass = "";
        String tempNum = "";
        int i = 0;
     try
     { x = new Scanner(accountInfo);//reads file
         x.useDelimiter("[,\n]");//each field seperated by a coma or space
         
         while(x.hasNext() && !found) {
             tempNum = x.next();
             tempUser = x.next();
             tempPass = x.next();
             
             
             if (tempUser.trim().equals(userName.trim())&& tempPass.trim().equals(password.trim()))
             { found = true;//trim method removes spaces
                 JOptionPane.showMessageDialog(null,"Login successful");
                 
                }else 
                { JOptionPane.showMessageDialog(null,"Login failed,2 attempts remaining");
             userName = JOptionPane.showInputDialog(null,"Please enter  username");
             password = JOptionPane.showInputDialog(null,"Please enter  password");
                    
            }
            
            
        
        }
        y = new Scanner(accountInfo);//reads file
         y.useDelimiter("[,\n]");//each field seperated by a coma or space
         
         while(y.hasNext() && !found)
         {   tempNum = y.next();
             tempUser = y.next();
             tempPass = y.next();
             
             
             
             if (tempUser.trim().equals(userName.trim())&& tempPass.trim().equals(password.trim()))
             { found = true;//trim method removes spaces
                 JOptionPane.showMessageDialog(null,"Login successful");
                 
                }else 
                { JOptionPane.showMessageDialog(null,"Login failed,1 attempts remaining");
                    userName = JOptionPane.showInputDialog(null,"Please enter your desired username");
            password = JOptionPane.showInputDialog(null,"Please enter your desired password");
                    
            }
            
            
        
        }
        z = new Scanner(accountInfo);//reads file
         z.useDelimiter("[,\n]");//each field seperated by a coma or space
         
         while(z.hasNext() && !found)
         {   tempNum = z.next();
             tempUser = z.next();
             tempPass = z.next();
             
             
             if (tempUser.trim().equals(userName.trim())&& tempPass.trim().equals(password.trim()))
             { found = true;//trim method removes spaces
                 JOptionPane.showMessageDialog(null,"Login successful");
                 
                }else 
                { JOptionPane.showMessageDialog(null,"Too many failed attempts,closing program");
                    System.exit(0);
               
            }
            
            
        
        }
    }
        catch(Exception e)
        {
        }
        
        
    }
}
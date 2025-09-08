import java.util.*;

public class MailManager {
    public static void main(String[] args) {
        AuthService auth = new AuthService();
        boolean isAuthenticated = false;
        String LoggedInMail = null;
        MailManagementSystem manager = null;
        boolean inSession = true;

        Scanner sc = new Scanner(System.in);
        int userOption;
        while(true) {

            while (!isAuthenticated) {
                System.out.println();
                System.out.println("Mail Management System.");
                System.out.println("1. SignUp");
                System.out.println("2. Login");
                System.out.println("3. Logout");

                int value = sc.nextInt();
                sc.nextLine();

                if (value == 1) {
                    System.out.println("Enter Your EmailId: ");
                    String email = sc.nextLine().toLowerCase();

                    System.out.println("Enter your password: ");
                    String pwd = sc.nextLine().toLowerCase();

                    if (auth.SignUp(email, pwd)) {
                        System.out.println("SignUp successful.");
                    } else {
                        System.out.println("SignUp Error...");
                    }
                } else if (value == 2) {
                    System.out.println("Enter Your EmailId: ");
                    String mail = sc.nextLine().toLowerCase();

                    System.out.println("Enter your password: ");
                    String pswd = sc.nextLine().toLowerCase();

                    if (auth.login(mail, pswd)) {
                        isAuthenticated = true;
                        inSession =true;
                        LoggedInMail = mail;
                        manager = auth.getMailSystem(mail);
                        System.out.println("LogIn successful!!");
                    } else {
                        System.out.println("LogIn Error..");
                    }
                } else {
                    System.out.println("Enter a valid case.");
                }
            }

            while (inSession) {
                System.out.println("----------------------------------");
                System.out.println("Mail Management System.");
                System.out.println("----------------------------------");
                System.out.println("1. Store Email.");
                System.out.println("2. delete Email.");
                System.out.println("3. Show MailBox.");
                System.out.println("4. Add tag to Email.");
                System.out.println("5. Show Stats of all Emails.");
                System.out.println("6. Search Emails.");
                System.out.println("7. Wildcard search Email.");
                System.out.println("8. Logout. ");
                System.out.println("9. Exit.");
                System.out.println("-----------------------------------1");


                System.out.println("Enter your choice");
                userOption = sc.nextInt();
                sc.nextLine();

                if (userOption == 1) {
                    manager.StoreMails();
                } else if (userOption == 2) {
                    manager.deleteMails();
                } else if (userOption == 3) {
                    manager.showMailBox();
                } else if (userOption == 4) {
                    manager.addTags();
                } else if (userOption == 5) {
                    manager.ShowStats();
                } else if (userOption == 6) {
                    manager.Search();
                } else if (userOption == 7) {
                    manager.wildcardSearch();
                } else if (userOption == 8) {
                    System.out.println("Logging Out...");
                    auth.logout(LoggedInMail);
                    isAuthenticated=false;
                    inSession = false;
                } else if (userOption == 9) {
                    System.out.println("Exiting");
                    System.exit(0);
                } else {
                    System.out.println("Enter a valid Choice");
                }
            }
        }

    }
}

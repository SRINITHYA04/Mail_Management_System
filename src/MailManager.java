import java.util.*;

public class MailManager {
    public static void main(String[] args) {

        MailManagementSystem manager = new MailManagementSystem();
        Scanner sc = new Scanner(System.in);
        int userOption;
        while(true){
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
            System.out.println("8. Exit.");
            System.out.println("-----------------------------------1");



            System.out.println("Enter your choice");
            userOption =sc.nextInt();
            sc.nextLine();

            if(userOption == 1){
            manager.StoreMails();
            }
            else if(userOption==2){
                manager.deleteMails();
            }

            else if(userOption ==3){
                manager.showMailBox();
            }
            else if(userOption == 4){
                manager.addTags();
            }
            else if(userOption==5){
                manager.ShowStats();
            }
            else if (userOption == 6) {
                manager.Search();
            }
            else if(userOption==7){
                manager.wildcardSearch();
            }

            else if(userOption == 8){
                System.out.println("Exiting");
                System.exit(0);
            }
            else{
                System.out.println("Enter a valid Choice");
            }
        }
    }
}

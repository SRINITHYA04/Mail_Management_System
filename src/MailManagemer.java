import java.util.*;

public class MailManagemer {
    public static void main(String[] args) {

        Stack<Mail> mailBox = new Stack<>();

        Scanner sc = new Scanner(System.in);
        int userOption;
        while(true){
            System.out.println("Mail Management System.");
            System.out.println("1. Store Email.");
            System.out.println("2. delete Email.");
            System.out.println("3. Show MailBox.");
            System.out.println("4. Add tag to Email.");
            System.out.println("5. Show Stats of all Emails.");
            System.out.println("6. Search Emails.");
            System.out.println("7. Wildcard search Email.");
            System.out.println("8. Exit.");


            System.out.println("Enter your choice");
            userOption =sc.nextInt();

            if(userOption == 1){
                Mail mail = new Mail();
                mailBox.add(mail);
                System.out.println("Mail stored successfully!!!");
            }
            if(userOption==2){
                System.out.println("Enter the Index of the mail to delete :");
                int index = sc.nextInt();
                mailBox.remove(index);
            }
            if(userOption ==3){
                System.out.println("MailBox.");
                if(!mailBox.isEmpty()){
                    for(Mail m : mailBox) {
                        m.displayDetails();
                    }
                }
                else{
                    System.out.println("No mails in the mail box!!!");
                }
            }
            if(userOption == 4){
                System.out.println("Enter the Index of the mail to add tag :");
                int index = sc.nextInt();
                System.out.println("Enter the tag: ");
                String tag = sc.next();

                Mail mailToAdd = mailBox.get(index);
                mailToAdd.setTag(tag);
                System.out.println("Tag added successfully!!!");
            }

            if(userOption == 7){
                System.out.println("Exiting");
                System.exit(0);
            }
        }
    }
}

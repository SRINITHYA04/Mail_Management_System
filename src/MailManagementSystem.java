import java.util.*;
import java.util.stream.Collectors;

public class MailManagementSystem {
    private  List<Mail> mailBox;
    private final Set<String> spamWords;
    private final Scanner sc;

    //constructor
    public MailManagementSystem(){

        mailBox = new ArrayList<>();
        spamWords = new HashSet<>(Arrays.asList("lottery","spam","offer","winner","urgent","won","free"));
        sc = new Scanner(System.in);
    }

    public void StoreMails(){

        System.out.println("Enter the Sender's Email: ");
        String sender = sc.nextLine().toLowerCase();


        System.out.println("Enter the Receiver's Email: ");
        String receiver = sc.nextLine().toLowerCase();

        System.out.println("Enter the Subject of the Email: ");
        String subject = sc.nextLine();

        System.out.println("Enter the Content of the Email: ");
        String content = sc.nextLine();

        Mail mail = new Mail(sender, receiver,subject,content);
        checkSpam(mail);
        mailBox.add(mail);
        System.out.println("Mail stored successfully!!!");
    }

    private void checkSpam(Mail mail) {
        String content = mail.getContent().toLowerCase();
        for(String words : spamWords){
            if(content.contains(words)){
                mail.setspam(true);
                break;
            }
        }
    }

    public void deleteMails(){
        System.out.println("Enter the Index of the mail to delete :");
        int index = sc.nextInt();
        if(index>=0 && index < mailBox.size()){
            mailBox.remove(index);
            System.out.println("Mail removed successfully....");
        }
        else{
            System.out.println("Invalid mail Index!!!....");
        }
    }

    public void showMailBox(){
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

    public void addTags(){
        System.out.println("Enter the Index of the mail to add tag :");
        int index = sc.nextInt();
        sc.nextLine();
        if(index>=0 && index < mailBox.size()){
            System.out.println("Enter the tag: ");
            String tag = sc.nextLine();

            Mail mailToAdd = mailBox.get(index);
            mailToAdd.setTag(tag);
            System.out.println("Tag added successfully!!!");
        }
        else{
            System.out.println("Invalid mail index!!!");
        }

    }

    public void ShowStats(){
        System.out.println("Mail Statistics:");
        System.out.println("Total mails: "+ mailBox.size());
        System.out.println("Enter the number of recent mails to display: ");
        int n = sc.nextInt();
        System.out.println();
        System.out.println("The recent "+n+" mails.");
        System.out.println();

        mailBox.stream()
                .skip(Math.max(0,mailBox.size()-n))
                .forEach(System.out::println);

    }


    public void Search() {
        System.out.println("Enter the word to search:");
        String word = sc.nextLine().toLowerCase();

        List<Mail> results = mailBox.stream()
                .filter(mail ->
                                mail.getSender().toLowerCase().contains(word)||
                                mail.getReceiver().toLowerCase().contains(word)||
                                mail.getSubject().toLowerCase() .contains(word)||
                                mail.getContent().toLowerCase() .contains(word)||
                                mail.getTag().stream().anyMatch(tag-> tag.toLowerCase() .contains(word)))
                .toList();

        if(results.isEmpty()){
            System.out.println("No Emails Found.");
        }
        else{
            System.out.println("Search Result.");
            results.forEach(System.out::println);
        }
    }

    public void wildcardSearch() {
        System.out.println("Enter the pattern to search:");
        final String word = sc.nextLine().toLowerCase().replace("*",".*");

        List<Mail> results = mailBox.stream()
                .filter(mail ->
                        mail.getSender().toLowerCase().matches(word)||
                                mail.getReceiver().toLowerCase().matches(word)||
                                mail.getSubject().toLowerCase() .matches(word)||
                                mail.getContent().toLowerCase() .matches(word)||
                                mail.getTag().stream().anyMatch(tag-> tag.toLowerCase() .matches(word)))
                .toList();

        if(results.isEmpty()){
            System.out.println("No Emails Found.");
        }
        else{
            System.out.println("Search Result.");
            results.forEach(System.out::println);
        }
    }
}

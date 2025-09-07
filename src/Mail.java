import java.util.*;
public class Mail {
    private String receiver;
    private String sender;
    private String subject;
    private String content;
    private String tag;
    private boolean spam;

    public Mail(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Sender's Email: ");
        this.sender = sc.next().toLowerCase();

        System.out.println("Enter the Receiver's Email: ");
        this.receiver = sc.next().toLowerCase();

        System.out.println("Enter the Subject of the Email: ");
        this.subject = sc.next();

        System.out.println("Enter the Content of the Email: ");
        this.content = sc.next();

        this.tag= "No tag";
        this.spam = false;

    }
    public void setTag(String tag) {
        if(this.tag.startsWith("No")){
            this.tag = tag+" |";
        }
        else {
            this.tag += " " + tag+" |";
        }
    }


    public void displayDetails() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Sender's mailID: " + sender);
        System.out.println("Receiver's mailID: "+ receiver);
        System.out.println("Subject:"+subject);
        System.out.println("Content: "+content);
        System.out.println("Tag: "+tag);
        System.out.println("Spam: "+ (spam ?"yes":"No"));
        System.out.println("-------------------------------------------------------------");
    }
}
import java.util.*;
public class Mail {
    private String receiver;
    private String sender;
    private String subject;
    private String content;
    private ArrayList<String> tag = new ArrayList<>();
    private boolean isspam;

    //contructor
    public Mail(String sender, String receiver,String subject,String content){
       this.sender=sender;
       this.receiver = receiver;
       this.subject=subject;
       this.content=content;

        this.tag.add("No tag");
    }

    //getters
    public String getSender(){ return  this.sender;}
    public String getReceiver(){ return  this.receiver;}
    public String getSubject(){ return  this.subject;}
    public String getContent(){ return  this.content;}
    public List<String> getTag(){ return  this.tag;}
    public boolean getspam(){ return  this.isspam;}

    //setters

    public void setspam( boolean val){ this.isspam = val;}
    public void setTag(String tags) {
        if(Objects.equals(tag.getLast(), "No tag")){
            tag.removeLast();
        }
        if(!tag.contains(tags))
            this.tag.add(tags);
    }

    //mutators
    public void removeTag(String tags){
        tag.remove(tags);
    }

    //methods
    @Override
    public String toString(){
        return "Sender's emailID: "+sender+"\nReceiver's emailID: "+receiver+"\nSubject: "+subject
                +"\nContent: "+content+"\nTags: "+tag+"\nSpam: "+isspam+"\n";
    }

    public void displayDetails() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Sender's mailID: " + sender);
        System.out.println("Receiver's mailID: "+ receiver);
        System.out.println("Subject:"+subject);
        System.out.println("Content: "+content);
        System.out.println("Tag: "+tag);
        System.out.println("Spam: "+ (isspam?"yes":"No"));
        System.out.println("-------------------------------------------------------------");
    }
}
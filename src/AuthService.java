import  java.util.*;

class AuthService {
    private Map<String, User> users = new HashMap<>();
    private Map<String, MailManagementSystem> mailboxes = new HashMap<>();


    public boolean SignUp(String email, String password) {
        if(!users.containsKey(email)) {
            User user = new User(email,password);
            users.put(email,user);
            mailboxes.put(email, new MailManagementSystem());
            return true;
        }
        return false;
    }
    public boolean login(String email, String password) {
        if(users.containsKey(email)) {
            User user = users.get(email);
            if(user.passwordHash.equals(hash(password))) {
                user.isLoggedIn = true;
                return true;
            }
        }
        return false;
    }

    public boolean logout(String email) {
        if(users.containsKey(email) && users.get(email).isLoggedIn) {
            users.get(email).isLoggedIn = false;
            return true;
        }
        return false;
    }

    private String hash(String password) {
        // simple placeholder for hashing
        return Integer.toString(password.hashCode());
    }

    public MailManagementSystem getMailSystem(String mail) {
        return mailboxes.get(mail);
    }
}

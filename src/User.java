class User {
    String email;
    String passwordHash;
    boolean isLoggedIn;

    User(String email, String password) {
        this.email = email;
        this.passwordHash = hash(password);
        this.isLoggedIn = false;
    }
    //getter
    public boolean getIsLoggendIn(){ return isLoggedIn;}

    private String hash(String password) {
        // simple placeholder for hashing
        return Integer.toString(password.hashCode());
    }

}

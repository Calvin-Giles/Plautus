public class Admin {
    private String username;
    private String email;
    private String password;

    
    private boolean hasSuperAccess;

    //Constructors
    public Admin() {}

    public Admin(String username, String email, String password, boolean hasSuperAccess) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.hasSuperAccess = hasSuperAccess;
    }

    //Getters & Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isHasSuperAccess() { return hasSuperAccess; }
    public void setHasSuperAccess(boolean hasSuperAccess) { this.hasSuperAccess = hasSuperAccess; }
}

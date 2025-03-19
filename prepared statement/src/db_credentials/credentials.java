package db_credentials;

public class credentials {
    private final String dbUrl = "jdbc:mysql://127.0.0.1:3306/your_database";
    private final String dbUsername = "Your_username";
    private final String dbPassword = "Your_password";

    public String getDbUrl() {
        return dbUrl;
    }
    public String getDbUsername() {
        return dbUsername;
    }
    public String getDbPassword() {
        return dbPassword;  // If hashed, return the hashed version here
    }
}

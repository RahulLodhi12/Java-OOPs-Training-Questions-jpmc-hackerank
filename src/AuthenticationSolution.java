import java.util.*;
import java.io.*;

interface IUser {
    public int getId();
    public void setId(int id);
    public String getEmail();
    public void setEmail(String email);
    public String getPassword();
    public void setPassword(String password);
    public int getIncorrectAttempt();
    public void setIncorrectAttempt(int incorrectAttempt);
    public String getLocation();
    public void setLocation(String location);
}

interface IApplicationAuthState {
    public List<IUser> getRegisteredUser();
    public void setRegisteredUser(List<IUser> registeredUsers);
    public List<IUser> getUsersLoggedIn();
    public void setUsersLoggedIn(List<IUser> usersLoggedIn);
    public List<String> getAllowedLocations();
    public void setAllowedLocations(List<String> allowedLocations);
    public String Register(IUser user);
    public String Login(IUser user);
    public String Logout(IUser user);
}
// Implement User and ApplicationAuthState class.

class User implements IUser{
    int id;
    String email;
    String password;
    String location;
    int incorrectAttempt=0;

    public User(int id, String email, String password, String location){
        this.id = id;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public int getIncorrectAttempt() {
        return 0;
    }

    @Override
    public void setIncorrectAttempt(int incorrectAttempt) {

    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public void setLocation(String location) {

    }
}

class ApplicationAuthState implements IApplicationAuthState{
    List<String> allowedLocations;
    List<IUser> registeredUsers;
    List<IUser> usersLoggedIn;

    public ApplicationAuthState(List<String> allowedLocations){
        this.allowedLocations = allowedLocations;
        registeredUsers = new ArrayList<>();
        usersLoggedIn = new ArrayList<>();
    }

    @Override
    public List<IUser> getRegisteredUser() {
        return null;
    }

    @Override
    public void setRegisteredUser(List<IUser> registeredUsers) {

    }

    @Override
    public List<IUser> getUsersLoggedIn() {
        return null;
    }

    @Override
    public void setUsersLoggedIn(List<IUser> usersLoggedIn) {

    }

    @Override
    public List<String> getAllowedLocations() {
        return null;
    }

    @Override
    public void setAllowedLocations(List<String> allowedLocations) {

    }

    @Override
    public String Register(IUser user) {
        if(registeredUsers.contains(user)){
            return "Already Register";
        }
        else{
            registeredUsers.add(user);
            return "Successfully Register";
        }
    }

    @Override
    public String Login(IUser user) {
        if(registeredUsers.contains(user) && user.getIncorrectAttempt()<3){

        }

        return "";
    }

    @Override
    public String Logout(IUser user) {
        return null;
    }
}

public class AuthenticationSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        List<IUser> users = new ArrayList<IUser>();
        List<String> allowedLocations = new ArrayList<String>();

        int allowedLocationCount = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < allowedLocationCount; i++) {
            String a = bufferedReader.readLine().trim();
            allowedLocations.add(a);
        }

        ApplicationAuthState authState = new ApplicationAuthState(allowedLocations);

        int usersCount = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < usersCount; i++) {
            String[] a = bufferedReader.readLine().trim().split(",");
            users.add(new User(Integer.parseInt(a[0]), a[1], a[2], a[3]));
        }

        int actionCount = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 0; i < actionCount; i++) {
            String[] a = bufferedReader.readLine().trim().split(":");
            int uindex = Integer.parseInt(a[1]);
            if (a[0].equals("Register")) {
                writer.println(authState.Register(users.get(uindex)));
            } else if (a[0].equals("Login")) {
                writer.println(authState.Login(users.get(uindex)));
            } else if (a[0].equals("Logout")) {
                writer.println(authState.Logout(users.get(uindex)));
            }
        }

        writer.close();
    }
}

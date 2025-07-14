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
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int getIncorrectAttempt() {
        return incorrectAttempt;
    }

    @Override
    public void setIncorrectAttempt(int incorrectAttempt) {
        this.incorrectAttempt=incorrectAttempt;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }
}

class ApplicationAuthState implements IApplicationAuthState{
    List<String> allowedLocations;
    List<IUser> registeredUsers;
    List<IUser> usersLoggedIn;

    public ApplicationAuthState(List<String> allowedLocations){
        this.allowedLocations = new ArrayList<>(allowedLocations);
        registeredUsers = new ArrayList<>();
        usersLoggedIn = new ArrayList<>();
    }

    @Override
    public List<IUser> getRegisteredUser() {
        return registeredUsers;
    }

    @Override
    public void setRegisteredUser(List<IUser> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    @Override
    public List<IUser> getUsersLoggedIn() {
        return usersLoggedIn;
    }

    @Override
    public void setUsersLoggedIn(List<IUser> usersLoggedIn) {
        this.usersLoggedIn = usersLoggedIn;
    }

    @Override
    public List<String> getAllowedLocations() {
        return allowedLocations;
    }

    @Override
    public void setAllowedLocations(List<String> allowedLocations) {
        this.allowedLocations = allowedLocations;
    }

    @Override
    public String Register(IUser user) {
        for(IUser iUser: registeredUsers){
            if(iUser.getEmail().equals(user.getEmail())) {
                return user.getEmail() + " is already registered!";
            }
        }

        registeredUsers.add(user);
        return user.getEmail() + " registered successfully!";
    }

    @Override
    public String Login(IUser user) {
        IUser myuser=null; //registered user
        for(IUser iUser: registeredUsers){
            if(iUser.getEmail().equals(user.getEmail())){
                myuser=iUser;
                break;
            }
        }
        if(myuser==null){
            return user.getEmail() + " is not registered!";
        }

        if(myuser.getIncorrectAttempt()>=3){
            return myuser.getEmail() + " is blocked!";
        }

        if(!myuser.getPassword().equals(user.getPassword())){
            myuser.setIncorrectAttempt(myuser.getIncorrectAttempt()+1);
            return myuser.getEmail() + " password is incorrect!";
        }

        if(!allowedLocations.contains(myuser.getLocation())){
            return user.getEmail() + " is not allowed to login from this location!";
        }

        for(IUser iUser: usersLoggedIn){
            if(user.getEmail().equals(iUser.getEmail())){
                if(user.getLocation().equals(iUser.getLocation())){
                    return user.getEmail() + " is already logged in!";
                }
                else{
                    return user.getEmail() + " is already logged in from another location!";
                }
            }
        }


        usersLoggedIn.add(user);
        myuser.setIncorrectAttempt(0); //registered user
        return user.getEmail() + " logged in successfully!";
    }

    @Override
    public String Logout(IUser user) {
        IUser myuser=null;
        for(IUser iUser: usersLoggedIn){
            if(iUser.getEmail().equals(user.getEmail())){
                myuser=iUser;
                break;
            }
        }

        if(myuser==null){
            return user.getEmail() + " is not logged in!";
        }

        usersLoggedIn.remove(myuser);
        return myuser.getEmail() + " logged out successfully!";
    }
}

/*
I/P 1:
1
location4
4
16,user16@email.com,14165,location16
8,user8@email.com,89680,location8
17,user17@email.com,26883,location17
16,user16@email.com,36862,location16
10
Register:2
Register:2
Login:1
Register:2
Login:0
Login:0
Login:0
Register:2
Register:1
Register:2
*/


/*
I/P 2:
2
location1
location2
3
7,user7@email.com,90559,location7
10,user10@email.com,41853,location10
2,user2@email.com,80573,location2
5
Register:1
Register:1
Login:0
Login:1
Register:2
*/


/*
I/P 3:
2
location1
location2
3
7,user7@email.com,90559,location7
10,user10@email.com,41853,location10
2,user2@email.com,80573,location2
5
Register:1
Register:1
Login:1
Login:1
Register:2
*/


/*
I/P 4:
2
location1
location2
4
7,user7@email.com,90559,location7
10,user10@email.com,41853,location10
2,user2@email.com,80573,location2
10,user10@email.com,41853,location11
5
Register:1
Register:1
Login:1
Login:3
Register:2
*/

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

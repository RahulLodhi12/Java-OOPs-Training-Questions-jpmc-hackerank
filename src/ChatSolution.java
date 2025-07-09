import java.util.*;

class Chat {
    List<String> members;
    List<Integer> files;
    HashMap<Integer,String> messages; //<id,msg>

    public Chat() {
        this.members = new ArrayList<>();
        this.files = new ArrayList<>();
        this.messages = new HashMap<>();
    }

    //3 overloaded add() methods:

    void add(String[] names){
        for(String name: names){
            members.add(name);
        }
    }

    void add(int[] ids){
        for(int id: ids){
            files.add(id);
        }
    }

    void add(int id, String newMessage){
        messages.put(id,newMessage);
    }

    //3 overloaded remove() methods:

    void remove(String[] names){
        for(String name: names){
            if(members.contains(name)){
                members.remove(name);
            }
            else{
                System.out.println("Member with name "+name+" does not exist");
            }
        }
    }

    void remove(int[] ids){
        for(int id: ids){
            if(files.contains(id)){
                files.remove(Integer.valueOf(id));
            }
            else{
                System.out.println("File with id "+id+" does not exist");
            }
        }
    }

    void remove(int id){
        if(messages.containsKey(id)){
            messages.remove(id);
        }
        else{
            System.out.println("Message with id "+id+" does not exist");
        }
    }

    void printConversation(){
        System.out.println("Total number of members in the conversation are " + members.size());
        System.out.print("The names of these members are ");
        for(String name: members){
            System.out.print(name + " ");
        }
        System.out.println();

        System.out.println("Total number of files in the conversation are " + files.size());
        System.out.print("The messages in the conversation are");
        for(Map.Entry<Integer,String> mp: messages.entrySet()){
            System.out.print(" '" +mp.getValue() + "' ");
        }
    }
}

public class ChatSolution{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] lineArray = sc.nextLine().split(" "); //names

        Chat newChat = new Chat();
        newChat.add(lineArray);

        lineArray = sc.nextLine().split(" "); //files

        int[] files = new int[lineArray.length];
        for (int i=0; i < lineArray.length; i++) {
            files[i] = Integer.parseInt(lineArray[i]);
        }

        newChat.add(files);

        String line = sc.nextLine();
        int numberOfMessages = Integer.parseInt(line); //convert

        for (int i=0; i < numberOfMessages; i++) {
            line = sc.nextLine();
            newChat.add(i, line);
        }

        lineArray = sc.nextLine().split(" "); //names array/list

        newChat.remove(lineArray);

        lineArray = sc.nextLine().split(" "); //files array/list

        int[] filesRemoved = new int[lineArray.length];

        for(int i=0; i < lineArray.length; i++) {
            filesRemoved[i] = Integer.parseInt(lineArray[i]);
        }

        newChat.remove(filesRemoved);

        lineArray = sc.nextLine().split(" "); //ids

        for(int i=0; i < lineArray.length; i++) {
            newChat.remove(Integer.parseInt(lineArray[i]));
        }

        newChat.printConversation();

    }
}

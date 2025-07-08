import java.util.*;

class Chat {
    List<String> members;
    List<Integer> files; //files id
    HashMap<Integer,String> messages;

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
        files.add(id);
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
                files.remove(id);
            }
            else{
                System.out.println("File with id "+id+" does not exist");
            }
        }
    }

    void remove(int id){
        if(messages.containsKey(id)){
            messages.remove(id);
            files.remove(id);
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

        Chat chat = new Chat();

        String[] names = {"John","Ray","Zee"};
        chat.add(names);

        int[] ids = {567,986,789};
        chat.add(ids);

        int n = sc.nextInt(); sc.nextLine();

        for(int i=0;i<n;i++){
            String msg = sc.nextLine();
            chat.add(i,msg);
        }

        String[] namesList = {"Ray"};
        chat.remove(namesList);

        int[] idList = {7,4,3};
//        chat.remove(idList);
        chat.remove(7);
        chat.remove(4);
        chat.remove(3);

        chat.printConversation();
    }
}


import java.util.ArrayList;
public class ConsoleDisplay {
    public static void printMenu() {
      System.out.println(String.format("%s - ADD; %s - DELETE; %s - UPDATE; %s - SHOW;" +
              " %s - FIND; %s - Exit;", ActionType.ADD.getIndex(), ActionType.DELETE.getIndex(),
              ActionType.EXIT.getIndex(), ActionType.FIND.getIndex(), ActionType.SHOW.getIndex(),
              ActionType.UPDATE.getIndex()));
    }

    public static void printContacts(ArrayList<Contact> contacts){
        System.out.println("CONTACTS: ");
        if (contacts.size()==0){
            System.out.println("No contacts found");
        }
        int index = 1;
        for (Contact contact : contacts){
            System.out.println(index++);
            System.out.println(contact.getName());
            System.out.println(contact.getBirthday());
            System.out.println("_______________________________________");
        }
    }

    public static void printContact(Contact contact){
        System.out.println("CONTACT: ");
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        System.out.println(contact.getBirthday());
        System.out.println("_______________________________________");
    }
}
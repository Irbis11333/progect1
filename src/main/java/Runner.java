import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            ConsoleDisplay.printMenu();
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input == ActionType.EXIT.getIndex()) {
                    System.out.println("Close Phone Book ;P");
                    break;
                } else if (input == ActionType.ADD.getIndex()) {
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter phone: ");
                    String phone = scanner.next();
                    System.out.print("Enter birthday: ");
                    String birthday = scanner.next();
                    Contact contact = new Contact(name, phone, birthday);

                    phonebook.add(contact);
                    ConsoleDisplay.printContacts(phonebook.getAllContact());

                } else if (input == ActionType.DELETE.getIndex()) {
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    phonebook.del(id);
                    ConsoleDisplay.printContacts(phonebook.getAllContact());
                } else if (input == ActionType.SHOW.getIndex()) {
                    System.out.print("Enter id: ");
                    int id = scanner.nextInt();
                    ConsoleDisplay.printContact(phonebook.get(id));
                } else if (input == ActionType.FIND.getIndex()) {
                    System.out.print("Find by name: ");
                    String name = scanner.next();
                    ArrayList<Contact> filteredContacts = phonebook.findByName(name);
                    ConsoleDisplay.printContacts(filteredContacts);
                }
            } else {
                System.out.println("Looser! ;P");
                break;
            }
        }
        scanner.close();
    }
}
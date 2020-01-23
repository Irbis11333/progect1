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
                    System.out.println("How do you want to search the contact?");
                    System.out.println("If you want search by foul name - input 1");
                    System.out.println("If you want search by first letters of name - input 2");
                    System.out.println("If you want search by 4 last numbers of phone - input 3");

                    int searchTypeIndex = scanner.nextInt();
                    if (searchTypeIndex == 1) {
                        System.out.print("Find by name: ");
                        String name = scanner.next();
                        ArrayList<Contact> filteredContacts = phonebook.findByName(name);
                        ConsoleDisplay.printContacts(filteredContacts);
                    }else if(searchTypeIndex== 2){
                        System.out.print("Find by name first letters: ");
                        String name = scanner.next();
                        ArrayList<Contact> filteredContacts = phonebook.findByFirstLetters(name);
                        ConsoleDisplay.printContacts(filteredContacts);
                    } else if(searchTypeIndex== 3){
                        System.out.print("Find by phone last numbers: ");
                        String phone = scanner.next();
                        ArrayList<Contact> filteredContacts = phonebook.findByPhone(phone);
                        ConsoleDisplay.printContacts(filteredContacts);
                    }
                }else if (input == ActionType.UPDATE.getIndex()){
                    System.out.print("input id : ");
                    int id = scanner.nextInt();
                    ConsoleDisplay.printContact(phonebook.get(id));
                    System.out.print("input number of field that you want update: ");
                    int numberOfField = scanner.nextInt();
                    if(numberOfField==1){
                        Contact contact1 = phonebook.get(id);
                        System.out.print("input new name:");
                        String name = scanner.next();
                        Contact contact2 = new Contact(name,contact1.getPhone(),contact1.getBirthday());
                        phonebook.set(id, contact2);
                        ConsoleDisplay.printContact(phonebook.get(id));
                    }else if (numberOfField==2){
                        Contact contact1 = phonebook.get(id);
                        System.out.print("input new phone:");
                        String phone = scanner.next();
                        Contact contact2 = new Contact(contact1.getName(),phone,contact1.getBirthday());
                        phonebook.set(id, contact2);
                        ConsoleDisplay.printContact(phonebook.get(id));
                    }else if (numberOfField==3){
                        Contact contact1 = phonebook.get(id);
                        System.out.print("input new birthday:");
                        String birthday = scanner.next();
                        Contact contact2 = new Contact(contact1.getName(),contact1.getPhone(),birthday);
                        phonebook.set(id, contact2);
                        ConsoleDisplay.printContact(phonebook.get(id));
                    }
                }else if (input == ActionType.SAVE.getIndex()){
                    FileControl.saveToFile(phonebook.getAllContact());
                }
            } else {
                System.out.println("Looser! ;P");
                break;
            }
        }
        scanner.close();
    }
}
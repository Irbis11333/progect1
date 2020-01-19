import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Contact> contacts = new ArrayList<>();


    public ArrayList<Contact> getAllContact(){
        return contacts;
    }

    protected void add(Contact contact){
        contacts.add(contact);
    }

    public Contact get(int id){
        return contacts.get(--id);
    }

    public void del(int id){
       contacts.remove(--id);
    }
    public void set(int id,Contact contact){
        contacts.set(id,contact);
    }
    public ArrayList<Contact> findByName(String name){
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)){
                result.add(contact);
            }
        }
        return result;
    }
    public ArrayList<Contact> findByFirstLetters (String fistLetters){
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().substring(0,3).equals(fistLetters)){
                result.add(contact);
            }
        }
        return result;
    }
    public ArrayList<Contact> findByPhone(String phone){
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getPhone().substring(6,10).equals(phone)){
                result.add(contact);
            }
        }
        return result;
    }
}

public class Contact {
    private String name;
    private String phone;
    private String birthday;

    public Contact(String name, String phone, String birthday) {
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

     public String getBirthday() {
        return birthday;
    }

    public String toString (){
        return name+";"+phone+";"+birthday+";";
    }
}
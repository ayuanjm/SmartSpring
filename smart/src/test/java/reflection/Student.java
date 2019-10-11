package reflection;

public class Student {
    private String money;
    private Person person;
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Person getPerson() {
        return new Person();
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

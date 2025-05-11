package ra.model;

public class Person {
    String name;
    String age;
    String address;

    public Person(String address, String age, String name) {
        this.address = address;
        this.age = age;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

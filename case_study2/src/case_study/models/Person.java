package case_study.models;

public abstract class Person {
    private String name;
    private int dateBirth;
    private String sex;
    private int identification;
    private int phoneNumber;
    private String email;

    public Person(String name, int dateBirth, String sex, int identification,
                  int phoneNumber, String email) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.sex = sex;
        this.identification = identification;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(int dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateBirth=" + dateBirth +
                ", sex='" + sex + '\'' +
                ", identification=" + identification +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}

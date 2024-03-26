package za.ac.cput.domain;

public class UserProfile {
    private String Name;
    private String Surename;
    private String Gender;
    private double Age;
    private String ID;

    public UserProfile() {
    }

    private UserProfile(Builder builder) {
        this.Name = builder.Name;
        this.Surename = builder.Surename;
        this.Gender = builder.Gender;
        this.Age = builder.Age;
        this.ID = builder.ID;

    }

//    public UserProfile(String name, String surename, String gender, int age, int ID) {
//        Name = name;
//        Surename = surename;
//        Gender = gender;
//        Age = age;
//        this.ID = ID;
//    }

    public String getName() {
        return Name;
    }

    public String getSurename() {
        return Surename;
    }

    public String getGender() {
        return Gender;
    }

    public double getAge() {
        return Age;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "Name='" + Name + '\'' +
                ", Surename='" + Surename + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Age=" + Age +
                ", ID=" + ID +
                '}';
    }

    public static class Builder {
        private String Name;
        private String Surename;
        private String Gender;
        private double Age;
        private String ID;




    public Builder setName(String Name) {
        this.Name = Name;
        return this;
    }

    public Builder setSurename(String Surename) {
        this.Surename = Surename;
        return this;
    }

    public Builder setGender(String Gender) {
        this.Gender = Gender;
        return this;
    }

    public Builder setAge(double Age) {
        this.Age = Age;
        return this;
    }

    public Builder setID(String ID) {
        this.ID = ID;
        return this;
    }

    public Builder copy(UserProfile e) {
        this.Name = e.Name;
        this.Surename = e.Surename;
        this.Gender = e.Gender;
        this.Age = e.Age;
        this.ID = e.ID;
        return this;
    }

    public UserProfile build() {
        return new UserProfile(this);
    }
}
}


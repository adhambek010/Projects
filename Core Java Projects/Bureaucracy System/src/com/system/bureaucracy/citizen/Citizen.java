package com.system.bureaucracy.citizen;

public class Citizen {
    private  String name;
    private  int age;
    private  boolean married;
    private String address;
    private String phone;
    private String gender;


    public Citizen(String name, int age, boolean married, String address, String phone, String gender) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return married;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public boolean hasPassportRestrictions() {
        return false;
    }
    public boolean hasLearnerLicense() {
        return false;
    }
    public boolean passedMedicalExam() {
        return false;
    }


}
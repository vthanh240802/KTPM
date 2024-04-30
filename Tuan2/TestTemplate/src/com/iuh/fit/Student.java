package com.iuh.fit;

import java.util.Objects;

/**
 * created-date 2024
 */
public class Student {
    private String name;
    private String phone;
    private String email;

    private String doSomething;

    /**
     * print the name
     */
    private void name(){
        System.out.println(name);
    }

    /**
     *
     * @param name
     * @param phone
     * @param email
     */
    public Student(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone(), getEmail());
    }
}

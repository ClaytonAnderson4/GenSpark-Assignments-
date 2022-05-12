package com.company;

//Person inherits the abstract animal class
public class Person extends Animal{

    //Abstraction through data hiding
    private String name;
    private int age;

    public Person(){
    }

    //Compile time Polymorphism through method overloading
    public Person(String name, int age){
        setName(name);
        setAge(age);
    }


    //Run time Polymorphism through method overriding
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //Inheritance & Polymorphism
    @Override
    public void hungry() {
        System.out.println("I am Hungry");
    }

    //Encapsulation through getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

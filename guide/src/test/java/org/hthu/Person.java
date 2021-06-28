package org.hthu;

public class Person {
    public static int count1= 1;
    private static Person person = new Person();
    public static int count2= 5;
    private Person() {
        count1++;
        count2++;
    }
    public static Person getInstance() {
        return person;
    }
    public static void main(String[] args) {
        Person person = Person.getInstance();
        System.out.println(person.count1 + "," + person.count2);
    }
}

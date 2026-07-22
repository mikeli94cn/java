/*
 * OOP
 * how to declare/instantiate objects (including nested classes)
 * how the object lifecycle works
 * */

//1. declaring and instantiating objects
//basic class and object
class Person{
    String name;

    void sayHello(){
        System.out.println("Hello," + name);
    }
}
//create object
Person p =new Person(); //declaration + instantiation
p.name = "John";
p.sayHello();

//what happens internally?
Person p = new Person();
/*
 * steps:
 * 1.memory allocated on heap
 * 2.constructor runs
 * 3.reference p stored on stack
 * 4.p points to the object
 * */

//2.nested class objects
//java supports nested classes (class inside class)
//2.1 static nested class
class Outer{
    static class Inner{
        void show(){
            System.out.println("Static nested class");
        }
    }
}
//Instantiate
Outer.Inner obj = new Outer.Inner();
obj.show();
//no need for outer instance


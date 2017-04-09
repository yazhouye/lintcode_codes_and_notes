/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/toy-factory
@Language: Java
@Datetime: 16-08-18 06:13
*/

/**
 * Your object will be instantiated and called as such:
 * ToyFactory tf = new ToyFactory();
 * Toy toy = tf.getToy(type);
 * toy.talk();
 */
interface Toy 
{
    void talk();
}

class Dog implements Toy 
{
    @Override
    public void talk()
    {
        System.out.println("Wow");
    }
}

class Cat implements Toy 
{
    @Override
    public void talk()
    {
        System.out.println("Meow");
    }
}

public class ToyFactory 
{
    public Toy getToy(String type) 
    {
        if(type.equals("Dog"))
        {
            return new Dog();
        }
        else if(type.equals("Cat"))
        {
            return new Cat();
        }
        else
        {
            return null;
        }
    }
}
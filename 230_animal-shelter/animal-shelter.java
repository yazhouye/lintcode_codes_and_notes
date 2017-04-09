/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/animal-shelter
@Language: Java
@Datetime: 16-07-29 11:15
*/

//two queue
/*
public class AnimalShelter 
{
    private Queue<String> catQueue;
    private Queue<String> dogQueue;
    private int no;

    public AnimalShelter() 
    {
        catQueue = new LinkedList<String>();
        dogQueue = new LinkedList<String>();
        no = 1;
    }

    void enqueue(String name, int type) 
    {
        if(type==0)
        {
            catQueue.offer(name+","+String.valueOf(no++));
        }
        else
        {
            dogQueue.offer(name+","+String.valueOf(no++));
        }
    }

    public String dequeueAny() 
    {
        if(catQueue.size()==0)
        {
            return dequeueDog();
        }
        if(dogQueue.size()==0)
        {
            return dequeueCat();
        }
        
        int no1 = Integer.parseInt(catQueue.peek().split(",")[1]);
        int no2 = Integer.parseInt(dogQueue.peek().split(",")[1]);
        if(no1<no2)
        {
            return dequeueCat();
        }
        else
        {
            return dequeueDog();
        }
    }

    public String dequeueDog() 
    {
        return dogQueue.poll().split(",")[0];
    }

    public String dequeueCat() 
    {
        return catQueue.poll().split(",")[0];
    }
}
*/

//one queue
abstract class Animal
{
    public int ID;
    public String name;
    
    public Animal(int ID, String name)
    {
        this.ID = ID;
        this.name = name;
    }
    
    public abstract String type();
}

class Dog extends Animal
{
    public Dog(int ID, String name)
    {
        super(ID, name);
    }
    
    @Override
    public String type()
    {
        return "Dog";
    }
}

class Cat extends Animal
{
    public Cat(int ID, String name)
    {
        super(ID, name);
    }
    
    @Override
    public String type()
    {
        return "Cat";
    }
}

public class AnimalShelter 
{
    private int ID;
    private ArrayList<Animal> list;
    
    public AnimalShelter() 
    {
        ID = 1; //optional
        list = new ArrayList<Animal>();
    }
    
    void enqueue(String name, int type) 
    {
        Animal animal = null;
        if(type==0)
        {
            animal = new Cat(ID++, name); 
        }
        else
        {
            animal = new Dog(ID++, name);
        }
        list.add(animal);
    }
    
    public String dequeueAny() 
    {
        String name = list.get(0).name;
        list.remove(0);
        return name;
    }
    
    public String dequeueCat() 
    {
	    String s="";
	    Animal a=null;
	    
	    Iterator<Animal> i = list.iterator();
	    while(i.hasNext())
	    {
	        a = i.next();
	        if(a.type()=="Cat")
	        {
	            s = a.name;
	            break;
	        }
	    }
	    list.remove(a);
	    return s;
    }
    
    public String dequeueDog() 
    {
	    String s="";
	    Animal a=null;

	    Iterator<Animal> i = list.iterator();
	    while(i.hasNext())
	    {
	        a = i.next();
	        if(a.type()=="Dog")
	        {
	            s = a.name;
	            break;
	        }
	    }
	    list.remove(a);
	    return s;
    }
}
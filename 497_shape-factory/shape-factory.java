/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/shape-factory
@Language: Java
@Datetime: 16-08-18 06:13
*/

/**
 * Your object will be instantiated and called as such:
 * ShapeFactory sf = new ShapeFactory();
 * Shape shape = sf.getShape(shapeType);
 * shape.draw();
 */
interface Shape 
{
    void draw();
}

class Rectangle implements Shape 
{
    @Override
    public void draw()
    {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class Square implements Shape 
{
    @Override
    public void draw()
    {
        System.out.println(" ---- ");
        System.out.println("|    |");
        System.out.println("|    |");
        System.out.println(" ---- ");
    }
}

class Triangle implements Shape 
{
    @Override
    public void draw()
    {
        System.out.println("  /\\");
        System.out.println(" /  \\");
        System.out.println("/____\\");
    }
}

public class ShapeFactory 
{
    public Shape getShape(String shapeType) 
    {
        if(shapeType==null)
        {
            return null;
        }
        
        if(shapeType.equals("Square"))
        {
            return new Square();
        }
        else if(shapeType.equals("Triangle"))
        {
            return new Triangle();
        }
        else if(shapeType.equals("Rectangle"))
        {
            return new Rectangle();
        }
        
        return null;
    }
}
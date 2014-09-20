package main;

/**
 * Created by Arman on 9/19/2014.
 */
public class Products {
    private static int idh= 0;
    private int id;
    private String name;
    private String description;
    private int count;
    private int price;


   public Products(String name, String description, int count, int price)
   {
       this.name=name;
       this.description=description;
       this.count=count;
       this.price =price;
       this.id=++idh;

   }
    public Products(Products second){
        this.name=second.name;
        this.description= second.description;
        this.count=second.count;
        this.price =second.price;
        this.id=second.id;
    }


    public void setPrice(int price) {
        this.price = price;
    }
    public int getID(){return this.id;}
    public void setCount(int count) {
        this.count = count;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getCount(){
        return count;
    }
    public int getPrice(){
        return price;
    }
}

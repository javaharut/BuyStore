package main;

/**
 * Created by Arman on 9/19/2014.
 */
public class Products {
    String name;
    String description;
    int count;
    int price;


   public Products(String name, String description, int count, int price)
   {
       this.name=name;
       this.description=description;
       this.count=count;
       this.price =price;

   }


    public void setPrice(int price) {
        this.price = price;
    }

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

package main;

/**
 * Created by Arman on 9/19/2014.
 */
public class Products {
    String name;
    int id;
    String description;
    int count;
    int price;

   public Products() {

   }


   public Products(String name, String description, int count, int price)
   {
       this.name=name;
       this.description=description;
       this.count=count;
       this.price =price;

   }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String res = "name " + this.name +" description " + this.description + " count " + this.count +" price " + this.price;
        return res;
    }
}

import java.util.*;

class program957
{
    public static void main(String A[])
    {
        HashMap <Integer, Integer>inventory = new HashMap<Integer, Integer>();

        // ADD 101 50
        inventory.put(101,50);

        // ADD 102 30
        inventory.put(102,30);

        // SELL 101 5
        if(inventory.containsKey(101))
        {
            inventory.put(101, inventory.get(101) - 5);
        }

        // RESTOCK 102 20
        if(inventory.containsKey(102))
        {
            inventory.put(102, inventory.get(102) + 20);
        } 

        int productid = 101;

        // Product 101 available quantity : 45
        if(inventory.containsKey(productid))
        {
            System.out.println("Product "+productid+" avaialable quantity : "+inventory.get(productid));
        }
        else
        {
            System.out.println("Product not found");
        }
    }
}
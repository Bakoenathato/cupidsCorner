package za.ac.cput.domain;
//nasiphi sunduza 222499028
import za.ac.cput.factory.ChatFactory;

public class Main {
    public static void main(String[] args){

        Chat c = ChatFactory.createChat("Sibusiso", "Fanele",  "Hey,how you doing",  "15:03");

        if (c !=null)
        System.out.println(c.toString());

        else System.out.println("Object not set");
    }
}

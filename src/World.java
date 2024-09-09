import java.util.ArrayList;
import java.util.Scanner;

public class World {

    private ArrayList<Cheese> food;
    private ArrayList<Fields> fields;



    //The world should be generated in 3 sizes: small, medium, large;
    //Small: 25 fields, Medium: 64 Fields, Large: 100 Fields;
    //Depending on the size, an ID system is drawn that assigns coordinates.
    //I.e.: 36 (6x6 with IDs: 0_0, 0_1, 0_2, 0_3, 0_4, 1_0, 1_1 ....)
    //64 (8x8)
    //144 (12x12)
    //Movement will set the position property of the platypus to a new ID.
    //Don't know how to do this: A field should have a property of whether cheese is present or not (Boolean);
    //If cheese is present, the platypus eats the cheese and can go further; The cheese property is cleared from that field.


    public World(int amount){
        food = new ArrayList<>();
        fields = new ArrayList<>();
//        generateCheese(amount);
    }

    public void generateWorld(){

       while (true){
           Scanner reader1 = new Scanner(System.in);
           System.out.println("Select a world size! 1 = small (6x6), 2 = medium (8x8), 3 = large (12x12)");
           int size = reader1.nextInt();

           if (size == 1){
               //generate 36 fields
               for (int i = 0; i < 5 ; i++) {

                   }

               }
               break;
           }

           if (size == 2){
               //generate 64 fields
               break;
           }

           if (size ==3){
              //generate 64 fields
               break;
          }
           else {
               System.out.println("You can only select a world size between 1 and 3.");
               continue;


           }
       }
    }
//   public void generateCheese(int amount){
//       for (int i = 0; i <= amount ; i++) {
//           Scanner reader1 = new Scanner(System.in);
//           System.out.println("Enter a taste: ");
//           int taste = reader1.nextInt();
//
//
//           Scanner reader2 = new Scanner(System.in);
//           System.out.println("Enter a name: ");
//           String name = reader2.nextLine();
//
//           Cheese cheese = new Cheese(taste, name);
//           food.add(cheese);
//
//       }
//   }

}

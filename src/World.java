import java.awt.*;
import java.util.Scanner;

public class World {

    private int size;
    private Fields[] fields;

   //The world should be generated in 3 sizes: small, medium, large;
   //Small: 25 fields, Medium: 64 Fields, Large: 100 Fields;
   //Depending on the size, an ID system is drawn that assigns coordinates.
   //I.e.: 36 (6x6 with IDs: 0_0, 0_1, 0_2, 0_3, 0_4, 1_0, 1_1 ....)
   //64 (8x8)
   //144 (12x12)
   //Movement will set the position property of the platypus to a new ID.
   //Don't know how to do this: A field should have a property of whether cheese is present or not (Boolean);
   //If cheese is present, the platypus eats the cheese and can go further; The cheese property is cleared from that field.


    public World(){
        getSize();
        generateWorld();
        populateWorld();
    }

    public void getSize(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the world (1 = small, 2 = medium, 3 = large): ");
        this.size = scanner.nextInt();

    }


    public void generateWorld() {
        //methods for each of the sizes of the world (if-statements);
        if (size == 1) {
            fields = new Fields[25];
            int pointer = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    Point coordinate = new Point(i, j);
                    fields[pointer] = new Fields(coordinate);
                    //fields[pointer].printCoordinate();
                    pointer++;
                }
            }
        }

        if (size == 2) {
            fields = new Fields[64];
            int pointer = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Point coordinate = new Point(i, j);
                    fields[pointer] = new Fields(coordinate);
                    //fields[pointer].printCoordinate();
                    pointer++;
                }
            }
        }

        if (size == 3) {
            fields = new Fields[100];
            int pointer = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    Point coordinate = new Point(i, j);
                    fields[pointer] = new Fields(coordinate);
                    //fields[pointer].printCoordinate();
                    pointer++;
                }
            }
        }
    }



    public void printWorld() {
        int pointer = 0;
        int recursion = (int) Math.sqrt(fields.length);


        for (int i = 0; i < (int) Math.sqrt(fields.length); i++) {

            while (Math.round(fields[i].getCoordinate().getX()) < recursion) {
                if (fields[pointer].isHasPlatypus()) {
                    System.out.print("| P");
                    recursion--;
                    pointer++;
                } else {
                    System.out.print("|  ");
                    recursion--;
                    pointer++;
                }
            }

            System.out.print("|\n");
            for (int j = 0; j < Math.sqrt(fields.length); j++) {

                System.out.print("---");
            }
            System.out.print("-");
            System.out.println();
            recursion = (int) Math.sqrt(fields.length);

        }
    }

    public void populateWorld(){
        int platypusIndex = (int)(Math.random() * fields.length);
        System.out.println(platypusIndex);
        fields[platypusIndex].setHasPlatypus(true);
        // implement method to add cheese (or other things) to the fields in the field Array.

        // write method in fields class to implement rng on whether a field receives a cheese.

    }
}

import java.util.ArrayList;

public class World {

    private int size;
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


    public World(int size){
        this.size = size;
        fields = new ArrayList<>();
    }

    public void generateWorld(){
        //methods for each of the sizes of the world (if-statements);
    }

}

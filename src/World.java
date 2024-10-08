import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class World {

    private int size;
    private Fields[] fields;
    private Platypus platypus;

    //Don't know how to do this: A field should have a property of whether cheese is present or not (Boolean);
    //If cheese is present, the platypus eats the cheese and can go further; The cheese property is cleared from that field.


    public World() {
        getSize();
        generateWorld();
        addPlatypus();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void getSize() {
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
                    pointer++;
                }
            }
        }

        if (size == 3) {
            fields = new Fields[144];
            int pointer = 0;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    Point coordinate = new Point(i, j);
                    fields[pointer] = new Fields(coordinate);
                    pointer++;
                }
            }
        }
    }

    public void printTitle() {
        clearScreen();
        System.out.print("   ___  ____   ____   ____    ___  _____   __  __ __  ____    ____  ____     ___  _     \n");
        System.out.print("  /  _]|    \\ |    \\ |    |  /  _]/ ___/  /  ]|  |  ||    \\  /    ||    \\   /  _]| |    \n");
        System.out.print(" /  [_ |  D  )|  _  | |  |  /  [_(   \\_  /  / |  |  ||  _  ||  o  ||  o  ) /  [_ | |    \n");
        System.out.print("|    _]|    /  |  |  | |  | |    _]\\__  |/  /  |  _  ||  |  ||     ||     ||    _]| |___\n");
        System.out.print("|   [_ |    \\ |  |  | |  | |   [_ /  \\ /   \\_ |  |  ||  |  ||  _  ||  O  ||   [_ |     |\n");
        System.out.print("|     ||  .  \\|  |  | |  | |     |\\    \\     ||  |  ||  |  ||  |  ||     ||     ||     |\n");
        System.out.print("|_____||__|\\_||__|__||____||_____| \\___|\\____||__|__||__|__||__|__||_____||_____||_____|\n");
        System.out.println();
        System.out.println();

    }

    public void printWorld() {

        int pointer = 0;            //used to keep track of the index of the field in which we are currently
        for (int i = 0; i < (int) Math.sqrt(fields.length); i++) {

            for (int j = 0; j < Math.sqrt(fields.length); j++) {

                if (fields[pointer].getHasPlatypus()) {
                    System.out.print("| P ");
                    pointer++;
                } else {
                    System.out.print("|   ");
                    pointer++;
                }
            }

            System.out.print("|\n");
            for (int j = 0; j < Math.sqrt(fields.length); j++) {

                System.out.print("----");
            }
            System.out.print("-\n");

        }
    }

    public void addPlatypus() {

        //configure field to have platypus
        int randomLocation = (int) (Math.random() * fields.length);
        System.out.println("The platypus starts in field : " + (randomLocation + 1));
        fields[randomLocation].setHasPlatypus(true);

        //configure platypus to be linked to field
        platypus = new Platypus();
        platypus.setPosition(fields[randomLocation]);
    }

    public void getMovement() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Which way do you want to go? ('a' = left, 'd' = right, 'w' = up, 's' = down");
            String direction = scanner.next();

            switch (direction) {
                case "a":
                    moveLeft();
                    clearScreen();
                    printWorld();
                    break;
                case "d":
                    moveRight();
                    clearScreen();
                    printWorld();
                    break;
                case "w":
                    moveUp();
                    clearScreen();
                    printWorld();
                    break;
                case "s":
                    moveDown();
                    clearScreen();
                    printWorld();
                    break;
            }
        }
    }

    public void moveLeft() {
        int index = Arrays.asList(fields).indexOf(platypus.getPosition());
        fields[index].setHasPlatypus(false);
        fields[index - 1].setHasPlatypus(true);
        platypus.setPosition(fields[index - 1]);
    }

    public void moveRight() {
        int index = Arrays.asList(fields).indexOf(platypus.getPosition());
        fields[index].setHasPlatypus(false);
        fields[index + 1].setHasPlatypus(true);
        platypus.setPosition(fields[index + 1]);

    }

    public void moveUp() {
        int index = Arrays.asList(fields).indexOf(platypus.getPosition());
        fields[index].setHasPlatypus(false);
        fields[index - (int) Math.sqrt(fields.length)].setHasPlatypus(true);
        platypus.setPosition(fields[index - (int) Math.sqrt(fields.length)]);
    }

    public void moveDown() {
        int index = Arrays.asList(fields).indexOf(platypus.getPosition());
        fields[index].setHasPlatypus(false);
        fields[index + (int) Math.sqrt(fields.length)].setHasPlatypus(true);
        platypus.setPosition(fields[index + (int) Math.sqrt(fields.length)]);
    }

    // implement method to add cheese (or other things) to the fields in the field Array.

    // write method in fields class to implement rng on whether a field receives a cheese.


}

import java.util.Scanner;

public class Console {
    public static void print(String printmsg) {
        System.out.println(printmsg);
    }

    public static int readInt(String msg) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int parsedInt = Integer.MIN_VALUE;
        while (!valid) {
            print(msg);
            String userInput = input.nextLine();
            try {
                parsedInt = Integer.parseInt(userInput);
                valid = true;
            } catch (NumberFormatException ex) {
                //keep looping
            }
        }
        return parsedInt;
    }

    public static int readInt(String msg, int min, int max) {
        int x = readInt(msg);

        while (x > max || x < min) {
            x = readInt(msg);

        }
        return x;
    }

    public static double readDouble(String msg) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        double parsedDouble = Double.NaN;
        while (!valid) {
            print(msg);
            String userInput = input.nextLine();
            try {
                parsedDouble = Double.parseDouble(userInput);
                valid = true;
            } catch (NumberFormatException ex) {
                //keep looping
            }
        }
        return parsedDouble;
    }

    public static double readDouble(String msg, double max, double min) {

        double x = readDouble(msg);

        while (x < max || x > min) {
            x = readDouble(msg);
        }

        return x;
    }

    public static float readFloat(String msg) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        float parsedFloat = Float.MIN_VALUE;
        while (!valid) {
            print(msg);
            String userInput = input.nextLine();
            try {
                parsedFloat = Float.parseFloat(userInput);
                valid = true;
            } catch (NumberFormatException ex) {
                //keep looping
            }
        }
        return parsedFloat;
    }

    public static float readFloat(String msg, float max, float min) {

        float x = readFloat(msg);

        while (x < max || x > min) {
            x = readFloat(msg);
        }

        return x;
    }


}

import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {

        System.out.println("Woven threads: Chapter 1");
        System.out.println("you walk into a house. The door closes behind you. in front of you there are two doors" +
                "pick left or right");

        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();

        if(answer.equals("left")){
            System.out.println("you see two more doors in front of you.");
            answer = input.nextLine();

            if(answer.equals("left")){
                System.out.println("you fell into a spike pit");
            }

            else if(answer.equals("right")){
                System.out.println("you start getting chased by a ghost. there are two tunnels infront of you.");
                answer = input.nextLine();
                if(answer.equals("possess")){
                    System.out.println("You have possessed the ghost, you may now freely leave.");
                }
                else
                    System.out.println("You werent fast enough, the ghost possessed you");
            }

        }
        else if(answer.equals("right")){
            System.out.println("after the doorway you make it up the stairs. at the end of the hall is a " +
                    "giant spider. there are two rooms to hide in, left or right");
            answer = input.nextLine();

            if(answer.equals("left")){
                System.out.println("after closing the door, you use your phone as a flashlight. The room is filled with" +
                        "the babies of the giant spider. you die");
            }

            else if(answer.equals("right")){
                System.out.println("there is a window with an escape ladder. You can either climb down or jump down");
                answer = input.nextLine();

                if (answer.equals("climb")){
                    System.out.println("you take too long to go down the ladder. The spider catches up and breaks the ladder." +
                            " You die");
                }

                else if(answer.equals("jump")){
                    System.out.println("you safely land on some bushes and escape alive.");
                }
            }
        }
    }
}

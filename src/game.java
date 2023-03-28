import java.util.Scanner; import java.util.Random;


public class game {
    static Random Rand = new Random(); static Scanner Scan = new Scanner(System.in);
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnterKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }
    public static void randomEvent(hero main){
        int seed = 1; int DL = 14;
        switch (seed){
            case 1: {
                System.out.println("As you walk towards the streets you notice a young boy as he is being beaten by a group of poor and drunk man. Would you " +
                        "help him? (y/n)"); char answ = Scan.next().charAt(0);
                while(answ != 'y' && answ != 'n') {
                    System.out.println("y/n");
                    answ = Scan.next().charAt(0);
                }
                if(answ == 'n'){
                    System.out.println("You decided not to help the boy. He lies on the ground as you walk past him.");
                    main.currSan -=2;
                    System.out.println("Your sanity is lowered by 2 and is currently at: " + main.currSan);
                }
                else {
                    System.out.println("You're a hero and heroes need to help others. What will you do now, as you have approached drunk men?");
                    System.out.println("1. Threat them - they will fear (CHAR check)");
                    System.out.println("2. Fight them - they will know your strength (STR check)");
                    int answ2 = Scan.nextInt();
                    if(answ2 == 1){
                        game.pressEnterKeyToContinue(); game.clearScreen();
                        System.out.println("You tell the drunks what horrible things you are willing to do to them.");
                        if(main.check(4) > DL){
                            System.out.println("They run away like cowards they are. (Success)");
                            System.out.println("EXP + 10\nGold + 10"); main.exp +=10; main.gold +=10;
                        }
                        else{
                            System.out.println("They are not scared of you and you are all alone now with them... (Failure)");
                            System.out.println("You feel weak and stupid now. You also got beaten.");
                            System.out.println("HP - 1\nSanity -2"); main.currSan -=2; main.currHp--;
                        }

                    }
                    else if(answ2 == 2){
                        game.pressEnterKeyToContinue(); game.clearScreen();
                        System.out.println("You approach them with lethal intends. ");
                        if(main.check(1) > DL){
                            System.out.println("They were no match for you.");
                            System.out.println("EXP + 10\nGold + 10"); main.exp +=10; main.gold +=10;
                        }
                        else{
                            System.out.println("You were no match for them... (Failure)");
                            System.out.println("You feel weak and stupid now. You also got beaten.");
                            System.out.println("HP - 1\nSanity -2"); main.currSan -=2; main.currHp--;
                        }
                    }
                }

            }
        }
    }
    static int question(){
        int answ;
        System.out.println("So, what would you like to do?");
        System.out.println("1. Go for a quest");
        System.out.println("2. Rest in a Inn");
        System.out.println("3. Reflect onto myself");
        System.out.println("4. Quit");
        answ = Scan.nextInt();
        return answ;
    }
    static void gameOver(){
        System.out.println("GAME OVER!");
        System.exit(0);
    }
}

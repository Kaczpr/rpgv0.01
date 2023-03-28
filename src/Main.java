public class Main {
    public static void main(String[] args) {
    hero protag = new hero();
    protag.create();
    while(protag.currHp > 0 && protag.currSan > 0) {
        game.pressEnterKeyToContinue();
        game.clearScreen();
        switch (game.question()) {
            case 1:{
                game.randomEvent(protag); break;
            }
            case 2: {
                protag.rest(); break;
            }
            case 3: {
                protag.showExtra(); break;
            }
            case 4: {
                System.exit(0);
            }
            default: {
                System.out.println("No option like that"); break;
            }
        }
    }
    game.gameOver();
    }
}
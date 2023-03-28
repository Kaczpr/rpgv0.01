import java.util.Random;
import java.util.Scanner;

public class hero {
    Scanner scan = new Scanner(System.in);
    Random Rand = new Random();

    double hp, mp;
    String name;
    double S, Dex, Con, Int, Wis, Char;
    double mS, mDex, mCon, mInt, mWis, mChar;

    void setModifiers(){
        this.mS =   (this.S-10)/2; this.mS = Math.ceil(this.mS);
        this.mDex = (this.Dex-10)/2; this.mDex = Math.ceil(this.mDex);
        this.mCon = (this.Con-10)/2; this.mCon = Math.ceil(this.mCon);
        this.mInt = (this.Int-10)/2; this.mInt = Math.ceil(this.mInt);
        this.mWis = (this.Wis-10)/2; this.mWis = Math.ceil(this.mWis);
        this.mChar = (this.Char-10)/2; this.mChar = Math.ceil(this.mChar);
        this.hp = 20 + this.mCon;
    }
    hero(String name, Integer hp, Integer mp, Integer S, Integer Dex, Integer Con, Integer Int, Integer Wis, Integer Char){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.S = S;
        this.Dex = Dex;
        this.Con = Con;
        this.Int = Int;
        this.Wis = Wis;
        this.Char = Char;
        this.setModifiers();
    }
    hero(){
        this.name = "noName";
        this.hp = 10;
        this.mp = 10;
        this.S = 10;
        this.Dex = 10;
        this.Con = 10;
        this.Int = 10;
        this.Wis = 10;
        this.Char = 10;
        this.setModifiers();
    };
    void hello (){

        System.out.println("Hello I'm " + this.name + "!");
    }
    double attack(){
        double toHit = 0;
        int dice = Rand.nextInt(20) + 1;
        toHit = this.mS + dice;
        System.out.println(this.name + " attacks! " + toHit + "( S: " + this.mS + " + Dice: " + dice + ") to hit!");
        return toHit;
    }
    void showExtra(){
        System.out.println("Mighty " + this.name + "'s statistics: ");
        System.out.println("Health points, your vitality: " + this.hp);
        System.out.println("Strength, measuring physical power: " + this.S + " (+" + this.mS + ")" +
                "\nDexterity, measuring agility: " + this.Dex + " (+" + this.mDex + ")" +
                "\nConstitution, measuring endurance: " + this.Con + " (+" + this.mCon + ")" +
                "\nIntelligence, measuring reasoning and memory: " + this.Int + " (+" + this.mChar + ")" +
                "\nWisdom, measuring Perception and Insight: " + this.Wis + " (+" + this.mWis + ")" +
                "\nCharisma, measuring force of Personality: " + this.Char  + " (+" + this.mChar + ")");
    }
    void show(){
        System.out.println("Strength: " + this.S +
                "\nDexterity:" + this.Dex +
                "\nConstitution: " + this.Con +
                "\nIntelligence: " + this.Int +
                "\nWisdom: " + this.Wis +
                "\nCharisma: " + this.Char);
    }
    void increase(){
        int choice;
        System.out.println("What skill would you like to increase? 1 - S; 2 - Dex; 3 - Con; 4 - Int; 5 - Wis; 6 - Char");
        choice = scan.nextInt();
        switch (choice){
            case 1: this.S ++ ; break;
            case 2: this.Dex ++ ; break;
            case 3: this.Con ++ ; break;
            case 4: this.Int ++ ; break;
            case 5: this.Wis ++ ; break;
            case 6: this.Char ++ ; break;
        }
    }
    boolean decrease(){
        int choice;
        System.out.println("What skill would you like to decrese? 1 - S; 2 - Dex; 3 - Con; 4 - Int; 5 - Wis; 6 - Char");
        choice = scan.nextInt();
        switch (choice){
            case 1: if(this.S > 8) this.S -- ; else {
                System.out.println("Skill cannot be lesser then 8!");
                return false;
            } break;
            case 2: if(this.Dex > 8) this.Dex -- ; else {
                System.out.println("Skill cannot be lesser then 8!");
                return false;
            } break;
            case 3: if(this.Con > 8) this.Con -- ; else {
                System.out.println("Skill cannot be lesser then 8!");
                return false;
            } break;
            case 4: if(this.Int > 8) this.Int -- ; else {
                System.out.println("Skill cannot be lesser then 8!");
                return false;
            } break;
            case 5: if(this.Wis > 8) this.Wis -- ; else {
                System.out.println("Skill cannot be lesser then 8!");
                return false;
            } break;
            case 6: if(this.Char > 8) this.Char -- ; else {
                System.out.println("Skill cannot be lesser then 8!");
                return false;
            } break;
        }
        return true;
    }
    void create(){
        int points = 10; int inOrDec;
        System.out.println("Hi! Tell us, whats your name adventurer? ");
        this.name = scan.nextLine();
        System.out.println("Well, hello there " + this.name + "!");
        game.pressEnterKeyToContinue();
        game.clearScreen();
        System.out.println("Now, let us hear about your skills. Currently your skills are looking like this:");
        this.showExtra();
        System.out.println("You have " + points + " points to increase your skills. Increasing each skill by one point costs one point.\nYou can also decrease " +
                "your skills to gain extra points, but remember - your skill cannot be lesser then 8\n" +
                "Now..."); game.pressEnterKeyToContinue(); game.clearScreen();
        while(points > 0){
            System.out.print("Would you like to increase, or decrease your skill? (1 - Increase, 2 - Decrease)");
            inOrDec = scan.nextInt();
            switch (inOrDec){
                case 1: this.increase(); points --; break;
                case 2:
                    if(this.decrease()) points++;
                    break;
            }
            this.show();
            System.out.println("Points left: " + points);
            game.pressEnterKeyToContinue(); game.clearScreen();
        }
        System.out.println("You're out of points now, so lets look at how your character looks."); this.setModifiers();
        game.pressEnterKeyToContinue(); game.clearScreen();
        this.showExtra();
        game.pressEnterKeyToContinue(); game.clearScreen();
        System.out.println("Your, my friend, are quite ready to set forth into this fantasy lands! Take care!"); game.pressEnterKeyToContinue(); game.clearScreen();
    }
}

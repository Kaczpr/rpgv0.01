import java.util.Random;
import java.util.Scanner;

public class hero {
    Scanner scan = new Scanner(System.in);
    Random Rand = new Random();

    double hp, san;
    String name;
    double S, Dex, Con, Int, Wis, Char;
    double mS, mDex, mCon, mInt, mWis, mChar;
    int exp, gold;

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
        this.san = mp;
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
        this.san = 10;
        this.S = 10;
        this.Dex = 10;
        this.Con = 10;
        this.Int = 10;
        this.Wis = 10;
        this.Char = 10;
        this.setModifiers();
        this.exp = 0;
    };
    void hello (){

        System.out.println("Hello I'm " + this.name + "!");
    }
    double whatSkill(int skill){
        double ret;
        switch(skill){

            case 1: ret =    this.mS; break;
            case 2: ret =    this.mDex; break;
            case 3: ret =    this.mCon; break;
            case 4: ret =    this.mInt; break;
            case 5: ret =    this.mWis; break;
            case 6: ret =    this.mChar; break;
            default: ret =  0; break;
        }
        return ret;
    }
    double whatFullSkill(int skill){
        double ret;
        switch(skill){

            case 1: ret =    this.S; break;
            case 2: ret =    this.Dex; break;
            case 3: ret =    this.Con; break;
            case 4: ret =    this.Int; break;
            case 5: ret =    this.Wis; break;
            case 6: ret =    this.Char; break;
            default: ret =  0; break;
        }
        return ret;
    }
    double check(int skill){
        double toHit = 0;
        int dice = Rand.nextInt(20) + 1;
        toHit = this.mS + dice;
        System.out.println("Lets roll the dice..."); game.pressEnterKeyToContinue();
        System.out.println("Your results are: " + toHit + " (" + dice + " + " + whatSkill(skill) + ")");
        return toHit;
    }
    void showExtra(){
        System.out.println("Mighty " + this.name + "'s statistics: ");
        System.out.println("Health points, measuring your vitality: " + this.hp);
        System.out.println("Sanity points, measuring your Will to adventure forth" + this.san);
        System.out.println("Strength, measuring physical power: " + this.S + " (+" + this.mS + ")" +
                "\nDexterity, measuring agility: " + this.Dex + " (+" + this.mDex + ")" +
                "\nConstitution, measuring endurance: " + this.Con + " (+" + this.mCon + ")" +
                "\nIntelligence, measuring reasoning and memory: " + this.Int + " (+" + this.mChar + ")" +
                "\nWisdom, measuring Perception and Insight: " + this.Wis + " (+" + this.mWis + ")" +
                "\nCharisma, measuring force of Personality: " + this.Char  + " (+" + this.mChar + ")");
        System.out.println("Experience points, measuring experience you've gained along the way: " + this.exp);
        System.out.println("Gold coins, measuring your wealth: " + this.gold);
    }
    void show(){
        System.out.println("Strength: " + this.S +
                "\nDexterity:" + this.Dex +
                "\nConstitution: " + this.Con +
                "\nIntelligence: " + this.Int +
                "\nWisdom: " + this.Wis +
                "\nCharisma: " + this.Char);
    }
    void increase(int howMany, int choice){

        switch (choice){
            case 1: this.S += howMany ; break;
            case 2: this.Dex += howMany ; break;
            case 3: this.Con += howMany ; break;
            case 4: this.Int += howMany ; break;
            case 5: this.Wis += howMany ; break;
            case 6: this.Char += howMany ; break;
        }
    }

    void decrease(int howMany, int choice){

        switch (choice){
            case 1: if(this.S > 8) this.S -= howMany ; else {
                System.out.println("Skill cannot be lesser then 8!");
            } break;
            case 2: if(this.Dex > 8) this.Dex -= howMany ; else {
                System.out.println("Skill cannot be lesser then 8!");
            } break;
            case 3: if(this.Con > 8) this.Con -= howMany ; else {
                System.out.println("Skill cannot be lesser then 8!");
            } break;
            case 4: if(this.Int > 8) this.Int -= howMany ; else {
                System.out.println("Skill cannot be lesser then 8!");
            } break;
            case 5: if(this.Wis > 8) this.Wis -= howMany ; else {
                System.out.println("Skill cannot be lesser then 8!");
            } break;
            case 6: if(this.Char > 8) this.Char -= howMany ; else {
                System.out.println("Skill cannot be lesser then 8!");
            } break;
        }
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
            int choice;
            System.out.println("What skill would you like to increase/decrease? 1 - S; 2 - Dex; 3 - Con; 4 - Int; 5 - Wis; 6 - Char");
            choice = scan.nextInt();
            System.out.println("And by how many points? "); int howMany = scan.nextInt();


            switch (inOrDec) {
                case 1: {
                    if (howMany > points) {
                        System.out.println("You don't have that many points left friend");
                    } else {
                        this.increase(howMany, choice);
                        points -= howMany;

                    }
                    break;
                }
                case 2: {
                    if (howMany > (whatFullSkill(choice) - 8)) {
                        System.out.println("Skill cannon be lesser then 8");
                    }
                    else {
                        this.decrease(howMany, choice);
                        points += howMany;
                    }
                    break;
                }
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

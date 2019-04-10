/**
 * Does Mao work?!?!?
 */
import java.util.*;
public class MaoTester
{
    public static void main(String [] args){
        Scanner thunter = new Scanner(System.in);
        Scanner looker = new Scanner(System.in);
        Random blaine = new Random();
        String str;
        System.out.println("1 - Cook up some random rules.");
        System.out.println("2 - Check whether a random card is of a random type.");
        System.out.println("3 - Check out whoTurn.");
        System.out.println("4 - Check out whatNext.");
        System.out.println("Anything else - Leave immediately.");
        str = thunter.nextLine();
        System.out.println();
        System.out.println();
        System.out.println();
        while(str.equals("1")||str.equals("2")||str.equals("3")||str.equals("4")){
            switch(str){
                case "1":   int human = Mao.randyRules(1);
                            int alice = Mao.randyRules(2);
                            int bob = Mao.randyRules(3);
                            int charlie = Mao.randyRules(4);
                            System.out.println("Here are some random rules.");
                            System.out.println(human+": "+Mao.stringRule(human));
                            System.out.println(alice+": "+Mao.stringRule(alice));
                            System.out.println(bob+": "+Mao.stringRule(bob));
                            System.out.println(charlie+": "+Mao.stringRule(charlie));
                            break;
                case "2":   Deck deck = new Deck();
                            deck.shuffle();
                            Card card = deck.deal();
                            System.out.println();
                                int type = Mao.randomCardType();
                            System.out.println("Card: "+card);
                            System.out.println(type+":"+Mao.cardType(type));
                            System.out.println(Mao.itsAMatch(card,type));
                            break;
                case "3":   ArrayList<Integer> rules = new ArrayList<Integer>();
                            int move1 = 0;
                            int move2 = 0;
                            System.out.println("You wanna make up some moves or should I? Type 1 or 2.");
                            if(looker.nextInt()==1){
                                System.out.println("Enter a move as a 5-digit integer");
                                move1 = looker.nextInt();
                                System.out.println("Enter the move that followed it.");
                                move2 = looker.nextInt();
                            }else{
                                move1 = (blaine.nextInt(4)+1)*10000+1000+(blaine.nextInt(4)+1)*100+blaine.nextInt(13)+1;
                                move2 = (blaine.nextInt(4)+1)*10000+1000+(blaine.nextInt(4)+1)*100+blaine.nextInt(13)+1;
                            }
                            System.out.println("You wanna make up some rules or should I? Type 1 or 2.");
                            if(looker.nextInt()==1){
                                System.out.println("Type the nine- or ten-digit integer representing a rule.");
                                System.out.println("Keep doing this till you want to stop. Then, press -1.");
                                int rule = looker.nextInt();
                                while(rule!=-1){
                                    rules.add(rule);
                                }
                            }else{
                                System.out.println("No problem! How many would you like?");
                                int amount = looker.nextInt();
                                for(int i=0; i<amount; i++){
                                    rules.add(Mao.randyRules(blaine.nextInt(4)+1));
                                }
                            }
                            System.out.println("Okay, so here are the rules.");
                            for(int i=0; i<rules.size(); i++)
                                System.out.println(rules.get(i)+": "+Mao.stringRule(rules.get(i)));
                            System.out.println("And here are the moves!");
                            System.out.println(move1+": "+Mao.stringMove(move1));
                            System.out.println(move2+": "+Mao.stringMove(move2));
                            System.out.println(Mao.whoTurn(move1,move2,rules)+": According to these rules, it is "+Mao.numToPlaya(Mao.whoTurn(move1, move2, rules))+"'s turn.");
                            break;
                case "4":   ArrayList<Integer> rodrick = new ArrayList<Integer>();
                            int move = 0;
                            System.out.println("You wanna make up the move or should I? Type 1 or 2.");
                            if(looker.nextInt()==1){
                                System.out.println("Enter a move as a 5-digit integer");
                                move = looker.nextInt();
                            }else{
                                move = (blaine.nextInt(4)+1)*10000+1000+(blaine.nextInt(4)+1)*100+blaine.nextInt(13)+1;
                            }
                            System.out.println("You wanna make up some rules or should I? Type 1 or 2.");
                            if(looker.nextInt()==1){
                                System.out.println("Type the nine- or ten-digit integer representing a rule.");
                                System.out.println("Keep doing this till you want to stop. Then, press -1.");
                                int rule = looker.nextInt();
                                while(rule!=-1){
                                    rodrick.add(rule);
                                }
                            }else{
                                System.out.println("No problem! How many would you like?");
                                int amount = looker.nextInt();
                                for(int i=0; i<amount; i++){
                                    rodrick.add(Mao.randyRules(blaine.nextInt(4)+1));
                                }
                            }
                            System.out.println("Okay, so here are the rules.");
                            for(int i=0; i<rodrick.size(); i++)
                                System.out.println(rodrick.get(i)+": "+Mao.stringRule(rodrick.get(i)));
                            System.out.println("And here is the move!");
                            System.out.println(move+": "+Mao.stringMove(move));
                            System.out.println("According to these rules,"+Mao.whatNext(move,rodrick)+" must be played.");
                default:    break;
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Now what?");
            str = thunter.nextLine();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}
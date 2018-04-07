/**
 * Write a description of class AABattleSimulator here.
 * This program simulates battles in the Axis and Allies 1942 board game Second Edition
 * @author (Emmanuel Rosario) 
 * @version (1/25/2016)
 **/
import java.util.*;// importing a vital packages necessary to carry certain methods in this program
public class AABattleSimulator{
    private int length = 1000 ;// the number of simulations or battles- the default value is 1000
    private ArrayList<Pairs> attackPack = new ArrayList<Pairs>();// where the attacking side units will be placed in
    private ArrayList<Pairs> defensePack = new ArrayList<Pairs>();// where the defensive side units will be placed in

    /**
     * Constructor for objects of class AABattle
     * @param attack - an array of attacking units in cost order
     * @param defense - an array of defensive units in cost order
     * The simulation length is also initialized 
     */
    public AABattleSimulator(int[] attack, int[] defense){
        int count = 0;
        // this big if- else statement handles the infantry-artillery support system
        if(attack[0] > 0 && attack[1] > 0){
            if(attack[0] < attack[1]){// if there is more artillery than infantry
                while(count < attack[0]){
                    attackPack.add(new Pairs(2,"Ground"));// all infantry will be supported
                    count++;  
                }
            }

            else if (attack[0] > attack[1]){ // if there is more infantry than artilley
                while(count < attack[0]-attack[1]){//first add the unsupported infantry units
                    attackPack.add(new Pairs(1,"Ground"));
                    count++;
                }
                while(count < attack[0]){// now adding supported infantry units
                    attackPack.add(new Pairs(2,"Ground"));
                    count++;
                }
            }
            else{
                while(count < attack[0]){
                    attackPack.add(new Pairs(2,"Ground"));
                    count++;
                }
            }
        }
        else{
            if(attack[0] > 0){
                while(count < attack[0]){
                    attackPack.add(new Pairs(1,"Ground"));
                    count++;
                }
            }
        }
        
        // these next 4 for loops take care of the other 4 battle units for the attackPack arraylist in cost order
        for(int a = 0; a < attack[1]; a++){
            attackPack.add(new Pairs(2,"Ground"));
        }
        for(int t = 0; t < attack[2]; t++){
            attackPack.add(new Pairs(3,"Ground"));
        }
        for(int f = 0; f < attack[3]; f++){
            attackPack.add(new Pairs(3,"Aerial"));
        }
        for(int b = 0; b < attack[4]; b++){
            attackPack.add(new Pairs(4,"Aerial"));
        }

        // these 5 for loops enters the defensive units in defensePack arraylist in cost order
        for(int I = 0; I < defense[0]; I++){
            defensePack.add(new Pairs(2,"Ground"));
        }
        for(int A = 0; A < defense[1]; A++){
            defensePack.add(new Pairs (2,"Ground"));
        }
        for(int T = 0; T < defense[2]; T++){
            defensePack.add(new Pairs (3,"Ground"));
        }
        for(int F = 0; F < defense[3]; F++){
            defensePack.add(new Pairs (4,"Aerial"));
        }
        for(int B = 0; B < defense[4]; B++){
            defensePack.add(new Pairs (1,"Aerial"));
        }
        this.length = length;// the length is initialized to what it is initialized in the setSimulationLength method - it would be called in the Lim's Driver class
    }

    /**
     * Runs a Simulation of an Axis and Allies Battle and determines the probablity of victory of the attacking
     * force. Casualities are removed by cheapest(cost-wise) troops first
     * @return chance -  the chance or probability of the attacking force winning
     */
    public double run(){
        // creating copies of the attackPack and defensePack arraylist - will be used later in this method
        ArrayList<Pairs> copyAttack = new ArrayList<Pairs>();
        copyAttack.addAll(attackPack);
        ArrayList<Pairs> copyDefense = new ArrayList<Pairs>();
        copyDefense.addAll(defensePack);

        int attackWin = 0;// will keep count of how many times the attackPack wins 
        double chance = 0;// will be used in the end of the method to return the probability of the attackPack force winning
        for(int k = 0; k < this.length; k++){// this for loops handles the simulation length - if the length is 1000 - this will loop 1000 times
            while(attackPack.size() > 0 && defensePack.size() > 0){// this while loop will loop for one whole battle
                // this is simulating the rolls and counting the hits
                int hit = 0;
                for(int i = 0; i < attackPack.size(); i++){
                    int roll = dieRoll();
                    if(roll <= attackPack.get(i).value){
                        hit++;
                    }
                }

                // this is doing the same but for the defense side
                int enemyHit = 0;
                for(int j = 0; j < defensePack.size(); j++){
                    int roll1 = dieRoll();
                    if(roll1 <= defensePack.get(j).value){
                        enemyHit++;
                    }
                }

                //removing casualties from the defenders
                while(hit > 0 && defensePack.size() > 0){
                    defensePack.remove(0);
                    hit--;
                }

                // removing casualities from the attacker 
                while(enemyHit > 0 && attackPack.size() > 0){
                    attackPack.remove(0);
                    enemyHit--;
                }
            }
            // using my helper - this if-else statement will determine who is the winner and keep count how many times the attackPack wins
            if(determineVictor() == attackPack){
                //System.out.println("Attack Won");
                attackWin++;
            }
            else{
                //System.out.println("Defense Won");
            }
            // now both arraylists are cleared and then the objects in their copies are added back to them 
            // so essentially I am restarting the arraylist for the next simulation
            attackPack.clear();
            attackPack.addAll(copyAttack);
            defensePack.clear();
            defensePack.addAll(copyDefense);
        }
        chance = (double)attackWin/this.length;
        return chance;
    }

    /**
     * This method sets the simulation length, which by default starts at 1000.
     * @param len - the number of simulations or simulatin length the user desires
     */
    public void setSimulationLength(int len){
        this.length = len;
    }
    
    /**
     * This method returns the winner of each battle or simulation
     * @return attackPack or defensePack - depends on who is the winner 
     */
    public ArrayList<Pairs> determineVictor(){
        for(int i = 0; i < attackPack.size(); i++){
            if((attackPack.get(i).type.equals("Ground") ) && defensePack.size() == 0){
                return attackPack; // the attackPack only wins if they wiped out the defensePack and have atleast one "Ground" unit remaining
            }
        }
        return defensePack; //the defensePack wins if the if statement is not meant
    }

    /**
     * This method simulates a dice roll with numbers between 1-6
     * @return roll - the number the die rolls on 
     */
    public int dieRoll(){
        Random rand = new Random();// random object is creating
        int roll = rand.nextInt(6)+1;// random int between 1-6 is rolled 
        return roll;// the roll is returned
    }
}


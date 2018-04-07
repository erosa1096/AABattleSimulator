------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:


public int[] getUnits()
    {
        int [] units = new int[5];
        Scanner in = new Scanner(System.in);
        
        System.out.print("Number of infrantry units: ");
        int answer1 = in.nextInt();
        units[0] = answer1;
        
        System.out.print("Number of artillery units: ");
        int answer2 = in.nextInt();
        units[1] = answer2;
        
        System.out.print("Number of tank units: ");
        int answer3 = in.nextInt();
        units[2] = answer3;
        
        System.out.print("Number of fighter units: ");
        int answer4 = in.nextInt();
        units[3] = answer4;
        
        System.out.print("Number of bomber units: ");
        int answer5 = in.nextInt();
        units[4] = answer5;
        
        return units;
    }
    
   
    
    attackPack.size() != 0 || defensePack.size() != 0
    
            //         attackPack.addAll(infantry);
        //         attackPack.addAll(artillery);
        //         attackPack.addAll(tank);
        //         attackPack.addAll(fighter);
        //         attackPack.addAll(bomber);
        // 
        //         defensePack.addAll(enemyInfantry);
        //         defensePack.addAll(enemyArtillery);
        //         defensePack.addAll(enemyTank);
        //         defensePack.addAll(enemyFighter);
        //         defensePack.addAll(enemyBomber);
        
        
            private ArrayList<Integer> infantry = new ArrayList<Integer>();
    private ArrayList<Integer> artillery = new ArrayList<Integer>();
    private ArrayList<Integer> tank = new ArrayList<Integer>();
    private ArrayList<Integer> fighter = new ArrayList<Integer>();
    private ArrayList<Integer> bomber = new ArrayList<Integer>();

    private ArrayList<Integer> enemyInfantry = new ArrayList<Integer>();
    private ArrayList<Integer> enemyArtillery = new ArrayList<Integer>();
    private ArrayList<Integer> enemyTank = new ArrayList<Integer>();
    private ArrayList<Integer> enemyFighter = new ArrayList<Integer>();
    private ArrayList<Integer> enemyBomber = new ArrayList<Integer>();

    
    
     //if(attack[0] > 0 && attack[1] > 0){
        if(attack[0] > attack[1]){
            while(count < attack[0]-attack[1]+1){
                attackPack.add(new Pairs(2,"Ground"));
                count++;
            }
        }
        else if (attack[0] < attack[1]){
            while(count < attack[1]-attack[0] ){
                attackPack.add(new Pairs(2,"Ground"));
                count++;
            }
        }
        else
        {
            while(count < attack[0])
            {
                attackPack.add(new Pairs(2,"Ground"));
                count++;
            }
        }
        //}

        
        

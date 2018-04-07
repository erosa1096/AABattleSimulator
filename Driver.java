import java.util.*;
/**
 * Test Driver for Homework #1: Axis & Allies 1942, 2nd Edition
 * 
 * @author Darren Lim
 * @version 1.0
 */
public class Driver
{
    /**
     * Main program for our Driver
     * 
     * @param args  Command Line Arguments
     */
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Type in the number of attacking infantry units =>");
        int aInfantry, aArtillery, aTank, aFighter, aBomber, dInfantry, dArtillery, dTank, dFighter, dBomber;
        aInfantry = Integer.parseInt(s.next());
        System.out.print("Type in the number of attacking artillery units =>");
        aArtillery = Integer.parseInt(s.next());
        System.out.print("Type in the number of attacking tank units =>");
        aTank = Integer.parseInt(s.next());
        System.out.print("Type in the number of attacking fighter units =>");
        aFighter = Integer.parseInt(s.next());
        System.out.print("Type in the number of attacking bomber units =>");
        aBomber = Integer.parseInt(s.next());
        System.out.print("Type in the number of defending infantry units =>");
        dInfantry = Integer.parseInt(s.next());
        System.out.print("Type in the number of defending artillery units =>");
        dArtillery = Integer.parseInt(s.next());
        System.out.print("Type in the number of defending tank units =>");
        dTank = Integer.parseInt(s.next());
        System.out.print("Type in the number of defending fighter units =>");
        dFighter = Integer.parseInt(s.next());
        System.out.print("Type in the number of defending bomber units =>");
        dBomber = Integer.parseInt(s.next());
        AABattleSimulator simulator = new AABattleSimulator(new int[]{aInfantry, aArtillery, aTank, aFighter, aBomber},
                    new int[]{dInfantry, dArtillery, dTank, dFighter, dBomber});
        simulator.setSimulationLength(300000);//300 000
        System.out.println(simulator.run());
        s.close();
    }
}

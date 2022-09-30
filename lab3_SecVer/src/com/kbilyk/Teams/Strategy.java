package com.kbilyk.Teams;

import com.kbilyk.Droids.Droid;
import com.kbilyk.Droids.GunDroid;
import com.kbilyk.Droids.LaserDroid;
import com.kbilyk.Droids.RepairDroid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import static com.kbilyk.Controllers.Correct.checkCorrect;

/**
 * The strategy of team
 * Choose how team will the enemies
 */
public class Strategy {
    private LinkedList<Droid> attackPrior = new LinkedList<>(); // The ordered list of enemy droids
    private final ArrayList<Droid> priorDroid = new ArrayList<>(); // The ordered list of classes enemies droids

    private final Team currTeam;    // The current team
    private final Team enemies;     // The enemy team
    private boolean isFullRandom;   // is all team members hit random (absolute random strategy)

    /**
     * Constructor
     * @param currTeam The team for which the strategy is prescribed
     * @param enemies The enemy team
     */
    public Strategy(Team currTeam, Team enemies) {
        this.currTeam = currTeam;
        this.enemies = enemies;
        initAttackers();
    }


    /**
     * Initializing the behavior for the attacking droids
     */
    private void initAttackers() {
        System.out.println("\n-------------------------------------");
        System.out.println(currTeam.getName() + "`s strategy!");
        System.out.println("The count of attackers in " + currTeam.getName() + " team is " + currTeam.attackersList().size());
        System.out.println("How many attackers will have random strategy?");

        int random = checkCorrect(0, currTeam.attackersList().size());


        currTeam.setRandomAttackers(random);
        randomAttackers();

        // it`s full random attackers strategy - form list of enemies and end the method
        if(random == currTeam.attackersList().size()){
            setFullRandom(true);
            formList();
            return;
        }

        // init in which order attack the enemies
        LinkedList<String> droidsName = new LinkedList<String>();
        System.out.println("-------------------------------------");
        droidsName.add("Gun droids");
        droidsName.add("Laser droids");
        droidsName.add("Repair droids");
        System.out.println("Which type of droids do you want to attack in the first place? Type a number");
        formOrder(droidsName);
        System.out.println("Which type of droids do you want to attack in the second place?");
        formOrder(droidsName);
        System.out.println("Which type of droids do you want to attack in the third place?");
        formOrder(droidsName);
        formList(); // form the list of enemies
    }

    /**
     * Method order of classes (which class of droids attack in a first, second place..)
     * @param droidsName The names of droid class
     */
    private void formOrder(LinkedList<String> droidsName) {

        // print all available classes
        int i = 1;
        for(String string : droidsName){
            System.out.println(i + " - " + string);
            i++;
        }

        ArrayList<Droid> droids = new ArrayList<>();
        droids.add(new GunDroid());
        droids.add(new LaserDroid());
        droids.add(new RepairDroid());

        // write the type of droid
        int type = checkCorrect(1, droidsName.size());

        // add droid to ordered list of classes
        priorDroid.add(droids.get(type - 1));
        droidsName.remove(type - 1);
    }

    /**
     * Set the strategy to attackers
     */
    public void randomAttackers(){

        // list of attackers of the team
        LinkedList<Droid> attackers = currTeam.attackersList();

        // if it`s full random strategy - set that all members hit randomly
        if(currTeam.getRandomAttackers() == attackers.size()){
            for (Droid droid : attackers){
                droid.setHitRandom(true);
            }
            return;
        }

        // if it isn`t full random strategy -
        // random choose which droids will hit randomly
        int count = 0;
        while(count != currTeam.getRandomAttackers()){
            Random random = new Random();
            int randIndex = random.nextInt(0, currTeam.getRandomAttackers());
            if(!attackers.get(randIndex).isHitRandom()){
                attackers.get(randIndex).setHitRandom(true);
                count++;
            }
        }
    }

    /**
     * Method that form new list of enemies
     * (check who is died, who is reborn)
     */
    public void formList(){
        attackPrior.clear(); // clear current list of enemies

        // check all list of enemies, if alive - add in refreshed attack list
        // full random strategy
        if (isFullRandom){
            for(Droid droid : enemies.getTeam()){
                if(droid.isAlive()){
                    attackPrior.add(droid);
                }
            }
            return;
        }

        // strategy is not full random
        // add alive enemy droids in order to priority attack list
        for (Droid value : priorDroid) {
            for (Droid droid : enemies.getTeam()) {
                if (droid.getClass() == value.getClass() && droid.isAlive()) {
                    attackPrior.add(droid);
                }
            }
        }
    }

    /**
     * Get the list of enemies
     * @return The list of enemies
     */
    public LinkedList<Droid> getAttackPrior() {
        return attackPrior;
    }

    /**
     * Set if the strategy of the team is full random
     * @param fullRandom If the strategy of the team is full random
     */
    public void setFullRandom(boolean fullRandom) {
        isFullRandom = fullRandom;
    }

}

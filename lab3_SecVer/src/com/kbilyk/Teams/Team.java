package com.kbilyk.Teams;

import com.kbilyk.Droids.Droid;
import com.kbilyk.Droids.RepairDroid;

import java.util.ArrayList;
import java.util.LinkedList;

public class Team {
    private String name;            // The name of the team
    private ArrayList<Droid> team = new ArrayList<> (); // All members of team
    private LinkedList<Droid> isAlive = new LinkedList<>(); // Members that alive in team
    private int randomAttackers;  // how many attackers hit randomly
    private Strategy strategy;   // strategy for droids

    /**
     * Constructor
     * @param name The name of team
     */
    public Team(String name) {
        this.name = name;
    }

    /**
     * Default constructor
     */
    public Team(){}


    /**
     * All droids attack the enemy team
     */
    public void attack() {

        for (Droid droid : getIsAlive()) {
            // if all enemy droids was killed - end attack
            if (strategy.getAttackPrior().isEmpty()) {
                return;
            }

            if(droid.getClass() != RepairDroid.class){
                droid.attack(strategy.getAttackPrior());
            }
            else{
                ((RepairDroid) droid).attack(this, strategy.getAttackPrior());
            }

            strategy.formList(); // refresh the list of enemy droids
        }
    }

    /**
     * Find the droid with min health
     * @return The droid with min health
     */
    public Droid minHealth(){

        double percenHP = isAlive.get(0).getPerHP();
        int min = 0;

        for(int i = 1; i < isAlive.size(); i++){
            if (isAlive.get(i).getPerHP() < percenHP){
                min = i;
                percenHP = isAlive.get(i).getPerHP();
            }
        }
        return isAlive.get(min);
    }

    /**
     * The list of attackers
     * @return Return the list of attackers of team
     */
    public LinkedList<Droid> attackersList(){

        LinkedList<Droid> attackers = new LinkedList<>();
        for(Droid droid : team){
            if(droid.getClass() != RepairDroid.class){
                attackers.add(droid);
            }
        }
        return attackers;
    }

    /**
     * Print all members of team
     */
    public void printTeam(){
        System.out.println('\n' + getName() + " team:");
        for(Droid droid : team){
            System.out.println(droid);
        }
    }

    /**
     * Method that check if team alive
     * @return true - if team alive, false - another case
     */
    public boolean ifTeamAlive(){
        changeAliveList();
        return !isAlive.isEmpty();
    }

    /**
     * Change the list of alive droids in team
     */
    public void changeAliveList(){
        isAlive.removeIf(droid -> !droid.isAlive());
    }

    /**
     * Refresh all statuses of droid in the team
     * (refresh droid after the battle, set alive, active, health)
     */
    public void setAllAlive(){
        for(Droid droid : team){
            droid.refreshDroid();
        }
    }

    /**
     * Get the name of the team
     * @return The name of the team
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name of the team
     * @param name The new name of the team
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Set the members of team
     * @param team The members of team
     */
    public void setTeam(ArrayList<Droid> team) {
        this.team = team;
        isAlive.addAll(team);
    }

    /**
     * Get the list of team members
     * @return The list of team members
     */
    public ArrayList<Droid> getTeam() {
        return team;
    }

    /**
     * Get the list of alive team members
     * @return The list of alive team members
     */
    public LinkedList<Droid> getIsAlive() {
        return isAlive;
    }

    /**
     * Get how many attackers hit randomly
     * @return How many attackers hit randomly
     */
    public int getRandomAttackers() {
        return randomAttackers;
    }

    /**
     * Set how many attackers hit randomly
     * @param randomAttackers how many attackers hit randomly
     */
    public void setRandomAttackers(int randomAttackers) {
        this.randomAttackers = randomAttackers;
    }

    /**
     * Set strategy of the team
     * @param strategy Strategy of the team
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return this.name + '\n' + team;
    }
}

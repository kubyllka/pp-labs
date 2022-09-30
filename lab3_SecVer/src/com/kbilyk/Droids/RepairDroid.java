package com.kbilyk.Droids;

import com.kbilyk.RepairTools.RepairTool;
import com.kbilyk.Teams.Team;

import java.util.LinkedList;

import static com.kbilyk.Interfaces.DroidInterface.*;

public class RepairDroid extends Droid{

    private RepairTool reptool; // The repair tool for droid
    private int damage;         // The damage of droid if he will hit with his own body

    /**
     * Default constructor
     */
    public RepairDroid() {}


    /**
     * Constructor that set name and repair tool
     * @param Name The name of droid
     * @param tool The repair tool of droid
     */
    public RepairDroid(String Name, RepairTool tool) {
        super(Name);
        setHealth(REPAIR_DROID_MINHEALTH + random.nextInt(REPAIR_DROID_HEALTHINTERVAL));
        setDamage(REPAIR_DROID_MINDAMAGE + random.nextInt(REPAIR_DROID_DAMAGEINTERVAL));
        setReptool(tool);
        setMaxHealth(getHealth());
    }

    /**
     * Attack for repair droid in battle 1 to 1
     * @param enemy The enemy of player
     */
    @Override
    public void attack(Droid enemy) {

        // if the hp is maximum - he will hit the enemy with his own body
        if(getPerHP() == 1.0){
            enemy.getHit(damage);
            getHit(damage / 2);
            System.out.println(getName() + " hit the " + enemy.getName() + " with own body! But it`s hurts..." +
                    " Damage: " + damage);
        }else{
            // else heal yourself
            if(!reptool.ability()){
                getHeal(reptool.getHeal());
                System.out.println(getName() + " heal yourself! Heal: " + reptool.getHeal());
            }
        }
    }

    /**
     * Attack for repair droid in battle team to team
     * @param enemy The enemies of player
     * @param currt The team in which this droid is
     */
    public void attack(Team currt, LinkedList<Droid> enemy) {
        // if the droid is not active - end attack
        if(ifIsActive()){
            return;
        }
        // if all team members has the highest HP - droid will hit the enemy with his own body
        if(currt.minHealth().getPerHP() == 1.0){
            attack(enemy.getFirst());
        }else{
            // else he heal the members of the team
            if(!reptool.ability(currt)){
                Droid h = currt.minHealth();
                h.getHeal(reptool.getHeal());
                System.out.println(getName() + " heal " + h.getName() + " Heal: " + reptool.getHeal());
            }
        }
    }

    /**
     * Set the repair tool for droid
     * @param reptool The repair tool
     */
    public void setReptool(RepairTool reptool) {
        reptool.setUser(this);
        this.reptool = reptool;
    }

    /**
     * Set the damage of droid
     * @param damage The damage of droid
     * */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-12s: %-10s", "repair tool", reptool.getName());
    }
}

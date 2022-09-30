package com.kbilyk.Droids;

import com.kbilyk.Weapons.Lasers.Laser;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.kbilyk.Interfaces.DroidInterface.*;

/**
 * The laser droid can use weapon that never misses
 *
 */
public class LaserDroid extends Droid{

    private Laser laser;    // The weapon of droid

    /**
     * Default constructor
     */
    public LaserDroid(){}

    /**
     * Constructor that set name and laser
     * @param Name The name of droid
     * @param laser The laser of droid
     */

    public LaserDroid(String Name, Laser laser) {
        super(Name);
        setHealth(LASER_DROID_MINHEALTH + random.nextInt(LASER_DROID_HEALTHINTERVAL));
        setLaser(laser);
        setMaxHealth(getHealth());
    }

    /**
     * Attack for laser droid in battle 1 to 1
     * @param enemy The enemy of player
     */
    @Override
    public void attack(Droid enemy) {
        // if the droid is not active - end attack
        if(ifIsActive()){
            return;
        }

        // if droid can hit - check if he can use the crit and use it
        if(!laser.crit(enemy)){
            // attack if crit is not used
            enemy.getHit(laser.getDamage());
            System.out.println(getName() + " roasted a poor " + enemy.getName()+ " a little with laser!" +
                    " Damage: " + laser.getDamage());
        }
    }

    /**
     * Attack for laser droid in battle team to team
     * @param enemies The enemies of player
     */
    public void attack(LinkedList<Droid> enemies) {
        // if the droid is not active - end attack
        if(ifIsActive()){
            return;
        }

        // if droid can hit - check if he can use the crit and use it
        if(laser.crit(enemies)){
            return;
        }

        // the list of enemies that laser droid will hit
        ArrayList<Droid> beaten = new ArrayList<>();

        // the number of that droids
        int enemNum = (int) (enemies.size() * laser.getCoerTeam() + 0.5);

        // choose random enemies if he hit random
        if(isHitRandom()){
            for(int i = 0; i < enemNum; i++){
                int indxEnemy = random.nextInt(0, enemies.size());
                beaten.add(enemies.get(indxEnemy));
            }
        }
        else {
            // choose some droids from begin the ordered enemy list
            for(int i = 0; i < enemNum; i++) {
                beaten.add(enemies.get(i));
            }
        }

        // beat all chosen droids
        for(Droid droid : beaten){
            droid.getHit(laser.getDamage());
        }
        System.out.println(getName() + " roasted a little with laser!");
    }

    /**
     * Set new laser to droid
     * @param laser The new gun
     */
    public void setLaser(Laser laser) {
        laser.setUser(this);
        this.laser = laser;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-12s: %-10s ", "laser", laser.getName());
    }
}

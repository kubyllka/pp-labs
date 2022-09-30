package com.kbilyk.Droids;

import com.kbilyk.Weapons.Guns.Gun;

import java.util.LinkedList;

import static com.kbilyk.Interfaces.DroidInterface.*;


/**
 * Gun droid - attacker that can have weapon with high damage
 * but this weapon can miss.
 *
 */
public class GunDroid extends Droid{

    private Gun gun;                // The weapon of droid (gun)

    /**
     * Default constructor
     */
    public GunDroid(){}

    /**
     * Constructor
     * @param Name The name of droid
     * @param gun The object of current gun (weapon)
     */
    public GunDroid(String Name, Gun gun) {
        super(Name);
        setHealth(GUN_DROID_MINHEALTH + random.nextInt(GUN_DROID_HEALTHINTERVAL));
        setGun(gun);
        setMaxHealth(getHealth());
    }

    /**
     * Attack for gun droid
     * @param enemy The enemy of player
     */
    @Override
    public void attack(Droid enemy) {
        // if the droid is not active - end attack
        if(ifIsActive()){
            return;
        }
        // check the value of accuracy of droid for this round
        int droidAccur = random.nextInt(DROID_MINACCURACY, DROID_MAXACCURACY + 1);

        // if he miss - end the attack
        if(droidAccur < gun.getAccuracy()){
            System.out.println("Ohhhhh... " + getName() + " missed a bit and didn't hit anyone...");
            return;
        }
        // if droid can hit - check if he can use the crit
        if(!gun.crit(enemy,droidAccur)){
            enemy.getHit(gun.getDamage());
            System.out.println(getName() + " kicked the " + enemy.getName() + "`s ass. Damage: " + gun.getDamage());
        }
    }

    /**
     * Attack in team battle
     * @param enemies The list of enemies
     */
    public void attack(LinkedList<Droid> enemies) {

        Droid enemy;

        // choose random enemy if he hit random
        if(isHitRandom()){
            int indxEnemy = random.nextInt(0, enemies.size());
            enemy = enemies.get(indxEnemy);
        }
        else {
            // choose first enemy in created order
            System.out.println(enemies.size());
            enemy = enemies.getFirst();
        }

        // attack the enemy if he can
        attack(enemy);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-12s: %-10s ", "gun", gun.getName());
    }

    /**
     * Get the gun of droid
     * @return The object gun
     */
    public Gun getGun() {
        return gun;
    }

    /**
     * Set new gun to droid
     * @param gun The new gun
     */
    public void setGun(Gun gun) {
        this.gun = gun;
        gun.setUser(this);
    }
}

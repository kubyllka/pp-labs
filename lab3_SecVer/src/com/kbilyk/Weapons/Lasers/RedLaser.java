package com.kbilyk.Weapons.Lasers;

import com.kbilyk.Droids.Droid;

import java.util.LinkedList;

import static com.kbilyk.Interfaces.DroidInterface.random;
import static com.kbilyk.Interfaces.LaserInterface.*;

/**
 * The red laser
 * Crit: set fire to all enemies -  x2 damage divided on all enemies (once for game)
 */
public class RedLaser extends Laser{

    /**
     * Constructor
     */
    public RedLaser() {
        setName("Red Laser");
        setDamage(RED_LASER_MINDAMAGE + random.nextInt(RED_LASER_DAMAGEINTERVAL));
        setCoerTeam(RED_LASER_COEFTEAM);
    }

    /**
     * Using a crit on droid in battale 1 to 1 (double damage to enemy)
     * @param enemy The enemy of droid
     * @return if the crit of laser is used
     */
    @Override
    public boolean crit(Droid enemy) {
        if(isCrit()){       // if crit is used
            return false;
        }

        if(random.nextBoolean()){
            setCrit(true);
            int damage = (getDamage() * 2);
            enemy.getHit(damage);
            System.out.println(getUser().getName() + " set fire to " + enemy.getName() +
                    " Damage: " + damage);
            return true;
        }
        return false;
    }

    /**
     * Using a crit on all droids of enemy`s team in battle team to team
     * (double damage divided on enemies size)
     * @param enemies The list of current enemies
     * @return if the crit of laser is used
     */
    @Override
    public boolean crit(LinkedList<Droid> enemies) {
        if(isCrit()){
            return false;
        }

        if(random.nextBoolean()){
            setCrit(true);
            int damage = (getDamage() * 2) / enemies.size();

            for(Droid droid : enemies){
                droid.getHit(damage);
            }
            System.out.println(getUser().getName() + " set fire to all enemies! Incredibly burning! " +
                    "Damage for everyone: " + damage);
            return true;
        }
        return false;
    }
}

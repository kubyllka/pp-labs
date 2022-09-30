package com.kbilyk.Weapons.Lasers;

import com.kbilyk.Droids.Droid;

import java.util.LinkedList;

import static com.kbilyk.Interfaces.DroidInterface.random;
import static com.kbilyk.Interfaces.LaserInterface.*;

/**
 * The blue laser
 * Crit: 1.5x damage to enemy and knocked out the enemy for one round
 */
public class BlueLaser extends Laser{

    /**
     * Constructor
     */
    public BlueLaser() {
        setName("Blue Laser");
        setDamage(BLUE_LASER_MINDAMAGE + random.nextInt(BLUE_LASER_DAMAGEINTERVAL));
        setCoerTeam(BLUE_LASER_COEFTEAM);
    }

    /**
     * Using a crit on droid in battale 1 to 1
     * (1.5x damage to enemy and knocked out the enemy for one round)
     * @param enemy The enemy of droid
     * @return if the crit of laser is used
     */
    @Override
    public boolean crit(Droid enemy) {

        if(isCrit()){       // if crit is used - end using crit
            return false;
        }

        if(random.nextBoolean()){
            setCrit(true);
            int damage = (int) (getDamage() * 1.5);
            enemy.getHit(damage);
            enemy.setActive(false); // set enemy inactive for one round
            System.out.println(getUser().getName() + " knocked out a " + enemy.getName() + " for one round." +
                    " Damage: " + damage);
            return true;
        }
        return false;
    }

    /**
     * Using a crit on droid in battle team to team
     * (double damage divided on enemies size)
     * @param enemies The list of current enemies
     * @return if the crit of laser is used
     */
    @Override
    public boolean crit(LinkedList<Droid> enemies) { return crit(enemies.getFirst());}
}

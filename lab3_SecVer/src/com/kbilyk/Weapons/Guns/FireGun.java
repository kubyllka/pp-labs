package com.kbilyk.Weapons.Guns;
import com.kbilyk.Droids.Droid;
import static com.kbilyk.Interfaces.DroidInterface.*;
import static com.kbilyk.Interfaces.GunInterface.*;
import static com.kbilyk.Interfaces.GunInterface.random;

/**
 * The fire gun - the maximum possible damage in party (without crit)
 * Crit - hit enemy with double damage
 */
public class FireGun extends Gun{

    /**
     * Constructor
     */
    public FireGun() {
        setName("Fire Gun");
        setDamage(FIRE_GUN_MINDAMAGE + random.nextInt(FIRE_GUN_DAMAGEINTERVAL));
        setAccuracy(FIRE_GUN_MINACCURACY + random.nextInt(FIRE_GUN_ACCURACYINTERVAL));
    }

    /**
     * Method that activate crit
     * @param enemy The enemy of droid
     * @param accuracy The accuracy of curr droid in that round
     * @return if the crit was used or not
     */
    @Override
    public boolean crit(Droid enemy, int accuracy) {
        if(accuracy >= DROID_MAXACCURACY - 2){
            enemy.getHit(getDamage() * 2);
            System.out.println(getUser().getName() + " did a piu-piu-piu and dealt x2 damage to " +
                            "" + enemy.getName() + " Damage: " + getDamage() * 2);
            return true;
        }
        return false;
    }
}

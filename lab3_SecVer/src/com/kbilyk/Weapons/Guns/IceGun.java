package com.kbilyk.Weapons.Guns;

import com.kbilyk.Droids.Droid;
import static com.kbilyk.Interfaces.DroidInterface.DROID_MAXACCURACY;
import static com.kbilyk.Interfaces.GunInterface.*;

/**
 * The ice gun
 * Crit: kill the enemy with one hit (if accuracy of player is the maximum value)
 */

public class IceGun extends Gun{

    /**
     * Constructor
     */
    public IceGun() {
        setName("Ice Gun");
        setDamage(ICE_GUN_MINDAMAGE + random.nextInt(ICE_GUN_DAMAGEINTERVAL));
        setAccuracy(ICE_GUN_MINACCURACY + random.nextInt(ICE_GUN_ACCURACYINTERVAL));
    }

    /**
     * Method that activate crit
     * @param enemy The enemy of droid
     * @param accuracy The accuracy of curr droid in that round
     * @return if the crit was used or not
     */
    @Override
    public boolean crit(Droid enemy, int accuracy) {
        if(accuracy == DROID_MAXACCURACY){
            enemy.setAlive(false);
            System.out.println(getUser().getName() + " killed " + enemy.getName() + " with a well-placed shot... Eehhh");
            return true;
        }
        return false;
    }
}

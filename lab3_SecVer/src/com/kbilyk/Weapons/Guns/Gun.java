package com.kbilyk.Weapons.Guns;
import com.kbilyk.Droids.Droid;
import com.kbilyk.Weapons.Weapon;

/**
 * Gun - the class of weapon.
 * Has the high damage but the droid needs to make accuracy checks
 * every turn in order to hit the enemy
 */

public abstract class Gun extends Weapon {

    private int accuracy; // the minimum accuracy that the player must have to hit the enemy with this gun

    public abstract boolean crit(Droid enemy, int accuracy);

    /**
     * Get the accuracy of gun
     * @return The accuracy of gun
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     * Set the accuracy of gun
     * @param accuracy The accuracy of gun
     */
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
}

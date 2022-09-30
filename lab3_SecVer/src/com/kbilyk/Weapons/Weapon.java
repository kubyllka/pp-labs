package com.kbilyk.Weapons;
import com.kbilyk.Droids.Droid;


/**
 * The abstract class weapon
 */
public abstract class Weapon {
    private String name;    // the name of the weapon
    private int damage;     // the damage of the weapon
    private Droid user;     // the user of that weapon;

    /**
     * Default constructor
     */
    public Weapon() {}

    /**
     * Get the name of weapon
     * @return The name of weapon
     */
    public String getName() {
        return name;
    }

    /**
     * Set new weapon
     * @param name The name of droid
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the damage of the weapon
     * @return The damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Set the damage of the weapon
     * @param damage The damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Get the user of that weapon
     * @return The user of weapon
     */
    public Droid getUser() {
        return user;
    }

    /**
     * Set the user of that weapon
     * @param user The user of weapon
     */
    public void setUser(Droid user) {
        this.user = user;
    }
}

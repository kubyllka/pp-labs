package com.kbilyk.RepairTools;

import com.kbilyk.Droids.Droid;
import com.kbilyk.Teams.Team;

public abstract class RepairTool {

    private String name;    // the name of the tool
    private int heal;       // the heal of the weapon
    private Droid user;     // the user of that weapon;
    private boolean ability; // if ability of tool is used

    /**
     * Abstract method to using this ability (battle 1 to 1)
     * @return if ability was used
     */
    public abstract boolean ability();

    /**
     * Abstract method to using this ability (battle team to team)
     * @param curr The team of repair droid
     * @return if ability was used
     */
    public abstract boolean ability(Team curr);

    /**
     * Get the name of tool
     * @return The name of tool
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name of tool
     * @param name The new name of tool
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get heal of tool
     * @return the heal of tool
     */
    public int getHeal() {
        return heal;
    }

    /**
     * Set new heal of tool
     * @param heal The new heal of tool
     */
    public void setHeal(int heal) {
        this.heal = heal;
    }

    /**
     * Get who is using that weapon
     * @return The user of tool
     */
    public Droid getUser() {
        return user;
    }

    /**
     * Set who is using that weapon
     */
    public void setUser(Droid user) {
        this.user = user;
    }

    /**
     * Check if ability was used
     * @return true - if ability was used, false - other
     */
    public boolean isAbility() {
        return ability;
    }

    /**
     * Set the condition of ability
     * @param ability New condition for ability
     */
    public void setAbility(boolean ability) {
        this.ability = ability;
    }
}

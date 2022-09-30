package com.kbilyk.Weapons.Lasers;
import com.kbilyk.Droids.Droid;
import com.kbilyk.Weapons.Weapon;
import java.util.LinkedList;

public abstract class Laser extends Weapon {

    private boolean crit;      // If crit is used

    private double coerTeam;  // How many percent of enemy team numbers the laser will hit

    public abstract boolean crit(Droid enemy);// the abstract method that activate the crit in battle 1 to 1

    public abstract boolean crit(LinkedList<Droid> enemies); // method that activate the crit in battle team to team

    public double getCoerTeam() {
        return coerTeam;
    } // get how many percent of team members red laser will hit

    /**
     * Set how many percent of team members laser will hit
     * @param coerTeam percent of team members laser will hit
     */
    public void setCoerTeam(double coerTeam) {
        this.coerTeam = coerTeam;
    }

    /**
     * Get the value of crit
     * @return if is crit of laser is used
     */
    public boolean isCrit() {
        return crit;
    }

    /**
     * Set crit condition
     * @param crit is crit used or not
     */
    public void setCrit(boolean crit) {
        this.crit = crit;
    }
}

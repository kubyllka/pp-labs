package com.kbilyk.RepairTools;
import com.kbilyk.Teams.Team;

import static com.kbilyk.Interfaces.DroidInterface.random;
import static com.kbilyk.Interfaces.RepairToolInterface.*;

/**
 * The Heal Pro is the repair tool
 * Ability: can heal multiple team members
 */
public class HealPro extends RepairTool{
    /**
     * Constructor
     */
    public HealPro() {
        setName("Heal Pro");
        setHeal(HEALPRO_MINHEAL + random.nextInt(HEALPRO_HEALINTERVAL));
        setAbility(false);
    }

    /**
     * Using the ability in battle 1 to 1 (can heal yourself with x2 heal)
     * @return if the ability is used
     */
    @Override
    public boolean ability() {
        if(isAbility() && getUser().getPerHP() >= HEALPRO_MINPERHEALTH){
            return false;
        }
        if(random.nextBoolean()){
            setAbility(true);
            int heal = getHeal() * 2;
            getUser().getHeal(heal);
            System.out.println(getUser().getName() + " heal yourself. Wow! x2 heal! Heal: " + heal);
            return true;
        }
        return false;
    }

    /**
     * Using the ability in battle team to team (can heal teammate with x2 heal)
     * @return if the ability is used
     */
    @Override
    public boolean ability(Team curr) {
        // if ability was used or all teammates has high percent of health - end using the ability
        if(isAbility() || curr.minHealth().getPerHP() >= HEALPRO_MINPERHEALTH){
            return false;
        }

        // if random num is higher than minimum num for use the ability - heal someone
        // with x2 heal
        if(random.nextInt(0, ABILITY_INTERVAL + 1) >= HEALPRO_ABIL_ACTIVATE){
            setAbility(true);
            int heal = getHeal() * 2; // x2 heal
            curr.minHealth().getHeal(heal);
            System.out.println(getUser().getName() + " heal " + curr.minHealth().getName() +
                    ". Wow! x2 heal! Heal: " + heal);
            return true;
        }
        return false;
    }
}

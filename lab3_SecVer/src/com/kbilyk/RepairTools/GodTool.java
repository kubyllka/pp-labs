package com.kbilyk.RepairTools;

import com.kbilyk.Droids.Droid;
import com.kbilyk.Teams.Team;

import static com.kbilyk.Interfaces.DroidInterface.random;
import static com.kbilyk.Interfaces.RepairToolInterface.*;

/**
 * God tool is the repair tool
 * Ability: can raised from the dead (not yourself)
 */
public class GodTool extends RepairTool{

    /**
     * Constructor
     */
    public GodTool() {
        setName("God Tool");
        setHeal(GODTOOL_MINHEAL + random.nextInt(GODTOOL_HEALINTERVAL));
        setAbility(false);
    }

    /**
     * Using ability in battle 1 to 1 (raise someone from death)
     * @return false cause droid can raise from death yourself
     */
    @Override
    public boolean ability() { return false; }

    /**
     * Using ability in battle team to team (raise someone from death)
     * @param curr The team of droid
     * @return if ability was used
     */
    @Override
    public boolean ability(Team curr) {

        // if ability is used or nobody is dead - end using the ability
        if(isAbility() || curr.getTeam().size() == curr.getIsAlive().size()){
            return false;
        }

        // if the maximum number falls out - use ability
        if((random.nextInt(0, ABILITY_INTERVAL + 1) == ABILITY_INTERVAL)){
            setAbility(true);
            for(Droid droid : curr.getTeam()){
                if(!droid.isAlive()){
                    // heal the 30 percent of health to droid
                    droid.setHealth(droid.getMaxHealth() / 3);
                    droid.setAlive(true);
                    System.out.println(getUser().getName() + " did the impossible... He raised from the dead " +
                            droid.getName()  + "! Heal: " + droid.getMaxHealth() / 3);
                    return true;
                }
            }
        }

        return false;
    }
}

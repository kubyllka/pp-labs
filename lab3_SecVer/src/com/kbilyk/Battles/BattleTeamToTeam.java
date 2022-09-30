package com.kbilyk.Battles;

import com.kbilyk.Teams.Strategy;
import com.kbilyk.Teams.Team;

import static com.kbilyk.Interfaces.DroidInterface.random;

/**
 * The battle between two teams of droids
 * Print all moves of droids in team to team battle
 */
public class BattleTeamToTeam {
    private Team attacker;         // The attacker for each round
    private Team defender;         // The defender for each round
    private int currentRound = 0;   // The number of current round

    /**
     * Constructor that init who is the defender and attacker for
     * first round
     * Also create a strategy for each team
     * @param firteam The first team in battle
     * @param secteam The second team in battle
     */
    public BattleTeamToTeam(Team firteam, Team secteam) {
        initFighters(firteam, secteam);
        attacker.printTeam();
        defender.printTeam();
        attacker.setStrategy(new Strategy(attacker, defender));
        defender.setStrategy(new Strategy(defender, attacker));
    }
    public void battle(){

        // while all teams is alive - continue battle
        while(defender.ifTeamAlive() && attacker.ifTeamAlive()){
            numOfRound();

            System.out.println("Attacker team: " + attacker.getName());
            System.out.println("Defender team: " + defender.getName() + '\n');

            attacker.attack();

            attacker.printTeam();
            defender.printTeam();

            Team temp = attacker;
            attacker = defender;
            defender = temp;
        }

        // Print the winner
        System.out.println("\n-------------------------------------");
        if (defender.ifTeamAlive()){
            System.out.println("Let`s celebrate " + defender.getName() + "`s win!" );
        }else{
            System.out.println("Let`s celebrate " + attacker.getName() + "`s win!" );
        }

        // Refresh droids after the battle
        attacker.setAllAlive();
        defender.setAllAlive();
    }


    /**
     * Print and change the current num of round
     */
    private void numOfRound(){
        currentRound++;
        System.out.println("-------------------------------------");
        System.out.println("Round " + currentRound);
    }

    /**
     * Method defines who is attacker and who is the defender first time
     * @param firteam The first team of battle
     * @param secteam The second team of battle
     */
    private void initFighters(Team firteam, Team secteam) {
        if (random.nextBoolean()) {
            attacker = firteam;
            defender = secteam;
        } else {
            attacker = secteam;
            defender = firteam;
        }
    }
}

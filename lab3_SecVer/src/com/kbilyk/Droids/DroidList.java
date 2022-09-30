package com.kbilyk.Droids;
import com.kbilyk.RepairTools.*;
import com.kbilyk.Weapons.Guns.*;
import com.kbilyk.Weapons.Lasers.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import static com.kbilyk.Controllers.Correct.checkCorrect;
import static com.kbilyk.Interfaces.DroidInterface.*;
import static com.kbilyk.Interfaces.GunInterface.*;
import static com.kbilyk.Interfaces.LaserInterface.*;
import static com.kbilyk.Interfaces.RepairToolInterface.*;

/**
 * The class that save all information about the droids
 */
public class DroidList{
    private ArrayList<Droid> droids = new ArrayList<Droid>();  // the all list of created droids
    public LinkedList<Droid> isNotUsed = new LinkedList<Droid>(); // the list of droids that not used

    /**
     * Default constructor
     */
    public DroidList(){

        // The default droids
        droids.add(new GunDroid("Shpak", new FireGun()));
        droids.add(new GunDroid("Tsymbal", new IceGun()));
        droids.add(new GunDroid("Skrybailo-Leskiv", new FireGun()));
        droids.add(new GunDroid("Paholok", new IceGun()));


        droids.add(new LaserDroid("Skorohoda", new BlueLaser()));
        droids.add(new LaserDroid("Doroshenko", new BlueLaser()));
        droids.add(new LaserDroid("Kynash", new RedLaser()));
        droids.add(new LaserDroid("Rudenko", new RedLaser()));

        droids.add(new RepairDroid("Zerbino", new HealPro()));
        droids.add(new RepairDroid("Protsko", new GodTool()));

        isNotUsed.addAll(droids); // add all droids to list where we write all not used droids

    }

    /**
     * Add new droid to the list
     * @param droid The droid that will be added to the list
     */

    public void addNewDroid(Droid droid){
        droids.add(droid);
        isNotUsed.add(droid);
    }

    /**
     * Print all droids that was created
     */
    public void printDroids(){
        System.out.println('\n'+ "Droids:");
        for(Droid droid : droids){
            System.out.println(droid);
        }
    }

    /**
     * Creates new droid and chooses a weapon for droid
     */
    public void createDroid() {

        System.out.println("\nWhat type of droid you want to create?");
        System.out.println("-------------------------------------");
        System.out.println("1 - Gun droid");
        System.out.println("HP: " + GUN_DROID_MINHEALTH + "-" + (GUN_DROID_MINHEALTH + GUN_DROID_HEALTHINTERVAL));
        System.out.println("Uses guns that do a lot of damage but sometimes miss :(");
        System.out.println("-------------------------------------");
        System.out.println("2 - Laser droid");
        System.out.println("HP: " + LASER_DROID_MINHEALTH + "-" + (LASER_DROID_MINHEALTH + LASER_DROID_HEALTHINTERVAL));
        System.out.println("Uses high-precision lasers that don`t miss but deal medium damage");
        System.out.println("-------------------------------------");
        System.out.println("3 - Repair droid");
        System.out.println("HP: " + REPAIR_DROID_MINHEALTH + "-" + (REPAIR_DROID_MINHEALTH + REPAIR_DROID_HEALTHINTERVAL));
        System.out.println("Uses tools to repair his comrades, can hit enemies with his body");
        System.out.println("-------------------------------------");

        // input the value
        int type = checkCorrect(1, 3);


        // Write name for droid
        System.out.println("Type the name of droid:");
        String name = input.next();

        // Creates different droids of different types
        switch (type) {
            case 1 -> addNewDroid(new GunDroid(name, selectGun()));
            case 2 -> addNewDroid(new LaserDroid(name, selectLaser()));
            case 3 -> addNewDroid(new RepairDroid(name, selectRepTool()));
        }
    }

    /**
     * Choose the repair tool for repair droid
     * @return The repair tool for droid
     */
    private RepairTool selectRepTool() {

        System.out.println("\nChoose your repair tool!");
        System.out.println("-------------------------------------");
        System.out.println("1 - Heal Pro");
        System.out.println("Heal: " + HEALPRO_MINHEAL + "-" +(HEALPRO_MINHEAL + HEALPRO_HEALINTERVAL));
        System.out.println("Ability: heal someone with x2 heal)");
        System.out.println("-------------------------------------");
        System.out.println("2 - God Tool");
        System.out.println("Heal: " + GODTOOL_MINHEAL + "-" +(GODTOOL_MINHEAL + GODTOOL_HEALINTERVAL));
        System.out.println("Ability: can raised from the dead (not yourself)");
        System.out.println("-------------------------------------");

        // input value
        int type = checkCorrect(1, 2);

        switch(type){
            case 1 -> {
                return new HealPro();
            }
            case 2 -> {
                return new GodTool();
            }
        }

        return selectRepTool();
    }

    /**
     * Choose the laser for laser droid
     * @return The laser for droid
     */
    private Laser selectLaser() {

        System.out.println("\nChoose your laser!");
        System.out.println("-------------------------------------");
        System.out.println("1 - Blue Laser");
        System.out.println("Damage: " + BLUE_LASER_MINDAMAGE + "-" +(BLUE_LASER_MINDAMAGE + BLUE_LASER_DAMAGEINTERVAL));
        System.out.println("Crit: knocked out enemy for one round and hit x1.5 damage to him (once for game)");
        System.out.println("-------------------------------------");
        System.out.println("2 - Red Laser");
        System.out.println("Damage: " + RED_LASER_MINDAMAGE + "-" +(RED_LASER_MINDAMAGE + RED_LASER_DAMAGEINTERVAL));
        System.out.println("Crit: set fire to all enemies -  x2 damage divided on all enemies (once for game)");
        System.out.println("-------------------------------------");

        // input value
        int type = checkCorrect(1, 2);

        switch(type){
            case 1 -> {
                return new BlueLaser();
            }
            case 2 -> {
                return new RedLaser();
            }
        }

        return selectLaser();
    }

    /**
     * Choose the gun for gun droid
     * @return The gun for droid
     */
    private Gun selectGun() {

        System.out.println("\nChoose your gun!");
        System.out.println("-------------------------------------");
        System.out.println("1 - Fire Gun");
        System.out.println("Damage: " + FIRE_GUN_MINDAMAGE + "-" +(FIRE_GUN_MINDAMAGE + FIRE_GUN_DAMAGEINTERVAL));
        System.out.println("Peculiarity: it is not always possible to hit the target with it," +
                " only if the accuracy of the player is greater than the accuracy of the weapon");
        System.out.println("Crit: kill the enemy with one shot if the accuracy is highest");
        System.out.println("-------------------------------------");
        System.out.println("2 - Ice Gun");
        System.out.println("Damage: " + ICE_GUN_MINDAMAGE + "-" +(ICE_GUN_MINDAMAGE + ICE_GUN_DAMAGEINTERVAL));
        System.out.println("Peculiarity: it is not always possible to hit the target with it," +
                " only if the accuracy of the player is greater than the accuracy of the weapon");
        System.out.println("Crit: hit with x2 damage if accuracy is very high");
        System.out.println("-------------------------------------");

        int type = checkCorrect(1, 2);

        // input value
        switch(type){
            case 1 -> {
                return new FireGun();
            }
            case 2 -> {
                return new IceGun();
            }
        }

        return selectGun();
    }


    Scanner input = new Scanner(System.in);
}

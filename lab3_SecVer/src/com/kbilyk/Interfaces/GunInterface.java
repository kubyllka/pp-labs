package com.kbilyk.Interfaces;

import java.util.Random;

/**
 * The general info about guns (constants)
 */
public interface GunInterface {
    int ICE_GUN_MINACCURACY = 10;     // the minimum accuracy that the player must have to hit the target with this gun
    int ICE_GUN_ACCURACYINTERVAL = 4;   // accuracy interval for ice gun
    int ICE_GUN_MINDAMAGE = 70;         // the minimum damage of ice gun
    int ICE_GUN_DAMAGEINTERVAL = 20;    // damage interval for ice gun

    int FIRE_GUN_MINACCURACY = 9;     // the minimum accuracy that the player must have to hit the target with this gun
    int FIRE_GUN_ACCURACYINTERVAL = 4;  // accuracy interval for fire gun
    int FIRE_GUN_MINDAMAGE = 60;        // the minimum damage of fire gun
    int FIRE_GUN_DAMAGEINTERVAL = 20; // damage interval for rire gun


    Random random = new Random();     // for random numbers
}

package com.kbilyk.Interfaces;
import java.util.Random;

/**
 * The general info about classes of droids
 */
public interface DroidInterface {
    int GUN_DROID_MINHEALTH = 300;          // min health for gun droid
    int GUN_DROID_HEALTHINTERVAL = 50;      // the interval of health from [min... min + interval)
    int LASER_DROID_MINHEALTH = 250;        // min health for laser droid
    int LASER_DROID_HEALTHINTERVAL = 40;    // the interval of health from [min... min + interval)

    int REPAIR_DROID_MINHEALTH = 230;       // min health for repair droid (healer)
    int REPAIR_DROID_HEALTHINTERVAL = 50;   // the interval of health from [min... min + interval)

    int REPAIR_DROID_MINDAMAGE = 20;       // min health for repair droid (healer)
    int REPAIR_DROID_DAMAGEINTERVAL = 10;   // the interval of health from [min... min + interval)

    int DROID_MINACCURACY = 0;          // the min possible accuracy for droid
    int DROID_MAXACCURACY = 20;         // the max possible accuracy for droid


    Random random = new Random();           // for random numbers
}

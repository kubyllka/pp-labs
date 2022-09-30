package com.kbilyk.Interfaces;

/**
 * The general info about repair tools
 */
public interface RepairToolInterface {
    int GODTOOL_MINHEAL = 30;            // the minimum heal for god tool
    int GODTOOL_HEALINTERVAL = 10;      // heal interval for god tool
    int HEALPRO_MINHEAL = 35;           // the minimum heal for heal pro
    int HEALPRO_HEALINTERVAL = 10;      // heal interval for heal pro
    double HEALPRO_MINPERHEALTH = 0.6;  // the min percent of health od droid when he can activate his ability
    int ABILITY_INTERVAL = 20;          // the interval for using ability
    int HEALPRO_ABIL_ACTIVATE = ABILITY_INTERVAL - 3;

}

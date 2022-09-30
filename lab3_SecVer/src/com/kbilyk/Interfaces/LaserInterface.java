package com.kbilyk.Interfaces;

/**
 * The general info about lasers
 */
public interface LaserInterface {

    int RED_LASER_MINDAMAGE = 50;           // the minimum damage for red laser
    int RED_LASER_DAMAGEINTERVAL = 10;      // damage interval for red laser
    double RED_LASER_COEFTEAM = 0.5;        // how many percent of team members red laser will hit

    int BLUE_LASER_MINDAMAGE = 50;         // the minimum damage for blue laser
    int BLUE_LASER_DAMAGEINTERVAL = 20;    // damage interval for blue laser
    double BLUE_LASER_COEFTEAM = 0.6;       // how many percent of team members blue laser will hit
}

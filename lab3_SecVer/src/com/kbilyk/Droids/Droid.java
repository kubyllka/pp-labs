package com.kbilyk.Droids;

import java.util.LinkedList;

/**
 * The base class of droid (abstract)
 * That has base characteristic of every droid like name, health, maxHealth
 * Also every droid has certain states: dead, is he hit randomly, etc...
 */
public abstract class Droid {
    private String name;         // The name of the droid
    private int health;          // The current health of droid
    private int maxHealth;       // The max health of droid
    private boolean isHitRandom; // If he hit random enemy (team battle)

    private boolean isActive;    // If the droid is active
    private boolean isAlive;     // The condition of droid: dead or alive

    /**
     * Default constructor
     */
    public Droid() {}

    /**
     * Constructor with name
     * @param Name The name of droid
     */
    public Droid(String Name){
        this.name = Name;
        isAlive = true;
        isHitRandom = false;
        isActive = true;
    }

    /**
     * The droid takes damage
     * @param damage The value of damage that droid get
     */
    public void getHit(int damage){
        health -= damage;
        if (health <= 0){
            setAlive(false);
            health = 0;
        }
    }

    /**
     * Method that change the status of droid if he knocked out
     * @return if he change his status or not
     */
    public boolean ifIsActive(){
        if(!isActive){
            isActive = true;
            System.out.println(getName() + " is sleeping now... Zzzzz");
            return true;
        }
        return false;
    }

    /**
     * The abstract method that attack the enemy
     * @param enemy The enemy of player
     */
    public abstract void attack(Droid enemy);

    /**
     * The method for attack in team battle
     * @param enemies The list of enemies
     */
    public void attack(LinkedList<Droid> enemies){}

    /**
     * Get the condition of droid: is alive (health > 0) or dead
     * @param alive if the droid is alive (health > 0) or dead
     */
    public void setAlive(boolean alive) {
        if(!alive){ setHealth(0);}
        isAlive = alive;
    }

    /**
     * Refresh droid params after battle
     * Set new health and active
     */
    public void refreshDroid(){
        isAlive = true;
        isActive = true;
        health = maxHealth;
    }

    /**
     * Get a heal from Repair Droid
     * @param heal The value of heal to that droid
     */
    public void getHeal(int heal) {
        health += heal;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    /**
     * Get a percentage of health
     * @return The percentage of health
     */
    public double getPerHP(){
        return (health * 1.0) / maxHealth;
    }

    /**
     * The getter which return name
     * @return The name of droid
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name to droid
     * @param name The name of droid
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the current health of droid
     * @return The current health of droid
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set current health of droid
     * @param health The current health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Get the maximum health of droid
     * @return The maximum health of droid
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Get the maximum health of droid
     * @param maxHealth The maximum health of droid
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Get if the droid hit random enemy in team battle
     * @return If the droid hit random enemy in team battle
     */
    public boolean isHitRandom() {
        return isHitRandom;
    }

    /**
     * Set if the droid hit random enemy in team battle
     * @param hitRandom If the droid hit random enemy in team battle
     */
    public void setHitRandom(boolean hitRandom) {
        isHitRandom = hitRandom;
    }

    /**
     * Get the condition of droid: is alive (health > 0) or dead
     * @return if the droid is alive (health > 0) or dead
     */
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return String.format("%-15s  HP: %-5d  maxHP: %-5d  ", name, health, maxHealth);
    }

    /**
     * Get if droid is active
     * @return If droid is active
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Set if droid is active
     * @param active  If droid is active
     */
    public void setActive(boolean active) {
        isActive = active;
    }
}

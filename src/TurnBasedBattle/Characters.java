package TurnBasedBattle;

import java.util.*;

/**
 * Abstract  class representing a game character thats either the player or the enemy.
 */

abstract class Characters extends MainGame
{
	
	//Create all the variables for the strength, endurance, current endurance, how many heals left, armour, name, if they are blocking, and the random generator.
    protected int strength;
    protected int endurance;
    protected int currentEndurance;
    protected int healsLeft;
    protected int armour;
    protected String name;
    protected boolean isBlocking;
    protected Random rand = new Random();
	

    /**
     * Constructs a new Character with specified attributes.
     * @param characterName The display name of the character
     * @param characterEndurance Maximum health points
     * @param characterStrength Base attack power
     * @param characterHealsLeft Starting number of healing charges
     * @param characterArmor Damage reduction value
     */
    public Characters(String characterName, int characterEndurance, int characterStrength, int characterHealsLeft, int characterArmour) 
    {
    	
    	//Sets all the variables equal to the parameters.
    	name = characterName;
    	endurance = characterEndurance;
    	strength = characterStrength;
    	healsLeft = characterHealsLeft;
    	armour = characterArmour;
    	currentEndurance = endurance;
    	isBlocking = false;
    	
	}
    
    /* Checks if character is defeated.
    * @return True if HP is 0 or below
    */
	public boolean isDefeated() 
	{
		
        return currentEndurance <= 0;
        
    }

    /**
     * Displays current player stats.
     */
	public void displayPlayerStats() 
	{
		
		//Ouput the player stats.
		 System.out.println(name + " — HP: " + currentEndurance + "/" + endurance + " | Heals left: " + healsLeft);
		 
    }
	
    /**
     * Displays current enemy stats.
     */
    public void displayEnemyStats() 
    {
    	
		//Ouput the enemy stats.
    	System.out.println(name + " — HP: " + currentEndurance + "/" + endurance + " | Heals left: " + healsLeft);
    	
	}
   
    /**
     * Performs an attack with chance for critical hit.
     * @return The amount of damage dealt before enemy reductions.
     */
    public int attack(String name) 
    {
    	
    	//Set a variabe for the name.
    	String nameMethod = name;
    	
    	//use a random number generator to see the damage between 5 and the strength number (+1 cause random int generator starts 1 less than the bound.
        int damage = rand.nextInt(6, strength + 1);
        
        //10%chance for a critical hit.
        if (rand.nextDouble() < 0.1) 
        {
        	
            //Tell the user they got a critical hit.
            System.out.println("CRITICAL HIT by " + nameMethod + "!");
            
            //Double the damage.
            damage *= 2;
            
        }
        
        //Output the attack message.
        System.out.println(nameMethod + " attacks for " + damage + " damage.");
        
        //Return damage.
        return damage;
        
    }

    /**
     * Prepares to block the next incoming attack.
     * Doubles armor effectiveness for the next damage taken.
     */
    public void block(String name) 
    {
    	
    	//Variable for the name.
    	String nameMethod = name;
    	
    	//Set isBlocking to true.
        isBlocking = true;
        
        //Type out the block message.
        System.out.println(nameMethod + " prepares to block (will reduce damage by " + (armour*2) + " next turn)!");
    }

    /**
     * Attempts to heal the character.
     * @return The amount healed and 0 if no heals remain.
     */
    public int heal(String name) 
    {
    	
    	//Variable for name.
    	String nameMethod = name;
    	
    	//If statement for the amount of heals left.
        if (healsLeft > 0) 
        {
        	//Random heal between 10-20.
            int healAmount = rand.nextInt(11) + 10;
            
            //Make sure that the current health doesntexceed the max health.
            currentEndurance = Math.min(currentEndurance + healAmount, endurance);
            
            //-1 heal usage.
            healsLeft--;
            
            //Print out heal message.
            System.out.println(nameMethod + " heals for " + healAmount + " points!");
            
            //Return the amount of heals.
            return healAmount;
            
        } 
        
        //If the character used all their heals.
        else 
        {
        	
        	//Output heal message.
            System.out.println(nameMethod + " has no heals left!");
            
            //return 0 healing.
            return 0;
            
        }
        
    }
    
    /**
     * Processes incoming damage with armor and block reductions.
     * @param damage The raw incoming damage amount
     * @return The actual damage taken after reductions
     */
    public int takeDamage(int damage, String name) 
    {
    	
    	//Variable for name.
    	String nameMethod = name;
    	
        //Initalize the amount blocked.
        int blockingBonus = 0;
        
        //If the character is blocking.
        if (isBlocking) 
        {
        	//Blocking bonus will be set to the armour.
            blockingBonus = armour;
            
        }
        
        //Total reduction will be armour + the blocking bonus, so that way the armour doubles if its blocking and stays the same if its not.
        int totalReduction = armour + blockingBonus;
        
        //Make sure a minimum of 1 damage.
        int actualDamage = Math.max(damage - totalReduction, 1); 

        //Current health will equal the current health - the actual damage.
        currentEndurance -= actualDamage;

        //If user is blocking.
        if (isBlocking) 
        {
        	//Tell user they are blocking.
            System.out.println(nameMethod + " blocks and reduces damage by " + totalReduction + " points!");
            
        } 
        
        //If the aromur is greater than 0.
        else if (armour > 0) 
        {
        	//Tell the user how much the armour protected them.
            System.out.println(nameMethod + "'s armor reduces damage by " + armour + " points!");
            
        }
        
        //Tell the user how much damage they took.
        System.out.println(nameMethod + " takes " + actualDamage + " damage!");

        //Reset blocking after the attack.
        isBlocking = false;
        
        //Return the actual damage.
        return actualDamage;
       
    }
    
    /**
     * Abstract method for character-specific special abilities.
     * @param opponent The target character for the special move
     */
    public abstract void specialMove(Characters opponent);
}
	


package TurnBasedBattle;

import java.util.*;

public class MainGame 
{
	
	//Public variables for name and enemy
	public static String name;
	public static String enemy;
	
	public static void main(String[] args) throws InterruptedException
	{
		
		//Variables for which character the user chose, their name, and the opponents name.
		String charChoice, nameChoice = null, enemyName = null;
		
		//Variable used when checking to make sure the user inputs a correct letter for the character.
		int x = 0;
		
		//Character class for the player.
		Characters player;
		
		//Create a scanner and a random generator.
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		//Print out the rules of the game, as well as any other important info. Also ask which character they would like to play.
		System.out.println("Welcome to Battle Clash! \nThe rules are simple. You get to pick between playing as a mage, a warrior or an archer. \nYou will play against a goblin, barbarian, or a giant. \nEach turn, you will get to pick between 4 actions, attacking, blocking, healing or a special move. \nThe stats of these 3 actions depends on your choice of character. \nFirst person to lose all their health wins. \nFirstly you must pick between \nA mage. Has 75 health, 15 attack damage, and 5 heals. (type 'm' to select a mage). \nA warrior. Has 150 health, 30 attack damage, and 2 heals. (type 'w' to select a warrior). \nAn archer. Has 100 health, 20 attack damage, and 4 heals. (type 'a' to select an archer).");
		
		//Set the character choice as the character they just picked.
		charChoice = sc.next();
		
		//If the user inputs anything other than m, w, or a, then this if statement will happen.
		if(!charChoice.equals("m") && !charChoice.equals("w") && !charChoice.equals("a"))
		{
			
			//Set x = -1 for error testing.
			x = -1;
			
			//Reset the character choice.
			charChoice = "";
			
		}
		
		//While loop for when x = -1 (error in the input).
		while(x == -1)
		{
			
			//Let the user know the error, and ask for the input again.
			System.out.println("Sorry, the character you selected does not exist. Please type in 'm' for mage, 'w' for warrior or 'a' for archer.");
			
			//Set the new input as the new character.
			charChoice = sc.next();
			
			//If they input the character correct, this if statement will happen.
			if(charChoice.equals("m") || charChoice.equals("w") || charChoice.equals("a"))
			{
				//Break, and if it is still incorrect, while loop will happen again.
				break;
				
			}
			
		}
		
		//If the character choice was the mage.
		if(charChoice.equals("m"))
		{
			
			//Tell the user the inputed the character correct, and ask for the name.
			System.out.println("Mage! Great choice! Now give your character a name:");
			
			//Skip the blank line.
			sc.nextLine();
			
			//Make the next line the name they picked.
			nameChoice = sc.nextLine();
			
			//Create a new mage with the name they inputted.
			player = new Mage(nameChoice);
		}
		
		//If the character choice was the warrior.
		else if(charChoice.equals("w"))
		{
			
			//Tell the user the inputed the character correct, and ask for the name.
			System.out.println("Warrior! Great choice! Now give your character a name:");
			
			//Skip the blank line.
			sc.nextLine();
			
			//Make the next line the name they picked.
			nameChoice = sc.nextLine();
			
			//Create a new warrior with the name they inputted.
			player = new Warrior(nameChoice);
		}
		else
		{
			
			//Tell the user the inputed the character correct, and ask for the name.
			System.out.println("Archer! Great choice! Now give your character a name:");
			
			//Skip the blank line.
			sc.nextLine();
			
			//Make the next line the name they picked.
			nameChoice = sc.nextLine();
			
			//Create a new archer with the name they inputted.
			player = new Archer(nameChoice);
		}
		

		//Let them know the name was correctly inputted.
		System.out.println("Thats a great name " + nameChoice + "!");
		
		//Pause for 1 second.
		Thread.sleep(1000);
		
		//Get them ready for the game.
		System.out.println("Get ready to start the game!");
		
		//Pause for 1 second.
		Thread.sleep(1000);
		
		//Tell them the game is  picking  an enemy.
		System.out.println("Picking an enemy...");
		
		//Pause for 1 second.
		Thread.sleep(1000);
		
		//Create a character for the enemy.
		Characters enemy;
		
		//Create a random generator for one of the 3 picks (it will generate numbers from 0-2 not 1-3).
        int enemyChoice = rand.nextInt(3); 
        
        //If it picks 0
        if (enemyChoice == 0) 
        {
        	
        	//Create the Goblin player, and name it goblin.
            enemy = new Goblin("Goblin");
            
            //Set the enemy name variable as goblin.
            enemyName = "goblin";
            
        } 
        
        //If it picks 1
        else if (enemyChoice == 1) 
        {
        	
        	//Create the Barbarian player, and name it Barbarian.
            enemy = new Barbarian("Barbarian");
            
            //Set the enemy name variable as barbarian.
            enemyName = "barbarian";

        }
        
        //If it picks 2
        else 
        {
        	
        	//Create the Giant player, and name it Giant.
            enemy = new Giant("Giant");
            
            //Set the enemy name variable as giant.
            enemyName = "giant";

        }
        
        //Tell the user who their enemy is.
        System.out.println("A wild " + enemyName + " appears!");
        
		//Pause for 1 second.
        Thread.sleep(1000);
        
        //Make sure that there is a variable for if its the players turn or not.
        boolean playerTurn = true;
        
        //While both the player and the enemy are alive, continue the game.
        while (!player.isDefeated() && !enemy.isDefeated()) 
        {
        	
    		//Pause for 1 second.
            Thread.sleep(1000);
            
            //Output the users and the enemies stats.
            System.out.println("\n--- Current Stats ---");
            player.displayPlayerStats();
            enemy.displayEnemyStats();
            System.out.println("---------------------");
            
    		//Pause for 1 second.
            Thread.sleep(1000);
            
            //If its the players turn.
            if (playerTurn) 
            {
            	
            	//Ask the user for what action they would like.
                System.out.println("\nIt's your turn! Choose an action:");
                System.out.println("1. Attack (type '1')");
                System.out.println("2. Block (type '2')");
                System.out.println("3. Heal (type '3')");
                System.out.println("4. Special Move (type '4')");
                
                //Make the number they inputted the action they will do.
                int action = sc.nextInt();

                //If they choose action 1.
                if (action == 1) 
                {
                	
                	//Make the enemy take damage, and the player attack while adding the correct paramters.
                    enemy.takeDamage(player.attack(nameChoice), enemyName);
                    
                } 
                
            	//If they choose action 2.
                else if (action == 2) 
                {
                	
                	//Make the player block, while adding the correct paramters.
                    player.block(nameChoice);
                    
                } 
                
            	//If they choose action 3.
                else if (action == 3) 
                {
                	
                	//Make the player heal, while adding the correct paramters.
                    player.heal(nameChoice);
                    
                } 
                
            	//If they choose action 4.
                else if (action == 4) 
                {
                	
                	//Make the player use special move, while adding the correct paramters.
                    player.specialMove(enemy);
                } 
                
                //If any other input is none of the otinos given. 
                else 
                {
                	
                	//tell the user their turn is skipped.
                    System.out.println("Invalid action, turn skipped!");
                    
                }
                
            } 
            
            //If its not the players turn.
            else 
            {
            	
            	//Tell the user its the enemies turn.
                System.out.println("\nEnemy's turn!");
                
                //Make the action they do random.
                int action = rand.nextInt(4) + 1;
                
            	//If action 1 is chosen.
                if (action == 1) 
                {
                	
                	//Make the player take damage, and the enemy attack while adding the correct paramters.
                    player.takeDamage(enemy.attack(enemyName), nameChoice);
                    
                } 
                
            	//If action 2 is chosen.
                else if (action == 2) 
                {
                	
                	//Make the enemy block, while adding the correct paramters.
                    enemy.block(enemyName);
                    
                } 
                
            	//If action 3 is chosen.
                else if (action == 3) 
                {
                	
                	//Make the enemy heal, while adding the correct paramters.
                    enemy.heal(enemyName);
                    
                } 
                
            	//If action 4 is chosen.
                else if (action == 4) 
                {
                	
                	//Make the player use special move, while adding the correct paramters.
                    enemy.specialMove(player);
                    
                }
                
            }

            //Change the turn.
            playerTurn = !playerTurn;
            
        }
        
        //If the player is defeated.
        if (player.isDefeated()) 
        {
        	
        	//Tell the user they died.
            System.out.println("\nYou were defeated by the " + enemyName + "...");
            
        } 
        
        //If the enemy is defeated.
        else 
        {
        	//Tell the user they won.
            System.out.println("\nYou defeated the " + enemyName + "! Victory!");
            
        }

        //Close the scanner.
        sc.close();
        
	}

}

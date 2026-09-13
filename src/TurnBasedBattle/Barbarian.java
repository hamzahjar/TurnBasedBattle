package TurnBasedBattle;

public class Barbarian extends Characters 
{
	
	//Barbarian constructor that calls the superclass constructor with specific stats.
	public Barbarian(String name) 
	{
		
		super(name, 125, 25, 3, 5);
		
	}

	//Override the specialMove method from the Characters class.
	@Override
	public void specialMove(Characters opponent) 
	{
		
		//Pause the thread for 1 second to simulate a delay before the special move.
		try 
		{
			
			Thread.sleep(1000);
			
		}
		
		catch (InterruptedException e) 
		{
			
			//Print the stack trace if the sleep is interrupted.
			e.printStackTrace();
			
		}

		//Announce the special move being used
		System.out.println(name + " uses frenzied cleave!");

		//Define the minimum and maximum possible special damage.
		int min = strength + 5;
		int max = strength + 15;

		//Calculate a random amount of special damage between min and max.
		int specialDamage = rand.nextInt(max - min + 1) + min;

		//Display how much special damage was dealt.
		System.out.println(name + " deals " + specialDamage + " special damage!");

		//Apply the calculated special damage to the opponent.
		opponent.takeDamage(specialDamage, opponent.name);
		
	}
	
}

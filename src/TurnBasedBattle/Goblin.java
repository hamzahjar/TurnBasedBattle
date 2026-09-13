package TurnBasedBattle;

public class Goblin extends Characters 
{
	
	//Goblin constructor that calls the superclass constructor with specific stats.
	public Goblin(String name) 
	{
		
		super(name, 50, 10, 6, 3);
		
	}

	//Override the specialMove method from the Characters class.
	@Override
	public void specialMove(Characters opponent) 
	{
		
		//Pause the thread for 1 second to simulate a delay before the attack.
		try 
		{
			
			Thread.sleep(1000);
			
		} 
		
		catch (InterruptedException e)
		{
			
			//Print the stack trace if the sleep is interrupted.
			e.printStackTrace();
			
		}

		//Print out the name of the special move used.
		System.out.println(name + " uses gold-plated dagger!");

		//Calculate the minimum and maximum possible damage based on strength.
		int min = strength + 5;
		int max = strength + 15;

		//Generate a random amount of special damage between min and max.
		int specialDamage = rand.nextInt(max - min + 1) + min;

		//Print out how much special damage was dealt.
		System.out.println(name + " deals " + specialDamage + " special damage!");

		//Inflict the special damage on the opponent.
		opponent.takeDamage(specialDamage, opponent.name);
		
	}

}

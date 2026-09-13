package TurnBasedBattle;

public class Mage extends Characters 
{
	
	//Mage constructor that calls the superclass constructor with specific stats.
	public Mage(String name) 
	{
		
		super(name, 75, 15, 5, 2);
		
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

		//Announce the special move being used.
		System.out.println(name + " uses arcane blast!");

		//Define the minimum and maximum potential special damage.
		int min = strength + 5;
		int max = strength + 15;

		//Calculate a random special damage amount between min and max.
		int specialDamage = rand.nextInt(max - min + 1) + min;

		//Display how much special damage was dealt.
		System.out.println(name + " deals " + specialDamage + " special damage!");

		//Apply the calculated damage to the opponent.
		opponent.takeDamage(specialDamage, opponent.name);
		
	}
	
}
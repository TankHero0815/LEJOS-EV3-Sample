
public class TestFahrt_la
{
	public static void main(String[] args)
	{
	
		KillingMachine robot = new KillingMachine();
        robot.assemble();
        for (int i = 0; i < 5; i++)
        {
        	robot.drive(4, 1);
        	Helfer.delayProgramm(1);
        }
	}
}
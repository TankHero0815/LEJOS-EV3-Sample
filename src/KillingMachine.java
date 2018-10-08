import lejos.hardware.port.Port;

public class KillingMachine
{
	EV3Brick mainBrick;
	Port portA; 
	Port portB;
	Motor leftEngine;
	Motor rightEngine;
	
	public void assemble()
	{
		mainBrick = new EV3Brick();
		portA = mainBrick.getPort("A");
		portB = mainBrick.getPort("B");
		leftEngine = new Motor();
		rightEngine = new Motor();
		leftEngine.connect(portA);
		rightEngine.connect(portB);
	}
	
	public void drive(double leftSpeed, double rightSpeed)
	{
		leftEngine.start(leftSpeed);
		rightEngine.start(rightSpeed);
	}
}
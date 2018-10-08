import lejos.hardware.port.Port;

public class KillingMachineOld
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
	
	public void drive(double t, double v)
	{
		leftEngine.start(v);
		rightEngine.start(v);
		//Helfer.delayProgramm(t);
		//leftEngine.stop();
		//rightEngine.stop();
	}
	
	public void turnLeft(double t, double v)
	{
		rightEngine.start(v);
		Helfer.delayProgramm(t);
		rightEngine.stop();
	}
	
	public void turnRight(double t, double v)
	{
		leftEngine.start(v);
		Helfer.delayProgramm(t);
		leftEngine.stop();
	}
}
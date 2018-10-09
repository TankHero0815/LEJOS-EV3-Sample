import lejos.hardware.port.Port;

public class KillingMachine {
	EV3Brick mainBrick;
	Port portA;
	Port portB;
	Motor leftEngine;
	Motor rightEngine;
	private double speed;

	KillingMachine(double v) {
		this.assemble();
		this.setSpeed(v);

	}

	private void assemble() {
		mainBrick = new EV3Brick();
		portA = mainBrick.getPort("A");
		portB = mainBrick.getPort("B");
		leftEngine = new Motor();
		rightEngine = new Motor();
		leftEngine.connect(portA);
		rightEngine.connect(portB);
	}

	public void setSpeed(double speed) {
		if (speed > 3) {
			this.speed = 3;
		} else if (speed < -3) {
			this.speed = -3;
		}

	}

	public double getSpeed() {
		return this.speed;
	}

	public void drive(double t) {
		leftEngine.start(this.speed);
		rightEngine.start(this.speed);
		Helfer.delayProgramm(t);
		leftEngine.stop();
		rightEngine.stop();
	}
}
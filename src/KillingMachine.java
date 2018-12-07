import lejos.hardware.port.Port;

public class KillingMachine {
	EV3Brick mainBrick;
	Port portA;
	Port portB;
	Motor leftEngine;
	Motor rightEngine;
	private double speed;
	private final double WHEELDIAMETER = 0.056;
	private final double UMFANG = this.WHEELDIAMETER * Math.PI;
	private final double SPURWEITE = 0.12;

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
		} else {
			this.speed = speed;
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

	public void rotate(double angle) {
		double x = (this.speed <= 0) ? -1 : 1;

		double duration = x * this.SPURWEITE * Math.PI / this.UMFANG / this.speed * (angle / 180);

		if (duration >= 0) {
			leftEngine.start(this.speed);
			rightEngine.start(-this.speed);
			Helfer.delayProgramm(duration);

		} else {
			rightEngine.start(-this.speed);
			leftEngine.start(this.speed);
			Helfer.delayProgramm(-duration);

		}

		leftEngine.stop();
		rightEngine.stop();

	}

	public void twoWheelCurve(double angle, double rad) {
		// double x = (rad)/Helfer.SPURWEITE;
		double x = (angle <= 0) ? -1 : 1;
		double bow2 = x * angle / 360.0 * 2 * Math.PI * (rad + Helfer.SPURWEITE);
		double bow1 = x * angle / 360.0 * 2 * Math.PI * rad;
		double time2 = Helfer.getUmdrehungen(bow2);
		double time1 = Helfer.getUmdrehungen(bow1);

		// System.out.println(time);

		if (x > 0) {
			rightEngine.start(this.speed);
			leftEngine.start(time2 / time1 * this.speed);
		} else {
			rightEngine.start(time2 / time1 * speed);
			leftEngine.start(speed);

		}
		Helfer.delayProgramm(time1);
		rightEngine.stop();
		leftEngine.stop();
	}

	public void oneWheelTurn(double angle) {
		double x = (this.speed <= 0) ? -1 : 1;
		// double duration = x * angle / 90 / this.speed;
		double duration = x * 2 * this.SPURWEITE * Math.PI / this.UMFANG / this.speed * (angle / 360);

		if (duration >= 0) {
			leftEngine.start(this.speed);
			Helfer.delayProgramm(duration);

		} else {
			rightEngine.start(this.speed);
			Helfer.delayProgramm(-duration);

		}

		leftEngine.stop();
		rightEngine.stop();

	}

	public void driveMeters(double m) {
		double t = m / UMFANG / this.speed;
		leftEngine.start(this.speed);
		rightEngine.start(this.speed);
		Helfer.delayProgramm(t);
		leftEngine.stop();
		rightEngine.stop();

	}
}
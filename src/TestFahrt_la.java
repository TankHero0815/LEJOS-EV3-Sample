
public class TestFahrt_la {
	public static void main(String[] args) {

		KillingMachine robot = new KillingMachine(3);
		robot.drive(5);
		Helfer.delayProgramm(2);
		robot.setSpeed(-3);
		robot.drive(5);

	}
}
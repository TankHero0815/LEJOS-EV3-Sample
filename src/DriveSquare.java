
public class DriveSquare {
	public static void main(String[] args) {

		KillingMachine robot = new KillingMachine(1);
		for (int i = 0; i < 4; i++) {
			robot.driveMeters(0.5);
			robot.oneWheelTurn(90);
		}

	}
}

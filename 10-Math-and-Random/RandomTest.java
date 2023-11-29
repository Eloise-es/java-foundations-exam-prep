import java.util.Random;

public class RandomTest {

	void noSeed() {
		Random r = new Random();
		int noArg = r.nextInt();
		int noArgAgain = r.nextInt();
		int arg = r.nextInt(10);

		Random r2 = new Random();
		int noArg2 = r2.nextInt();
		int noArgAgain2 = r2.nextInt();
		int arg2 = r2.nextInt(10);

		System.out.println("no arg: " + noArg + "\nAnd again: " + noArgAgain + "\nwith arg: " + arg);
		System.out.println("no arg: " + noArg2 + "\nAnd again: " + noArgAgain2 + "\nwith arg: " + arg2);
	}

	void withSeed() {
		Random r = new Random(10000);
		int noArg = r.nextInt();
		int noArgAgain = r.nextInt();
		int arg = r.nextInt(10);

		Random r2 = new Random(10000);
		int noArg2 = r2.nextInt();
		int noArgAgain2 = r2.nextInt();
		int arg2 = r2.nextInt(10);

		System.out.println("no arg: " + noArg + "\nAnd again: " + noArgAgain + "\nwith arg: " + arg);
		System.out.println("no arg: " + noArg2 + "\nAnd again: " + noArgAgain2 + "\nwith arg: " + arg2);
	}

	public static void main(String[] args) {
		RandomTest test = new RandomTest();

		System.out.println("\nTEST NO SEED");
		test.noSeed();

		System.out.println("\nTEST WITH SEED");
		test.withSeed();

		System.out.println("");
	}
}


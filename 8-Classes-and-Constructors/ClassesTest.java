
public class ClassesTest {
	String name;
	int age;

	ClassesTest() { // if no args
		this("No name", 18);
	}

	ClassesTest(int age) { // if only age provided
		this("No name", age);
	}

	ClassesTest(String name) { // if only name provided
		this(name, 18);
	}

	ClassesTest(String name, int age) { // both name and age
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return this.name + " " + this.age;
	}

	public static void main(String[] args) {
		System.out.println(new ClassesTest());
		System.out.println(new ClassesTest("eloise"));
		System.out.println(new ClassesTest(28));
		System.out.println(new ClassesTest("Eloise", 28));
	}
}

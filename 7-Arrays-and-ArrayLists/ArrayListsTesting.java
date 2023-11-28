import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListsTesting {
	public static void main (String[] args) {

		// ****** test 1 *****
		System.out.println("TEST ONE");

		var al = new ArrayList<Integer>();
		al.add(1);
		System.out.println(al);

		// ****** test 2 *****
		System.out.println("TEST TWO");

		ArrayList<String> al2 = new ArrayList<>();
		if (al2.add("a")) {
			if (al2.contains("a")) {
				al2.add(al2.indexOf("a"), "b");
			}
		}
		System.out.println(al2);
		
		// ****** test 3 *****
		System.out.println("TEST THREE");

		// ArrayList<String> al3 = new ArrayList<>();
		ArrayList<String> al3 = new ArrayList<>(Arrays.asList(new String[]{"a","b","c","d","e","f","g","h", "i", "j", "k"}));
		System.out.println(al3.size());
		al3.add(11, "x");
		System.out.println(al3);
		System.out.println(al3.size());

		// ****** test 4 *****
		System.out.println("TEST FOUR");
		
		var list1 = new ArrayList<String>();
		var list2 = new ArrayList<String>();
		list1.add("a"); list1.add("b");
		list2.add("b"); list2.add("c"); list2.add("d");
		list1.addAll(list2);
		list1.remove("b");
		System.out.println(list1);

		// ****** test 5 *****
		System.out.println("TEST FIVE");
		
		var list3 = new ArrayList<String>();
		var list4 = new ArrayList<String>();
		list3.add("a"); list3.add("b");
		list4.add("b"); list4.add("c"); list4.add("d");
		list3.addAll(list4);
		System.out.println(list3);
		list3.remove("b");
		System.out.println(list3);

			// ****** test 6 *****
		System.out.println("TEST SIX");
		
		var list5 = new ArrayList<String>();
		var list6 = new ArrayList<String>();
		list5.add("a"); list5.add("b");
		list6.add("b"); list6.add("c"); list6.add("d");
		list5.addAll(list6);
		System.out.println(list5);
		list5.removeAll(list6); // Removes every instance of any of the elements (so both b's)
		System.out.println(list5);
	}
}
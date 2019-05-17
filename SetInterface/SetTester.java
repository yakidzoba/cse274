/**
 * A tester that tests the operations of a set of objects.
 *  
 * @author michaeldzoba
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SetTester {

	@Test
	void testGetCurrentSize() {
		// tests constructor
		SortedSet set = new SortedSet();

		// tests empty set
		assertEquals(set.getCurrentSize(), 0);

		// tests adding 5 objects to set
		assertTrue(set.add("bat"));
		assertEquals(set.getCurrentSize(), 1);
		assertTrue(set.add("hat"));
		assertEquals(set.getCurrentSize(), 2);
		assertTrue(set.add("cat"));
		assertEquals(set.getCurrentSize(), 3);
		assertTrue(set.add("ba"));
		assertEquals(set.getCurrentSize(), 4);
		assertTrue(set.add("car"));
		assertEquals(set.getCurrentSize(), 5);

		// tests adding duplicates
		assertFalse(set.add("cat"));
		assertEquals(set.getCurrentSize(), 5);

		// double checking
		// System.out.println(set.toString());
		// System.out.println("Current size: " + set.getCurrentSize());
	}

	@Test
	void testIsEmpty() {
		// tests constructor
		SortedSet set = new SortedSet();

		// tests empty set
		assertEquals(set.getCurrentSize(), 0);
		assertTrue(set.isEmpty());

		// tests a non-empty set
		assertTrue(set.add("cat"));
		assertFalse(set.isEmpty());
	}

	@Test
	void testAdd() {
		// tests constructor
		SortedSet set = new SortedSet();

		// tests constructor being empty
		assertEquals(set.getCurrentSize(), 0);
		assertTrue(set.isEmpty());

		// tests duplicates
		assertTrue(set.add("z"));
		assertFalse(set.add("z"));

		// tests sorting - adds 14 strings - should be: a at b bat c cat d e f g h i z
		assertTrue(set.add("cat"));
		assertTrue(set.add("bat"));
		assertTrue(set.add("Bat"));
		assertTrue(set.add("at"));
		assertTrue(set.add("a"));
		assertTrue(set.add("i"));
		assertTrue(set.add("b"));
		assertTrue(set.add("g"));
		assertTrue(set.add("Apple"));
		assertTrue(set.add("e"));
		assertTrue(set.add("c"));
		assertTrue(set.add("d"));
		assertTrue(set.add("h"));

		// System.out.println(set.toString());

		// checking the size to be 14
		assertEquals(set.getCurrentSize(), 14);
	}

	@Test
	void testRemoveString() {
		// tests constructor
		SortedSet set = new SortedSet();

		// tests constructor being empty
		assertEquals(set.getCurrentSize(), 0);
		assertTrue(set.isEmpty());

		// tests adding 5 objects to set
		assertTrue(set.add("bat"));
		assertEquals(set.getCurrentSize(), 1);
		assertTrue(set.add("hat"));
		assertEquals(set.getCurrentSize(), 2);
		assertTrue(set.add("cat"));
		assertEquals(set.getCurrentSize(), 3);
		assertTrue(set.add("ba"));
		assertEquals(set.getCurrentSize(), 4);
		assertTrue(set.add("car"));
		assertEquals(set.getCurrentSize(), 5);

		// System.out.println(set.toString());

		// tests removing "cat" - result should be [ ba bat car hat]
		assertTrue(set.remove("cat"));
		// System.out.println(set.toString());

	}

	@Test
	void testRemove() {
		// tests constructor
		SortedSet set = new SortedSet();

		// tests empty set
		assertEquals(set.getCurrentSize(), 0);
		assertTrue(set.isEmpty());

		// tests adding 5 objects to set
		assertTrue(set.add("bat"));
		assertEquals(set.getCurrentSize(), 1);
		assertTrue(set.add("hat"));
		assertEquals(set.getCurrentSize(), 2);
		assertTrue(set.add("cat"));
		assertEquals(set.getCurrentSize(), 3);
		assertTrue(set.add("ba"));
		assertEquals(set.getCurrentSize(), 4);
		assertTrue(set.add("car"));
		assertEquals(set.getCurrentSize(), 5);

		// System.out.println("initial linked list: " + set.toString());
		set.remove();
		set.remove();
		// should remove 2 strings
		// System.out.println("string removed: " + set.remove());
		// System.out.println("string removed: " + set.remove());
		assertEquals(set.getCurrentSize(), 3);

		// System.out.println("result: " + set.toString());

	}

	@Test
	void testClear() {
		// tests constructor
		SortedSet set = new SortedSet();

		// tests empty set
		assertEquals(set.getCurrentSize(), 0);
		assertTrue(set.isEmpty());

		// tests adding 5 objects to set
		assertTrue(set.add("bat"));
		assertEquals(set.getCurrentSize(), 1);
		assertTrue(set.add("hat"));
		assertEquals(set.getCurrentSize(), 2);
		assertTrue(set.add("cat"));
		assertEquals(set.getCurrentSize(), 3);
		assertTrue(set.add("ba"));
		assertEquals(set.getCurrentSize(), 4);
		assertTrue(set.add("car"));
		assertEquals(set.getCurrentSize(), 5);

		// System.out.println(set.toString());
		set.clear();
		// System.out.println(set.toString());
		assertEquals(set.getCurrentSize(), 0);
		assertTrue(set.isEmpty());
	}

	@Test
	void testContains() {
		// tests constructor
		SortedSet set = new SortedSet();

		// tests empty set
		assertEquals(set.getCurrentSize(), 0);
		assertTrue(set.isEmpty());

		// tests containing an element in an empty set
		assertFalse(set.contains("at"));

		// tests string that is contained
		assertTrue(set.add("at"));
		assertTrue(set.contains("at"));
		assertEquals(set.getCurrentSize(), 1);
	}

	@Test
	void testToString() {
		// tests constructor
		SortedSet set = new SortedSet();

		// tests empty set
		assertEquals(set.getCurrentSize(), 0);
		assertTrue(set.isEmpty());

		// tests adding 5 objects to set
		assertTrue(set.add("bat"));
		assertEquals(set.getCurrentSize(), 1);
		assertTrue(set.add("hat"));
		assertEquals(set.getCurrentSize(), 2);
		assertTrue(set.add("cat"));
		assertEquals(set.getCurrentSize(), 3);
		assertTrue(set.add("ba"));
		assertEquals(set.getCurrentSize(), 4);
		assertTrue(set.add("car"));
		assertEquals(set.getCurrentSize(), 5);

		// tests toString method. should be: [ ba bat car cat hat ]
		//System.out.println(set.toString());
	}

	@Test
	void testToArray() {

		// tests constructor
		SortedSet set = new SortedSet();

		// tests empty set
		assertEquals(set.getCurrentSize(), 0);
		assertTrue(set.isEmpty());
		
		// testing empty array - should not print anything
		set.toArray();
//		for(int i = 0; i < set.toArray().length; i ++) {
//			System.out.println(set.toArray()[i]);
//		}
		

		// tests adding 5 objects to set
		assertTrue(set.add("bat"));
		assertEquals(set.getCurrentSize(), 1);
		assertTrue(set.add("hat"));
		assertEquals(set.getCurrentSize(), 2);
		assertTrue(set.add("cat"));
		assertEquals(set.getCurrentSize(), 3);
		assertTrue(set.add("ba"));
		assertEquals(set.getCurrentSize(), 4);
		assertTrue(set.add("car"));
		assertEquals(set.getCurrentSize(), 5);
		
		// converts the set into an Array
		set.toArray();
		
		// prints out each element of the array
//		for(int i = 0; i < set.toArray().length; i ++) {
//			System.out.println(set.toArray()[i]);
//		}
	}

}

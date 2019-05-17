/**
 * A tester that tests the queue implementation
 * @author michaeldzoba
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {

	@Test
	void testArrayQueue() {
		// Tests constructor and checks if isEmpty
		ArrayQueue<String> queue = new ArrayQueue<>();
		assertTrue(queue.isEmpty());
	}

	@Test
	void testArrayQueueInt() {
		// Tests constructor and checks if isEmpty
		ArrayQueue<String> queue = new ArrayQueue<>(10);
		assertTrue(queue.isEmpty());
		
	}

	@Test
	void testEnqueue() {
		// Tests constructor and checks if isEmpty
		ArrayQueue<String> queue = new ArrayQueue<>();
		assertTrue(queue.isEmpty());
		
		// Tests adding to empty queue
		queue.enqueue("cat");
		assertEquals(queue.getFront(), "cat");
		queue.enqueue("dog");
		assertEquals(queue.getFront(), "cat");
	}

	@Test
	void testGetFront() {
		// Tests constructor and checks if isEmpty
		ArrayQueue<String> queue = new ArrayQueue<>();
		assertTrue(queue.isEmpty());
		
		// Tests adding to front and getFront()
		queue.enqueue("cat");
		assertEquals(queue.getFront(), "cat");
		queue.enqueue("dog");
		assertEquals(queue.getFront(), "cat");
	}

	@Test
	void testDequeue() {
		// Tests constructor and checks if isEmpty
		ArrayQueue<String> queue = new ArrayQueue<>();
		assertTrue(queue.isEmpty());
		
		// Tests adding to front and getFront()
		queue.enqueue("cat");
		assertEquals(queue.getFront(), "cat");
		queue.enqueue("dog");
		assertEquals(queue.getFront(), "cat");
		queue.dequeue();
		assertEquals(queue.dequeue(), "dog");
	}

	@Test
	void testIsEmpty() {
		// Tests constructor and checks if isEmpty
		ArrayQueue<String> queue = new ArrayQueue<>();
		assertTrue(queue.isEmpty());
		
		// Tests adding to front and getFront()
		queue.enqueue("cat");
		assertEquals(queue.getFront(), "cat");
		
		assertFalse(queue.isEmpty());
	}

	@Test
	void testClear() {
		// Tests constructor and checks if isEmpty
		ArrayQueue<String> queue = new ArrayQueue<>();
		assertTrue(queue.isEmpty());
		
		// Tests adding to front and getFront()
		queue.enqueue("cat");
		assertEquals(queue.getFront(), "cat");
		queue.enqueue("dog");
		assertEquals(queue.getFront(), "cat");
		
		// Tests clear method
		queue.clear();
		assertTrue(queue.isEmpty());
	}

}

import java.lang.reflect.Array;
import java.util.Set;

/**
 * A linked-node implementation of the Set ADT in which elements of the set are
 * always sorted (in this case, lexicographically, which is a fancy way of
 * saying "alphabetically"). Note that the String class has a compareTo method
 * which you should be using to assist you in keeping the set sorted.
 * 
 * @author michaeldzoba
 * 
 *         My code does not take into consideration if a string is upper or
 *         lower case. I am assuming if the word entered is upper case then it
 *         will go to the front of the linked list when sorted because of the
 *         compareTo method.
 * 
 *         If I wanted to, I could easily make all string upper or lower case to
 *         better sort them if needed.
 * 
 */
public class SortedSet implements SetInterface<String> {

	private Node head;
	private int size = 0;

	// constructor
	public SortedSet() {
		String set[] = new String[size];
	}

	// methods
	@Override
	public int getCurrentSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean add(String newEntry) {

		Node newNode = new Node(newEntry);
		Node current = head;

		// if empty, add to head
		if (isEmpty()) {
			head = newNode;
			size++;
			return true;
		}
		// if set contains duplicates, do not add and return false
		if (contains(newEntry)) {
			return false;
		}
		// if not empty, add and sort
		else {
			// compares to head
			if (newEntry.compareTo(current.data) > 0) {

				while (current != null) {

					if (current.next == null) {
						current.next = newNode;
						size++;
						return true;
					}

					if (newEntry.compareTo(current.next.data) > 0) {
						current = current.next;
					}

					else {
						newNode.next = current.next;
						current.next = newNode;
						size++;
						return true;
					}
				}
			}
			// if less then the head, add before head
			else {
				newNode.next = current;
				head = newNode;
				size++;
				return true;
			}

		}
		return false;
	}

	@Override
	public boolean remove(String anEntry) {
		Node current = head;

		while (current.next != null) {
			if (current.next.data.equals(anEntry)) {
				current.next = current.next.next;
				size--;
				return true;
			}
			current = current.next;
		}

		return false;
	}

	@Override
	public String remove() {
		Node current = head;
		Node res;

		if (current != null) {
			res = head;
			head = current.next;
			size--;
			return res.data;
		}
		return null;
	}

	@Override
	public void clear() {

		head = null;
		size = 0;

	}

	@Override
	public boolean contains(String anEntry) {

		Node current = head;

		while (current != null) {
			if (current.data.equals(anEntry)) {
				return true;
			}
			current = current.next;
		}
		return false;

	}

	/*
	 * returns a string representation of the items in the set, specifically a space
	 * separated list of the strings, enclosed in square brackets []. For example,
	 * if the set contained cat, dog, then this should return "[cat dog]". If the
	 * set were empty, then this should return "[]".
	 */
	@Override
	public String toString() {

		String str = "[ ";

		Node current = head;

		// this is the length of the linked list
		while (current != null) {
			str += current.data + " ";
			current = current.next;
		}

		str += "]";
		return str;
	}

	// copied this from the book
	@Override
	public String[] toArray() {
		String result[] = new String[size];
		Node current = head;
		int index = 0;

		while ((index < size) && (current != null)) {
			result[index] = current.data;
			index++;
			current = current.next;
		}

		return result;
	}

	// Node Class
	private class Node {

		String data;
		Node next;

		// Constructors
		public Node() {

		}

		public Node(String data) {
			this.data = data;
		}

	}

}

package main;

import list.LinkedList;

/**
 * 
 * Class to create and test the linked list.
 *
 */
public class Main {

	public static void main(String args[]) {
		LinkedList ll = new LinkedList();
		ll.addData(1);
		ll.addData("hello");
		ll.addData(true);
		ll.addData('a');
		
		LinkedList ll2 = ll;
		
		System.out.println(ll.containsAll(ll2));
	}

}

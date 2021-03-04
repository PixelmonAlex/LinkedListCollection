package list;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * Class to represent the list of nodes and to provide operations that can act on the list.
 *
 */

public class LinkedList implements Collection<Node<?>>{
	
	//first node in the list
	private Node<?> startNode, endNode, previousNode, nav;
	
	//number of nodes in the list
	private int size;
	
	/**
	 * The constructor takes no parameters.
	 */
	public LinkedList() {
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		nav = startNode;
		while(nav != null) {
			if(nav.equals(o)) {
				return true;
			}
			nav = nav.getNext();
		}
		return false;
	}

	@Override
	public Iterator<Node<?>> iterator() {
		return new ListIter();
	}

	@Override
	public Object[] toArray(){
		Object[] arr = new Object[size];
		nav = startNode;
		int i = 0;
		
		while(nav != null) {
			arr[i] = nav.getData();
			i++;
			nav = nav.getNext();
		}
		
		return arr;
	}

	@Override
	public <T> T[] toArray(T[] a) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Due to the LL's intended heterogeneity, creating a homogoneous list of a type"
				+ "other than Object is impossible to do without risking errors."
				+ "\nTo create an Object array, please use toArray().");
	}

	@Override
	public boolean add(Node<?> e) {
		e.setNext(null);
		
		if(size == 0) {
			startNode = e;
		}
		else {
			previousNode = endNode;
			endNode = e;
			previousNode.setNext(endNode);
		}
		
		size++;
		
		return true;
	}
	
	/**
	 * Adds items to the linked list. 
	 * @param item - the item that is to be added.
	 */
	public <T> void addData(T item) {
		
		//node which will be added
		Node<T> node = new Node<T>(item);
		
		node.setNext(null);
		
		if(size == 0) {
			startNode = node;
			endNode = startNode;
		}
		else {
			previousNode = endNode;
			endNode = node;
			previousNode.setNext(endNode);
		}
		
		size++;
	}

	/**
	 * Removes first instance of o in the list.
	 * @param o - Item to remove.
	 */
	@Override
	public boolean remove(Object o) {
		if(startNode.equals(o)) {
			startNode = startNode.getNext();
			return true;
		}
		else {
			nav = startNode;
			previousNode = null;
			
			while(!nav.equals(o)) {
				previousNode = nav;
				nav = nav.getNext();
				
				if(nav == null) {
					return false;
				}
			}
			
			previousNode.setNext(nav.getNext());
			return true;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object item : c) {
			if(!contains(item)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends Node<?>> c) {
		for(Node<?> n : c) {
			add(n);
		}
		return true;
	}
	
	
	public <T> void addItems(Collection<T> items) {
		for(T item : items) {
			addData(item);
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object o : c) {
			if(contains(o)) {
				remove(o);
			}
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if(containsAll(c)) {
			Node<?> newStart = null;
			int i = 0;
			for(Object o : c) {
				if(i == 0) {
					newStart = createNodeAround(o);
				}
				else {
					newStart.setNext(createNodeAround(o));
				}
				i++;
			}
			size = i;
			startNode = newStart;
			return true;
		}
		return false;
	}
	
	private <T> Node<T> createNodeAround(T data) {
		return new Node<T>(data);
	}

	@Override
	public void clear() {
		startNode = null;
	}
	
	/**
	 * 
	 * A class to enable iteration over the list using the for-each syntax.
	 *
	 */
	private class ListIter implements Iterator<Node<?>> {

		private Node<?> navigator;
		
		public ListIter() {
			navigator = startNode;
		}
		
		@Override
		public boolean hasNext() {
			return navigator != null;
		}

		@Override
		public Node<?> next() {
			Node<?> temp = navigator;
			navigator = navigator.getNext();
			return temp;
		}
	}
}

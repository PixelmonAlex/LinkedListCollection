package list;

/**
 * 
 * Class to represent a node in the list.
 * Each node contains a pointer to the next Node in the list and an item of data.
 *
 * @param <T> The data type of the data stored in the node.
 */
public class Node<T> implements Comparable<T>{

	private Node<?> next;
	private T data;
	
	public Node(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public Node<?> getNext() {
		return next;
	}
	
	public void setData(T x) {
		data = x;
	}
	
	public void setNext(Node<?> x) {
		next = x;
	}

	@Override
	public int compareTo(T o) {
		return o.toString().compareTo(data.toString());
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Node) {
			return data.equals(((Node<?>) o).getData());
		}
		return data.equals(o);
	}
}

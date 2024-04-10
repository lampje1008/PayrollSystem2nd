package PayrollSystem;

/** Data structure that links multiple data in form of a chain, node. */
public class Node<T> {
	private T		data;
	private Node<T>	next;
	
	/** Creates a new node that comes first.
	 * @param dataPortion	The data reference that the node holds. */
	Node(T dataPortion) {
		this(dataPortion, null);
	} // end constructor
	
	/** Creates a new node that comes after another node.
	 * @param dataPortion	The data the node holds.
	 * @param nextNode		The node that comes after this node. */
	Node(T dataPortion, Node<T> nextNode) {
		data = dataPortion;
		next = nextNode;
	} // end constructor
	
	/** Returns data of this node.
	 * @return	The data of this node. */
	T getData() {
		return data;
	} // end getData
	
	/** Sets data of this node.
	 * @param newData	The data that will be held by this node. */
	void setData(T newData) {
		data = newData;
	} // end setData
	
	/** Returns the node that comes after this node.
	 * @return	The node that comes after this node. */
	Node<T> getNextNode() {
		return next;
	} // end getNextNode
	
	/** Sets the node that comes after this node.
	 * @param nextNode	The node that will come after this node. */
	void setNextNode(Node<T> nextNode) {
		next = nextNode;
	} // end setNextNode
} // end Node

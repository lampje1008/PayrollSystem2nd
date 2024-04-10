package PayrollSystem;

/** A class of bags whose entries are stored in a chain of linked nodes.
 * 	The bag is never full. */
public class LinkedBag<T> implements BagInterface<T> {
	private Node<T>	firstNode;
	private int 	numberOfEntries;
	
	/** Creates an empty bag. */
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor
	
	/** Adds a new entry to this bag.
	 * @param newEntry	The object to be added as a new entry.
	 * @return	True. */
	public boolean add(T newEntry) { // OutOfMemoryError possible
		// Add to beginning of chain:
		Node<T> newNode = new Node<>(newEntry);
		newNode.setNextNode(firstNode);
		firstNode = newNode;
		numberOfEntries++;
		
		return true;
	} // end add
	
	/** Retrieves all entries that are in this bag.
	 * @return	A newly allocated array of all the entries in this bag.
	 *		Note: If the bag is empty, the returned array is empty. */
	public T[] toArray() {
		//The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked entries
		
		int index = 0;
		Node<T> currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			index++;
			currentNode = currentNode.getNextNode();
		} // end while
		
		return result;
	} // end toArray
	
	/** Counts the number of times a given entry appears in this bag.
	 * @param anEntry	The entry to be counted.
	 * @return	The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int loopCounter = 0;
		Node<T> currentNode = firstNode;
		
		while ((loopCounter < numberOfEntries) && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				frequency++;
			
			loopCounter++;
			currentNode = currentNode.getNextNode();
		} // end while
		
		return frequency;
	} // end getFrequencyOf
	
	/** Tests whether this bag contains a given entry.
	 * @param anEntry	The entry to locate.
	 * @return	True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while
		
		return found;
	} // end contains
	
	/** Removes one unspecified entry from this bag, if possible.
	 * @return	Either the removed entry, if the removal was successful, or null. */
	public T remove() {
		T result = null;
		if (firstNode != null) {
			result = firstNode.getData();
			firstNode = firstNode.getNextNode(); // Remove first node from chain
			numberOfEntries--;
		} // end if
		
		return result;
	} // end remove
	
	/** Removes one occurrence of a given entry from this bag, if possible.
	 * @param anEntry	The entry to be removed.
	 * @return	True if the removal was successful, or false if not. */
	public boolean remove(T anEntry) {
		boolean result = false;
		Node<T> nodeN = getReferenceTo(anEntry);
		
		if (nodeN != null) {
			nodeN.setData(firstNode.getData());		// Replace located entry with entry
													// in first node
			firstNode = firstNode.getNextNode();	// Remove first node
			numberOfEntries--;
			result = true;
		} // end if
		
		return result;
	} // end remove
	
	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();
	} // end clear
	
	/** Sees whether this bag is empty.
	 * @return	True if the bag is empty, or false if not. */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty
	
	/** Gets the current number of entries in this bag.
	 * @return	The integer number of entries currently in the bag. */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize
	
	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node<T> getReferenceTo(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		
		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		} // end while
		
		return currentNode;
	} // end getReferenceTo
} // end LinkedBag

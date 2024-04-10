package PayrollSystem;

import java.util.Arrays;

/** A class of bags whose entries are stored in a resize-able array. */
public final class ArrayBag<T> implements BagInterface<T> {
	private T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	private boolean initialized = false;
	
	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	/** Creates an empty bag having a given initial capacity.
	 * @param desiredCapacity	The integer capacity desired. */
	public ArrayBag(int desiredCapacity) {
		if (desiredCapacity <= MAX_CAPACITY) {
			// The cast is safe because the new array contains null entries.
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[]) new Object[desiredCapacity];	// Unchecked cast
			bag = tempBag;
			numberOfEntries = 0;
			initialized = true;									// Last action
		} else
			throw new IllegalStateException("Attempt to create a bag " +
											"whose capacity exceeds " +
											"allowed maximum.");
	} // end constructor
	
	/** Adds a new entry to this bag.
	 * @param newEntry	The object to be added as a new entry.
	 * @return	True if the addition is successful, or false if not. */
	public boolean add(T newEntry) {
		checkInitialization();
		boolean result = true;
		if (isArrayFull())
			doubleCapacity();
		else { // Assertion: result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		} // end if
		
		return result;
	} // end add
	
	/** Retrieves all entries that are in this bag.
	 * @return	A newly allocated array of all the entries in this bag. */
	public T[] toArray() {
		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];	// Unchecked cast
		for (int index = 0; index < numberOfEntries; index++)
			result[index] = bag[index];
		return result;
	} // end toArray
	
	/** Gets the current number of entries in this bag.
	 * @return	The integer number of entries currently in the bag. */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize
	
	/** Sees whether this bag is empty.
	 * @return	True if the bag is empty, or false if not. */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty
	
	/** Removes one unspecified entry from this bag, if possible.
	 * @return	Either the removed entry, if the removal was successful, or null. */
	public T remove() {
		checkInitialization();
		T result = removeEntry(numberOfEntries - 1);
		return result;
	} // end remove
	
	/** Removes one occurrence of a given entry from this bag, if possible.
	 * @param anEntry	The entry to be removed.
	 * @return	True if the removal was successful, or false if not. */
	public boolean remove(T anEntry) {
		checkInitialization();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	} // end remove
	
	/** Removes all entries from this bag. */
	public void clear() {
		while (!isEmpty())
			remove();
	} // end clear
	
	/** Counts the number of times a given entry appears in this bag.
	 * @param anEntry	The entry to be counted.
	 * @return	The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry) {
		checkInitialization();
		int counter = 0;
		for (int index = 0; index < numberOfEntries; index++)
			if (anEntry.equals(bag[index]))
				counter++;
		
		return counter;
	} // end getFrequencyOf
	
	/** Tests whether this bag contains a given entry.
	 * @param anEntry	The entry to locate.
	 * @return	True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry) {
		checkInitialization();
		return getIndexOf(anEntry) > -1;
	} // end contains
	
	// Returns true if the bag is full, or false if not.
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	} // end isArrayFull
	
	// Throws an exception if this object is not initialized
	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException("ArrayBag is not initialized " +
										"properly.");
	} // end checkInitialization
	
	// Removes and returns the entry at a given array index.
	// If no such entry exists, returns null.
	// Preconditions: 0 <= givenIndex < numberOfEntries;
	//				  checkInitialization has been called.
	private T removeEntry(int givenIndex) {
		T result = null;
		if (!isEmpty() && (givenIndex >= 0)) {
			result = bag[givenIndex];
			bag[givenIndex] = bag[numberOfEntries - 1];
			
			bag[numberOfEntries - 1] = null;
			numberOfEntries--;
		} // end if
		
		return result;
	} // end removeEntry
	
	// Locates a given entry within the array bag.
	// Returns the index of the entry, if located, or -1 otherwise.
	// Precondition: checkInitialization has been called.
	private int getIndexOf(T anEntry) {
		int where = -1;
		boolean stillLooking = true;
		int index = 0;
		while (stillLooking && (index < numberOfEntries)) {
			if (anEntry.equals(bag[index])) {
				stillLooking = false;
				where = index;
			} // end if
			index++;
		} // end while
		
		// Assertion: If where > -1, anEntry is in the array bag, and it
		// equals bag[where]; otherwise, anEntry is not in the array
		
		return where;
	} // end getIndexOf
	
	// Doubles the size of the array bag.
	// Precondition: checkInitialization has been called.
	private void doubleCapacity() {
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	} // end doubleCapacity
	
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a bag whose " +
											"capacity exceeds allowed" +
											"maximum of " + MAX_CAPACITY);
	} // end checkCapacity
} // end ArrayBag
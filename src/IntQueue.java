
import java.util.NoSuchElementException;
/**
 * The IntQueue provides the data structure for a collection of integers.
 * 
 * @author Luke Newman copied largely from Michael Main's ArrayQueue.java
 * 				in "Introduction to Data Structures" pg.389-393
 * 			10/13/2016
 *
 */
public class IntQueue {
	private int[] data;
	private int numOfItems;
	private int front;
	private int rear;
	/**
	 * The no-argument constructor instantiates an IntQueue of size 10.
	 * 
	 * @postcondition
	 * 		A new IntQueue has been instantiated and the size of the queue is 10.
	 */
	public IntQueue(){
		data = new int[10];
		numOfItems = 0;
	}
	/**
	 * The constructor instantiates an IntQueue of a specified size.
	 * @param initialCapacity
	 * 		initialCapacity - the specified size of the queue
	 * @postcondition
	 * 		A new IntQueue has been instantiated and the size of the queue is initialCapacity.
	 */
	public IntQueue(int initialCapacity){
		data = new int[initialCapacity];
		numOfItems = 0;
	}
	/**
	 * add increases the size of the queue by one and adds the item to the back of the queue.
	 * 
	 * @param item
	 *  	item - the integer that is to be added to the queue
	 * @postcondition 
	 * 		the item has been added to the rear of the queue
	 */
	public void add(int item){
		if (numOfItems == 0){
			rear = 0;
			front = 0;
		}
		else if (numOfItems == data.length){
			ensureCapacity(2 * data.length + 1);
			rear = nextIndex(rear);
		}
		else 
			rear = nextIndex(rear);
		data[rear] = item;
		numOfItems++;
		
	}
	/**
	 * remove() removes the integer that is at the front of the queue
	 * @precondition 
	 * 		the queue is not empty
	 * @return
	 * 		returns the integer that was at the front of the queue
	 * @postcondition
	 * 		numOfItems has been decremented, the next item in the queue is at data[front]
	 */
	public int remove(){
		int answer;
		
		if (numOfItems == 0){
			throw new NoSuchElementException("Queue underflow");
		}
		answer = data[front];
		front = nextIndex(front);
		numOfItems--;
		return answer;
	}
	/*
	 * nextIndex(int i) returns the next index in the circular array.
	 * 
	 */
	private int nextIndex(int i){
		int answer;
		if (i == data.length-1)
			answer = 0;
		else
			answer = i + 1;
		return answer;
	}
	/**
	 * isEmpty() determines whether the queue is empty or not
	 * 
	 * @return
	 * 		returns true if the queue is empty
	 * 		returns false if the queue is not empty
	 */
	public boolean isEmpty(){
		return (numOfItems == 0);
	}
	/**
	 * size() is an accessor method that gives the size of the queue
	 * 
	 * @return
	 * 		returns the size of the list
	 */
	public int size(){
		return numOfItems;
	}
	/**
	 * ensureCapacity(int minimumCapacity) increases the size of the queue to minimumCapacity
	 * 
	 * @param minimumCapacity
	 * 		minimumCapacity - an integer that will be the new size of the queue
	 * @postcondition 
	 * 		if minimumCapacity is larger than the length of the array, a new array 
	 * 		has been initialized with the new larger capacity, the items are copied
	 * 		into the larger array, and data references to that larger array. No action
	 *      is taken if the length of the array is already larger or equal to 
	 *      minimumCapacity.
	 */
	public void ensureCapacity(int minimumCapacity){
		int[] biggerArray;
		
		if (data.length >= minimumCapacity)
			return;
		else if (numOfItems == 0)
			data = new int[minimumCapacity];
		else if (front <= rear){
			biggerArray = new int[minimumCapacity];
			System.arraycopy(data, front, biggerArray, front, numOfItems);
			data = biggerArray;
		}
		else{
			biggerArray = new int[minimumCapacity];
			System.arraycopy(data, front, biggerArray, 0, data.length - front);
			System.arraycopy(data, 0, biggerArray, data.length - front, rear + 1);
			front = 0;
			rear = numOfItems - 1;
			data = biggerArray;
		}
	}

}
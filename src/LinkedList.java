import java.util.Iterator;

public class LinkedList<E> implements IList<E> {

	
	// Instance Variables
	private DoubleListNode<E> dummy;
	private int size;
    
	
	
    private class LLIterator implements Iterator<E>{
    	
        private DoubleListNode<E> nextNode;
        private boolean removeOK;
    	
        private LLIterator(){
            nextNode = dummy.getNext();
            removeOK = false;
        }
        
        // O(1)
        public boolean hasNext(){ 
        	return nextNode != dummy;
        }
        
        // O(1)
        public E next(){ 
            assert hasNext();
            
            E result = nextNode.getData();
            nextNode = nextNode.getNext();
            
            removeOK = true;
            
            return result;
        }
        
        // O(1)
        public void remove(){
            assert removeOK;
            removeOK = false;
            
            // nextNode points at next node instead of current node to be removed
            // so to get node before, must go back twice
            nextNode.setData(null);
            DoubleListNode<E> previous = nextNode.getPrev().getPrev();
            DoubleListNode<E> after = nextNode;
            previous.setNext(after);
            after.setPrev(previous);
            size--;
            
        }
    }
    
    
    // Constructors
    // Creates a Double LinkedList with a dummy node
    public LinkedList() {
    	size = 0;
    	dummy = new DoubleListNode<E>();
    }
    
    
    // Creates a Double LinkedList with a dummy node and parameter node as first node
    public LinkedList(DoubleListNode<E> first) {
    	size = 1;
    	dummy = new DoubleListNode<E>();
    	dummy.setNext(first);
    	first.setPrev(dummy);
    }
    
    // Creates a Double LinkedList with a dummy node and first node containing the parameter item
    public LinkedList(E item)
    {
    	size = 1;
    	dummy = new DoubleListNode<E>();
    	DoubleListNode<E> first = new DoubleListNode<E>(dummy, item, dummy);
    	dummy.setNext(first);
    	dummy.setPrev(first);
    }
    
    
    // Methods
    
    
    // O(1)
    // Method adds an item to the end of the list
    // Pre: None
    // Post: size() = old size() + 1, get(size() - 1) = item
	public void add(E item){

		if(size == 0)
			addFirst(item);
		else
		{
			DoubleListNode<E> last = dummy.getPrev();
			DoubleListNode<E> temp = new DoubleListNode<E>(last,item,dummy);
			dummy.setPrev(temp);
			last.setNext(temp);
			size++;
		}

	}
	
	
	// O(1) if adding to front or back
	// O(N) if adding somewhere else in list
	// Pre: 0 <= pos <= size()
	// Post: size() = old size() + 1, get(pos) = item, all elements in
	// the list with a positon >= pos have a position = old position + 1
	// Method that inserts the parameter item at the indicated position 
	public void insert(int pos, E item){
		
		assert(pos >= 0 && pos <= size);
		
		if(pos == 0)
			addFirst(item);
		else if(pos == size)
			addLast(item);
		else
		{
			DoubleListNode<E> temp = dummy.getNext();
			int index = 0;
			
			// Get to node position
			// Temp holds the node for the location to be replaced
			while(index < pos-1)
			{
				temp = temp.getNext();
				index++;
			}
			DoubleListNode<E> post = temp.getNext();
			DoubleListNode<E> param = new DoubleListNode<E>(temp,item,post);
			temp.setNext(param);
			post.setPrev(param);
			size++;	
		}	
	}

	// O(1) if setting item at front or back of list
	// O(N) if setting item somewhere else in list
	// Pre: 0 <= pos < size()
	// Post: get(pos) = item, return the old get(pos)
	// Method that changes the item at the specified position
	public E set(int pos, E item){
		
		assert pos >= 0 && pos < size;
		
		E previousData;
		
		if(pos == 0)
		{
			DoubleListNode<E> temp = dummy.getNext();
			previousData = temp.getData();
			temp.setData(item);
		}
		else if(pos == size-1)
		{
			DoubleListNode<E> temp = dummy.getPrev();
			previousData = temp.getData();
			temp.setData(item);
		}
		else
		{
			DoubleListNode<E> temp = dummy.getNext();
			int index = 0;
			
			// Get to node that data is to be changed
			while(index != pos)
			{
				temp = temp.getNext();
				index++;
			}
			previousData = temp.getData();
			temp.setData(item);
		}
		return previousData;
	}

	// O(1) if getting item from front or back
	// O(N) if getting item from somewhere else in list
	// Pre: 0 <= pos < size()
	// Post: Returns the item at the position
	// Method that gets the item at the specified position
	public E get(int pos){

		assert pos >= 0 && pos < size;
		
		E Data;
		
		// Optimization for getting first and last nodes
		if(pos == 0)
		{
			DoubleListNode<E> temp = dummy.getNext();
			Data = temp.getData();		
		}
		else if(pos == size-1)
		{
			DoubleListNode<E> temp = dummy.getPrev();
			Data = temp.getData();
		}
		else
		{
			DoubleListNode<E> temp = dummy.getNext();
			int index = 0;
			while(index != pos)
			{
				temp = temp.getNext();
				index++;
			}
			Data = temp.getData();
		}
		return Data;
	}

	// O(1) if removing from front or back of list
	// O(N) if removing from somewhere else in list
	// Pre: 0 <= pos < size()
	// Post: size() = old size() - 1, all elements of 
	// list with a positon > pos have a position = old position - 1
	// Method that removes the item at the indicated position
	public E remove(int pos){
				
		assert pos >= 0 && pos < size;
		
		E previousData;
		
		
		// Utilizing methods already made to optimize
		if(pos == 0)
			previousData = removeFirst();
		else if(pos == size-1)
			previousData = removeLast();
		
		// General Case
		else
		{
			DoubleListNode<E> temp = dummy.getNext();
			int index = 0;
			
			// get to node to be removed. Temp holds node that is to be removed
			while(index != pos)
			{
				temp = temp.getNext();
				index++;
			}
			
			// Get node before and after to change
			temp.setData(null);
			DoubleListNode<E> post = temp.getNext();
			DoubleListNode<E> pre = temp.getPrev();
			pre.setNext(post);
			post.setPrev(pre);
			size--;
			
			previousData = temp.getData();
		}
		return previousData;
	}

	// O(N)
	// Pre: None
	// Post: if obj is in this list the first occurence has been removed and size() = old size() - 1. 
	// If obj is not present the list is not altered in any way.
	// Method that removes the first instance of the parameter object
	public boolean remove(E obj){

		boolean flag = false;	
		int index = 0;
		
		if(size != 0)
		{
			
			DoubleListNode<E> temp = dummy.getNext();
			flag = obj.equals(temp.getData());
			index = 0;
			
			// Keep looking for obj until either gone through entire list or flag = true
			while(temp != dummy && !flag)
			{
				index++;
				temp = temp.getNext();
				flag = obj.equals(temp.getData());
			}
		}
		
		if(flag)
			remove(index);
		
		return flag;
	}

	// O(N)
	// Pre: 0 <= start < size(), start <= stop <= size()
	// Post: return a list whose size is stop - start and
	// contains the elements at positions start through stop - 1 in this list.
	// Method returns a sublist of elements in this list from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
	public IList<E> getSubList(int start, int stop){
		
    	assert start >= 0 && start <= stop && start < size && stop <= size;
    	
    	IList<E> output = new LinkedList<E>();
    	Iterator<E> it = this.iterator();
    	
    	// First for loop gets to node right before start
    	for(int i = 0; i < start; i++)
    		it.next();
    	
    	// Second for loop does the adding from start to stop
    	for(int j = 0; j < stop-start; j++)
    		output.add(it.next());
    	return output;
		
	}

	// O(1)
	// Pre: None
	// Post: Returns the size of the list
	// Method returns the size of the list
	public int size(){
		return size;
	}

	// O(N)
	// Pre: None
	// Post: return the index of the first element equal to item or -1 if item
	// is not present
	// Method finds the first instance of the parameter item in the list
	public int indexOf(E item){
		
		assert size != 0;
		
		int location = -1;
		int index = 0;
		DoubleListNode<E> temp = dummy.getNext();
		boolean flag = false;
		flag = item.equals(temp.getData());
		
		// Keeps searching until item is found or finished going through list
		while(!flag && temp != dummy)
		{
			index++;
			temp = temp.getNext();
			flag = item.equals(temp.getData());
		}
		
		if(flag)
			location = index;
		
		return location;
	}

	// O(N)
	// Pre: None
	// Post: return the index, starting at the parameter index, of the first element
	// equal to item or -1 if item is not present
	// Method finds the first instance of the parameter item in the list from a starting index
	public int indexOf(E item, int pos){
		
		assert pos >= 0 && pos < size && size != 0;
		
		int location = -1;
		int index = 0;
		boolean flag = false;
		DoubleListNode<E> temp = dummy.getNext();
		
		// This loop gets node at starting location
		while(index != pos)
		{
			index++;
			temp = temp.getNext();
		}
		
		flag = item.equals(temp.getData());
		
		// Loop goes through looking for item and exits if found or gone through list
		while(!flag && temp != dummy)
		{
			index++;
			temp = temp.getNext();
			flag = item.equals(temp.getData());
		}
		
		if(flag)
			location = index;
		
		return location;
	}

	
	
	
	// O(1)
	// Pre: None
	// Post: List is empty
	// Empties list of contents leaving only the dummy node
	public void makeEmpty(){

		dummy.setNext(dummy);
		dummy.setPrev(dummy);
		size = 0;
	}

	// O(1)
	// Pre: None
	// Post: None
	// Method returns the iterator for the linked list
	public Iterator<E> iterator(){
		return new LLIterator();
	}
	
	// O(N)
	// Pre: 0 <= start < size(), start <= stop <= size()
	// Post: size() = old size() - (stop - start)
	// Method removes the items ranging from start (inclusive) to stop (exclusive)
    public void removeRange(int start, int stop){
    	
    	assert start >= 0 && start <= stop && start < size && stop <= size;
    	
    	// If want to remove all elements
    	if(start == 0 && stop == size)
    		makeEmpty();
    	
    	// If starting location is 0
    	else if(start == 0)
    	{
	    	int index = 0;
	    	DoubleListNode<E> pre = dummy.getNext();
	    	DoubleListNode<E> post;
	    	post = pre;
	    	while(index != stop)
	    	{
	    		index++;
	    		post = post.getNext();
	    	}
	    	
	    	pre.setNext(post);
	    	post.setPrev(pre);
	    	size = size - (stop-start);
    	}
    	
    	// General case
    	else if(start != stop && size != 0)
    	{
	    	int index = 0;
	    	DoubleListNode<E> pre = dummy.getNext();
	    	DoubleListNode<E> post;
	    	
	    	// Loop gets to starting position
	    	while(index != start-1)
	    	{
	    		index++;
	    		pre = pre.getNext();
	    	}
	    	post = pre;
	    	while(index != stop)
	    	{
	    		index++;
	    		post = post.getNext();
	    	}
	    	
	    	pre.setNext(post);
	    	post.setPrev(pre);
	    	size = size - (stop-start);
    	}
    	
    }
	
	/**
	 * O(1)
	 * add item to the front of the list.
	 * <br>pre: none
	 * <br>post: size() = old size() + 1, get(0) = item
	 * @param item the data to add to the front of this list
	 */
	public void addFirst(E item){
		if(size == 0)
		{
			DoubleListNode<E> temp = new DoubleListNode<E>(dummy,item,dummy);
			dummy.setNext(temp);
			dummy.setPrev(temp);
		}
		else
		{
			DoubleListNode<E> oldFirst = dummy.getNext();
			DoubleListNode<E> temp = new DoubleListNode<E>(dummy,item,oldFirst);
			dummy.setNext(temp);
			oldFirst.setPrev(temp);
		}
		size++;
	}


	/**
	 * O(1)
	 * add item to the end of the list.
	 * <br>pre: none
	 * <br>post: size() = old size() + 1, get(size() -1) = item
	 * @param item the data to add to the end of this list
	 */
	public void addLast(E item){
		
		// addLast behaves the same as add
		add(item);
	}


	/**
	 * O(1)
	 * remove and return the first element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old first element of this list
	 */
	public E removeFirst(){	
		assert size != 0;
		
		DoubleListNode<E> temp = dummy.getNext();
		DoubleListNode<E> post = temp.getNext();
		temp.setData(null);
		dummy.setNext(post);
		post.setPrev(dummy);
		size--;
		
	    return temp.getData();
	}


	/**
	 * O(1)
	 * remove and return the last element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old last element of this list
	 */
	public E removeLast(){	
		assert size > 0;
		
		DoubleListNode<E> temp = dummy.getPrev();
		DoubleListNode<E> pre = temp.getPrev();
		pre.setNext(dummy);
		temp.setData(null);
		dummy.setPrev(pre);
		size--;
		
	    return temp.getData();
	}


	// O(N)
	// Pre: None
	// Post: Returns a string consisting of the elements of the list
	// Method returns a string of the elements of the list
	public String toString(){	

		String output = "[";
		if(size != 0)
		{
			DoubleListNode<E> temp = dummy.getNext();
			output += temp.getData().toString();
			while(temp.getNext() != dummy)
			{				
				output += ", ";
				temp = temp.getNext();
				output += temp.getData().toString();
				
			}
		}
		output += "]";
	    return output;
	}


	/**
	 * O(N)
	 * check if this list is equal to another Object.
	 * <br>pre: none
	 * @return true if other is a non null LinkedList object
	 * with the same elements as this LinkedList in the same
	 * order.
	 */
	public boolean equals(Object other){
		
		if(other instanceof LinkedList)
		{
			LinkedList<E> otherDLL = (LinkedList<E>) other;
			if(size != otherDLL.size())
				return false;
			else
			{
				boolean result = true;
				DoubleListNode<E> temp1 = dummy.getNext();
				Iterator<E> it = otherDLL.iterator();
				E dataThis;
				E dataOther;
				while(temp1 != dummy)
				{
					dataThis = temp1.getData();
					dataOther = it.next();
					result = result && dataThis.equals(dataOther);
					temp1 = temp1.getNext();
				}
				
				
				return result;
			}
			
		}
		else
			return false;
	}


}
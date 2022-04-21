package lab06;

// creating Node
class Node<T>{
	Object data;
	Node next;
	
	public Node(Object value) {
		data = value;
		next = null;
	}
}

public class ListNode<T> {
	
	Node head;
	int size;
	
	//Constructor 
	public ListNode() {
		head = null;
		size = 0;
	}
	
    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * elements may be added to this list.  In particular, some
     * lists will refuse to add null elements, and others will impose
     * restrictions on the type of elements that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what elements may be added.
     *
     * @param item element to be appended to this list
     * @return {@code true}
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     * @throws IllegalArgumentException      if some property of this element
     *                                       prevents it from being added to this list
     */
    public boolean add(Object item) {
    	if(item == null) {
    		throw new NullPointerException();
    	}
    	
    	if(head == null) {
    		head = new Node(item);
    		
    	}
    	
    	else if(head.next == null) {
    		head.next = new Node(item);
    	
    	}
    	
    	else{
    		Node prev = head;
    		
    		//Goes to the end of the Linked list
	    	for(int i = 0; i < size; i++) {
	    		prev = prev.next;
	    	}
	    	prev.next = new Node(item);
	    	++size;
    	}
    	
    	return true;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).  Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param position   index at which the specified element is to be inserted
     * @param item element to be inserted
     * @throws ClassCastException            if the class of the specified element
     *                                       prevents it from being added to this list
     * @throws NullPointerException          if the specified element is null and
     *                                       this list does not permit null elements
     * @throws IllegalArgumentException      if some property of the specified
     *                                       element prevents it from being added to this list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index > size()})
     */
    public void add(int position, Object item) {
        if(position > size || position < 0) {
        	throw new IndexOutOfBoundsException("Position is not valid");
        }
        
        if(item == null || item == "") {
        	throw new IllegalArgumentException();
        }
        
        if(head == null) {
    		head = new Node(item);
    		++size;
    	}
    	
    	else if(head.next == null) {
    		head.next = new Node(item);
    		++size;
    	}
    	
    	else{
    		Node prev = head;
    		Node next = head.next;
    		 for(int i = 0; i < position; i++) {
    			 prev = prev.next;
    			 next = next.next;
    		 }
    		 
    		 prev.next = new Node(item);
    		 prev.next.next = next;
    		 ++size;
    	}
        
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * {@code Objects.equals(o, e)}.
     *
     * @param item element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     * @throws ClassCastException   if the type of the specified element
     *                              is incompatible with this list
     * @throws NullPointerException if the specified element is null and this
     *                              list does not permit null elements
     */
    public boolean contains(Object item) {
        
    	if(item == null) {
    		throw new NullPointerException();
    	}
    	
    	if(head == null) {
    		return false;
    	}
    	
    	Node prev = head;
    	boolean found = false;
    	
    	for(int i = 0; i < size; i++) {
    		if(prev == new Node(item)) {
    			found = true;
    		}
    		prev = prev.next;
    	}
    	
    	if(!found) {
    		return false;
    	}
    	
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param position index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    public Object get(int position) {
    	if(position > size) {
        	throw new IndexOutOfBoundsException("Position is not valid");
        }
        
        if(position < 0) {
        	throw new IllegalArgumentException();
        }
        
        Node temp = head;
        
        for(int i = 0; i < position + 1; i++) {
        	temp = temp.next;
        }
        
        return temp;
    }

    /**
     * Removes the last element in this list. Returns the element that was removed from the
     * list.
     *
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    public Object removeLast() {
        if(head == null) {
        	return null;
        }
        
        if(head.next == null) {
        	return null;
        }
        
        Node temp = head;
        
        while(temp.next.next != null) {
        	temp = temp.next;
        }
        
        Node last = temp.next;
        temp.next = null;
        --size;
        
        return last.data;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present (optional operation).  If this list does not contain
     * the element, it is unchanged.  More formally, removes the element with
     * the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list changed
     * as a result of the call).
     *
     * @param item element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     * @throws ClassCastException            if the type of the specified element
     *                                       is incompatible with this list
     * @throws NullPointerException          if the specified element is null and this
     *                                       list does not permit null elements
     */
    public boolean remove(Object item) {
    	if(item == null) {
    		throw new NullPointerException();
    	}
    	
    	if(head == null) {
    		return false;
    	}
    	
    	Node temp = head;
    	Node prev = null;
    	
    	if(temp != null && temp.data == item) {
    		temp = temp.next;
    		return true;
    	}
    	
    	while(temp != null && temp.data != item) {
    		prev = temp;
    		temp = temp.next;
    	}
    	
    	if(temp == null) {
    		return false;
    	}
    	
    	prev.next = temp.next;
    	
    	--size;
    	
        return true;
    }

    /**
     * Removes the element at the specified position from the end of the list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the head of the list.
     *
     * @param position the index of the item the end of the list to be removed
     * @return the head of the list
     * @throws IndexOutOfBoundsException     if the index is out of range
     *                                       ({@code index < 0 || index >= size()})
     */
    public Object removeFromEnd(int position){
    	int headPosition = size + 1;
    	
    	if(position > headPosition) {
        	throw new IndexOutOfBoundsException("Position is not valid");
        }
        
        if(position < 0) {
        	throw new IllegalArgumentException();
        }
        
        if(position == 0) {
        	return null;
        }
        
        Node temp = head;
        
        Node second = head;
        
        //When position matches the size of the linked list, removes head
        if(position == headPosition) {
        	Node toR = temp;
        	head = head.next;
        	return toR.data;
        }
        
        // Iterates "position" times to create space in between temp and second 
        for(int i = 0; i < position; i++) {
        	second = second.next;
        }
        
        // Increments until second is at the end of the linked list, temp should be pointing at the Node to be removed
        while(second.next != null) {
        	temp = temp.next;
        	second = second.next;
        }
        
        // Gets node to return before removing it from the linked list
        Node toReturn = temp.next; 
        
        // links the node before the removed node to the node after the removed node
        temp.next = temp.next.next;
        
        --size;
        
        return toReturn.data;
       
    }

    /**
     * Shows ListNode as a String, with each object in parentheses separated by “arrows” (->).
     * A ListNode of {1, 2, 3} should return the String "(1) -> (2) -> (3)".
     * @return String representation of the ListNode
     */
    @Override
    public String toString() {
    	String LLString = "";
    	
    	Node current = head;
    	
    	while(current.next != null) {
    		LLString += current.data + "->";
    		current = current.next;
    	}
    	
    	LLString += current.data;
    	
        return LLString;
    }

    public static void main(String[] args){
    	ListNode list = new ListNode();
    	System.out.println(list.add("Ab"));
    	list.add(0, "Cd");
    	list.add("Ef");
    	list.add("gh");
    	System.out.println(list);
    	System.out.println("Size: " + list.size);
    	//System.out.println(list.removeLast());
    	//list.remove("Ef");
    	System.out.println(list.removeFromEnd(2));
    	System.out.println(list);
    	
    	
        System.out.println("Hello gradle!");
    }

}


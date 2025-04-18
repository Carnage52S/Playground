public class CustomDoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail; // Added tail reference for efficient operations at the end
    private int size;
    
    public CustomDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // Add element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail); // Set new node's prev to current tail
            tail.setNext(newNode); // Set current tail's next to new node
            tail = newNode;        // Update tail to new node
        }
        size++;
    }
    
    // Add element at the beginning of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head); // Set new node's next to current head
            head.setPrev(newNode); // Set current head's prev to new node
            head = newNode;        // Update head to new node
        }
        size++;
    }
    
    // Add element at specified index
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        if (index == size) {
            add(data);
            return;
        }
        
        // Find the node at position index
        Node<T> current = getNodeAt(index);
        
        // Create new node and update references
        Node<T> newNode = new Node<>(data);
        newNode.setNext(current);
        newNode.setPrev(current.getPrev());
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        
        size++;
    }
    
    // Get element at specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        return getNodeAt(index).getData();
    }
    
    // Helper method to get node at specified index
    private Node<T> getNodeAt(int index) {
        Node<T> current;
        
        // Optimize traversal by starting from the closest end
        if (index < size / 2) {
            // Start from head for indices in first half
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            // Start from tail for indices in second half
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
        
        return current;
    }
    
    // Remove element at specified index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        Node<T> nodeToRemove;
        
        if (index == 0) {
            // Remove head
            nodeToRemove = head;
            head = head.getNext();
            if (head == null) {
                tail = null; // List is now empty
            } else {
                head.setPrev(null);
            }
        } else if (index == size - 1) {
            // Remove tail
            nodeToRemove = tail;
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            // Remove from middle
            nodeToRemove = getNodeAt(index);
            nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
            nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
        }
        
        size--;
        return nodeToRemove.getData();
    }
    
    // Get size of the list
    public int size() {
        return size;
    }
    
    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Clear the list
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
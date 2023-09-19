public class LinkedListDeque<T> {
    private Node head;
    private Node tail;
    private int size = 0;
    public class Node {
        private Node prev;
        private T item;
        private Node next;
    }
    public void addFirst(T item) {
        Node p = new Node();
        p.item = item;
        p.next = head.next;
        p.next.prev = p;
        p.prev = head;
        head.next = p;
        size++;

    }
    public void addLast(T item) {
        Node p = new Node();
        p.item = item;
        p.prev = tail.prev;
        p.prev.next = p;
        p.next = tail;
        tail.prev = p;
        size++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque(){
        for(Node p = head;p != tail;p = p.next) {
            System.out.print(p.item+" ");
        }
        System.out.println();
    }
    public T removeFirst() {
        if(isEmpty())
            return null;
        T item = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return item;
    }
    public T removeLast() {
        if(isEmpty())
            return null;
        T item = tail.prev.item;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size--;
        return item;
    }
    public T get(int index) {
        if(index >= size)
            return null;
        Node p = head.next;
        while(index != 0){
            p = p.next;
            index--;
        }
        return p.item;
    }
    public LinkedListDeque(){
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public LinkedListDeque(LinkedListDeque other){
        Node q = other.head.next;
        while(q != tail){
            addLast(q.item);
            q = q.next;
        }
    }
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(head, index);
    }

    private T getRecursiveHelper(Node currentNode, int index) {

        if (index == 0) {
            return currentNode.next.item;
        }


        return getRecursiveHelper(currentNode.next.next, index - 1);
    }

}

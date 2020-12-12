import java.util.*;
public class SequentialSearchST<Key, Value> {
    
    int size;
    Node head;

    public SequentialSearchST() {
        size = 0;
        head = null;
    }
    //node class
    class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }

    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(Key key) {
        if (key == null) {
           
            System.out.println("Key cannot be null");
        }
        else if (get(key)==null){
            return false;
        }
        return true;
        
    }

    public Value get(Key key) {
        for (Node x = head; x!=null; x=x.next) {
                if (x.key == key) {
                    return x.val;
                }
            }
            return null;
    }

    public void put(Key key, Value val) {
        if (key == null) {
             System.out.println("Key cannot be null");
             return;
        }
        Node newest = new Node(key, val, null);

        if (head == null) {
            head = newest;
            size ++;
            
        }
        else if (head.next==null || head.next!=null) {
                for (Node x = head; x!=null; x=x.next) {
                    if (key == x.key) {
                        x.val = val;
                        return;
                    }
                            
                } 
                newest.next = head;
                head = newest;
                size++;       
        }

        
    }

    
    public void delete(Key key) {
         Node x = delete(head, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x==null){
            return null;
        }
        for (x = x; x!=null; x=x.next) {
                if (x.key == key) {
                   x.key = null;
                   size--;
                   return x.next;
                }
            }
        return null;    
    }

    public Iterable<Key> keys()  {
       ArrayList<Key> arr = new ArrayList<Key>();
        for (Node x = head; x!= null; x = x.next) {
            arr.add(x.key);     
        }
        return arr;     
    }    

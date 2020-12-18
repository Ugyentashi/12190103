import java.util.*;

public class BinarySearch<Key extends Comparable<Key>, Value> {
    Node root;

    class Node{
        Key key;
        Value val;
        Node left,right;
        int size;

        public Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    

    public boolean isEmpty() {
        if (size()==0){
            return true;
        }
        return false;
    }

   public int size() {
        return size(root);
    }

   
    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        else {
            return x.size;
        }
    }

  
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key should not be null");
        }

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) {
            return get(x.left, key);
        }
        else if (cmp > 0) {
            return get(x.right, key);
        }
        else {
            return x.val;
        }
    }


    
    public void put(Key key, Value val) {
        root = put(root,key,val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x== null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);

        if (cmp < 0 ){
            x.left = put(x.left,key,val);
            //size++;
        }
        else if (cmp > 0 ){
            x.right = put(x.right,key,val);
            //size++;
        }
        else if (cmp==0){
            x.val=val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

     public Key Min() {
        return Min(root).key;
    } 

    private Node Min(Node x) { 
        if (x.left == null){
            return x;
        }
        return Min(x.left);         
    }

    public Key max() {
        return max(root).key;
    } 

    private Node max(Node x) { 
        if (x.right == null){
            return x;
        }
        return max(x.right);         
    } 
 

   
    public Key floor(Key key) {
        Node x = floor(root,key);
        if (x==null){
            return null;
        }
        return x.key;
    } 

    private Node floor(Node x, Key key) {
        if (x == null){
            return null;
        } 
        int cmp = key.compareTo(x.key);
        if (cmp==0){
            return x;
        }
        if (cmp < 0){
            return floor(x.left,key);
        }
        Node temp = floor(x.right, key);

        if (temp!= null){
            return temp;
        }
        return x;
    }

    

  

    private void keys(Node x, ArrayList<Key> arr, Key lo, Key hi) { 
        if (x == null) return;

        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key);

        if (cmplo < 0) {
            keys(x.left, arr, lo, hi); 
        }
        if (cmplo <= 0 && cmphi >= 0) {
            arr.add(x.key); 
        }
        if (cmphi > 0) {
            keys(x.right, arr, lo, hi); 
        }
    } 


    public static void main(String[] args) {
        BinarySearch<String, Integer> obj = new BinarySearch<String, Integer>();
        obj.put("Ada",1);
        obj.put("Ballerina",3);
        System.out.println(obj.get("Ada"));
        
        obj.put("Html",5);
        obj.put("Java",7);
        System.out.println(obj.get("Java"));
        System.out.println(+obj.size());
        //System.out.println(obj.get(1));
        System.out.println(obj.Min());
        System.out.println(obj.floor("Ballerina"));

        //System.out.println(obj.keys("Ada", "Java"));

        obj.put("Java", 8);
        obj.put("Dart", 9);

        System.out.println(obj.get("Java"));
        System.out.println(+obj.size());
        //System.out.println(obj.keys("Ballerina", "Java"));






       
    }


}
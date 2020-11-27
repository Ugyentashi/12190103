import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
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

    //return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        else {
            return x.size;
        }
    }

    // public boolean contains(Key key) {
       
    // }
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
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

    public Key min() {
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null){
            return x;
        }
        return min(x.left);         
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

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException("first argument to keys() is null");
        }

        if (hi == null) {
            throw new IllegalArgumentException("second argument to keys() is null");
        }

        ArrayList<Key> arr = new ArrayList<Key>();
        for (Node x = root; x == lo; x = x.left) {
            arr.add(x.key);     
        }
        keys(root, arr, lo, hi);
        return arr;
        
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
        Solution<String, Integer> obj = new Solution<String, Integer>();
        obj.put("ABDUL",1);
        System.out.println(obj.get("ABDUL"));
        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        System.out.println(obj.get("SAI"));
        obj.put("TASHI",4);
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));
        System.out.println(obj.keys("ABDUL","TASHI"));
        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        System.out.println(obj.get("SAMAL"));
        obj.put("NIMA",7);
        System.out.println(obj.size());
        System.out.println(obj.get("CHIMI"));
        System.out.println(obj.floor("CHIMI"));
        obj.put("SONAM",8);
        System.out.println(obj.keys("ABDUL","TASHI"));
    }
}



    


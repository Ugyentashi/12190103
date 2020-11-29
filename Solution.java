import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    int size;
    static int nodeCount; //used in select function
    private Node root;
   
    public Solution() {
        size = 0;
        root = null;
    }
    class Node{
        Key key;
        Value val;
        Node left,right;
    
    public Node(Key key, Value val){
            this.key = key;
            this.val = val;
        }
    }

    public boolean isEmpty() {
         if (size() == 0) {
            return true;
        }
        return false;
       
    }

    public int size() {
      return size; 
    }




    public boolean contains(Key key) {
       Node N = root;
       if(key == null){
            throw new IllegalArgumentException("error! no contain() key");
       }
       else{
            while(N.key != key){
                int cmp = key.compareTo(N.key);
                if(cmp < 0){
                    N = N.left;
                }
                else{
                    N = N.right;
                }
            }
            return true;
       }
    }


    public Value get(Key key) {
         Node N = root; 
         while(N.key != key){
            int cmp = key.compareTo(N.key);
            if(cmp < 0){
                N = N.left;
            }
            else if(cmp > 0){
                N = N.right;
            }
        }
        if (N.key == key) {
                    return N.val;
                }
            return null;
    }


    public void put(Key key, Value val) {
        if (key == null){
            System.out.println("Key cannot be null");
            return;
        }

        Node y = new Node(key, val);

        if (root == null){
            root = y;
            size++;
        }
        else{
            Node N = root;
            Node part;
            while (true){
                part = N;
                int cmp = key.compareTo(N.key);
                if (cmp<0){
                    N = N.left;
                    if (N==null){
                        part.left = y;
                        size++;
                        return;
                    }
                    else if(N.key == key){
                        N.val = val;
                        return;
                    }
                }
                else if (cmp>0){
                    N = N.right;
                    if (N==null){
                        part.right = y;
                        size++;
                        return;
                    }
                    else if (N.key == key){
                        N.val = val;
                        return;
                    }
                }
            }
        }
    }


    public Key min() {
        if(isEmpty()){
            throw new NoSuchElementException("isEmpty() exception as no element");
        }
        else{
            Node N = root;
            while(N.left != null){
                N = N.left;
            }
            return N.key;
       }
    }

    public Key max() {
        if(isEmpty()){
            throw new NoSuchElementException("isEmpty() exception as no element");
        }
        else{
            Node N = root;
            while(N.right != null){
                N = N.right;
            }
            return N.key;
       }
    }

    public Key floor(Key key){
        if(isEmpty()){
            throw new NoSuchElementException("empty symbol table");
        }
        Node N = root;
        Node part = null;
        while(N != null){
            part = N;
            int cmp = key.compareTo(part.key);
            if(key == null){
                throw new IllegalArgumentException("null key exception");
            }
            if(cmp == 0){
                return part.key;
            }
            if(cmp < 0){
                N = part.left;
            }
           
            else if(cmp > 0){
                N = part.right;
               
                int comp = key.compareTo(N.key);
                if(comp < 0 ){
                    return part.key;
                }
                
                else{
                    N = part.right;
                } 
            }
        }
        return part.key;
    }


    public Key select(int k) {
        nodeCount=0;
        if ((k<0) || k>=size()) {
            throw new IllegalArgumentException("rank is between 0 and size()");
        }
        return select(root, k+1).key;
    }
    
    // Return key of rank k. 
     private Node select(Node x, int k) {
        Stack<Node> stack = new Stack<Node>();
        Node N = root;
        while (!stack.empty() || N != null)
        {
            if (N != null)
            {
                stack.push(N);
                N = N.left;
            }
            else
            {
                N = stack.pop();
                nodeCount++;
                if(nodeCount == k)
                    break;
                N = N.right;
            }
        }
        return N;
    } 



    


    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException("key is null");
        }

        if (hi == null) {
            throw new IllegalArgumentException("keys is null");
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

        int compl = lo.compareTo(x.key); 
        int compli = hi.compareTo(x.key);

        if (compl < 0) {
            keys(x.left, arr, lo, hi); 
        }
        if (compl <= 0 && compli >= 0) {
            arr.add(x.key); 
        }
        if (compli > 0) {
            keys(x.right, arr, lo, hi); 
        }
    } 
    public static void main(String[] args) {
        Solution <String, Integer> obj = new Solution <String, Integer>();
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
        System.out.println(obj.select(2));
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
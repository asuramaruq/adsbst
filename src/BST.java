import java.util.Iterator;
import java.util.Stack;

public class BST <K extends Comparable<K>,V> implements Iterable<BST.KeyValuePair> {
    public Node root;
    private class Node<K,V> {
        private K key;
        private V val;
        int size;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            size=1;
        }
        public String toString(){
            return "key is "+key+"and value is "+val;
        }
    }
    private Node put(Node<K,V> node, K key, V val){
        if(node==null){
            return new Node<>(key,val);
        }
        int cmp=node.key.compareTo(key);
        if (cmp == 0) {
            return null;
        } else if (cmp > 0) {
            node.left = put(node.left, key, val);
        } else {
            node.right = put(node.right, key, val);
        }
        node.size= (node.right!=null ? node.right.size : 0) + (node.left!=null ? node.left.size:0) + 1;
        return node;
    }
    public void put(K key, V val){
        root=put(root,key,val);
    }

    public V get(K key){
        Node<K,V> temp=get(key,root);
        return temp.val;
    }
    private Node get(K key, Node<K,V> node){
        int cmp=node.key.compareTo(key);
        if(cmp==0){
            return node;
        }else if(cmp>0){
            return get(key,node.left);
        }else{
            return get(key,node.right);
        }
    }

    public void delete(K key){
        root=delete(root,key);
    }
    private Node delete(Node<K,V> node,K key){
        if(node==null){
            return node;
        }
        int cmp=node.key.compareTo(key);
        if(cmp==0){
            if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            Node<K,V> minNode=getMin(node.right);
            node.key=minNode.key;
            node.val=minNode.val;
            node.right=delete(node.right,minNode.key);
        } else if(cmp>0){
            node.left=delete(node.left,key);
        }else{
            node.right=delete(node.right,key);
        }
        node.size=(node.right!=null ? node.right.size : 0) + (node.left!=null ? node.left.size:0) + 1;
        return node;
    }
    private Node getMin(Node node){
        if(node.left!=null){
            return getMin(node.left);
        }
        return node;
    }

    public void inOrderTraversal(Node<K,V> node){
        if(node!=null){
            inOrderTraversal(node.left);
            System.out.println(node.toString());
            inOrderTraversal(node.right);
        }
    }
    //add size
    public int size(){
        return root.size;
    }
    //access both key and value during iteration

    public Iterator<BST.KeyValuePair> iterator(){
        return new MyBSTIterator(root);
    }
    private class MyBSTIterator implements Iterator<BST.KeyValuePair>{
        private Stack<KeyValuePair> st;
        public MyBSTIterator(Node<K,V> root){
            st=new Stack<>();
            inOrderTraversal(root);
        }
        @Override
        public boolean hasNext(){
            return !st.empty();
        }
        @Override
        public KeyValuePair next(){
            return st.pop();
        }
        public void inOrderTraversal(Node<K,V> node){
            if(node!=null){
                inOrderTraversal(node.right);
                st.push(new KeyValuePair(node.key,node.val));
                inOrderTraversal(node.left);
            }
            return;
        }
    }
    public class KeyValuePair{
        private K key;
        private V val;
        public KeyValuePair(K key, V val){
            this.key=key;
            this.val=val;
        }
        public K getKey(){
            return key;
        }
        public V getVal(){
            return val;
        }
        @Override
        public String toString(){
            return "key is '"+key+"' and value is '"+val+"'";
        }
    }

}

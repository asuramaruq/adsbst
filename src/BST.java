public class BST <K extends Comparable<K>,V> {
    private Node root;
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
    }
    private Node<K,V> put(Node<K,V> node, K key, V val){
        if(node==null){
            return new Node<>(key,val);
        }
        int cmp=node.key.compareTo(key);
        if (cmp == 0) {
            return null;
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.left = put(node.left, key, val);
        }
        node.size= (node.right!=null ? node.right.size : 0) + (node.left!=null ? node.left.size:0) + 1;
        return node;
    }
    public void put(K key, V val){
        root=put(root,key,val);
    }
    public V get(K key){
        
    }
    public void delete(K key){

    }
    public Iterable<K> iterator(){
        //in order traversal
    }
    //add size
    //access both key and value during iteration
}

public class Main {
    public static void main(String[] args) {
        BST<Integer,String> tree=new BST<Integer,String>();
        tree.put(50,"is");
        tree.put(25,"name");
        tree.put(75,"Olzhas");
        tree.put(5,"Hello");
        tree.put(15,"my");
        for(var elem : tree){
            System.out.printf(elem.toString());
            System.out.println();
        }
        System.out.println("-------------");
        tree.delete(25);
        for(var elem : tree){
            System.out.printf(elem.toString());
            System.out.println();
        }
        System.out.println("-------------");
        System.out.println(tree.get(5).toString());
        System.out.println("-------------");
        System.out.println(tree.size());
    }
}
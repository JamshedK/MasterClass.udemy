package masterclass.udemy;

public class Main {

    public static void main(String[] args) {

//        NewLinkedList newLinkedList = new NewLinkedList();
//        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Adelaide";
//        String[] data = stringData.split(" ");
//        for(int i = 0; i < data.length; i++){
//            newLinkedList.add(data[i]);
//        }
//        newLinkedList.traverse();
//        newLinkedList.remove("Darwin");
//        newLinkedList.remove("Adelaide");
//        newLinkedList.remove("Sydney");
//        newLinkedList.traverse();

        BinarySearchTree tree = new BinarySearchTree(null);
        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Nigeria";
        String[] data = stringData.split(" ");
        for(int i = 0; i < data.length; i++){
            tree.add(data[i]);
        }
        System.out.println("List before deletion");
        tree.traverse(tree.getRoot());
        System.out.println("List after deletion");
        tree.remove("Darwin");
        tree.traverse(tree.getRoot());
    }
}

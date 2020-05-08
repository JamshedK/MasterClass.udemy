package masterclass.udemy;


public class BinarySearchTree implements NodeList {
    Node root = null;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    @Override
    public void add(String item) {
        Node newNode = new Node(item);
        if (root == null){
            this.root = newNode;
            System.out.println("Item " + item + " added as the root of the tree");
            return;
        }
        Node currentNode = root;
        while (currentNode != null) {
            int comparison = currentNode.myCompareTo(item);
            if (comparison < 0) {
                if (currentNode.next() != null) {
                    currentNode = (Node) currentNode.next();
                }
                else{
                    currentNode.setNext(newNode);
                    return;
                }
            }
            else if (comparison > 0){
                if(currentNode.previous() != null){
                    currentNode = (Node) currentNode.previous();
                }
                else{
                    currentNode.setPrevious(newNode);
                    return;
                }
            }
            else{
                System.out.println("Item " + item + " already exists");
                return;
            }
        }
    }

    @Override
    public void remove(String item) {

        Node nodeToBeRemoved = new Node(item);

        // if the node to be removed is the root
        // traverse to rightest node and set it as the new root
        if (item.equalsIgnoreCase(root.getStringValue()) ) {
            // but there is an exception if the root doesn't have a right node
            if(root.next() == null){
                root = (Node) root.previous();
                return;
            }
            //otherwise, traverse to the smallest node in left tree starting from root.next and set it as the new root,
            Node currentNode = (Node) root.next();
            Node previousNode = root;
            while (currentNode != null){
                // once you found it, set it as the new root
                if(currentNode.previous() == null){
                    currentNode.setNext(root.next());
                    currentNode.setPrevious(root.previous());
                    root = currentNode;
//                    previousNode.setPrevious(null);
                    System.out.println("next node " + previousNode.next().getStringValue());
                    // and if it has a right child node,
                    if(currentNode.next()!=null){
                        Node rightChildNode = (Node) currentNode.next();
                        currentNode.setNext(null);
                        add(rightChildNode.getStringValue());
                    }
                    return;
                }
                previousNode = currentNode;
                currentNode = (Node) currentNode.previous();
                }
            }
        System.out.println();

        Node currentNode = root;

        while (currentNode != null) {

            // if the node to be removed is a node with no children
            if (currentNode.next() == null && currentNode.previous() == null) {
                // then remove the
            }
            // if the node to be removed has a children, either right or left
        }
    }

    @Override
    public void traverse(Node root) {
        // recursive method
        if(root != null){
            traverse((Node) root.previous());
            System.out.println(root.getStringValue());
            traverse((Node) root.next());
        }
    }

    public Node getRoot() {
        return root;
    }
}

package masterclass.udemy;

public class NewLinkedList  {
    Node head = null;

    public void add(String item) {
        Node newNode = new Node(item);

        // if there is no item in the list, link head to the newNode
        if (head == null) {
            head = newNode;
            traverse();
            return;
        }

            // create a new node that links to the head and then traverse through the whole list by using currentNode.next()
            Node currentNode = head;

            while (currentNode != null) {
                int comparison = currentNode.myCompareTo(item);

                if (comparison < 0) {
                    // if we are not at the end of the list, then move on
                    if (currentNode.next() != null) {
                        currentNode = (Node) currentNode.next();
                    }
                    // if we are at the end of the list, the insert newNode at the end of the list
                    else {
                        currentNode.setNext(newNode);
                        newNode.setPrevious(currentNode);
                        System.out.println("Item " + newNode.getStringValue() + " inserted at the end of the list");
                        return;
                    }
                }
                // If the String is larger than the current value, place it before the current value
                else if ( comparison > 0) {
                    // if the insertion is at the beginning of the list
                    if(currentNode.previous() == null){
                        head = newNode;
                        newNode.setNext(currentNode);
                        currentNode.setPrevious(newNode);
                        System.out.println("Item " +  newNode.getStringValue() + " inserted at the head of the list");
                        return;
                    }
                    // otherwise
                    // set the previous item's "next" to newNode, and newNode's "next" to currentItem
                    else{
                        currentNode.previous().setNext(newNode);
                        newNode.setPrevious(currentNode.previous());
                        newNode.setNext(currentNode);
                        currentNode.setPrevious(newNode);
                        System.out.println("Item " + newNode.getStringValue() + " inserted in the middle of the list");
                        return;
                    }

                } else {
                    System.out.println("The Item is duplicated");
                    return;
                }
            }
    }

    public void traverse(){
        System.out.println("Here are the list of the items in the list: ");
        Node currentNode = head;
        while (currentNode != null){
            System.out.println("\t" + currentNode.getStringValue());
            currentNode = (Node) currentNode.next();
        }
    }

    public void remove(String item){
        Node currentNode = head;
        while (currentNode != null){
            // if the item exists, then remove it from the list
            int comparison = currentNode.myCompareTo(item);
            if(comparison == 0){
                if(item.equalsIgnoreCase(head.getStringValue())){
                    head = (Node) currentNode.next();
                }
                else{
                    currentNode.previous().setNext(currentNode.next());
                    if (currentNode.next() != null) {
                        currentNode.next().setPrevious(currentNode.previous());
                    }
                    System.out.println("Item " + currentNode.getStringValue() + " has been removed");
                }
                return;
            }
            else if(comparison < 0){
                currentNode = (Node) currentNode.next();
            }
            else{ // greater than 0
                // As the list is ordered alphabetically, we have passed the point where we could have deleted
                System.out.println("The item does not exist");
                return;
            }
        }

    }

}

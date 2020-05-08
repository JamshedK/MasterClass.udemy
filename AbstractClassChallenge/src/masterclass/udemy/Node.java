package masterclass.udemy;

import masterclass.udemy.ListItem;

//inner class
public class Node extends ListItem {

    public Node(String stringValue) {
        super(stringValue);
    }

    @Override
    protected ListItem next() {
        return this.rightLink;
    }

    @Override
    protected void setNext(ListItem listItem) {
        this.rightLink = listItem;
    }

    @Override
    public ListItem previous() {
        return this.leftLink;
    }

    @Override
    void setPrevious(ListItem listItem) {
        this.leftLink = listItem;
    }

    @Override
    int myCompareTo(String item) {
        return this.stringValue.compareTo(item);
    }

}
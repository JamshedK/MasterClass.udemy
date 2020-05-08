package masterclass.udemy;

public abstract class ListItem {
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;
    protected String stringValue;

    public ListItem( String stringValue) {
        this.stringValue = stringValue;
    }

     abstract ListItem next();
     abstract void setNext(ListItem listItem);
     abstract ListItem previous();
     abstract void setPrevious(ListItem listItem);
     abstract int myCompareTo(String item);

    public String getStringValue() {
        return stringValue;
    }
}

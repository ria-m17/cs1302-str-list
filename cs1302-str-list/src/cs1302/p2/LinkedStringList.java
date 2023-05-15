package cs1302.p2;

import cs1302.adt.Node;
import cs1302.adt.StringList;


/**
 * This class is the Linked List implementation of a string list.
 */

public class LinkedStringList extends BaseStringList {

    // node takes (item: String, next: Node)
    private Node head;

    /**
     * This is the constructor for the class which sets the head node to null.
     */
    public LinkedStringList() {
        super();
        head = null;
    } // LinkedStringList

    /**
     * Method that adds a node to the specified index with the contents of the item.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        // checking for exceptions
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Add: invalid index");
        } // if
        if (item.equals("")) {
            throw new IllegalArgumentException("Item cannot be empty");
        }
        if (item == null) {
            throw new NullPointerException("Item cannot be null");
        }
        if (index == 0) {
            head = new Node(item,head);
            super.size++;
            return true;
        }
        Node initial = head;
        for (int l = 0; l < index - 1; l++) {
            initial = initial.getNext();
        }
        Node later = head;
        for (int l = 0; l < index; l++) {
            later = later.getNext();
        }
        initial.setNext(new Node(item, later));
        size++;
        return true;
    }


    /**
     * Method that clears the contents of the array by setting the head to null.
     * Also sets the size to 0.
     */
    @Override
    public void clear() {
        // setting the head to null and size to 0.
        head = null;
        size = 0;
    } // clear

    /**
     * Method that gets the item of a node at a specified index.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        // checking for exceptions
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Get: Index Out of Bounds");
        }
        // making temp variables and nodes.
        String getTemp;
        Node getTempNode = head;
        // traversing the node to the desired index.
        for (int l = 0; l < index; l++) {
            getTempNode = getTempNode.getNext();
        }
        // returning the value at that index.
        getTemp = getTempNode.getItem();
        return getTemp;
    } // get

    /**
     * Method that removes a node at a specified index.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        // checking for exceptions
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Remove: Index Out of Bounds");
        }
        // making temp variables and nodes.
        String getTemp = get(index);
        Node removeNodeAtIndex = head;
        // if the index is 0 it will just return that node and remove it.
        if (index == 0) {
            head = removeNodeAtIndex.getNext();
        } else {
            // traversing the nodes
            for (int l = 0; l < index - 1; l++) {
                removeNodeAtIndex = removeNodeAtIndex.getNext();
            }
            // setting the nodes appropriately.
            removeNodeAtIndex.setNext(removeNodeAtIndex.getNext().getNext());

        }
        // decrementing size and returning the string that was removed.
        size--;
        return getTemp;
    } // remove



    /**
     * Method that will return a new stringlist with all the items from start to stop.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        // checking for exceptions
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Slice: Index Out of Bounds");
        } // if
        // creating a new LinkedString list object
        BaseStringList slicedArea = new LinkedStringList();
        int r = 0;
        // for loop to return the array with the required elements.
        for (int l = start; l < stop; l++) {
            String sliceTemp = get(l);
            slicedArea.add(r, sliceTemp);
            r++;
        }
        // returning the sliced portion
        return slicedArea;
    } // slice

    /**
     * Method that returns all the strings in the list in reverse order.
     * <p>
     * {@inheritDoc}
     */

    @Override
    public StringList reverse() {
        StringList listdemo = new LinkedStringList();
        int r = 0;
        for (int l = size() - 1; l >= 0; l--) {
            listdemo.add(r, get(l));
            r++;
        }
        return listdemo;
    } //reverse

} // LinkedStringList

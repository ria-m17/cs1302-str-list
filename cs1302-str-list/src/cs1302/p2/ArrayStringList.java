package cs1302.p2;

import cs1302.adt.StringList;

/**
 * This class represents the ArrayList implementation of a string list.
 */

public class ArrayStringList extends BaseStringList {

    //initializes the instance variables needed for this class
    private String[] items;

    /**
     * This is the constructor for the class which creates a String array with 10 empty items.
     */
    public ArrayStringList() {
        super();
        items = new String[100];
    } // ArrayStringList


    /**
     * Adds an item to the specified index of the array.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        // this method returns true if the value was successfully added
        // checking for exceptions

        if (item.equals("")) {
            throw new IllegalArgumentException("Add: Item cannot be empty");
        } else if (item == null) {
            throw new NullPointerException("Add: Item cannot be null");
        } else if (index < 0 || index > items.length) {
            throw new IndexOutOfBoundsException("Add: Index is out of bounds");
        } else {
            String[] list_demo = new String[items.length + 1];

            if (index > 0) {
                for (int l = 0; l < index; l++) {
                    list_demo[l] = items[l];
                } // for
            } // if

            if (index < items.length) {
                if (items[index] == null) {
                    items[index] = item;
                    size++;
                    return true;
                } // if
            } // outer if

            list_demo[index] = item;
            if (index < items.length) {
                for (int l = index + 1; l < list_demo.length; l++) {
                    list_demo[l] = items[l - 1];
                } // for
            } // if

            items = list_demo;
            size++;
            return true;

        } // else
    } // add


    /**
     * Sets all the items in the array to null and sets the size to 0.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        //looping through each index
        for (int l = 0; l < items.length - 1; l++) {
            //setting all indexes to null
            items[l] = null;
            // changing the size to 0.
            this.size = 0;
        } // for
    } // clear

    /**
     * Gets the item of the specified index of the array.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        return items[index];
    } // get

    /**
     * Removes the item of the specified index of the array.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        //checking for exceptions
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Remove: Index is out of bounds");
        }
        //making a temp variable
        String temp = get(index);
        //looping through the array
        for (int l = index; l < items.length - 1; l++) {
            items[l] = items[l + 1];
        }
        //decrementing the size and returning the string that was removed.
        size--;
        return temp;
    } // remove

    /**
     * Method that returns the string list with all the items from the start to stop index.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        // creating a new ArrayStringList object
        BaseStringList slicedArea = new ArrayStringList();
         // checking for exceptions
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Slice: Index is out of bounds");
        } // if

        // returning the new list with the required elements.
        if (start == stop) {
            slicedArea.makeString("[", ", ", "]");
        } else if (start != stop) {
            int r = 0;
            for (int l = start; l < stop; l++) {
                slicedArea.add(r,this.get(l));
                r++;
            } // for
        } // if
        return slicedArea;
    } // slice

    /**
     * Method that returns the string list with all the items in reverse order.
     * <p>
     * {@inheritDoc}
     */

    @Override
    public StringList reverse() {
        StringList listdemo = new ArrayStringList();
        int r = 0;
        for (int l = size() - 1; l >= 0; l--) {
            listdemo.add(r,items[l]);
            r++;
        }
        return listdemo;
    } //reverse

} // ArrayStringList

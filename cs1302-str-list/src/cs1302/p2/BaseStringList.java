package cs1302.p2;

import cs1302.adt.StringList;


/**
 * This class represents a base string list which is an implementation of the stringlist class.
 */
public abstract class BaseStringList implements StringList {



    //Initializes the insance variables
    protected int size;

    /**
     * This is the constructor for the class which sets the size instance variable to 0.
     */
    public BaseStringList() {
        // set the size to 0.
        size = 0;
    } // BaseStringList


    /**
     * Method that checks if the size is 0.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        boolean temp = false;
        //checks if the size is 0.
        if (size() == 0) {
            temp = true;
        }
        return temp;
    } // isEmpty

    /**
     * Method that returns the string starting with the start string, seperated by the sep string
     * and ending with the end string.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String makeStringTemp = start;
        //if it is empty then it will return an empty list.
        if (isEmpty() == true) {
            makeStringTemp = start + end;
        } else {
            // creating the correct string based on the index.
            for (int l = 0; l < size() - 1; l++) {
                makeStringTemp = makeStringTemp + this.get(l) + sep;
            }
            makeStringTemp = makeStringTemp + this.get(size() - 1) + end;
        }
        //returning the string.
        return makeStringTemp;
    } // makeString

    /**
     * Adds items at a certain index to the array.
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, StringList itemList) {
        if (itemList == null) {
            throw new NullPointerException("itemList cannot be null. ");
        } else if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds. ");
        } else if (itemList.isEmpty()) {
            return false;
            // creates a copy of the entire list, then iterates to add the item after the index
        } else {
            StringList list = itemList.slice(0, itemList.size());
            for (int l = 0; l < list.size() ; l++) {
                add(index + l, list.get(l));
            } // for
            return true;
        } //else
    } // add


    /**
     * Method that checks if the item at the specified index matches the target string.
     * <p>
     * {@inheritDoc}
     */
    public boolean contains(int start, String target) {
        if (start >= 0) {
            for (int l = start; l < this.size; l++) {
                if (this.get(l).equals(target)) {
                    return true;
                } //if
            } // for
            return false;
        } else {
            return true;
        } // else
    } // contains

    /**
     * Method that returns the size.
     *
     *<p>
     *{@inheritDoc}
     */
    @Override
    public int size() {
        //return the size of the object.
        return size;
    } // size

    /**
     *Method that returns the string with the specified contents.
     *
     *<p>
     *{@inheritDoc}
     */
    @Override
    public String toString() {
        // call the make string method.
        return makeString("[", ", ", "]");
    } // toString

} // BaseStringList

package com.kenfogel.interfacetest;

/**
 * This class implements the Pencil interface
 *
 * @author Ken Fogel
 */
public class WritingTool implements Pencil {

    /**
     * Method that must be overriden
     */
    @Override
    public void write1() {
        System.out.printf("standard interface%n");
    }

    /**
     * Method that must be overriden
     */
    @Override
    public void perform() {
        write1();
        write2();
        Pencil.write3();
    }

    /**
     * A method unique to this class
     */
    public void write5() {
        System.out.printf("Method only in WritingTool");
    }

    /**
     * Here we instantiate the WritingTool class and assign the reference to an
     * Interface reference. This means that only methods in the interface can be
     * called. The method unique to this class, write5 cannot be executed using
     * Pencil.
     *
     * @param args
     */
    public static void main(String[] args) {
        Pencil tool = new WritingTool();
        tool.perform();
        //tool.write5(); // Error as write5 is not defined in the interface
    }

}

package com.kenfogel.interfaceinheritance;

/**
 * Here we have a class that extends and implements
 *
 * @author Ken Fogel
 */
public class InterfaceInheritance extends AbstractClass implements IFace {

    private Employee worker;
    public InterfaceInheritance() {
        worker = new Employee("Bob", 43233.54);
    }

    @Override
    public void theMethod() {
        System.out.printf("theMethod%n");
    }

    @Override
    public void oneMethod() {
        System.out.printf("oneMethod%n");
    }
    
    /**
     * Exercising the methods
     */
    public void perform() {
        System.out.printf("%s %.2f%n", worker.name(), worker.salary());
        theMethod();
        oneMethod();
        
    }
    
    /**
     * Where it all begins
     * @param args 
     */
    public static void main(String[] args) {
        new InterfaceInheritance().perform();
    }

}

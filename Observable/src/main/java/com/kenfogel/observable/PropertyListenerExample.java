package com.kenfogel.observable;

/**
 * This class instantiates the observable and observer and connects them
 *
 * @author Ken Fogel
 */
public class PropertyListenerExample {

    public void perform() {
        var observable = new TheProperty();
        var observer = new TheListener();

        observable.addPropertyChangeListener(observer);
        observable.setObservedValue("moose");
        System.out.printf("PLE: New value in observer is %s%n", observable.getObservedValue());
    }

    public static void main(String[] args) {
        new PropertyListenerExample().perform();
    }
}

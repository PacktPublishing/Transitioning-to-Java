package com.kenfogel.observable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * An observable property is usually though not always found in a data class.
 * This way should a field have its value changed then other objects can be
 * notified.
 *
 * @author Ken Fogel
 */
public class TheProperty {

    private String observedValue = "unicorn";

    // This class is used to manage a listener object
    private final PropertyChangeSupport support;

    /**
     * Instantiate the PropertyChangeSupport
     */
    public TheProperty() {
        support = new PropertyChangeSupport(this);
    }

    /**
     * Assign a listener object that will be notified if the observed value
     * changes
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Allows you to remove the listener
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    /**
     * The setter for the observed value where we can notify all listeners.
     * Multiple listeners are allowed.
     *
     * @param value
     */
    public void setObservedValue(String value) {
        System.out.printf("TP: observedValue has changed.%n");
        support.firePropertyChange("observedValue", this.observedValue, value);
        observedValue = value;
    }

    /**
     * Plain getter
     *
     * @return
     */
    public String getObservedValue() {
        return observedValue;
    }
}

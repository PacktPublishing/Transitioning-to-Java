package com.kenfogel.observable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The Listener class whose propertyChange method is called whenever a change is
 * made in the TheProperty object.
 *
 * @author Ken Fogel
 */
public class TheListener implements PropertyChangeListener {

    private String updatedValue;

    /**
     * Called when a change occurs in objects this class is listening to
     *
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.printf("TL: The state has changed.%n");
        System.out.printf("TL: Observed field: %s%n", evt.getPropertyName());
        System.out.printf("TL: Previous value: %s%n", evt.getOldValue());
        System.out.printf("TL: New value: %s%n", evt.getNewValue());
        setUpdatedValue((String) evt.getNewValue());
    }

    /**
     * Just a getter to return the updated value
     * @return 
     */
    public String getUpdatedValue() {
        return updatedValue;
    }

    public void setUpdatedValue(String updatedValue) {
        this.updatedValue = updatedValue;
    }

}

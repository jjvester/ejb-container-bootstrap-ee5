package org.jjvester.ejb.container.bootstrap.ee5.stateless;

import javax.ejb.Local;

/**
 * The Interface Greeting.
 */
@Local
public interface Greeting {

    /**
     * Greet.<br>
     * Greet the given {@code name}
     * 
     * @param name
     *            the {@code name} of the person to greet.
     * @return the greeting.
     */
    String greet(String name);
}

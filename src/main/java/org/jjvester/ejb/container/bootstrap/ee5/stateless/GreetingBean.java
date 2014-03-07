package org.jjvester.ejb.container.bootstrap.ee5.stateless;

import javax.ejb.Stateless;

/**
 * The Class GreetingBean.
 */
@Stateless
public class GreetingBean implements Greeting {

    /**
     * {@inheritDoc}
     */
    @Override
    public String greet(final String name) {
        return "Hello " + name;
    }
}

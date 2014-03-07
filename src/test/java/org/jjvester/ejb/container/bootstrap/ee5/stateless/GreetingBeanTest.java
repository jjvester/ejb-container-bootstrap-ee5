package org.jjvester.ejb.container.bootstrap.ee5.stateless;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The Class GreetingBeanTest.
 */
public class GreetingBeanTest {

    private static final String CALCULATOR_JNDI_NAME = "GreetingBeanLocal";
    private static InitialContext INTIALCONTEXT;

    private Greeting greeting;

    /**
     * Bootstraps the openejb container.
     * 
     * @throws Exception
     *             if the container could not boot.
     */
    @BeforeClass
    public static void init() throws Exception {
        final Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");
        properties.put("openejb.deployments.classpath.include", ".*");

        INTIALCONTEXT = new InitialContext(properties);
    }

    /**
     * Sets up the context and looks up the {@link Greeting} EJB.
     * 
     * @throws NamingException
     *             if the Greeting EJB could not be found.
     */
    @Before
    public void setUp() throws NamingException {
        Object object = INTIALCONTEXT.lookup(CALCULATOR_JNDI_NAME);
        this.greeting = (Greeting) object;
    }

    @Test
    public void testGreet() {
        assertEquals("Invalid greeting", "Hello JJ", this.greeting.greet("JJ"));
    }
}

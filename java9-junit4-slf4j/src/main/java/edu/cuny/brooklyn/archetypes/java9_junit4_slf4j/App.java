package edu.cuny.brooklyn.archetypes.java9_junit4_slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
	private final static Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		LOGGER.info("Hello World!");
	}
}

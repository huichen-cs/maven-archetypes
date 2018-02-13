#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

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

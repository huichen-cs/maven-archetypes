#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
${symbol_pound}set( ${symbol_dollar}symbol_pound = '${symbol_pound}' )
${symbol_pound}set( ${symbol_dollar}symbol_dollar = '${symbol_dollar}' )
${symbol_pound}set( ${symbol_dollar}symbol_escape = '${symbol_escape}' )
package ${symbol_dollar}{package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Hello world!!
 *
 * In Eclipse IDE, suggest to install the e(fx)clilpse plugin
 */
public class App extends Application {
	private final static Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() {
		LOGGER.info("Launching the app ...");		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button = new Button("Say ${symbol_dollar}{symbol_escape}"Hello World!${symbol_dollar}{symbol_escape}"");
		button.setOnAction(e -> System.out.println("Hello, World!"));

		Group group = new Group();
		group.getChildren().add(button);
		Scene scene = new Scene(group, 800, 600);
		
		primaryStage.setTitle("Hello, World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void stop() {
		LOGGER.info("Exiting the app...");
	}
}

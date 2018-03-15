package edu.cuny.brooklyn.archetypes;

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
		Button button = new Button("Say \"Hello World!\"");
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

package application;
	
import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class intern extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new
FXMLLoader(getClass().getResource("app_layout.fxml"));
        Pane rootNode = loader.load();
        MenuBar menubar=createMenu();
        rootNode.getChildren().add(0,menubar);
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World");
        primaryStage.show();
	}
	private MenuBar createMenu() {
		Menu filemenu=new Menu("File");
		Menu helpmenu=new Menu("Help");
		MenuItem about=new MenuItem("about");
		helpmenu.getItems().addAll(about);
		about.setOnAction(event->aboutApp());
		MenuItem m=new MenuItem("New");
		MenuItem n=new MenuItem("Quit");
		m.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("New menu Item clicked");
			}
		});
		n.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		SeparatorMenuItem s=new SeparatorMenuItem();
		filemenu.getItems().addAll(m,s,n);
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(filemenu,helpmenu);
		return menuBar;
		
	}
	public static void aboutApp() {
		Alert alertDialog=new Alert(Alert.AlertType.ERROR);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("learning JavaFx");
		alertDialog.setContentText("I am just a beginner but soon I will be pro");
		//alertDialog.show();
		ButtonType b=new ButtonType("Yes");
		ButtonType b1=new ButtonType("No");
		alertDialog.getButtonTypes().setAll(b,b1);
		Optional<ButtonType> c=alertDialog.showAndWait();
		if(c.get()==b) {
			System.out.println("yes button");
			
		}
		if(c.get()==b1) {
			System.out.println("no button");
		}
	}
	
	
}

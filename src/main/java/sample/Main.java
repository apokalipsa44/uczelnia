package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {


    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
//        primaryStage.setTitle("JavaFX Built-in Layout Panes Example");
//
//        primaryStage.setScene(new Scene(root, 800, 600));
//        primaryStage.show();
//    }

    public void start(Stage stage) throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(MainWindowController.class.getClassLoader().getResource("sample/MainWindow.fxml"));
        loader.setLocation(getClass().getClassLoader().getResource("sample/MainWindow.fxml"));
        Scene scene=new Scene(loader.load(),1000,600);
        stage.setScene(scene);
        stage.setTitle("Program Trubo Uczelnia");

        stage.show();

        stage.setOnCloseRequest(event -> MainWindowController.closeProgram());
        DbManager.initDatabase();

    }

    public static void main(String args[]){
        launch(args);
    }
}


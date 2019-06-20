package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {




    public void start(Stage stage) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/MainWindow.fxml"));
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


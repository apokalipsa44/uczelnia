package sample;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class Main extends Application {

    public static Dao<Student,Integer> daoStudents;


    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/MainWindow.fxml"));
        Scene scene=new Scene(loader.load(),1000,600);
        stage.setScene(scene);
        stage.setTitle("Program Trubo Uczelnia");

        stage.show();

        stage.setOnCloseRequest(event -> MainWindowController.closeProgram());
        DbManager.initDatabase();
        daoStudents = DaoManager.createDao(DbManager.connectionSource, Student.class);
Student student=new Student();
        StudentDao studentDao=new StudentDao(DbManager.getConnectionSource());
        studentDao.createOrUpdate(Student.class, student);

    }

    public static void main(String args[]){
        launch(args);
    }
}


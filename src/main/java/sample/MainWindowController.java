package sample;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> indexColumn, semesterColumn;
    @FXML
    private TableColumn<Student, String> nameColumn, lastnameColumn;
    @FXML
    private Label pickedStudentLabel, pickedStudentLabel1, isPayedLabel;
    @FXML
    private TextField newStudentName, newStudentLastname, newStudentSemester, newStudentIndex;
    @FXML
    private CheckBox hasPayed, paymentSelection;


    public ObservableList studentsToTable() {
        ObservableList<Student> studentsList = FXCollections.observableArrayList();
        studentsList.add(new Student("Szczepan", "Charasimowicz", 14792, true, 5));
        studentsList.add(new Student("Kuba", "Kubuś", 64258, true, 2));
        studentsList.add(new Student("Micha", "Lamborgini", 11144, true, 2));
        studentsList.add(new Student("Kierowca", "Autobusa", 23548, true, 4));
        studentsList.add(new Student("Marcin", "Dobuzibierski", 23458, false, 5));
        studentsList.add(new Student("Brajanek", "Jackson", 19792, true, 3));
        studentsList.add(new Student("Allah", "Akbar", 33658, true, 1));

        return studentsList;
    }

    public Student pickAStudent() {
        studentTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() > 0) {
                    if (studentTable.getSelectionModel().getSelectedIndex() >= 0) {
                        pickedStudentLabel.setText(studentTable.getSelectionModel().getSelectedItem().toString());
                        pickedStudentLabel1.setText(studentTable.getSelectionModel().getSelectedItem().toString());
                        paymentSelection.setSelected(false);

                        if (studentTable.getSelectionModel().getSelectedItem().isHasPayed()) {
                            isPayedLabel.setText("Czesne opłacone");


                        } else if (studentTable.getSelectionModel().getSelectedItem().isHasPayed() != true) {
                            isPayedLabel.setText("Czesne nieopłacone.");


                        }
                }
            }
        }
    });
    return studentTable.getSelectionModel().getSelectedItem();
}

    public void addStudent() {
        Student student = new Student(newStudentName.getText(), newStudentLastname.getText(),
                Integer.parseInt(newStudentIndex.getText()), hasPayed.isSelected(), Integer.parseInt(newStudentSemester.getText()));
        studentTable.getItems().add(student);
    }

    public void removeStudent() {
        studentTable.getItems().remove(studentTable.getSelectionModel().getSelectedIndex());
        pickedStudentLabel1.setText("Student został usunięty.");
    }
    public void studentPayment(){
        paymentSelection.setSelected(false);
        paymentSelection.selectedProperty().addListener(new ChangeListener<Boolean>(){

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue){
                    if (pickAStudent().isHasPayed()==false){
                        pickAStudent().setHasPayed(true);
                        isPayedLabel.setText("Czesne zostało opłacone.");
                    }

                }
            }
            });



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("lastname"));
        indexColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("indexNumber"));
        semesterColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("semster"));
        studentTable.setItems(studentsToTable());
        pickAStudent();
        studentPayment();

    }

    public static void closeProgram() {
        Platform.exit();
        System.exit(0);
    }

}

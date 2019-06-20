package sample;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class TopMenu {
    public static MenuBar menuBar(){
        MenuBar menuBar=new MenuBar();
        Menu menuFile=new Menu("Plik");
        Menu menuEdit=new Menu("Edycja");
        Menu menuView=new Menu("Widok");

        MenuItem close=new MenuItem("Zamknij");
        MenuItem save=new MenuItem("zapisz");
        MenuItem undo=new MenuItem("Cofnij");
        MenuItem redo=new MenuItem("Ponów");
        MenuItem sizeUp=new MenuItem("Powiększ");
        MenuItem sizeDown=new MenuItem("Pomniejsz");

        menuBar.getMenus().add(menuFile);
        menuBar.getMenus().add(menuEdit);
        menuBar.getMenus().add(menuView);

        menuFile.getItems().add(save);
        menuFile.getItems().add(close);
        menuEdit.getItems().add(undo);
        menuEdit.getItems().add(redo);
        menuView.getItems().add(sizeDown);
        menuView.getItems().add(sizeUp);







        return menuBar;
    }

}

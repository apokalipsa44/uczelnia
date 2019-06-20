package sample;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {

    private static String databaseUrl = "jdbc:sqlite:students.db";
    private static ConnectionSource connectionSource;

    public static void initDatabase(){
        createConnectionSource();
//        dropTable(); //zakomentuj, żeby nie kasować za każym razem tabel w bazie
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource(){
        try {
            connectionSource = new JdbcConnectionSource(databaseUrl);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource == null){
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource!=null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    private static void createTable(){
        try {
            TableUtils.createTableIfNotExists(connectionSource, Student.class);

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private  static  void  dropTable() {
        try {
            TableUtils.dropTable(connectionSource, Student.class, true);
        } catch (SQLException e) {
            e.getMessage();
        }
        {
            try {
                connectionSource = new JdbcConnectionSource(databaseUrl);
                TableUtils.dropTable(connectionSource, Student.class, true);
                TableUtils.createTable(connectionSource, Student.class);


                connectionSource.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



package sample;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {

    public static final String DATABASE_URL = "jdbc:sqlite:students.db";
    public static final Logger LOGGER= LoggerFactory.getLogger(DbManager.class);
    public static ConnectionSource connectionSource;

    public static void initDatabase(){
        createConnectionSource();
//        dropTable(); //zakomentuj, żeby nie kasować za każym razem tabel w bazie
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource(){
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource==null) {
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource!=null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

   private static void createTable(){
       try {
           TableUtils.createTableIfNotExists(connectionSource, Student.class);
       } catch (SQLException e) {
           LOGGER.warn(e.getMessage());
       }
   }

   private static void dropTable(){
       try {
           TableUtils.dropTable(connectionSource,Student.class,true);
       } catch (SQLException e) {
           LOGGER.warn(e.getMessage());

       }

   }
}



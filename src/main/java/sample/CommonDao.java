package sample;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public abstract class CommonDao {
    public static final Logger LOGGER= LoggerFactory.getLogger(CommonDao.class);

    protected final ConnectionSource connectionSource;


    public CommonDao(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    public <T extends IStudent, I> void createOrUpdate(Class<T> tClass,IStudent iStudent){
        Dao<T,I>dao =getDao(tClass);
        try {
            dao.createOrUpdate((T) iStudent);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public  <T extends IStudent, I> Dao<T,I> getDao(Class<T> tClass){
        try {
            return DaoManager.createDao(connectionSource, tClass);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return null;
    }
}

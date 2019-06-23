package sample;

import com.j256.ormlite.support.ConnectionSource;

public class StudentDao extends CommonDao{
    public StudentDao(ConnectionSource connectionSource) {
        super(connectionSource);
    }
}

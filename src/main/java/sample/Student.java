package sample;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "STUDENTS")
public class Student {
    @DatabaseField(generatedId = true)
    private int id;


    @DatabaseField(columnName = "NAME")
    private String name;

    @DatabaseField(columnName = "LASNAME")
    private String lastname;

    @DatabaseField(columnName = "INDEX")
    private int indexNumber;

    @DatabaseField(columnName = "HASPAYED")
    private boolean hasPayed;

    @DatabaseField(columnName = "SEMESTER")
    private int semster;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public boolean isHasPayed() {
        return hasPayed;
    }

    public void setHasPayed(boolean hasPayed) {
        this.hasPayed = hasPayed;
    }

    public int getSemster() {
        return semster;
    }

    public void setSemster(int semster) {
        this.semster = semster;
    }

    public Student(String name, String lastname, int indexNumber, boolean hasPayed, int semster) {
        this.name = name;
        this.lastname = lastname;
        this.indexNumber = indexNumber;
        this.hasPayed = hasPayed;
        this.semster = semster;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return indexNumber + " " + name + " " + lastname;
    }
}

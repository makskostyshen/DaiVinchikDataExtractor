package mainClasses;

import static mainClasses.SQLConnectionConstants.TABLE_NAME;


public final class SQLQueries {

    private SQLQueries(){}

    public static final String SHOW_TABLES = "SHOW tables;";


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                "id INT," +
                "date_and_time TEXT," +
                "sender TEXT," +
                "photo_path TEXT," +
                "mess_text TEXT," +
                "PRIMARY KEY (id)" +
            ");";

    public static final String INSERT_MESSAGE =
            "INSERT INTO " + TABLE_NAME +
            "(id, date_and_time, sender, photo_path, mess_text)" +
            "VALUES (?, ?, ?, ?, ?)" +
            ";";

}

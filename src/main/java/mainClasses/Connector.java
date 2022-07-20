package mainClasses;

import messages.Message;

import java.sql.*;
import java.util.List;


public class Connector {

    private Connection connection;

    public Connector(){}

    public void connect() throws SQLException{
        connection = DriverManager.getConnection(
                SQLConnectionConstants.URL,
                SQLConnectionConstants.PROPERTIES);
    }

    public void close() throws SQLException {
        connection.close();
    }

    public Connection getConnection(){
        return connection;
    }

    public boolean notContainsTable(String tableName) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLQueries.SHOW_TABLES);

        boolean hasThisTable = false;
        while(resultSet.next()){
            String currentTableName = resultSet.getString(1);

            if(currentTableName.equals(tableName)){
                hasThisTable = true;
            }
        }
        statement.close();
        return !hasThisTable;
    }

    public void loadMessages(List<Message> messages) throws SQLException {

        String tableName = SQLConnectionConstants.TABLE_NAME;

        if (notContainsTable(tableName)){
            createTable();
            System.out.println("not contains");
        }

        SQLLoader loader = new SQLLoader();
        loader.loadMessages(messages, connection, tableName);
    }

    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();

        statement.executeUpdate(SQLQueries.CREATE_TABLE);

        statement.close();
    }

}

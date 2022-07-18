package mainClasses;

import messages.Message;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Connector {

    private Connection connection;

    public Connector(){}

    public void connect() throws SQLException{
        connection = DriverManager.getConnection(
                SQLConnectionConstants.URL,
                SQLConnectionConstants.USERNAME,
                SQLConnectionConstants.PASSWORD);

        connection.setClientInfo("autoReconnect", "true");
        connection.setClientInfo("useSSL", "false");
        connection.setClientInfo("characterEncoding", "CP1251");
        connection.setClientInfo("useUnicode", "true");




    }

    public void close() throws SQLException {
        connection.close();
    }

    public Connection getConnection(){
        return connection;
    }

    public boolean containsTable(String tableName) throws SQLException {

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
        return hasThisTable;
    }

    public void loadMessages(List<Message> messages) throws SQLException {

        String name = SQLConnectionConstants.TABLE_NAME;

        if (containsTable(name)){
//            createTable();
            insertMessages(messages);
        }
    }

    private void insertMessages(List<Message> messages) throws SQLException {

        PreparedStatement statement =
                connection.prepareStatement(SQLQueries.INSERT_MESSAGE);

        for (int i = 0; i < 2; i++){
            loadMessage(messages.get(i), statement);
        }
    }

    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();

        statement.executeUpdate(SQLQueries.CREATE_TABLE);

        statement.close();
    }

    public void loadMessage(Message message, PreparedStatement statement) throws SQLException {

        upgradeQuery(statement, message);
        statement.executeUpdate();
    }

    private void upgradeQuery( PreparedStatement statement, Message message) throws SQLException {
        statement.setInt(1, message.getId());
        statement.setString(2, message.getDate());
        statement.setString(3, message.getSender());
        System.out.println(
                new String(message.getSender().getBytes(StandardCharsets.UTF_8))
        );

//        String
//
//        System.out.println(new String(value.getBytes(fromEncoding), toEncoding));

        statement.setString(4, message.getPhotoPath());
        statement.setString(5, message.getText());
    }


}

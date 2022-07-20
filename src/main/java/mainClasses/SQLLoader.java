package mainClasses;

import messages.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;

public class SQLLoader {

    public void loadMessages(List<Message> messageList, Connection connection, String tableName)
            throws SQLException {

        String query = SQLQueries.getInsertMessageQueryByTableName(tableName);
        PreparedStatement statement = connection.prepareStatement(query);

        for (int i = 0; i < 2; i++){
            loadMessage(messageList.get(i), statement);
        }
        statement.close();
    }

    private void loadMessage(Message message, PreparedStatement statement) throws SQLException {
        upgradeQuery(message, statement);
        statement.executeUpdate();
    }

    private void upgradeQuery(Message message, PreparedStatement statement) throws SQLException {
        statement.setInt(1, message.getId());
        statement.setString(2, message.getDate());
        statement.setString(3, message.getSender());
        statement.setString(4, message.getPhotoPath());
        statement.setString(5, message.getText());
    }

}

package mainClasses;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void shouldGetJdbcConnection() throws SQLException {
        try(Connection connection = Main.getConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }
}
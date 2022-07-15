package mainClasses;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectorTest {

    private static Connector connector;

    @Before
    public void init() throws SQLException {
        connector = new Connector();
    }

    @After
    public void close() throws SQLException {
        connector.close();
    }

    @Test
    public void shouldGetJdbcConnection() throws SQLException {
        try(Connection connection = new Connector().getConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }







}
package mainClasses;

import java.util.Properties;

public class SQLConnectionConstants {

    public static final String URL
            = "jdbc:mysql://localhost:3306/dv_messages?autoReconnect=true&useSSL=false";

    public static final String USERNAME = "root";

    public static final String TABLE_NAME = FilePathConstants.getFolderName();

    public static final String PASSWORD = "okcsonic";

    public static final Properties PROPERTIES = getProperties();

    private static Properties getProperties(){
        Properties properties = new Properties();
        properties.put("autoReconnect", "true");
        properties.put("useSSL", "false");
        properties.put("characterEncoding", "CP1251");
        properties.put("useUnicode", "true");

        properties.put("password", PASSWORD);
        properties.put("user", USERNAME);
        return properties;
    }

}

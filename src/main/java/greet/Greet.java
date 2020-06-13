package greet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Greet extends GreetQueries{
    final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/test";

    public Connection getConnection() throws Exception {
        // TODO - add a username of "sa" and a blank password ""
        // TODO - if the db is created via default flyway config the username will be "sa" with a blank password
        // you can change this by removing the user element containing sa in the pom.xml file
        // if not be sure to delete the *.db files in your target folder before running mvn flyway:migrate the first time
        // and be sure the set the username to "sa" password blank ""
        // if your remove the user element from the pom.xml file you are use a username of "" and a password of ""
        Connection conn = DriverManager.getConnection(DATABASE_URL, "sa", "");
        return conn;
    }

    String greeting = "";

    public String GreetUser(String name, String lang) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1); // standardization
        name = name.replaceAll("\\s+","");
        Language language = new Language(lang);
        this.greeting = language.getGreeting() + name;
        try {
            Connection conn = getConnection();
            if (checkIfNameExist(name)) {
                final String UPDATE_NAME_COUNT = "update greet set count = count + 1 where name = ?";
                PreparedStatement updateNameStatement = conn.prepareStatement(UPDATE_NAME_COUNT);
                updateNameStatement.setString(1, name);
                updateNameStatement.execute();
            } else {
                final String INSERT_GREET_SQL = "insert into greet (name, count) values (?, ?)";
                PreparedStatement addNamePreparedStatement = conn.prepareStatement(INSERT_GREET_SQL);
                addNamePreparedStatement.setString(1, name);
                addNamePreparedStatement.setDouble(2, 1);
                addNamePreparedStatement.execute();
            }
            return greeting;

        } catch (Exception e) {
            System.out.println(e);
        }

        return name;
    } //greet

    public Boolean checkIfNameExist(String name) {

        // PreparedStatement are SQL statements that can be called
        // over and over with different parameters
        try {
            Connection conn = getConnection();
            final String FIND_NAME_SQL = "select * from greet where name = ?";

            PreparedStatement findNameStatement = conn.prepareStatement(FIND_NAME_SQL);

            findNameStatement.setString(1, name);
            findNameStatement.execute();

            ResultSet rs = findNameStatement.executeQuery();

            rs.next();
            return name.equals(rs.getString(("name")));
        } catch (Exception e) {
            return false;
//            System.out.println(e);
        }

    }


}

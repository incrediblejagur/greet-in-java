package net.greet;
import java.sql.*;

public class Greet extends GreetQueries{

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

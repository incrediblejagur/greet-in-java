package greet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GreetQueries {
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

    public String getNameCount(String name){
        name = name.substring(0, 1).toUpperCase() + name.substring(1); // standardization
        try {
            Connection conn = getConnection();
            final String FIND_NAME_SQL = "select count from greet where name = ?";

            PreparedStatement findNameStatement = conn.prepareStatement(FIND_NAME_SQL);

            findNameStatement.setString(1, name);
            findNameStatement.execute();

            ResultSet rs = findNameStatement.executeQuery();

            rs.next();
            return name+":"+rs.getInt("count");
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    } // greeted 'name'

    public int totalUniqueUsersGreeted() {
        int totalUniqueNames = 0;
        try {
            Connection conn = getConnection();
            final String INSERT_GREET_SQL = "SELECT COUNT(*) AS rowCount from greet";
            PreparedStatement totalCountStatement = conn.prepareStatement(INSERT_GREET_SQL);
            totalCountStatement.execute();

            ResultSet rs = totalCountStatement.executeQuery();

            rs.next();
            totalUniqueNames = rs.getInt("rowCount");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return totalUniqueNames;
    } //counter

    public Object getAllNamesGreeted(){  //greeted
        try {
            Connection conn = getConnection();
            final String FIND_NAME_SQL = "select * from greet";

            PreparedStatement findNameStatement = conn.prepareStatement(FIND_NAME_SQL);
            findNameStatement.execute();

            ResultSet rs = findNameStatement.executeQuery();
            List<String> nameList = new ArrayList<>();
            while(rs.next()) {
                nameList.add(rs.getString("name")+":"+rs.getString("count"));
            }
            return nameList;
        } catch (Exception e) {
//            System.out.println(e);
            return "";
        }
    } // greeted

    public String deleteName(String name){
        name = name.substring(0, 1).toUpperCase() + name.substring(1); // standardization
        try {
            Connection conn = getConnection();
            final String FIND_NAME_SQL = "delete from greet WHERE name = ?";

            PreparedStatement findNameStatement = conn.prepareStatement(FIND_NAME_SQL);
            findNameStatement.setString(1, name);
            findNameStatement.execute();

            return name + " deleted!";
        } catch (Exception e) {
//            System.out.println(e);
            return "";
        }
    } // clear 'name'

    public String deleteAllNames() {
        // don't touch any code in here!!!
        try {
            try(Connection conn = getConnection()) {
                // I repeat don't touch any code in here!!!
                Statement statement = conn.createStatement();
                statement.addBatch("TRUNCATE TABLE greet");
                statement.executeBatch();
                return "All names deleted.";
            }
        } catch(Exception ex) {
            return "error";
        }
    } // clear

}

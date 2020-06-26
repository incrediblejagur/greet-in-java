package net.greet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GreetQueries implements Greets {
    final String DATABASE_URL = "jdbc:h2:~/test";

    public Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection(DATABASE_URL, "sa", "");
        return conn;
    }

    public String addNameToDB(String name){
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
            return name;

        } catch (Exception e) {
            return "error";
        }
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
            return "Name not found.";
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
            int rs = findNameStatement.executeUpdate();
    if(rs == 1){
        return name + " deleted!";
    }else{
        return "Name already doesn't exist.";
    }
        } catch (Exception e) {
            return "Error deleting name from database.";
        }
    } // clear 'name'

    public String deleteAllNames() {
        try {
            try(Connection conn = getConnection()) {
                Statement statement = conn.createStatement();
                statement.addBatch("TRUNCATE TABLE greet");
                statement.executeBatch();
                return "All names deleted.";
            }
        } catch(Exception ex) {
            return "error";
        }
    } // clear

    public Boolean checkIfNameExist(String name) {
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

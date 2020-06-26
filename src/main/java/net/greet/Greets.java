package net.greet;

public interface Greets {
    String addNameToDB(String name);
    String getNameCount(String name);
    int totalUniqueUsersGreeted();
    Object getAllNamesGreeted();
    String deleteName(String name);
    String deleteAllNames();
}

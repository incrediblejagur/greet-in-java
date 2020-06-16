package net.greet;

public interface Greets {
    String getNameCount(String name);
    int totalUniqueUsersGreeted();
    Object getAllNamesGreeted();
    String deleteName(String name);
    String deleteAllNames();
}

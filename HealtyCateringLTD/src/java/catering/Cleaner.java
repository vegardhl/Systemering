package catering;

import java.sql.*; 

/**
 * A simple helper class that closes down all connections to the database
 * @author Team 6
 */
public class Cleaner {
    
    /*
     * Closes a result set
     * @param res the result set that is to be closed
     */
    public static void closeResSet(ResultSet res) {
        try {
            // Check if the result set is given a value
            if (res != null) {
                // Closes the result set
                res.close();
            }
        } catch (SQLException e) {
            writeMessage(e, "lukkResSet()");
        }
    }
    
    /*
     * Closes a statement
     * @param stm the statement that is to be closed
     */
    public static void closeStatement(Statement stm) { 
        try {
            // Check if the statement is given a value
            if (stm != null) {
                // Closes the statement
                stm.close();
            }
        } catch (SQLException e) {
            writeMessage(e, "lukkSetning()");
        }
    }
    
    /*
     * Closes the connection
     * @param connection the connection that is to be closed
     */
    public static void closeConnection(Connection connection) { 
        try {
            // Check if the connection is given a value
            if (connection != null) {
                // Closes the connection
                connection.close();
            }
        } catch (SQLException e) {
            writeMessage(e, "lukkForbindelse()"); 
        }
    }
    
    /*
     * Undoes all changes made in the current transaction and releases 
     * any database locks currently held by this Connection object.
     * @param connection the connection that is to be rolled back
     */
    public static void rollback(Connection connection) { try {
        if (connection != null && !connection.getAutoCommit()) { 
            connection.rollback();
        }
        } catch (SQLException e) {
            writeMessage(e, "rollback()");
        }
    }
    
    /*
     * Sets this connection's auto-commit mode to the given state.
     * If a connection is in auto-commit mode, then all its SQL statements 
     * will be executed and committed as individual transactions. 
     * @param connection the connection that is to be auto-commited
     */
    public static void settAutoCommit(Connection connection) { try {
        if (connection != null && !connection.getAutoCommit()) { 
            connection.setAutoCommit(true);
        }
        } catch (SQLException e) {
            writeMessage(e, "settAutoCommit()"); 
        }
    }
    
    /*
     * Posts a message . Should be used to check status when on operations when
     * needed.
     * @param e an exception given by an error that have occurred
     * @param melding the message that should be displayed
     */
    public static void writeMessage(Exception e, String melding) { 
        System.err.println("*** Feil oppstått: " + melding + ". ***"); 
        e.printStackTrace(System.err);
    }
}
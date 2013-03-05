package catering;

import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.enterprise.context.SessionScoped;

/**
 * Starts the connections to the database. Then handles all the communication.
 * @author Team 6
 */
public class Database {
    
    @Resource(name="jdbc/waplj_prosjekt")
    
    // Database driver name
    public final String DATABASE_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    
    // Holds the name of the database, includes username and password
    public final String DATABASE_NAME = "jdbc:derby://localhost:1527/waplj_prosjekt;user=waplj;password=waplj";
    
    // Holds the connections to the datasource
    private Connection connection = null;
    
    // Datasource object
    private DataSource dataSource = null;
    
    /**
     * Initializes the connection by finding the database driver and datasource.
     */
    public Database() {
        try {
            // Find driver for the database
            Class.forName(DATABASE_DRIVER);
        } catch (Exception e) {
            System.out.println("Driver ikke funnet");
        }
        
        try {
            // Initializes the datasource
            dataSource = (DataSource) new InitialContext().lookup("jdbc/waplj_prosjekt");
        } catch (NamingException ex) {
            System.out.println("Datasource FEIL!");
        }
    }
    
    /**
     * Initializes the connections to the database.
     */
    private void openConnection() {
        try {
            // Check if a datasoruce exists
            if (dataSource == null) {
                throw new SQLException("Ingen data source");
            }
            
            // Establishes a connection with the data source
            connection  = dataSource.getConnection();
            
            System.out.println("Tilkopling via datasource vellykket");
        } catch (Exception e) {
            System.out.println("Feil ved databasetilkopling: " + e);
        }
    }
    
    /**
     * Closes the database connection.
     */
    private void closeConnection() { 
        Cleaner.closeConnection(connection);
    }
    
    /*
    public ArrayList<Treningsokt> hentTreningsokter(String navn) {
        ArrayList<Treningsokt> okter = new ArrayList<Treningsokt>();
        åpneForbindelse();
        PreparedStatement setning = null;
        try {
            setning = forbindelse.prepareStatement("select * from trening where brukernavn='"+navn+"' order by dato");
            
            ResultSet res = setning.executeQuery();
            while (res.next()) {
                java.sql.Date sqlDate = res.getDate("dato");
                int oktNr = res.getInt("oktnr");
                int varighet = res.getInt("varighet");
                String kategori = res.getString("kategorinavn");
                String tekst = res.getString("tekst");
            
                java.util.Date date = new java.util.Date(sqlDate.getTime());
                okter.add(new Treningsokt(oktNr, date, varighet, kategori, tekst));
            }

        } catch (SQLException e) { 
            Opprydder.skrivMelding(e, "hentTreningsokter()");
        } finally { 
            Opprydder.lukkSetning(setning);
        }
        lukkForbindelse();
        
        return okter;
    }
    
    public boolean registrerNyOkt(Treningsokt ts, String navn) {
        åpneForbindelse();
        PreparedStatement setning = null;
        boolean b = false;
        try {
            
            setning = forbindelse.prepareStatement("INSERT INTO trening(dato, varighet, kategorinavn, tekst, brukernavn) VALUES(?,?,?,?,?)");
            
            java.sql.Date dato = new java.sql.Date(ts.getDato().getTime());
            String kategori = ts.getKategori().toLowerCase();
            
            setning.setDate(1, dato);
            setning.setInt(2, ts.getVarighet());
            setning.setString(3, ""+kategori);
            setning.setString(4, ""+ts.getTekst());
            setning.setString(5, ""+navn);
            setning.executeUpdate();
            b = true;
        } catch (SQLException e) { 
            Opprydder.skrivMelding(e, "registrerNyØkt()");
        } finally { 
            Opprydder.lukkSetning(setning);
        }
        lukkForbindelse();
        return b;
    }
    
    public boolean slettTreningsokt(int oktNr) {
        åpneForbindelse();
        PreparedStatement setning = null;
        boolean b = false;
        try {
            setning = forbindelse.prepareStatement("DELETE from trening where trening.oktnr=?");
            setning.setInt(1, oktNr);
            setning.executeUpdate();
            b = true;
        } catch (SQLException e) { 
            Opprydder.skrivMelding(e, "slettTreningsokt()");
        } finally { 
            Opprydder.lukkSetning(setning);
        }
        lukkForbindelse();
        return b;
    }
    
    public boolean endreTreningsokt(Treningsokt ts, int nr) {
        åpneForbindelse();
        PreparedStatement setning = null;
        boolean b = false;
        try {
            setning = forbindelse.prepareStatement("UPDATE trening SET dato=?,varighet=?, kategorinavn=?, tekst=? where oktnr=?");
            
            java.sql.Date dato = new java.sql.Date(ts.getDato().getTime());
            String kategori = ts.getKategori().toLowerCase();
            
            setning.setDate(1, dato);
            setning.setInt(2, ts.getVarighet());
            setning.setString(3, ""+kategori);
            setning.setString(4, ""+ts.getTekst());
            setning.setInt(5, nr);
            setning.executeUpdate();
            b = true;
        } catch (SQLException e) { 
            Opprydder.skrivMelding(e, "slettTreningsokt()");
        } finally { 
            Opprydder.lukkSetning(setning);
        }
        lukkForbindelse();
        return b;
    }
    
    public boolean registrerPassord(String passord, String bruker) {
        åpneForbindelse();
        PreparedStatement setning = null;
        boolean b = false;
        try {
            setning = forbindelse.prepareStatement("UPDATE bruker SET passord=? where brukernavn=?");
            
            setning.setString(1, ""+passord);
            setning.setString(2, ""+bruker);
            setning.executeUpdate();
    
            b = true;
        } catch (SQLException e) { 
            Opprydder.skrivMelding(e, "nyttPassord()");
        } finally { 
            Opprydder.lukkSetning(setning);
        }
        lukkForbindelse();
        return b;
    }
    */
    public static void main(String[] args) {
        System.out.println("Hei");
    }
}
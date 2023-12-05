package samples;

import java.text.ParseException;

import com.basiscomponents.db.DataRow;

public class AccountClass {
    // private int mitarbeiterID;
    // private String vorname;
    // private String passwort;
    // private String email;
    // private boolean freigabe;

    private final DataRow data;


     public AccountClass(DataRow data) {
        this.data = data;
     }

     public String getFieldAsString(String key) {
        return data.getAttribute(key);
     }

    public void setFieldValue(String key, String value){
        try {
            data.setFieldValue(key, value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    } 

    // public AccountClass(ResultSet rs) {
    //     try {
    //     this.mitarbeiterID = rs.getInt("MitarbeiterID");
    //     this.vorname = rs.getString("Vorname");
    //     this.passwort = rs.getString("Passwort");
    //     this.email = rs.getString("Email");
    //     this.freigabe = rs.getBoolean("Freigabe");
    //     } catch (SQLException e) {
    //        
    //         e.printStackTrace();
    //     }
    // }
    

    // public int getMitarbieterID(){
    //     return mitarbeiterID;
    // }
    // public void setMitarbeiterID(int mitarbeiterID) {
    //     this.mitarbeiterID = mitarbeiterID;
    // }

    // public String getVorname() {
    //     return vorname;
    // }
    // public void setVorname(String vorname) {
    //     this.vorname = vorname;
    // }

    // public String getPasswort(String passwort) {
    //     return passwort;
    // }
    // public void setPasswort (String passwort) {
    //     this.passwort = passwort;
    // }

    // public String getEmail (String email){
    //     return email;
    // }
    // public void setEmail (String email){
    //     this.email = email;
    // }

    // public boolean getFreigabe(boolean freigabe) {
    //     return freigabe;
    // }
    // public void setFreigabe(boolean freigabe) {
    //     this.freigabe = freigabe;
    // }
}

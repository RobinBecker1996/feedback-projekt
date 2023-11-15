package samples;


import java.text.ParseException;


import com.basiscomponents.db.DataRow;

public class MitarbeiterClass {
    private final DataRow data;


    public MitarbeiterClass(DataRow data) {
        this.data = data;
    }

    public String getFieldAsString(String key) {
        return data.getFieldAsString(key);
    }

    public void getFieldValue(String key, String value){
        try {
            data.setFieldValue(key, value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    // public MitarbeiterClass(ResultSet rs) {
    //     try {
    //         this.mitarbeiterID = rs.getInt("MitarbeiterID");
    //         this.vorname = rs.getString("Vorname");
    //         this.nachname = rs.getString("Nachname");
    //         this.feedback = rs.getString("Feedback");
    //         this.termin = rs.getDate("Termin");
    //         this.ziele = rs.getString("Ziele");
    //         this.schwerpunkt = rs.getString("Schwerpunkt");
    //     } catch (SQLException e) {
    //          App.consoleLog("MitarbeiterClass -> " + e.getMessage() );
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
    // public void setVornmae(String vorname) {
    //     this.vorname = vorname;
    // }

    // public String getNachname() {
    //     return nachname;
    // }
    //  public void getNachname(String nachname) {
    //     this.nachname = nachname;
    // }

    // public String getFeeback(String feedback) {
    //     return feedback;
    // }
    // public void setFeedback (String feedback) {
    //     this.feedback = feedback;
    // }

    // public Date getTermin (Date termin){
    //     return termin;
    // }
    // public void setTermin (Date termin){
    //     this.termin = termin;
    // }

    // public String getZiele(String ziele) {
    //     return ziele;
    // }
    // public void setZiele(String ziele) {
    //     this.ziele = ziele;
    // }

    //  public String getSchwerpunkt(String schwerpunkt) {
    //     return schwerpunkt;
    // }
    // public void setSchwerpunkt(String schwerpunkt) {
    //     this.schwerpunkt = schwerpunkt;
    // }
}

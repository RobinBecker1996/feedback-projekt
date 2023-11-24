package samples;


import java.text.ParseException;


import com.basiscomponents.db.DataRow;

public class FeedbackClass {
    private final DataRow data;

    public FeedbackClass(DataRow data) {
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


    // public FeedbackClass(ResultSet rs) {
    //     try {
    //         this.feedbackNr = rs.getInt("FeedbackNr");
    //         this.erstellung = rs.getDate("Erstellungsdatum");
    //     } catch (SQLException e) {
    //         App.consoleLog("FeedbackClass -> " + e.getMessage() );
    //     }
    // }
    

    // public int getFeedbackNr(int FeedbackNr){
    //     return feedbackNr;
    // }
    // public void setFeedbackNr(int feedbackNr){
    //     this.feedbackNr = feedbackNr;
    // }

    // public Date getErstellung(Date erstellung) {
    //     return erstellung;
    // }
    // public void setErstellung(Date erstellung) {
    //     this.erstellung = erstellung;
    // }
}



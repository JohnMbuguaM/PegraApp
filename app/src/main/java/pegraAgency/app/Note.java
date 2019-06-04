package pegraAgency.app;

import com.google.firebase.firestore.ServerTimestamp;
import com.google.type.Date;

public class Note {
    private String title, description;
    private int  phoneNo;





    public Note(){
        //An empty constructor
    }

    public Note(String title, String description, int phoneNo ){
        this.title = title;
        this.description = description;
        this.phoneNo = phoneNo;


    }



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPhoneNo() {
    return phoneNo;
    }


}

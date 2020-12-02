package application;

import javafx.beans.property.SimpleStringProperty;

public class AdminBlack {
	private final SimpleStringProperty blackmarknum;  
    private final SimpleStringProperty blackmarkcon;  
    private final SimpleStringProperty fines;
    private final SimpleStringProperty booknum; 
    private final SimpleStringProperty anum;
    private final SimpleStringProperty bornum;

    public AdminBlack(String blackmarknum, String bornum, String booknum, String anum, String blackmarkcon, String fines) {  
        this.blackmarknum = new SimpleStringProperty(blackmarknum);  
        this.blackmarkcon = new SimpleStringProperty(blackmarkcon);  
        this.fines = new SimpleStringProperty(fines); 
        this.booknum = new SimpleStringProperty(booknum); 
        this.anum = new SimpleStringProperty(anum); 
        this.bornum = new SimpleStringProperty(bornum); 
    }  

    public String getBlackmarknum() {  
        return blackmarknum.get();  
    }  

    public void setBlackmarknum(String text) {  
        blackmarknum.set(text);  
    }  
    public String getBornum() {  
        return bornum.get();  
    }  

    public void setBornum(String text) {  
        bornum.set(text);  
    }

    public String getBlackmarkcon() {  
        return blackmarkcon.get();  
    }  

    public void setBlackmarkcon(String text) {  
        blackmarkcon.set(text);  
    }  

    public String getFines() {  
        return fines.get();  
    }  

    public void setFines(String text) {  
        fines.set(text);  
    }  
    public String getBooknum() {  
        return booknum.get();  
    }  

    public void setBooknum(String text) {  
        booknum.set(text);  
    }  
    
    public String getAnum() {  
        return anum.get();  
    }  

    public void setAnum(String text) {  
        anum.set(text);  
    }
  
}


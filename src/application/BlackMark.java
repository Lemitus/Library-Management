package application;

import javafx.beans.property.SimpleStringProperty;

public class BlackMark {
	private final SimpleStringProperty blackmarknum;  
    private final SimpleStringProperty blackmarkcon;  
    private final SimpleStringProperty fines;   

    public BlackMark(String blackmarknum, String blackmarkcon, String fines) {  
        this.blackmarknum = new SimpleStringProperty(blackmarknum);  
        this.blackmarkcon = new SimpleStringProperty(blackmarkcon);  
        this.fines = new SimpleStringProperty(fines);      
    }  

    public String getBlackmarknum() {  
        return blackmarknum.get();  
    }  

    public void setBlackmarknum(String text) {  
        blackmarknum.set(text);  
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

  
}

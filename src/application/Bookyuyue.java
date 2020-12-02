
package application;

import javafx.beans.property.SimpleStringProperty;

public class Bookyuyue {
	private final SimpleStringProperty affairnum;  
    private final SimpleStringProperty takeplace;  
    private final SimpleStringProperty bookname;  
    private final SimpleStringProperty applytime;  
    private final SimpleStringProperty checkstate;   
    private final SimpleStringProperty bookplace;   
 

    public Bookyuyue(String affairnum,String bookname, String bookplace, String takeplace, String applytime, String checkstate) {  
        this.affairnum = new SimpleStringProperty(affairnum);  
        this.takeplace = new SimpleStringProperty(takeplace);  
        this.bookname = new SimpleStringProperty(bookname);  
        this.applytime = new SimpleStringProperty(applytime);  
        this.checkstate = new SimpleStringProperty(checkstate);  
        this.bookplace = new SimpleStringProperty(bookplace);    
    }  

    public String getAffairnum() {  
        return affairnum.get();  
    }  

    public void setAffairnum(String text) {  
        affairnum.set(text);  
    }  

    public String getTakeplace() {  
        return takeplace.get();  
    }  

    public void setTakeplace(String text) {  
        takeplace.set(text);  
    }  

    public String getBookname() {  
        return bookname.get();  
    }  

    public void setBookname(String text) {  
        bookname.set(text);  
    }  

    public String getApplytime() {  
        return applytime.get();  
    }  

    public void setApplytime(String text) {  
        applytime.set(text);  
    }  
    
    public String getCheckstate() {  
        return checkstate.get();  
    }  

    public void setCheckstate(String text) {  
        checkstate.set(text);  
    } 
      
    
    public String getBookplace() {  
        return bookplace.get();  
    }  

    public void setBookplace(String text) {  
        bookplace.set(text);  
    }  
  
}

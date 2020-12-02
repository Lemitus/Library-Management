package application;

import javafx.beans.property.SimpleStringProperty;

public class AdminBorrow {
	private final SimpleStringProperty affairnum;  
    private final SimpleStringProperty borrowplace;  
    private final SimpleStringProperty bookname;  
    private final SimpleStringProperty borrowtime;  
    private final SimpleStringProperty returntime;   
    private final SimpleStringProperty returnplace; 
    private final SimpleStringProperty renewtimes;
    private final SimpleStringProperty booknum; 
    private final SimpleStringProperty anum;
 

    public AdminBorrow(String affairnum, String bookname,String booknum, String anum, String borrowtime,String borrowplace, String returntime, String returnplace
    		, String renewtimes) {  
        this.affairnum = new SimpleStringProperty(affairnum);  
        this.borrowplace = new SimpleStringProperty(borrowplace);  
        this.bookname = new SimpleStringProperty(bookname);  
        this.borrowtime = new SimpleStringProperty(borrowtime);  
        this.returntime = new SimpleStringProperty(returntime);  
        this.returnplace = new SimpleStringProperty(returnplace); 
        this.renewtimes = new SimpleStringProperty(renewtimes); 
        this.booknum = new SimpleStringProperty(booknum); 
        this.anum = new SimpleStringProperty(anum); 
        
    }  

    public String getAffairnum() {  
        return affairnum.get();  
    }  

    public void setAffairnum(String text) {  
        affairnum.set(text);  
    }  

    public String getBorrowplace() {  
        return borrowplace.get();  
    }  

    public void setBorrowplace(String text) {  
        borrowplace.set(text);  
    }  

    public String getBookname() {  
        return bookname.get();  
    }  

    public void setBookname(String text) {  
        bookname.set(text);  
    }  

    public String getBorrowtime() {  
        return borrowtime.get();  
    }  

    public void setBorrowtime(String text) {  
        borrowtime.set(text);  
    }  
    
    public String getReturntime() {  
        return returntime.get();  
    }  

    public void setReturntime(String text) {  
        returntime.set(text);  
    } 
      
    
    public String getReturnplace() {  
        return returnplace.get();  
    }  

    public void setReturnplace(String text) {  
        returnplace.set(text);  
    }  
    
    public String getRenewtimes() {  
        return renewtimes.get();  
    }  

    public void setRenewtimes(String text) {  
        renewtimes.set(text);  
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

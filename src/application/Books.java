package application;

import javafx.beans.property.SimpleStringProperty;

public class Books {
	private final SimpleStringProperty booknum;  
    private final SimpleStringProperty isbn;  
    private final SimpleStringProperty bookname;  
    private final SimpleStringProperty bookabb;  
    private final SimpleStringProperty bookwriter;  
    private final SimpleStringProperty bookclass; 
    private final SimpleStringProperty bookinfo;  
    private final SimpleStringProperty bookintime;  
    private final SimpleStringProperty bookprice; 
    private final SimpleStringProperty bookplace; 
    private final SimpleStringProperty borstate;
 

    public Books(String booknum, String isbn, String bookname, String bookabb, String bookwriter, String bookclass, 
    			String bookinfo, String bookintime, String bookprice, String bookplace, String borstate) {  
        this.booknum = new SimpleStringProperty(booknum);  
        this.isbn = new SimpleStringProperty(isbn);  
        this.bookname = new SimpleStringProperty(bookname);  
        this.bookabb = new SimpleStringProperty(bookabb);  
        this.bookwriter = new SimpleStringProperty(bookwriter);  
        this.bookclass = new SimpleStringProperty(bookclass);
        this.bookinfo = new SimpleStringProperty(bookinfo);  
        this.bookintime = new SimpleStringProperty(bookintime);  
        this.bookprice = new SimpleStringProperty(bookprice);
        this.bookplace = new SimpleStringProperty(bookplace); 
        this.borstate = new SimpleStringProperty(borstate);
    }  

    public String getBooknum() {  
        return booknum.get();  
    }  

    public void setBooknum(String text) {  
        booknum.set(text);  
    }  

    public String getIsbn() {  
        return isbn.get();  
    }  

    public void setIsbn(String text) {  
        isbn.set(text);  
    }  

    public String getBookname() {  
        return bookname.get();  
    }  

    public void setBookname(String text) {  
        bookname.set(text);  
    }  

    public String getBookabb() {  
        return bookabb.get();  
    }  

    public void setBookabb(String text) {  
        bookabb.set(text);  
    }  
    
    public String getBookwriter() {  
        return bookwriter.get();  
    }  

    public void setBookwriter(String text) {  
        bookwriter.set(text);  
    } 
    
    public String getBookclass() {  
        return bookclass.get();  
    }  

    public void setBookclass(String text) {  
        bookclass.set(text);  
    } 
    
    public String getBookinfo() {  
        return bookinfo.get();  
    }  

    public void setBookinfo(String text) {  
        bookinfo.set(text);  
    }  
    
    public String getBookintime() {  
        return bookintime.get();  
    }  

    public void setBookintime(String text) {  
        bookintime.set(text);  
    }  
    
    public String getBookprice() {  
        return bookprice.get();  
    }  

    public void setBookprice(String text) {  
        bookprice.set(text);  
    }  
    
    public String getBookplace() {  
        return bookplace.get();  
    }  

    public void setBookplace(String text) {  
        bookplace.set(text);  
    }  
    public String getBorstate() {  
        return borstate.get();  
    }  

    public void setBorstate(String text) {  
        borstate.set(text);  
    } 
}

package application;

import javafx.beans.property.SimpleStringProperty;

public class Account {
	private final SimpleStringProperty a_num;  
    private final SimpleStringProperty a_account;  
    private final SimpleStringProperty a_password;  
    private final SimpleStringProperty a_ques;  
    private final SimpleStringProperty a_name;  
    private final SimpleStringProperty a_permission; 
    private final SimpleStringProperty sex;  
    private final SimpleStringProperty black_mark;  
    private final SimpleStringProperty cur_bor; 
    private final SimpleStringProperty bor_limit;  
    private final SimpleStringProperty apply_limit;  
 

    public Account(String a_num, String a_account, String a_password, String a_ques, String a_name, String a_permission, 
    			String sex, String black_mark, String cur_bor, String bor_limit, String apply_limit) {  
        this.a_num = new SimpleStringProperty(a_num);  
        this.a_account = new SimpleStringProperty(a_account);  
        this.a_password = new SimpleStringProperty(a_password);  
        this.a_ques = new SimpleStringProperty(a_ques);  
        this.a_name = new SimpleStringProperty(a_name);  
        this.a_permission = new SimpleStringProperty(a_permission);
        this.sex = new SimpleStringProperty(sex);  
        this.black_mark = new SimpleStringProperty(black_mark);  
        this.cur_bor = new SimpleStringProperty(cur_bor);
        this.bor_limit = new SimpleStringProperty(bor_limit);  
        this.apply_limit = new SimpleStringProperty(apply_limit);  
    }  

    public String getA_num() {  
        return a_num.get();  
    }  

    public void setA_num(String text) {  
        a_num.set(text);  
    }  

    public String getA_account() {  
        return a_account.get();  
    }  

    public void setLA_account(String text) {  
        a_account.set(text);  
    }  

    public String getA_password() {  
        return a_password.get();  
    }  

    public void setA_password(String text) {  
        a_password.set(text);  
    }  

    public String getA_ques() {  
        return a_ques.get();  
    }  

    public void setA_ques(String text) {  
        a_ques.set(text);  
    }  
    
    public String getA_name() {  
        return a_name.get();  
    }  

    public void setA_name(String text) {  
        a_name.set(text);  
    } 
    
    public String getA_permission() {  
        return a_permission.get();  
    }  

    public void setA_permission(String text) {  
        a_permission.set(text);  
    } 
    
    public String getSex() {  
        return sex.get();  
    }  

    public void setSex(String text) {  
        sex.set(text);  
    }  
    
    public String getBlack_mark() {  
        return black_mark.get();  
    }  

    public void setBlack_mark(String text) {  
        black_mark.set(text);  
    }  
    
    public String getCur_bor() {  
        return cur_bor.get();  
    }  

    public void setCur_bor(String text) {  
        cur_bor.set(text);  
    }  
    
    public String getBor_limit() {  
        return bor_limit.get();  
    }  

    public void setBor_limit(String text) {  
        bor_limit.set(text);  
    }  
    
    public String getApply_limit() {  
        return apply_limit.get();  
    }  

    public void setApply_limit(String text) {  
        apply_limit.set(text);  
    }  
}

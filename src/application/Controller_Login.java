package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller_Login implements Initializable, ControlledStage {
	StageController myController;
	Connection con = Main.con;
    @FXML
    private Label text_account;

    @FXML
    private Label text_password;
    
    @FXML
    private Label ErrorText;

    @FXML
    private Hyperlink hyperlink_register;

    @FXML
    private CheckBox Checkbox_Admin;

    @FXML
    private ImageView login_in_imagine;

    @FXML
    private CheckBox Checkbox_SuperAdmin;

    @FXML
    private Hyperlink hyperlink_forget;

    @FXML
    private PasswordField field_password;

    @FXML
    private TextField field_account;

    @FXML
    private Button button_login;

    @FXML
    void LoginOnClick(ActionEvent event) {
    	String tacc, tpw;
    	tacc = field_account.getText().trim();
    	tpw = field_password.getText().trim();
        String acc = null;
        String pw = null;
        String perm = null;
        String num = null;
    	if(tacc.equals(""))
    		ErrorText.setText("请输入用户名！");
    	else if(tpw.equals(""))
    		ErrorText.setText("请输入密码！");
    	else{
    		try {
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select a_account, a_password, a_permission, a_num from account where a_account ='" + tacc + "'";
                ResultSet rs = statement.executeQuery(sql);
                if(!rs.first()){
                	ErrorText.setText("用户名不存在！");
                }
                else{
                	acc = rs.getString("a_account");
                	pw = rs.getString("a_password");
                	perm = rs.getString("a_permission");
                	num = rs.getString("a_num");
                }
                rs.close();
                con.close();
            } catch(ClassNotFoundException e) {   
                e.printStackTrace();   
                } catch(SQLException e) {
                e.printStackTrace();  
                }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        	//System.out.println(tpw + "\n" + pw);
        	if(tpw.equals(pw)){   
        		if(Checkbox_SuperAdmin.isSelected()){
        			if(perm.equals("SUPE")){
        				Main.mainuser.setName(acc);
        	    		Main.mainuser.setPassword(pw);
        	    		Main.mainuser.setPermission(perm);
        	    		Main.mainuser.setNum(num);
        	    		myController.setStage(Main.SuperAdminViewID, Main.LoginViewID);
        			}
        			else
        				ErrorText.setText("用户权限不足！");
        		}
        		else if(Checkbox_Admin.isSelected()){
        			if(perm.equals("SUPE")||perm.equals("ADMI")){
        				Main.mainuser.setName(acc);
        	    		Main.mainuser.setPassword(pw);
        	    		Main.mainuser.setPermission(perm);
        	    		Main.mainuser.setNum(num);
        	    		myController.setStage(Main.AdminViewID, Main.LoginViewID);
        			}
        			else
        				ErrorText.setText("用户权限不足！");
        		}
        		else{
        			Main.mainuser.setName(acc);
            		Main.mainuser.setPassword(pw);
            		Main.mainuser.setPermission(perm);
    	    		Main.mainuser.setNum(num);
            		myController.setStage(Main.ReaderViewID, Main.LoginViewID);
        		}
        	}
        	else{
        		ErrorText.setText("用户名或密码出错！！");
        	}
    	}
    }

    @FXML
    void RegisterOnClick(ActionEvent event) {
    	myController.setStage(Main.RegisterViewID);
    }

    @FXML
    void ForgetOnClick(ActionEvent event) {
    	myController.setStage(Main.ForgetViewID);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自动生成的方法存根
	}

	@Override
	public void setStageController(StageController stageController) {
		// TODO 自动生成的方法存根
		this.myController = stageController;
	}

}

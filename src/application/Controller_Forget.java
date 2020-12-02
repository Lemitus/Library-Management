

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller_Forget implements Initializable, ControlledStage{
	StageController myController;
	Connection con = Main.con;
    @FXML
    private Button ButtonReset;

    @FXML
    private Label LabelQues;

    @FXML
    private Button Button_find;
    @FXML
    private PasswordField Field_cpw;

    @FXML
    private PasswordField Field_pw;

    @FXML
    private TextField Field_account;

    @FXML
    void FindButtonOnClick(ActionEvent event) {
    	String tacc = Field_account.getText();
        String tques = null;
    	try {
            Class.forName(Main.driver);
            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
            Statement statement = con.createStatement();
            String sql = "select a_ques from account where a_account ='" + tacc + "'";
            ResultSet rs = statement.executeQuery(sql);
            if(!rs.first()){
            	LabelQues.setText("用户名不存在！");
            }
            else{
            	tques = rs.getString("a_ques");
            	LabelQues.setText(tques);
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
    }

    @FXML
    void ResetButtonOnClick(ActionEvent event) {
    	String tacc = Field_account.getText();
        String tpw = null;
        String tcpw = null;
    	try {
            Class.forName(Main.driver);
            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
            Statement statement = con.createStatement();
            String sql = "select a_ques from account where a_account ='" + tacc + "'";
            ResultSet rs = statement.executeQuery(sql);
            if(!rs.first()){
            	LabelQues.setText("用户名不存在！");
            }
            else{
            	tpw = Field_pw.getText();
            	tcpw = Field_cpw.getText();
            	if(tpw.equals(""))
            		LabelQues.setText("请输入新的密码！");
            	else if(tcpw.equals(""))
            		LabelQues.setText("请再次输入新的密码!");
            	else{
            		if(tpw.equals(tcpw)){
            			sql = "UPDATE account " +"SET a_password = '"+ tpw +"' WHERE a_account = '"+ tacc + "'";
            			statement.executeUpdate(sql);
            			System.out.println(tpw);
            			myController.getStage(Main.ForgetViewID).close();
            		}
            		else
            			LabelQues.setText("两次输入的密码不一致!");
            	}
            		
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
    }

	@Override
	public void setStageController(StageController stageController) {
		// TODO 自动生成的方法存根
		this.myController = stageController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自动生成的方法存根
		
	}

}

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller_UserInfo implements Initializable, ControlledStage{
	StageController myController;
	Connection con = Main.con;
    @FXML
    private ChoiceBox<String> CheckBox_key;

    @FXML
    private Label Label_BlackMark;

    @FXML
    private Label Label_sex;

    @FXML
    private Label Label_anum;

    @FXML
    private Label Label_aname;

    @FXML
    private Label Label_apermission;

    @FXML
    private Label Label_aacc;

    @FXML
    private TextField TextField_text;
    
    @FXML
    private Label Label_errortext;

    @FXML
    private Label Label_curbor;
    
    @FXML
    void ChangeButtonOnClick(ActionEvent event) {
    	String key = CheckBox_key.getValue();
    	String text = TextField_text.getText();
    	switch (key) {
		case "密码":
			key = "a_password";
			break;
		case "昵称":
			key = "a_name";
			break;
		case "性别":
			key = "sex";
			break;
		default:
			key = "";
			break;
		}
    	if(key.equals(""))
    		Label_errortext.setText("请选择要修改的属性！");
    	else if(text.equals(""))
    		Label_errortext.setText("请输入内容，改为空填“null”");
    	else{
    		try {
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "update account set " + key + "=" + "'"+ text + "' where a_account = '"+ Main.mainuser.getName() +"'";
                statement.executeUpdate(sql);
                Label_errortext.setText("修改成功！再次加载以查看");
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
    }

    @FXML
    void LoadInfoOnClcik(ActionEvent event) {
    	try {
            Class.forName(Main.driver);
            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
            Statement statement = con.createStatement();
            String sql = "select a_num, a_account, a_name, a_permission, sex, cur_bor, black_mark from account where a_num = '"+ Main.mainuser.getNum() +"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
            	Label_anum.setText(rs.getString("a_num"));
                Label_aacc.setText(rs.getString("a_account"));
                Label_aname.setText(rs.getString("a_name"));
                Label_apermission.setText(rs.getString("a_permission"));
                Label_sex.setText(rs.getString("sex"));
                Label_curbor.setText(rs.getString("cur_bor"));
                Label_BlackMark.setText(rs.getString("black_mark"));
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
		CheckBox_key.getItems().addAll("昵称", "性别", "密码");
		
	}

}

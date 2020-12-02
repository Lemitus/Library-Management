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

public class Controller_Register implements ControlledStage, Initializable {
	StageController myController;
	Connection con = Main.con;
    @FXML
    private TextField field_hint_ques;

    @FXML
    private TextField field_confirm_password;

    @FXML
    private Label label_error;

    @FXML
    private TextField field_niname;

    @FXML
    private TextField field_password;

    @FXML
    private TextField field_account;

    @FXML
    public ChoiceBox<String> field_sex;
    
    @FXML
    void ButtonRegisterOnClick(ActionEvent event) {
    	String tacc = field_account.getText();
    	String tpw = field_password.getText();
    	String tcpw = field_confirm_password.getText();
    	String tques = field_hint_ques.getText();
    	String tname = field_niname.getText();
    	String tsex = field_sex.getValue();
    	int rowCount=0;
        switch (tsex) {
		case "��":
			tsex = "ma";
			break;
		case "Ů":
			tsex = "fe";
		default:
			tsex = "de";
			break;
		}
        if(tacc.equals(""))
        	label_error.setText("�������û�����");
        else if(tpw.equals(""))
        	label_error.setText("���������룡");
        else if(tcpw.equals(""))
        	label_error.setText("���ٴ��������룡");
        else if(tname.equals(""))
        	label_error.setText("�������ǳƣ�");
        else{
        	try {
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();           	
                String sql = "select * from account where a_account ='" + tacc + "'";
                ResultSet rs = statement.executeQuery(sql);
                if(rs.first()){
                	label_error.setText("�Ѵ����û�����"+tacc);
                }
                else{
                	if(tpw.equals(tcpw)){
                		sql = "Select * from account";
                		rs = statement.executeQuery(sql);
                		rs.last();
                		rowCount = rs.getRow()+3;
                		sql = "INSERT INTO account " +"VALUES ('a" + rowCount+"', '" + tacc + "', '" +tpw+ "','"+tques+"', '"+
                		tname + "', 'READ', '" + tsex +"', null, 0, 15, 2)";
                		statement.executeUpdate(sql);
                		myController.getStage(Main.RegisterViewID).close();
                	}
                	else{
                		label_error.setText("������������벻һ��");
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
    	
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO �Զ����ɵķ������
		field_sex.getItems().addAll("��", "Ů", "����");
	}

	@Override
	public void setStageController(StageController stageController) {
		// TODO �Զ����ɵķ������
		this.myController = stageController;
	}

}

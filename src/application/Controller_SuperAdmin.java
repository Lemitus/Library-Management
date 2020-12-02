package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller_SuperAdmin implements Initializable, ControlledStage {
	StageController myController;
	Connection con = Main.con;
	ObservableList<Account> data =FXCollections.observableArrayList();

    @FXML
    private TableColumn<Account, String> TableColum3;

    @FXML
    private ChoiceBox<String> CheckBox_KeyWord;

    @FXML
    private TableColumn<Account, String> TableColum2;

    @FXML
    private TableColumn<Account, String> TableColum5;

    @FXML
    private TableColumn<Account, String> TableColum4;

    @FXML
    private TableColumn<Account, String> TableColum7;

    @FXML
    private TextField TextField_KeyWord;

    @FXML
    private TableColumn<Account, String> TableColum6;

    @FXML
    private TableColumn<Account, String> TableColum9;

    @FXML
    private TableColumn<Account, String> TableColum8;

    @FXML
    private TableColumn<Account, String> TableColum1;

    @FXML
    private TableColumn<Account, String> TableColum10;

    @FXML
    private TableColumn<Account, String> TableColum11;

    @FXML
    private TableView<Account> TableView_User;

    @FXML
    private TextField TextField_ANum;
    
    @FXML
    private ChoiceBox<String> CheckBox_SearchKey;
    
    @FXML
    private Label Label_Errortext;
    
    @FXML
    private TextField TextFieldText;
    
    @FXML
    void ReaderModeOnClick(ActionEvent event) {
    	myController.setStage(Main.ReaderViewID, Main.SuperAdminViewID);
    }

    @FXML
    void AdminModeOnClick(ActionEvent event) {
    	myController.setStage(Main.AdminViewID, Main.SuperAdminViewID);
    }

    
    @FXML
    void MenuItemAboutOnClick(ActionEvent event) {
    	myController.setStage(Main.AboutViewID);
    }

    @FXML
    void MenuItemLogOutOnClick(ActionEvent event) {
    	Main.mainuser.setName("");
    	Main.mainuser.setPassword("");
    	Main.mainuser.setPermission("");
    	Main.mainuser.setNum(""); 
    	myController.setStage(Main.LoginViewID, Main.SuperAdminViewID);
    }

    @FXML
    void MenuItemExitOnClick(ActionEvent event) {
    	System.exit(0);
    }
    

    @FXML
    void ChangeButtonOnClick(ActionEvent event) {
    	String key = CheckBox_SearchKey.getValue();
    	String acc = TextField_ANum.getText();
    	String text = TextFieldText.getText();
    	if(key == null)
    		key = "";
    	switch (key) {
		case "�û����":
			key = "a_num";
			break;
		case "�û���":
			key = "a_account";
			break;
		case "�û�����":
			key = "a_password";
			break;
		case "��ʾ����":
			key = "a_ques";
			break;
		case "�ǳ�":
			key = "a_name";
			break;
		case "�û�Ȩ��":
			key = "a_permission";
			break;
		case "�Ա�":
			key = "sex";
			break;
		case "������¼":
			key = "black_mark";
			break;
		case "��ǰ����":
			key = "cur_bor";
			break;
		case "��������":
			key = "bor_limit";
			break;
		case "ί������":
			key = "apply_limit";
			break;
		default:
			break;
		}
    	if(key.equals("")){
    		Label_Errortext.setText("��ѡ��һ���ؼ��֣�");
    	}
    	else if(acc.equals(""))
    		Label_Errortext.setText("�������û���ţ�");
    	else if(text.equals(""))
    		Label_Errortext.setText("�������޸����ݣ��ĳɿ����null��");
    	else{
    		try {
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "update account set " + key + "=" + "'"+ text + "' where a_num = '"+ acc +"'";
                statement.executeUpdate(sql);
                Label_Errortext.setText("�޸ĳɹ������������Բ鿴");
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
    void UserInfoOnClick(ActionEvent event) {
    	myController.setStage(Main.UserInfoViewID);
    }
    
    @FXML
    void SearchButtonOnClick(ActionEvent event) {  	
    	String key = CheckBox_KeyWord.getValue();
    	String text = TextField_KeyWord.getText();
    	if(key == null)
    		key = "";
    	switch (key) {
		case "�û����":
			try {
				data.clear();
	            Class.forName(Main.driver);
	            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
	            Statement statement = con.createStatement();
	            String sql = "select * from account where a_num = '" + text + "'";
	            ResultSet rs = statement.executeQuery(sql);
	            while(rs.next()){
	            	data.add(new Account(rs.getString("a_num"), rs.getString("a_account"), rs.getString("a_password"), 
	            			rs.getString("a_ques"), rs.getString("a_name"), rs.getString("a_permission"), rs.getString("sex"), 
	            			rs.getString("black_mark"), rs.getString("cur_bor"), rs.getString("bor_limit"), rs.getString("apply_limit")));
	            }
	            Label_Errortext.setText("");
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
			break;
		case "�û���":
			try {
				data.clear();
	            Class.forName(Main.driver);
	            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
	            Statement statement = con.createStatement();
	            String sql = "select * from account where a_account = '" + text + "'";
	            ResultSet rs = statement.executeQuery(sql);
	            while(rs.next()){
	            	data.add(new Account(rs.getString("a_num"), rs.getString("a_account"), rs.getString("a_password"), 
	            			rs.getString("a_ques"), rs.getString("a_name"), rs.getString("a_permission"), rs.getString("sex"), 
	            			rs.getString("black_mark"), rs.getString("cur_bor"), rs.getString("bor_limit"), rs.getString("apply_limit")));
	            }
	            Label_Errortext.setText("");
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
			break;
		case "�û�Ȩ��":
			try {
				data.clear();
	            Class.forName(Main.driver);
	            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
	            Statement statement = con.createStatement();
	            String sql = "select * from account where a_permission = '" + text + "'";
	            ResultSet rs = statement.executeQuery(sql);
	            while(rs.next()){
	            	data.add(new Account(rs.getString("a_num"), rs.getString("a_account"), rs.getString("a_password"), 
	            			rs.getString("a_ques"), rs.getString("a_name"), rs.getString("a_permission"), rs.getString("sex"), 
	            			rs.getString("black_mark"), rs.getString("cur_bor"), rs.getString("bor_limit"), rs.getString("apply_limit")));
	            }
	            Label_Errortext.setText("");
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
			break;
		case "��ǰ����":
			try {
				data.clear();
	            Class.forName(Main.driver);
	            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
	            Statement statement = con.createStatement();
	            String sql = "select * from account where cur_bor = '" + text + "'";
	            ResultSet rs = statement.executeQuery(sql);
	            while(rs.next()){
	            	data.add(new Account(rs.getString("a_num"), rs.getString("a_account"), rs.getString("a_password"), 
	            			rs.getString("a_ques"), rs.getString("a_name"), rs.getString("a_permission"), rs.getString("sex"), 
	            			rs.getString("black_mark"), rs.getString("cur_bor"), rs.getString("bor_limit"), rs.getString("apply_limit")));
	            }
	            Label_Errortext.setText("");
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
			break;
		case "ȫ��":
			try {
				data.clear();
	            Class.forName(Main.driver);
	            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
	            Statement statement = con.createStatement();
	            String sql = "select * from account";
	            ResultSet rs = statement.executeQuery(sql);
	            while(rs.next()){
	            	data.add(new Account(rs.getString("a_num"), rs.getString("a_account"), rs.getString("a_password"), 
	            			rs.getString("a_ques"), rs.getString("a_name"), rs.getString("a_permission"), rs.getString("sex"), 
	            			rs.getString("black_mark"), rs.getString("cur_bor"), rs.getString("bor_limit"), rs.getString("apply_limit")));
	            }
	            Label_Errortext.setText("");
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
			break;

		default:
			Label_Errortext.setText("��ѡ��һ���ؼ��֣�");
			break;
		}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO �Զ����ɵķ������
		CheckBox_KeyWord.getItems().addAll("�û����", "�û���", "�û�Ȩ��", "��ǰ����","ȫ��");
		CheckBox_SearchKey.getItems().addAll("�û����", "�û���", "�û�����", "��ʾ����", "�ǳ�", 
				"�û�Ȩ��", "�Ա�", "������¼", "��ǰ����", "��������", "ί������");
		
    	TableColum1.setCellValueFactory(new PropertyValueFactory<Account, String>("a_num"));
        TableColum2.setCellValueFactory(new PropertyValueFactory<Account, String>("a_account"));
        TableColum3.setCellValueFactory(new PropertyValueFactory<Account, String>("a_password"));
        TableColum4.setCellValueFactory(new PropertyValueFactory<Account, String>("a_ques"));
        TableColum5.setCellValueFactory(new PropertyValueFactory<Account, String>("a_name"));
        TableColum6.setCellValueFactory(new PropertyValueFactory<Account, String>("a_permission"));
        TableColum7.setCellValueFactory(new PropertyValueFactory<Account, String>("sex"));
        TableColum8.setCellValueFactory(new PropertyValueFactory<Account, String>("black_mark"));
        TableColum9.setCellValueFactory(new PropertyValueFactory<Account, String>("cur_bor"));
        TableColum10.setCellValueFactory(new PropertyValueFactory<Account, String>("bor_limit"));
        TableColum11.setCellValueFactory(new PropertyValueFactory<Account, String>("apply_limit"));       	
    	TableView_User.setItems(data);
    	try {
            Class.forName(Main.driver);
            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
            Statement statement = con.createStatement();
            String sql = "select * from account ";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
            	data.add(new Account(rs.getString("a_num"), rs.getString("a_account"), rs.getString("a_password"), 
            			rs.getString("a_ques"), rs.getString("a_name"), rs.getString("a_permission"), rs.getString("sex"), 
            			rs.getString("black_mark"), rs.getString("cur_bor"), rs.getString("bor_limit"), rs.getString("apply_limit")));
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
		// TODO �Զ����ɵķ������
		this.myController = stageController;
	}

}

package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class Controller_Admin implements Initializable, ControlledStage {
	StageController myController;
	Connection con = Main.con;
	ObservableList<Books> bookdata =FXCollections.observableArrayList();
    ObservableList<AdminYuyue> yuyuedata =FXCollections.observableArrayList();
    ObservableList<AdminBorrow> borrowdata =FXCollections.observableArrayList();
    ObservableList<AdminBlack> blackdata =FXCollections.observableArrayList();
    ObservableList<Account> userdata =FXCollections.observableArrayList();
	@FXML private TextField BorrowTextBookNum;
    @FXML private ChoiceBox<String> UserChoiceBoxSearch;
    @FXML private TableColumn<AdminBlack, String> BlackMarkColumn1;
    @FXML private TableColumn<Books, String> TableColumn5;
    @FXML private TableColumn<Books, String> TableColumn4;
    @FXML private TableColumn<Books, String> TableColumn7;
    @FXML private TableColumn<Books, String> TableColumn6;
    @FXML private TextField BookTextFieldBnum;
    @FXML private TableColumn<Books, String> TableColumn9;
    @FXML private TableColumn<Books, String> TableColumn8;
    @FXML private TableColumn<AdminBorrow, String> HistoryTableColumn6;
    @FXML private ChoiceBox<String> YuyueChoiceBoxSearch;
    @FXML private TableColumn<AdminBorrow, String> HistoryTableColumn7;
    @FXML private TableColumn<AdminBorrow, String> HistoryTableColumn4;
    @FXML private ChoiceBox<String> YuyueChoiceBoxResult;
    @FXML private TableColumn<AdminBorrow, String> HistoryTableColumn5;
    @FXML private TextField BlackTextText;
    @FXML private TableColumn<Books, String> TableColumn1;
    @FXML private TableColumn<AdminBorrow, String> HistoryTableColumn2;
    @FXML private TableColumn<AdminBorrow, String> HistoryTableColumn3;
    @FXML private TableColumn<Books, String> TableColumn3;
    @FXML private TableColumn<Books, String> TableColumn2;
    @FXML private TableColumn<AdminBorrow, String> HistoryTableColumn1;
    @FXML private TableColumn<AdminBlack, String> BlackMarkColumn4;
    @FXML private TextField UserTextFieldSearch;
    @FXML private TableColumn<AdminBlack, String> BlackMarkColumn5;
    @FXML private TableColumn<AdminBlack, String> BlackMarkColumn6;
    @FXML private TableColumn<AdminBlack, String> BlackMarkColumn2;
    @FXML private TableColumn<AdminBlack, String> BlackMarkColumn3;
    @FXML private TextField BlackTextSearch;
    @FXML private TextField BlackTextBlackNum;
    @FXML private TableColumn<AdminBorrow, String> HistoryTableColumn8;
    @FXML private TableColumn<AdminBorrow, String> HistoryTableColumn9;
    @FXML private TextField BooksTextFieldSearch;
    @FXML private ChoiceBox<String> BlackChoiceBoxText;
    @FXML private TextField UserTextFiedlAnum;
    @FXML private TextField YuyueTextAffairNum;
    @FXML private ChoiceBox<String> BooksChoiceBoxChange;
    @FXML private Label YuyueErrorText;
    @FXML private TableColumn<Books, String> TableColumn11;
    @FXML private TextField UserTextFieldText;
    @FXML private TableColumn<Books, String> TableColumn10;
    @FXML private Label BooksErrorText;
    @FXML private TextField BorrowTextFieldSearch;
    @FXML private Label BlackErrorText;
    @FXML private ChoiceBox<String> BorrowChoiceBoxSearch;
    @FXML private TableColumn<Account, String> UserTableColum3;
    @FXML private TableColumn<Account, String> UserTableColum4;
    @FXML private TableColumn<Account, String> UserTableColum1;
    @FXML private TableColumn<Account, String> UserTableColum2;
    @FXML private TableColumn<AdminYuyue, String> BookTableColumn2;
    @FXML private TextField BoorowTextAffairNum;
    @FXML private Label BorrowErrorText;
    @FXML private TableColumn<AdminYuyue, String> BookTableColumn1;
    @FXML private TableColumn<AdminYuyue, String> BookTableColumn8;
    @FXML private ChoiceBox<String> BooksChoiceBoxSearch;
    @FXML private TableColumn<AdminYuyue, String> BookTableColumn7;
    @FXML private TableColumn<AdminYuyue, String> BookTableColumn4;
    @FXML private TableColumn<AdminYuyue, String> BookTableColumn3;
    @FXML private TableColumn<AdminYuyue, String> BookTableColumn6;
    @FXML private TableColumn<AdminYuyue, String> BookTableColumn5;
    @FXML private TableColumn<Account, String> UserTableColum11;
    @FXML private TableColumn<Account, String> UserTableColum10;
    @FXML private TextField BoorowTextAnum;
    @FXML private ChoiceBox<String> BlackChoiceBoxSearch;
    @FXML private ChoiceBox<String> UserChoiceBoxChange;
    @FXML private TextField BooksTextFieldChange;
    @FXML private TableColumn<Account, String> UserTableColum7;
    @FXML private TableColumn<Account, String> UserTableColum8;
    @FXML private TableColumn<Account, String> UserTableColum5;
    @FXML private TableColumn<Account, String> UserTableColum6;
    @FXML private TextField YuyueTextSearch;
    @FXML private TableColumn<Account, String> UserTableColum9;
    @FXML private Label UserErrorText;
    @FXML private TableView<Account> UserTableview;
    @FXML private TableView<AdminBlack> BlackTableview;
    @FXML private TableView<AdminBorrow> BorrowTableview;
    @FXML private TableView<Books> BooksTableview;
    @FXML private TableView<AdminYuyue> YuyueTableview;
    @FXML
    void ReaderModeOnClick(ActionEvent event) {
    	myController.setStage(Main.ReaderViewID, Main.AdminViewID);
    }


    @FXML
    void SpuerAdminModeOnClick(ActionEvent event) {
    	if(Main.mainuser.getPermission().equals("SUPE"))
    		myController.setStage(Main.SuperAdminViewID, Main.AdminViewID);
    	else
    		myController.setStage(Main.ErrorViewID);
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
    	myController.setStage(Main.LoginViewID, Main.AdminViewID);
    }

    @FXML
    void MenuItemExitOnClick(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void UserInfoOnClick(ActionEvent event) {
    	myController.setStage(Main.UserInfoViewID);
    }
    @FXML
    void BooksSearchButtonOnClick(ActionEvent event) {
    	String key = BooksChoiceBoxSearch.getValue();
    	String text = BooksTextFieldSearch.getText();
    	if(key == null)
    		key = "";
    	switch (key) {
		case "ISBN":
			key = "isbn";
			break;
		case "����":
			key = "book_name";
			break;
		case "�������":
			key = "book_name_abbr";
			break;
		case "����":
			key = "writer_1";
			break;
		case "����":
			key = "classification";
			break;
		case "���ʱ��":
			key = "entry_time";
		case "���ڵ�":
			key = "in_place";
		case "�鱾���":
			key = "book_num";
		default:
			break;
		}
    	if(key.equals(""))
    		BooksErrorText.setText("��ѡ�� һ���ؼ��֣�");
    	else if(text.equals(""))
    		BooksErrorText.setText("�������������ݣ�");
    	else{
    		bookdata.clear();  		
    		try {
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select * from books where " + key + " ='" + text + "'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                	bookdata.add(new Books(rs.getString("book_num"), rs.getString("isbn"), rs.getString("book_name"),
                			rs.getString("book_name_abbr"), rs.getString("writer_1"), rs.getString("classification"),
                			rs.getString("info"), rs.getString("entry_time"), rs.getString("price"), rs.getString("in_place"),
                			rs.getString("bor_state")));
                }
                BooksErrorText.setText("");
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

    @FXML
    void BooksChangeButtonOnClick(ActionEvent event) {
    	String key = BooksChoiceBoxChange.getValue();
    	String text = BooksTextFieldChange.getText();
    	String bnum = BookTextFieldBnum.getText();
    	if(key == null)
    		key = "";
    	switch (key) {
		case "ISBN":
			key = "isbn";
			break;
		case "����":
			key = "book_name";
			break;
		case "�������":
			key = "book_name_abbr";
			break;
		case "����":
			key = "writer_1";
			break;
		case "����":
			key = "classification";
			break;
		case "���":
			key = "info";
			break;
		case "���ʱ��":
			key = "entry_time";
			break;
		case "����":
			key = "price";
			break;
		case "���ڵ�":
			key = "in_place";
			break;
		case "�������":
			key = "bor_state";
		case "����鱾":
			break;
		default:
			break;
		}
    	if(key.equals("")&&!(key.equals("����鱾")))
    		BooksErrorText.setText("��ѡ�� һ���ؼ��֣�");
    	else if(text.equals("")&&!(key.equals("����鱾")))
    		BooksErrorText.setText("�������޸����ݣ�");
    	else{  		
    		if(key.equals("����鱾")){
    			try {
    				String rowCount;
    				Date d = new Date();   
        	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        	        String date = sdf.format(d);
                    Class.forName(Main.driver);
                    con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                    Statement statement = con.createStatement();
                    String sql = "select * from books";
                    ResultSet rs = statement.executeQuery(sql);
            		rs.last();
            		rowCount = String.format("%05d", rs.getRow()+1);
                    sql = "insert into books values('b" + rowCount + "', '���༭', '���༭', '���༭', '���༭', '���༭', '��', '" + date +
                    		 "', 00.00, '���༭', '���༭')";
                    statement.executeUpdate(sql);
                    BooksErrorText.setText("��ӳɹ������������Բ鿴");
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
    		else{
    			try {
                    Class.forName(Main.driver);
                    con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                    Statement statement = con.createStatement();
                    String sql = "select * from books where book_num = '"+ bnum +"'";
                    ResultSet rs = statement.executeQuery(sql);
                    if(rs.next()){
                    	sql = "update books set " + key + "=" + "'"+ text + "' where book_num = '"+ bnum +"'";
                        statement.executeUpdate(sql);
                        BooksErrorText.setText("�޸ĳɹ������������Բ鿴");
                    }
                    else{
                    	BooksErrorText.setText("�鼮��Ų�����");
                    }
                    
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
    }

    @FXML
    void UserSearchButtonOnClick(ActionEvent event) {
    	String key = UserChoiceBoxSearch.getValue();
    	String text = UserTextFieldSearch.getText();   	
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
		case "ȫ��":
			break;
		default:
			break;
		}
    	if(key.equals("ȫ��")){
    		try {
	            Class.forName(Main.driver);
	            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
	            Statement statement = con.createStatement();
	            String sql = "select * from account";
	            ResultSet rs = statement.executeQuery(sql);
	            while(rs.next()){
	            	userdata.add(new Account(rs.getString("a_num"), rs.getString("a_account"), rs.getString("a_password"), 
	            			rs.getString("a_ques"), rs.getString("a_name"), rs.getString("a_permission"), rs.getString("sex"), 
	            			rs.getString("black_mark"), rs.getString("cur_bor"), rs.getString("bor_limit"), rs.getString("apply_limit")));
	            }
	            UserErrorText.setText("");
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
    	else if(key.equals(""))
    		UserErrorText.setText("��ѡ��ؼ���!");
    	else if(text.equals(""))
    		UserErrorText.setText("�������������ݣ�");
    	else{
    		try {
    			userdata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select * from account where  "+ key +" = '" + text + "'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                	userdata.add(new Account(rs.getString("a_num"), rs.getString("a_account"), rs.getString("a_password"), 
                			rs.getString("a_ques"), rs.getString("a_name"), rs.getString("a_permission"), rs.getString("sex"), 
                			rs.getString("black_mark"), rs.getString("cur_bor"), rs.getString("bor_limit"), rs.getString("apply_limit")));
                }
                UserErrorText.setText("");
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
    

    @FXML
    void UserChangeButtonOnClick(ActionEvent event) {
    	String key = UserChoiceBoxChange.getValue();
    	String acc = UserTextFiedlAnum.getText();
    	String text = UserTextFieldText.getText();
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
    		UserErrorText.setText("��ѡ��һ���ؼ��֣�");
    	}
    	else if(acc.equals(""))
    		UserErrorText.setText("�������û���ţ�");
    	else if(text.equals(""))
    		UserErrorText.setText("�������޸����ݣ��ĳɿ����null��");
    	else{
    		try {
    			userdata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "update account set " + key + "=" + "'"+ text + "' where a_num = '"+ acc +"'";
                statement.executeUpdate(sql);
                UserErrorText.setText("�޸ĳɹ������������Բ鿴");
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
    void BorrowSearchButtonOnClick(ActionEvent event) {
    	String key = BorrowChoiceBoxSearch.getValue();
    	String text = BorrowTextFieldSearch.getText();
    	if(key == null)
    		key = "";
    	switch (key) {
		case "������":
			key = "affair_num";
			break;
		case "�鱾���":
			key = "book_num";
			break;
		case "�û����":
			key = "a_num";
			break;
		case "����":
			key = "book_name";
			break;
		default:
			break;
		}
    	if(key.equals("ȫ��")){
    		try {
        		borrowdata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select affair_num, book_name,book_num, a_num, bor_time, bor_place, return_time, return_place, renew_times"
                		+ " from borrow_affair natural join books";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                	borrowdata.add(new AdminBorrow(rs.getString("affair_num"), rs.getString("book_name"), rs.getString("book_num"),
                			rs.getString("a_num"), rs.getString("bor_time"), rs.getString("bor_place"), rs.getString("return_time"),
                			rs.getString("return_place"), rs.getString("renew_times")));
                }
                BorrowErrorText.setText("");
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
    	else if(key.equals(""))
    		BorrowErrorText.setText("��ѡ��һ���ؼ��֣�");
    	else if(text.equals(""))
    		BorrowErrorText.setText("�������������ݣ�");
    	else{
    		try {
        		borrowdata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select affair_num, book_name,book_num, a_num, bor_time, bor_place, return_time, return_place, renew_times"
                		+ " from borrow_affair natural join books where " + key +"  ='" + text + "'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                	borrowdata.add(new AdminBorrow(rs.getString("affair_num"), rs.getString("book_name"), rs.getString("book_num"),
                			rs.getString("a_num"), rs.getString("bor_time"), rs.getString("bor_place"), rs.getString("return_time"),
                			rs.getString("return_place"), rs.getString("renew_times")));
                }
                BorrowErrorText.setText("");
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

    @FXML
    void BorrowLendButtonOnClick(ActionEvent event) {
    	try {
    		String bnum = BorrowTextBookNum.getText();
    		String anum = BoorowTextAnum.getText();
			String rowCount;
			Date d = new Date();   
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	        String date = sdf.format(d);
            Class.forName(Main.driver);
            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
            Statement statement = con.createStatement();
            String sql = "select * from borrow_affair";
            ResultSet rs = statement.executeQuery(sql);
    		rs.last();
    		rowCount = String.format("%05d", rs.getRow()+1);
            sql = "insert into borrow_affair values('bor" + rowCount + "','"+ bnum +"', '" + anum +"', '"+ date +"', '�ൺ��', "
            		+ "null, null, 0)";
            statement.executeUpdate(sql);
            BorrowErrorText.setText("����ɹ������������Բ鿴");
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
    void BorrowReturnButtonOnClcik(ActionEvent event) {
    	String text = BoorowTextAffairNum.getText();
    	if(text.equals(""))
    		BorrowErrorText.setText("�����������ţ�");
    	else{
    		try {
    			userdata.clear();
    			Date d = new Date();   
    	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    	        String date = sdf.format(d);
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select * from borrow_affair where affair_num = '"+ text+"'";
                ResultSet rs = statement.executeQuery(sql);
                if(rs.next()){
                	sql = "update borrow_affair set return_time = '" + date + "' where affair_num = '"+ text +"'";
                    statement.executeUpdate(sql);
                    sql = "update borrow_affair set return_place = '�ൺ��' where affair_num = '"+ text +"'";
                    statement.executeUpdate(sql);
                    BorrowErrorText.setText("�޸ĳɹ������������Բ鿴");
                }
                else
                	BorrowErrorText.setText("�����Ų����ڣ�");
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

    @FXML
    void YuyueSearchButtonOnClick(ActionEvent event) {
    	String key = YuyueChoiceBoxSearch.getValue();
    	String text = YuyueTextSearch.getText();
    	if(key == null)
    		key = "";
    	switch (key) {
		case "������":
			key = "affair_num";
			break;
		case "����":
			key = "book_name";
			break;
		case "�鱾���":
			key = "book_num";
			break;
		case "�û����":
			key = "a_num";
			break;
		case "�鼮���ڵ�":
			key = "in_place";
			break;
		default:
			break;
		}
    	if(key.equals("ȫ��")){
    		try {
    			yuyuedata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select affair_num, book_name, book_num, a_num, in_place, get_book_place, apply_time, check_state"
                		+ " from apply_record natural join books";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                	yuyuedata.add(new AdminYuyue(rs.getString("affair_num"), rs.getString("book_name"), rs.getString("book_num"),
                			rs.getString("a_num"), rs.getString("in_place"), rs.getString("get_book_place"),
                			rs.getString("apply_time"), rs.getString("check_state")));
                }
                YuyueErrorText.setText("");
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
    	else if(key.equals(""))
    		YuyueErrorText.setText("��ѡ��һ���ؼ��ʣ�");
    	else if(text.equals(""))
    		YuyueErrorText.setText("�������������ݣ�");
    	else{
    		try {
    			yuyuedata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select affair_num, book_name, book_num, a_num, in_place, get_book_place, apply_time, check_state"
                		+ " from apply_record natural join books where "+ key + " = '" + text + "'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                	yuyuedata.add(new AdminYuyue(rs.getString("affair_num"), rs.getString("book_name"), rs.getString("book_num"),
                			rs.getString("a_num"), rs.getString("in_place"), rs.getString("get_book_place"),
                			rs.getString("apply_time"), rs.getString("check_state")));
                }
                YuyueErrorText.setText("");
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

    @FXML
    void YuyueConfirmButtonOnClick(ActionEvent event) {
    	String key = YuyueChoiceBoxResult.getValue();
    	String text = YuyueTextAffairNum.getText();
    	if(key.equals("")){
    		YuyueErrorText.setText("��ѡ��һ���ؼ��֣�");
    	}
    	else if(text.equals(""))
    		YuyueErrorText.setText("�����������ţ�");
    	else{
    		try {
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select * from apply_record where affair_num = '" + text + "'";
                ResultSet rs = statement.executeQuery(sql);
                if(rs.next()){
                	sql = "update apply_record set check_state =" + "'"+ key + "' where affair_num = '"+ text +"'";
                    statement.executeUpdate(sql);
                    YuyueErrorText.setText("��˳ɹ������������Բ鿴");
                }
                else
                	YuyueErrorText.setText("�����Ų����ڣ�");             
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
    void BlackSearchButtonOnClick(ActionEvent event) {
    	String key = BlackChoiceBoxSearch.getValue();
    	String text = BlackTextSearch.getText();
    	if(key == null)
    		key = "";
    	if(key.equals("ȫ��")){
    		try {
        		blackdata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select black_mark_num, affair_num, book_num, a_num, detail, fines from (black_mark natural join commit)"
                		+ "natural join borrow_affair";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                	blackdata.add(new AdminBlack(rs.getString("black_mark_num"), rs.getString("affair_num"), rs.getString("book_num"), rs.getString("a_num"), 
                			rs.getString("detail"), rs.getString("fines")));
                }
                BlackErrorText.setText("");
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
    	else if(key.equals(""))
    		BlackErrorText.setText("��ѡ��һ���ؼ��֣�");
    	else if(text.equals(""))
    		BlackErrorText.setText("�������������ݣ�");
    	else{
    		switch (key) {
			case "����������":
				key = "black_mark_num";
				break;
			case "�鱾���":
				key = "book_num";
				break;
			case "�û����":
				key = "a_num";
				break;
			default:
				break;
			}
    		try {
        		blackdata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select black_mark_num, affair_num, book_num , a_num, detail, fines from (black_mark natural join commit)"
                		+ "natural join borrow_affair where " + key + " ='" + text + "'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                	blackdata.add(new AdminBlack(rs.getString("black_mark_num"), rs.getString("affair_num"), rs.getString("book_num"), 
                			rs.getString("a_num"), rs.getString("detail"), rs.getString("fines")));
                }
                BlackErrorText.setText("");
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

    @FXML
    void BlackChangeButtonOnClick(ActionEvent event) {
    	String key = BlackChoiceBoxText.getValue();
    	String text = BlackTextText.getText();
    	String bnum = BlackTextBlackNum.getText();
    	if(key == null)
    		key = "";
    	switch (key) {
		case "����������":
			key = "affair_num";
			break;
		case "�鱾���":
			key = "book_num";
			break;
		case "�û����":
			key = "a_num";
			break;
		case "��¼����":
			key = "detail";
			break;
		case "����":
			key = "fines";
			break;
		case "�����Ŀ":
			break;
		default:
			break;
		}
    	if(key.equals("")&&!(key.equals("�����Ŀ")))
    		BlackErrorText.setText("��ѡ�� һ���ؼ��֣�");
    	else if(text.equals("")&&!(key.equals("�����Ŀ")))
    		BlackErrorText.setText("�������޸����ݣ�");
    	else{  		
    		if(key.equals("�����Ŀ")){
    			if(text.equals(""))
    				BlackErrorText.setText("�������û���ţ�");
    			else{
    				try {
        				String rowCount;
                        Class.forName(Main.driver);
                        con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                        Statement statement = con.createStatement();
                        String sql = "select * from books";
                        ResultSet rs = statement.executeQuery(sql);
                		rs.last();
                		rowCount = String.format("%05d", rs.getRow()+1);
                        sql = "insert into black_mark values('bm" + rowCount + "', '" + bnum +"', '���༭', 00.00)";
                        statement.executeUpdate(sql);
                        sql = "insert into commit values('bm" + rowCount + "', '" + text + "')";
                        statement.executeUpdate(sql);
                        BlackErrorText.setText("��ӳɹ������������Բ鿴");
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
    		else{
    			try {
                    Class.forName(Main.driver);
                    con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                    Statement statement = con.createStatement();
                    String sql = "select * from black_mark where black_mark_num = '"+ bnum +"'";
                    ResultSet rs = statement.executeQuery(sql);
                    if(rs.next()){
                    	sql = "update black_mark set " + key + "=" + "'"+ text + "' where black_mark_num = '"+ bnum +"'";
                        statement.executeUpdate(sql);
                        BlackErrorText.setText("�޸ĳɹ������������Բ鿴");
                    }
                    else{
                    	BlackErrorText.setText("���������Ų�����");
                    }
                    
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
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO �Զ����ɵķ������
		BooksChoiceBoxSearch.getItems().addAll("ISBN","����", "�������", "����", "����", "���ʱ��", "�鱾���", "���ڵ�");
		BooksChoiceBoxChange.getItems().addAll("ISBN", "����", "����", "�������", "����", "���", "���ʱ��", "����", "���ڵ�", "�������", "����鱾");
		UserChoiceBoxSearch.getItems().addAll("�û����", "�û���", "�û�Ȩ��", "��ǰ����","ȫ��");
		UserChoiceBoxChange.getItems().addAll("�û����", "�û���", "�û�����", "��ʾ����", "�ǳ�", 
				 "�Ա�", "������¼", "��ǰ����", "��������", "ί������");
		BorrowChoiceBoxSearch.getItems().addAll("�鱾���", "����", "�û����", "������", "ȫ��");
		YuyueChoiceBoxSearch.getItems().addAll("������", "����", "�鱾���", "�û����", "�鼮���ڵ�", "ȫ��");
		YuyueChoiceBoxResult.getItems().addAll("�����", "�����", "���ͨ��", "ԤԼʧ��");
		BlackChoiceBoxSearch.getItems().addAll("������¼���", "�鱾���", "�û����", "ȫ��");
		BlackChoiceBoxText.getItems().addAll("����������", "�鱾���", "�û����", "��¼����", "����", "�����Ŀ");
		TableColumn1.setCellValueFactory(new PropertyValueFactory<Books, String>("booknum"));
		TableColumn2.setCellValueFactory(new PropertyValueFactory<Books, String>("isbn"));
		TableColumn3.setCellValueFactory(new PropertyValueFactory<Books, String>("bookname"));
		TableColumn4.setCellValueFactory(new PropertyValueFactory<Books, String>("bookabb"));
		TableColumn5.setCellValueFactory(new PropertyValueFactory<Books, String>("bookwriter"));
		TableColumn6.setCellValueFactory(new PropertyValueFactory<Books, String>("bookclass"));
		TableColumn7.setCellValueFactory(new PropertyValueFactory<Books, String>("bookinfo"));
		TableColumn8.setCellValueFactory(new PropertyValueFactory<Books, String>("bookintime"));
		TableColumn9.setCellValueFactory(new PropertyValueFactory<Books, String>("bookprice"));
		TableColumn10.setCellValueFactory(new PropertyValueFactory<Books, String>("bookplace"));
		TableColumn11.setCellValueFactory(new PropertyValueFactory<Books, String>("borstate"));
		BookTableColumn1.setCellValueFactory(new PropertyValueFactory<AdminYuyue, String>("affairnum"));
		BookTableColumn2.setCellValueFactory(new PropertyValueFactory<AdminYuyue, String>("bookname"));
		BookTableColumn3.setCellValueFactory(new PropertyValueFactory<AdminYuyue, String>("booknum"));
		BookTableColumn4.setCellValueFactory(new PropertyValueFactory<AdminYuyue, String>("anum"));
		BookTableColumn5.setCellValueFactory(new PropertyValueFactory<AdminYuyue, String>("bookplace"));
		BookTableColumn6.setCellValueFactory(new PropertyValueFactory<AdminYuyue, String>("takeplace"));
		BookTableColumn7.setCellValueFactory(new PropertyValueFactory<AdminYuyue, String>("applytime"));
		BookTableColumn8.setCellValueFactory(new PropertyValueFactory<AdminYuyue, String>("checkstate"));
		HistoryTableColumn1.setCellValueFactory(new PropertyValueFactory<AdminBorrow, String>("affairnum"));
		HistoryTableColumn2.setCellValueFactory(new PropertyValueFactory<AdminBorrow, String>("bookname"));
		HistoryTableColumn3.setCellValueFactory(new PropertyValueFactory<AdminBorrow, String>("booknum"));
		HistoryTableColumn4.setCellValueFactory(new PropertyValueFactory<AdminBorrow, String>("anum"));
		HistoryTableColumn5.setCellValueFactory(new PropertyValueFactory<AdminBorrow, String>("borrowtime"));
		HistoryTableColumn6.setCellValueFactory(new PropertyValueFactory<AdminBorrow, String>("borrowplace"));
		HistoryTableColumn7.setCellValueFactory(new PropertyValueFactory<AdminBorrow, String>("returntime"));
		HistoryTableColumn8.setCellValueFactory(new PropertyValueFactory<AdminBorrow, String>("returnplace"));
		HistoryTableColumn9.setCellValueFactory(new PropertyValueFactory<AdminBorrow, String>("renewtimes"));
		BlackMarkColumn1.setCellValueFactory(new PropertyValueFactory<AdminBlack, String>("blackmarknum"));
		BlackMarkColumn2.setCellValueFactory(new PropertyValueFactory<AdminBlack, String>("bornum"));
		BlackMarkColumn3.setCellValueFactory(new PropertyValueFactory<AdminBlack, String>("booknum"));
		BlackMarkColumn4.setCellValueFactory(new PropertyValueFactory<AdminBlack, String>("anum"));
		BlackMarkColumn5.setCellValueFactory(new PropertyValueFactory<AdminBlack, String>("blackmarkcon"));
		BlackMarkColumn6.setCellValueFactory(new PropertyValueFactory<AdminBlack, String>("fines"));
		UserTableColum1.setCellValueFactory(new PropertyValueFactory<Account, String>("a_num"));
		UserTableColum2.setCellValueFactory(new PropertyValueFactory<Account, String>("a_account"));
		UserTableColum3.setCellValueFactory(new PropertyValueFactory<Account, String>("a_password"));
		UserTableColum4.setCellValueFactory(new PropertyValueFactory<Account, String>("a_ques"));
		UserTableColum5.setCellValueFactory(new PropertyValueFactory<Account, String>("a_name"));
		UserTableColum6.setCellValueFactory(new PropertyValueFactory<Account, String>("a_permission"));
		UserTableColum7.setCellValueFactory(new PropertyValueFactory<Account, String>("sex"));
		UserTableColum8.setCellValueFactory(new PropertyValueFactory<Account, String>("black_mark"));
		UserTableColum9.setCellValueFactory(new PropertyValueFactory<Account, String>("cur_bor"));
		UserTableColum10.setCellValueFactory(new PropertyValueFactory<Account, String>("bor_limit"));
		UserTableColum11.setCellValueFactory(new PropertyValueFactory<Account, String>("apply_limit"));
		BooksTableview.setItems(bookdata);
		YuyueTableview.setItems(yuyuedata);
		BlackTableview.setItems(blackdata);
		UserTableview.setItems(userdata);
		BorrowTableview.setItems(borrowdata);
		
	}

	@Override
	public void setStageController(StageController stageController) {
		// TODO �Զ����ɵķ������
		this.myController = stageController;
	}

}

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
		case "书名":
			key = "book_name";
			break;
		case "书名简称":
			key = "book_name_abbr";
			break;
		case "作者":
			key = "writer_1";
			break;
		case "分类":
			key = "classification";
			break;
		case "入库时间":
			key = "entry_time";
		case "所在地":
			key = "in_place";
		case "书本编号":
			key = "book_num";
		default:
			break;
		}
    	if(key.equals(""))
    		BooksErrorText.setText("请选择 一个关键字！");
    	else if(text.equals(""))
    		BooksErrorText.setText("请输入搜索内容！");
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
		case "书名":
			key = "book_name";
			break;
		case "书名简称":
			key = "book_name_abbr";
			break;
		case "作者":
			key = "writer_1";
			break;
		case "分类":
			key = "classification";
			break;
		case "简介":
			key = "info";
			break;
		case "入库时间":
			key = "entry_time";
			break;
		case "单价":
			key = "price";
			break;
		case "所在地":
			key = "in_place";
			break;
		case "借阅情况":
			key = "bor_state";
		case "添加书本":
			break;
		default:
			break;
		}
    	if(key.equals("")&&!(key.equals("添加书本")))
    		BooksErrorText.setText("请选择 一个关键字！");
    	else if(text.equals("")&&!(key.equals("添加书本")))
    		BooksErrorText.setText("请输入修改内容！");
    	else{  		
    		if(key.equals("添加书本")){
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
                    sql = "insert into books values('b" + rowCount + "', '待编辑', '待编辑', '待编辑', '待编辑', '待编辑', '无', '" + date +
                    		 "', 00.00, '待编辑', '待编辑')";
                    statement.executeUpdate(sql);
                    BooksErrorText.setText("添加成功！重新搜索以查看");
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
                        BooksErrorText.setText("修改成功！重新搜索以查看");
                    }
                    else{
                    	BooksErrorText.setText("书籍编号不存在");
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
		case "用户编号":
			key = "a_num";
			break;
		case "用户名":
			key = "a_account";
			break;
		case "用户密码":
			key = "a_password";
			break;
		case "提示问题":
			key = "a_ques";
			break;
		case "昵称":
			key = "a_name";
			break;
		case "用户权限":
			key = "a_permission";
			break;
		case "性别":
			key = "sex";
			break;
		case "不良记录":
			key = "black_mark";
			break;
		case "当前借阅":
			key = "cur_bor";
			break;
		case "借阅上限":
			key = "bor_limit";
			break;
		case "委托上限":
			key = "apply_limit";
			break;
		case "全部":
			break;
		default:
			break;
		}
    	if(key.equals("全部")){
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
    		UserErrorText.setText("请选择关键字!");
    	else if(text.equals(""))
    		UserErrorText.setText("请输入搜索内容！");
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
		case "用户编号":
			key = "a_num";
			break;
		case "用户名":
			key = "a_account";
			break;
		case "用户密码":
			key = "a_password";
			break;
		case "提示问题":
			key = "a_ques";
			break;
		case "昵称":
			key = "a_name";
			break;
		case "性别":
			key = "sex";
			break;
		case "不良记录":
			key = "black_mark";
			break;
		case "当前借阅":
			key = "cur_bor";
			break;
		case "借阅上限":
			key = "bor_limit";
			break;
		case "委托上限":
			key = "apply_limit";
			break;
		default:
			break;
		}   	
    	if(key.equals("")){
    		UserErrorText.setText("请选择一个关键字！");
    	}
    	else if(acc.equals(""))
    		UserErrorText.setText("请输入用户编号！");
    	else if(text.equals(""))
    		UserErrorText.setText("请输入修改内容，改成空请填“null”");
    	else{
    		try {
    			userdata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "update account set " + key + "=" + "'"+ text + "' where a_num = '"+ acc +"'";
                statement.executeUpdate(sql);
                UserErrorText.setText("修改成功！重新搜索以查看");
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
		case "事务编号":
			key = "affair_num";
			break;
		case "书本编号":
			key = "book_num";
			break;
		case "用户编号":
			key = "a_num";
			break;
		case "书名":
			key = "book_name";
			break;
		default:
			break;
		}
    	if(key.equals("全部")){
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
    		BorrowErrorText.setText("请选择一个关键字！");
    	else if(text.equals(""))
    		BorrowErrorText.setText("请输入搜索内容！");
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
            sql = "insert into borrow_affair values('bor" + rowCount + "','"+ bnum +"', '" + anum +"', '"+ date +"', '青岛馆', "
            		+ "null, null, 0)";
            statement.executeUpdate(sql);
            BorrowErrorText.setText("借书成功！重新搜索以查看");
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
    		BorrowErrorText.setText("请输入事务编号！");
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
                    sql = "update borrow_affair set return_place = '青岛馆' where affair_num = '"+ text +"'";
                    statement.executeUpdate(sql);
                    BorrowErrorText.setText("修改成功！重新搜索以查看");
                }
                else
                	BorrowErrorText.setText("事务编号不存在！");
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
		case "事务编号":
			key = "affair_num";
			break;
		case "书名":
			key = "book_name";
			break;
		case "书本编号":
			key = "book_num";
			break;
		case "用户编号":
			key = "a_num";
			break;
		case "书籍现在地":
			key = "in_place";
			break;
		default:
			break;
		}
    	if(key.equals("全部")){
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
    		YuyueErrorText.setText("请选择一个关键词！");
    	else if(text.equals(""))
    		YuyueErrorText.setText("请输入搜索内容！");
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
    		YuyueErrorText.setText("请选择一个关键字！");
    	}
    	else if(text.equals(""))
    		YuyueErrorText.setText("请输入事务编号！");
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
                    YuyueErrorText.setText("审核成功！重新搜索以查看");
                }
                else
                	YuyueErrorText.setText("事务编号不存在！");             
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
    	if(key.equals("全部")){
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
    		BlackErrorText.setText("请选择一个关键字！");
    	else if(text.equals(""))
    		BlackErrorText.setText("请输入搜索内容！");
    	else{
    		switch (key) {
			case "不良事务编号":
				key = "black_mark_num";
				break;
			case "书本编号":
				key = "book_num";
				break;
			case "用户编号":
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
		case "借阅事务编号":
			key = "affair_num";
			break;
		case "书本编号":
			key = "book_num";
			break;
		case "用户编号":
			key = "a_num";
			break;
		case "记录内容":
			key = "detail";
			break;
		case "罚款":
			key = "fines";
			break;
		case "添加条目":
			break;
		default:
			break;
		}
    	if(key.equals("")&&!(key.equals("添加条目")))
    		BlackErrorText.setText("请选择 一个关键字！");
    	else if(text.equals("")&&!(key.equals("添加条目")))
    		BlackErrorText.setText("请输入修改内容！");
    	else{  		
    		if(key.equals("添加条目")){
    			if(text.equals(""))
    				BlackErrorText.setText("请输入用户编号！");
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
                        sql = "insert into black_mark values('bm" + rowCount + "', '" + bnum +"', '待编辑', 00.00)";
                        statement.executeUpdate(sql);
                        sql = "insert into commit values('bm" + rowCount + "', '" + text + "')";
                        statement.executeUpdate(sql);
                        BlackErrorText.setText("添加成功！重新搜索以查看");
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
                        BlackErrorText.setText("修改成功！重新搜索以查看");
                    }
                    else{
                    	BlackErrorText.setText("不良事务编号不存在");
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
		// TODO 自动生成的方法存根
		BooksChoiceBoxSearch.getItems().addAll("ISBN","书名", "书名简称", "作者", "分类", "入库时间", "书本编号", "所在地");
		BooksChoiceBoxChange.getItems().addAll("ISBN", "书名", "作者", "书名简称", "分类", "简介", "入库时间", "单价", "所在地", "借阅情况", "添加书本");
		UserChoiceBoxSearch.getItems().addAll("用户编号", "用户名", "用户权限", "当前借阅","全部");
		UserChoiceBoxChange.getItems().addAll("用户编号", "用户名", "用户密码", "提示问题", "昵称", 
				 "性别", "不良记录", "当前借阅", "借阅上限", "委托上限");
		BorrowChoiceBoxSearch.getItems().addAll("书本编号", "书名", "用户编号", "事务编号", "全部");
		YuyueChoiceBoxSearch.getItems().addAll("事务编号", "书名", "书本编号", "用户编号", "书籍现在地", "全部");
		YuyueChoiceBoxResult.getItems().addAll("待审核", "审核中", "审核通过", "预约失败");
		BlackChoiceBoxSearch.getItems().addAll("不良记录编号", "书本编号", "用户编号", "全部");
		BlackChoiceBoxText.getItems().addAll("借阅事务编号", "书本编号", "用户编号", "记录内容", "罚款", "添加条目");
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
		// TODO 自动生成的方法存根
		this.myController = stageController;
	}

}

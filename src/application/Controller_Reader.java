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

public class Controller_Reader implements Initializable, ControlledStage {
	StageController myController;
	Connection con = Main.con;
	    @FXML private TableColumn<Books, String> TableColumn10;
	    @FXML private TableColumn<BlackMark, String> BlackMarkColumn1;
	    @FXML private TableColumn<Books, String> TableColumn5;
	    @FXML private TableColumn<Books, String> TableColumn4;
	    @FXML private TableColumn<Books, String> TableColumn7;
	    @FXML private TableColumn<Books, String> TableColumn6;
	    @FXML private TableColumn<Books, String> TableColumn9;
	    @FXML private TableColumn<Books, String> TableColumn8;
	    @FXML private TableColumn<Books, String> TableColumn11;
	    @FXML private TextField SearchTextFieldText;
	    @FXML private TableColumn<Borrow, String> HistoryTableColumn6;
	    @FXML private TableColumn<Bookyuyue, String> BookTableColumn2;
	    @FXML private TableColumn<Borrow, String> HistoryTableColumn4;
	    @FXML private TableColumn<Bookyuyue, String> BookTableColumn1;
	    @FXML private TableColumn<Borrow, String> HistoryTableColumn5;
	    @FXML private TableColumn<Books, String> TableColumn1;
	    @FXML private TableColumn<Borrow, String> HistoryTableColumn2;
	    @FXML private TableColumn<Borrow, String> HistoryTableColumn3;
	    @FXML private TableColumn<Books, String> TableColumn3;
	    @FXML private ChoiceBox<String> SearchChexkBoxKey;
	    @FXML private TableColumn<Books, String> TableColumn2;
	    @FXML private TableColumn<Borrow, String> HistoryTableColumn1;
	    @FXML private TableColumn<Borrow, String> HistoryTableColumn7;
	    @FXML private TableColumn<BlackMark, String> BlackMarkColumn2;
	    @FXML private TableColumn<BlackMark, String> BlackMarkColumn3;
	    @FXML private TableColumn<Bookyuyue, String> BookTableColumn4;
	    @FXML private TableColumn<Bookyuyue, String> BookTableColumn3;
	    @FXML private TableColumn<Bookyuyue, String> BookTableColumn6;
	    @FXML private TableColumn<Bookyuyue, String> BookTableColumn5;
	    @FXML private TextField BookTextFieldBNum;
	    @FXML private ChoiceBox<String> Book_CheckBoxPlace;
	    @FXML private TableView<Borrow> HistoryTableView;
	    @FXML private TableView<BlackMark> BlackMarkView;
	    @FXML private TableView<Bookyuyue> YuyueTableView;
	    @FXML private TableView<Books> BookTableView;
	    @FXML private Label YuyueErrorText;
	    @FXML private Label SearchErrortext;
	    ObservableList<Books> bookdata =FXCollections.observableArrayList();
	    ObservableList<Bookyuyue> yuyuedata =FXCollections.observableArrayList();
	    ObservableList<Borrow> borrowdata =FXCollections.observableArrayList();
	    ObservableList<BlackMark> blackdata =FXCollections.observableArrayList();


    @FXML
    void AdminModeOnClick(ActionEvent event) {
    	if(Main.mainuser.getPermission().equals("SUPE")||Main.mainuser.getPermission().equals("ADMI"))
    		myController.setStage(Main.AdminViewID, Main.ReaderViewID);
    	else
    		myController.setStage(Main.ErrorViewID);
    }

    @FXML
    void SpuerAdminModeOnClick(ActionEvent event) {
    	if(Main.mainuser.getPermission().equals("SUPE"))
    		myController.setStage(Main.SuperAdminViewID, Main.ReaderViewID);
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
    	myController.setStage(Main.LoginViewID, Main.ReaderViewID);
    }
    
    @FXML
    void UserInfoOnClick(ActionEvent event) {
    	myController.setStage(Main.UserInfoViewID);
    }

    @FXML
    void MenuItemExitOnClick(ActionEvent event) {
    	System.exit(0);
    }
    

    @FXML
    void Search_SearchButtonOnClick(ActionEvent event) {
    	String key = SearchChexkBoxKey.getValue();
    	String text = SearchTextFieldText.getText();
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

		default:
			break;
		}
    	if(key.equals(""))
    		SearchErrortext.setText("请选择 一个关键字！");
    	else if(text.equals(""))
    		SearchErrortext.setText("请输入搜索内容！");
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
                SearchErrortext.setText("");
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
    void Book_BookButtonOnClick(ActionEvent event) {
    	String bnum = BookTextFieldBNum.getText();
    	String place = Book_CheckBoxPlace.getValue();
    	if(place == null)
    		place = "";
    	if(bnum.equals(""))
    		YuyueErrorText.setText("请输入书籍编号！");
    	else if(place.equals(""))
    		YuyueErrorText.setText("请选择取书地点！");
    	else{
    		try {
    			String rowCount;
    			String in_place;
    			Date d = new Date();   
    	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
    	        String date = sdf.format(d);  
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select * from apply_record";
                ResultSet rs = statement.executeQuery(sql);
        		rs.last();
        		rowCount = String.format("%05d", rs.getRow()+1);
        		sql = "select in_place from books where book_num = '" + bnum + "'";
        		rs = statement.executeQuery(sql);
        		if(rs.next()){
        			in_place = rs.getString("in_place");
                    sql = "INSERT INTO apply_record " +"VALUES ('apply" + rowCount+"', '" + bnum + "', '"+ Main.mainuser.getNum()
                    +"','"+in_place+ "','"+place+"', '"+date + "', '待审核')";
                    statement.executeUpdate(sql);
                    YuyueErrorText.setText("预约成功，重新查询以查看！");
        		}
        		else
        			YuyueErrorText.setText("书籍编号不存在！");
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
    void Book_BookSearchOnClick(ActionEvent event) {
    	String bnum = BookTextFieldBNum.getText();
    	String place = Book_CheckBoxPlace.getValue();
    	if(place == null)
    		place = "";
    	if(bnum.equals(""))
    		YuyueErrorText.setText("请输入书籍编号！");
    	else{
    		try {
    			yuyuedata.clear();
                Class.forName(Main.driver);
                con = DriverManager.getConnection(Main.url,Main.user,Main.password);
                Statement statement = con.createStatement();
                String sql = "select affair_num, book_name, in_place, get_book_place, apply_time, check_state"
                		+ " from books natural join apply_record where book_num = '" + bnum + "'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                	yuyuedata.add(new Bookyuyue(rs.getString("affair_num"), rs.getString("book_name"), rs.getString("in_place"),
                			rs.getString("get_book_place"), rs.getString("apply_time"), rs.getString("check_state")));
                }
                SearchErrortext.setText("");
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
    void HistoryButtonOnClick(ActionEvent event) {	
    	try {
    		borrowdata.clear();
            Class.forName(Main.driver);
            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
            Statement statement = con.createStatement();
            String sql = "select affair_num, book_name, bor_time, bor_place, return_time, return_place, renew_times"
            		+ " from borrow_affair natural join books where a_num ='" + Main.mainuser.getNum() + "'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
            	borrowdata.add(new Borrow(rs.getString("affair_num"), rs.getString("book_name"), rs.getString("bor_time"), 
            			rs.getString("bor_place"), rs.getString("return_time"), rs.getString("return_place"), rs.getString("renew_times")));
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
    void BlackMarkButtonOnClick(ActionEvent event) {
    	try {
    		blackdata.clear();
            Class.forName(Main.driver);
            con = DriverManager.getConnection(Main.url,Main.user,Main.password);
            Statement statement = con.createStatement();
            String sql = "select black_mark_num, detail, fines from black_mark natural join commit "
            		+ "where a_num ='" + Main.mainuser.getNum() + "'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
            	blackdata.add(new BlackMark(rs.getString("black_mark_num"), rs.getString("detail"), rs.getString("fines")));
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
	public void initialize(URL location, ResourceBundle resources) {
		// TODO 自动生成的方法存根
		SearchChexkBoxKey.getItems().addAll("ISBN","书名", "书名简称", "作者", "分类");
		Book_CheckBoxPlace.getItems().addAll("青岛馆", "文理图书馆", "蒋震图书馆");
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
		BookTableColumn1.setCellValueFactory(new PropertyValueFactory<Bookyuyue, String>("affairnum"));
		BookTableColumn2.setCellValueFactory(new PropertyValueFactory<Bookyuyue, String>("bookname"));
		BookTableColumn3.setCellValueFactory(new PropertyValueFactory<Bookyuyue, String>("bookplace"));
		BookTableColumn4.setCellValueFactory(new PropertyValueFactory<Bookyuyue, String>("takeplace"));
		BookTableColumn5.setCellValueFactory(new PropertyValueFactory<Bookyuyue, String>("applytime"));
		BookTableColumn6.setCellValueFactory(new PropertyValueFactory<Bookyuyue, String>("checkstate"));
		HistoryTableColumn1.setCellValueFactory(new PropertyValueFactory<Borrow, String>("affairnum"));
		HistoryTableColumn2.setCellValueFactory(new PropertyValueFactory<Borrow, String>("bookname"));
		HistoryTableColumn3.setCellValueFactory(new PropertyValueFactory<Borrow, String>("borrowtime"));
		HistoryTableColumn4.setCellValueFactory(new PropertyValueFactory<Borrow, String>("borrowplace"));
		HistoryTableColumn5.setCellValueFactory(new PropertyValueFactory<Borrow, String>("returntime"));
		HistoryTableColumn6.setCellValueFactory(new PropertyValueFactory<Borrow, String>("returnplace"));
		HistoryTableColumn7.setCellValueFactory(new PropertyValueFactory<Borrow, String>("renewtimes"));
		BlackMarkColumn1.setCellValueFactory(new PropertyValueFactory<BlackMark, String>("blackmarknum"));
		BlackMarkColumn2.setCellValueFactory(new PropertyValueFactory<BlackMark, String>("blackmarkcon"));
		BlackMarkColumn3.setCellValueFactory(new PropertyValueFactory<BlackMark, String>("fines"));
		BookTableView.setItems(bookdata);
		HistoryTableView.setItems(borrowdata);
		YuyueTableView.setItems(yuyuedata);
		BlackMarkView.setItems(blackdata);
	}

	@Override
	public void setStageController(StageController stageController) {
		// TODO 自动生成的方法存根
		this.myController = stageController;
	}

}

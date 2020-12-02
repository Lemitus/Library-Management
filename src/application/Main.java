package application;

import java.sql.Connection;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static String LoginViewID = "Login_View";
    public static String LoginViewRes = "/application/Login_view.fxml";
	public static String ReaderViewID = "Reader_View";
    public static String ReaderViewRes = "/application/Reader_view.fxml";
	public static String AdminViewID = "Admin_View";
    public static String AdminViewRes = "/application/Admin_view.fxml";
	public static String SuperAdminViewID = "Super_Admin_View";
    public static String SuperAdminViewRes = "/application/Super_admin_view.fxml";
    public static String RegisterViewID = "Register_View";
    public static String RegisterViewRes = "/application/Register_View.fxml";
    public static String ForgetViewID = "Forget_View";
    public static String ForgetViewRes = "/application/Forget_View.fxml";
    public static String AboutViewID = "About_view";
    public static String AboutViewRes = "/application/About_View.fxml";
    public static String UserInfoViewID = "UserInfo_View";
    public static String UserInfoViewRes = "/application/User_Info.fxml";
    public static String ErrorViewID = "Error_View";
    public static String ErrorViewRes = "/application/ErrorView.fxml";
    
    private StageController stageController;
    public static User mainuser;
    
    public static Connection con;
    public static String driver = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/library?&useSSL=true";
    public static String user = "root";
    public static String password = "971229";
    
    public User guest;
    
    @Override
    public void start(Stage primaryStage) {
        //新建一个StageController控制器
        stageController = new StageController();
        mainuser = new User();
        //将主舞台交给控制器处理
        stageController.setPrimaryStage("primaryStage", primaryStage);

        //加载两个舞台，每个界面一个舞台
        stageController.loadStage(LoginViewID, LoginViewRes);
        stageController.loadStage(ReaderViewID, ReaderViewRes);
        stageController.loadStage(AdminViewID, AdminViewRes);
        stageController.loadStage(SuperAdminViewID, SuperAdminViewRes);
        stageController.loadStage(RegisterViewID, RegisterViewRes);
        stageController.loadStage(ForgetViewID, ForgetViewRes);
        stageController.loadStage(AboutViewID, AboutViewRes);  
        stageController.loadStage(UserInfoViewID, UserInfoViewRes);
        stageController.loadStage(ErrorViewID, ErrorViewRes);
        stageController.getStage(LoginViewID).setTitle("登录");
        stageController.getStage(ReaderViewID).setTitle("图书馆信息管理系统<读者权限>");
        stageController.getStage(AdminViewID).setTitle("图书馆信息管理系统<管理员权限>");
        stageController.getStage(SuperAdminViewID).setTitle("图书馆信息管理系统<超级管理员权限>");
        stageController.getStage(RegisterViewID).setTitle("注册");
        stageController.getStage(ForgetViewID).setTitle("找回密码");
        stageController.getStage(AboutViewID).setTitle("关于");
        stageController.getStage(UserInfoViewID).setTitle("个人信息");
        stageController.getStage(ErrorViewID).setTitle("错误");
        //stageController.getStage(LoginViewID).setResizable(false);
        stageController.getStage(RegisterViewID).setResizable(false);
        stageController.getStage(ForgetViewID).setResizable(false);
        stageController.getStage(ErrorViewID).setResizable(false);
        //显示MainView舞台
        stageController.setStage(LoginViewID);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
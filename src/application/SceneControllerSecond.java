package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SceneControllerSecond implements Initializable{

	String id,name,email,phonenumber;
	
	
	@FXML 
	TableView<StudentData> tabledata;
	@FXML 
	TableColumn<StudentData,String> idCol;
	@FXML 
	TableColumn<StudentData,String> nameCol;
	@FXML 
	TableColumn<StudentData,String> emailCol;
	@FXML 
	TableColumn<StudentData,String> phonenumberCol;
	
	final ObservableList<StudentData> studentList = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("heloo");
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `studentdata`");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getString(1);
				name = rs.getString(2);
				email = rs.getString(3);
				phonenumber = rs.getString(4);
				studentList.add(new StudentData(id, name, email, phonenumber));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tabledata.setItems(studentList);
		
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		phonenumberCol.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
		
	}
	public static  Connection getConnection(){
		  {			 
			  String url = "jdbc:mysql://localhost:3306/studentdatabase";
			  String username = "root";
			  String pass = "";
			  try {
				
				  Connection conn = DriverManager.getConnection(url,username,pass);
				  System.out.println("connected");
			  return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		 }
	 }

}

package application;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TextField;

import javafx.stage.Stage;

public class SceneController  {

	
	
	
	
	Database database= Database.getInstance(); 
	
	


	
	final ObservableList<StudentData> studentList = FXCollections.observableArrayList();
	
	private Stage stage;
	private Parent root;
	
	@FXML
	TextField nameTextfield,emailTextfield,phonenumberTextfield;

	 
	
	
	public void Submit(ActionEvent event) throws IOException, SQLException {
		
		
		GettingDataFromUser();
		
		root = FXMLLoader.load(getClass().getResource("ShowScene.fxml")); 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		

		
		
	}
	
	@SuppressWarnings("static-access")
	public void GettingDataFromUser() throws SQLException {
		String name,email,phonenumber;
		 name = nameTextfield.getText();
		 email = emailTextfield.getText();
		 phonenumber = phonenumberTextfield.getText();	
		 
		database.getConnection();
		database.Post(name, email, phonenumber); 
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

package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FrontendController implements Initializable{
	
	@FXML
	private ImageView userProfile;
	
	@FXML
	private ImageView addFriend;
	
	@FXML
	private ImageView editProfile;
	
	@FXML
	private ImageView msgAny;
	
	@FXML
	private TextField searchText;
	
	@FXML
	private HBox friendBox;
	
	@FXML
	private ImageView friendPic;
	
	@FXML
	private Label friendName;
	
	@FXML
	private Label friendRecentText;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	//onclick user profile image
	@FXML
	public void ShowProfile(MouseEvent event){
		Parent root;
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../resources/ShowProfile.fxml"));
            root=(Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("User_Profile");
            stage.setScene(new Scene(root));
            stage.show();
            //it Hides the current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
        }
   
	}
	
	@FXML
	public void EditProfile(MouseEvent event){
		Parent root;
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("../resources/EditProfile.fxml"));
            root=(Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Edit Profile");
            stage.setScene(new Scene(root));
            stage.show();
            //it Hides the current window
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
        }
   
	}
	
	
	
	
	
	
	
	

}

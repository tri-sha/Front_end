package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.ApiService;
import application.RetrofitService;
import application.User;
import application.UserModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;


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
	private Label friendDp1;
	
	@FXML
	private Label friendName1;
	
	@FXML
	private Label friendDp2;
	
	@FXML
	private Label friendName2;
	
	@FXML
	private Label friendDp3;
	
	@FXML
	private Label friendName3;
	@FXML
	private Button loadUser;
	
	
	@FXML
	private TextArea messageBox;
	@FXML private ListView chatPane;
	@FXML private Button sendButton;
	
	List<User>alluser=new ArrayList<>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		RetrofitService retrofit=new RetrofitService();
		 ApiService getuser = retrofit.getService();
		 Call<UserModel>call=getuser.getallusers();
		 
		 call.enqueue(new Callback<UserModel>() {
			 @Override
			 public void onResponse(Call<UserModel> call,Response<UserModel> response) {
				 if(!response.isSuccessful()) {
					 searchText.setText("code: "+ response.code());
					 return;
				 }
				else {
					System.out.println("Successful!!");
					UserModel Umodel=response.body();
				
					 alluser = Umodel.getUsers();
					 if(alluser!=null) {
							
					 //updating UI other than application so given under this lemda expression
					 Platform.runLater(()->{
						 int i=1;
					for(User ulist:alluser) {
						//HBox huser=new HBox();
						//huser.setMaxWidth()
						
						//tempname="friendName"+i;
						//tempDp="friendDp"+i
						
						//fListcontainer.getChildren().add(Label);
						//FriendboxC newPane = new FriendboxC();
				        //newPane.setId(newID+(i++)); // Don't know why setting the CSS id is necessary here
				        //newPane.setOnAction(this::); // set onAction property
				        //fListcontainer.getChildren().add(newPane);
						if(i==1) {
						 System.out.println(friendName1);
						 friendName1.setText(ulist.firstname +' '+ ulist.lastname);
						 String s=ulist.firstname.substring(0, 2);
						 //System.out.println(s);
						 friendDp1.setText(s);
						}
						
						if(i==2) {
							 friendName2.setText(ulist.firstname +' '+ ulist.lastname);
							 String s=ulist.firstname.substring(0, 2);
							 //System.out.println(s);
							 friendDp2.setText(s);
							}
						
						if(i==3) {
							 friendName3.setText(ulist.firstname +' '+ ulist.lastname);
							 String s=ulist.firstname.substring(0, 2);
							 //System.out.println(s);
							 friendDp3.setText(s);
							}
						i++;
					}
					 });
					}
				
				}
			 }

			@Override
			public void onFailure(Call<UserModel> call, Throwable t) {
				// TODO Auto-generated method stub
			 searchText.setText("Load Failure: "+ t.getMessage());
			}
		 });

		
	}
	
	//onclick user profile image
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
	
	/*//message Controller
	@FXML
	public void onsendbuttonclick(ActionEvent e) {
		RetrofitService retrofit=new RetrofitService();
		 ApiService getuser = retrofit.getService();
		 
		
	}*/
	
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
	


	public void onloadusersclick(ActionEvent event){
		searchText.setText("Button clicked");	
	}
}
		 /*RetrofitService retrofit=new RetrofitService();
		 ApiService getuser = retrofit.getService();
		 Call<UserModel>call=getuser.getallusers();
		 
		 call.enqueue(new Callback<UserModel>() {
			 @Override
			 public void onResponse(Call<UserModel> call,Response<UserModel> response) {
				 if(!response.isSuccessful()) {
					 searchText.setText("code: "+ response.code());
					 return;
				 }
				else {
					System.out.println("Successful!!");
					UserModel Umodel=response.body();
				
					 alluser = Umodel.getUsers();
					 if(alluser!=null) {
							int i=1;
					 //updating UI other than application so given under this lemda expression
					 Platform.runLater(()->{
					for(User ulist:alluser) {
						//HBox huser=new HBox();
						//huser.setMaxWidth()
						
						//tempname="friendName"+i;
						//tempDp="friendDp"+i
						
						//fListcontainer.getChildren().add(Label);
						//FriendboxC newPane = new FriendboxC();
				        //newPane.setId(newID+(i++)); // Don't know why setting the CSS id is necessary here
				        //newPane.setOnAction(this::); // set onAction property
				        //fListcontainer.getChildren().add(newPane);
						if(i==1) {
						 friendName1.setText(ulist.firstname +' '+ ulist.lastname);
						 String s=ulist.firstname.substring(0, 2);
						 //System.out.println(s);
						 friendDp1.setText(s);
						}
						
						if(i==2) {
							 friendName2.setText(ulist.firstname +' '+ ulist.lastname);
							 String s=ulist.firstname.substring(0, 2);
							 //System.out.println(s);
							 friendDp2.setText(s);
							}
						
						if(i==3) {
							 friendName3.setText(ulist.firstname +' '+ ulist.lastname);
							 String s=ulist.firstname.substring(0, 2);
							 //System.out.println(s);
							 friendDp3.setText(s);
							}
					}
					 });
					}
				
				}
			 }

			@Override
			public void onFailure(Call<UserModel> call, Throwable t) {
				// TODO Auto-generated method stub
			 searchText.setText("Load Failure: "+ t.getMessage());

			}
				

	 });*/
	
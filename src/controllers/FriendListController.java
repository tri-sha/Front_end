package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.ApiService;
import application.RetrofitService;
import application.User;
import application.UserModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.ArrayList;


public class FriendListController implements Initializable{
	
	@FXML
	private Label uname;
	
	@FXML
	private Label fname;
	
	@FXML
	private Label lname;
	
	@FXML
	private Label msg;
	
	@FXML 
	private Button GetMore;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		//Label uname=new Label();
		//Label fname=new Label();
		//Label lname=new Label();
		
		// TODO Auto-generated method stub
	}
	
	@FXML
	public void ongetmoreButtonClick(javafx.event.ActionEvent event) throws IOException, Exception{
	msg.setText("Button clicked");	
	 RetrofitService retrofit=new RetrofitService();
	 ApiService getuser = retrofit.getService();
	 Call<UserModel>call=getuser.getallusers();
	 
	 call.enqueue(new Callback<UserModel>() {
		 @Override
		 public void onResponse(Call<UserModel> call,Response<UserModel> response) {
			 if(!response.isSuccessful()) {
				 msg.setText("code: "+ response.code());
				 return;
			 }
			else {
				UserModel Umodel=response.body();
				List<User> alluser=new ArrayList<>();
				 alluser=Umodel.getUsers();
				for(User ulist:alluser) {
					 uname.setText(ulist.username+',');
					 System.out.print(ulist.firstname+',');
					 System.out.println(ulist.lastname+',');
				}
				}
			
			}

		@Override
		public void onFailure(Call<UserModel> call, Throwable t) {
			// TODO Auto-generated method stub
			msg.setText("Load Failure: "+ t.getMessage());

		}
			

 });
	}
}

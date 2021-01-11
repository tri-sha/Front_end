package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.ApiService;
import application.RetrofitService;
import application.User;
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
		
		
		// TODO Auto-generated method stub
	}
	
	@FXML
	public void ongetmoreButtonClick(javafx.event.ActionEvent event) throws IOException, Exception{
	msg.setText("Button clicked");	
	 RetrofitService retrofit=new RetrofitService();
	 ApiService getuser = retrofit.getService();
	 Call<List<User>>call=getuser.getallusers();
	 
	 call.enqueue(new Callback<List<User>>() {
		 @Override
		 public void onResponse(Call<List<User>> call,Response<List<User>> response) {
			 if(!response.isSuccessful()) {
				 msg.setText("code: "+ response.code());
				 return;
			 }
			List<User>alluser= response.body();
			//List<User> alluser=new ArrayList<>();
			//alluser=umodel.getUsers();
			for(User ulist:alluser) {
				 uname.setText(ulist.username);
			     fname.setText(ulist.firstname);
			     lname.setText(ulist.lastname);
			}
		 }

		@Override
		public void onFailure(Call<List<User>> call, Throwable t) {
			// TODO Auto-generated method stub
			msg.setText("Load Failure: "+ t.getMessage());

		}
 });
	}
}

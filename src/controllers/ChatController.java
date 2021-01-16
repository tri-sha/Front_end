/*package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.org.slf4j.internal.LoggerFactory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ChatController implements Initializable{

	@FXML
	private TextArea messageBox;
	@FXML private ListView chatPane;
	@FXML private Button sendButton;
	
	//Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void sendButtonAction() throws IOException {
        String msg = messageBox.getText();
        if (!messageBox.getText().isEmpty()) {
            //Listener.send(msg);
        	chatPane=new ListView();
        	Label l=new Label();
        	l.setText(msg);
        	chatPane.getItems.add(l);
            messageBox.clear();
            	
        }
        
    }
	
	//@FXML 
	 
	/*
	@FXML private TextArea messageBox;
    @FXML private Label usernameLabel;
    @FXML private Label onlineCountLabel;
    @FXML private ListView userList;
    @FXML private ImageView userImageView;
    @FXML private Button recordBtn;
    @FXML ListView chatPane;
    @FXML ListView statusList;
    @FXML BorderPane borderPane;
    @FXML ComboBox statusComboBox;
    @FXML ImageView microphoneImageView;
	
	*/
}
*/
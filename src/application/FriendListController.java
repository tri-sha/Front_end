package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class FriendListController {
	
	@FXML
	private Label FriendName;
	
	@FXML
	private Label FRecentText;
	
	@FXML
	private ImageView FriendImg;
	
	
	public Label getFriendName() {
		return FriendName;
	}

	public void setFriendName(Label friendName) {
		FriendName = friendName;
	}

	public Label getFRecentText() {
		return FRecentText;
	}

	public void setFRecentText(Label fRecentText) {
		FRecentText = fRecentText;
	}

	public ImageView getFriendImg() {
		return FriendImg;
	}

	public void setFriendImg(ImageView friendImg) {
		FriendImg = friendImg;
	}

	
	
	
	
	
}

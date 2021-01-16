package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FriendboxC extends Pane{

    public FriendboxC() {
    	try {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../resources/UserFriendBox.fxml"));
        //loader.setRoot(this);
        
        //loader.setController(this);
        HBox child=(HBox)loader.load();
    	}catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
/*
    @FXML
    private Button btnAddNewPane;

    public void setOnAction(EventHandler<ActionEvent> handler) {
        btnAddNewPane.setOnAction(handler);
    }

    public EventHandler<ActionEvent> getOnAction() {
        return btnAddNewPane.getOnAction();
    }
}
*/

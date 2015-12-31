package com.View;

import com.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Anders on 12/31/2015.
 */
public class AdminViewController {
    private MainController mainController;
    @FXML
    public Button startGameButton;
    @FXML
    public Button saveSettingsButton;

    @FXML
    public void startGamePressed(ActionEvent event)
    {
        //Create the game.
        //Start the game, players can only connect to a started game.
        mainController.startServer();
    }

    @FXML
    public void saveSettingsPressed(ActionEvent event)
    {
        //Save the settings to a file which is loaded as default settings on startup.
    }

    public void init(MainController mainController)
    {
        this.mainController = mainController;
    }
}

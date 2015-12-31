package com;

/**
 * Created by Anders on 12/31/2015.
 */
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.ModelClasses.Command;
import com.View.AdminViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainController extends Application {
    static public ConcurrentLinkedQueue<Command> commandQueue = new ConcurrentLinkedQueue<Command>();
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AdminViewController adminViewController;
    private ServerThread serverThread;
    private ConnectionThread connectionThread;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Robots Multiplayer Server");

        //primaryStage.setOnCloseRequest(e -> clientThread.closeClient());

        initRootLayout();
        showAdminScreen();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            //Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("/com/View/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the admin screen.
     */
    public void showAdminScreen() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainController.class.getResource("/com/View/AdminLayout.fxml"));
            GridPane loginLayout = loader.load();

            adminViewController = loader.getController();
            adminViewController.init(this);

            // Show the login screen in the root layout.
            rootLayout.setCenter(loginLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *Starts the game by starting the thread that accept connections from clients and starting the threads that runs the game.
     */
    public void startServer()
    {
        connectionThread = new ConnectionThread();
        serverThread = new ServerThread();
    }

    /**
     *
     */
    public void saveSettings()
    {

    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

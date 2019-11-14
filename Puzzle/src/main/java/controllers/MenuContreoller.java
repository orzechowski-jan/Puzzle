package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class MenuContreoller {
	
	private MainController mainController;
	
	@FXML
	public void openApp() {
		loadAppScreen();
		
	}

	public void loadAppScreen() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AppScreen.fxml"));
		Pane pane = null;
		
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AppController appController = loader.getController();
		appController.setMainController(mainController);
		mainController.setScreen(pane);
	}
	
	@FXML
	public void openOptions() {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/OptionScreen.fxml"));
		Pane pane = null;
		
		try {
			pane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		mainController.setScreen(pane);
		
		OptionController optionController = loader.getController();
		optionController.setMainController(mainController);
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
}

package controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ResultsController {
	
	private MainController mainController;
	
	String [] tablica = getLastTimeFromFile().split("\\s+");
	
	@FXML
	private Label timeLabel;
	
	@FXML
	public void initialize() {
		timeLabel.setText((tablica[tablica.length - 2] + " seconds"));
	}
	
	@FXML
	public void back() {
		
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
	
	public String getLastTimeFromFile() {
		StringBuilder wordBuffer = new StringBuilder();
		FileInputStream input = null;
		
		try {
			input = new FileInputStream("times.txt");
			int nextByte;
			while ((nextByte = input.read()) != -1) {
				wordBuffer.append((char)nextByte);
			}
			
		} catch(IOException e) {
			System.out.println("Blad odczytu strumienia wejsciowego");
		}
		return wordBuffer.toString();
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
}

package controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class OptionController {

	private MainController mainController;
	
	String napis = getTimesFromFile();
	
	@FXML
	private Label textWithTimes;
	
	@FXML
	public void initialize() {
		textWithTimes.setText(napis);
	}
	
	@FXML
	public void backMenu() {
		mainController.loadMenuScreen();
	}
	
	public String getTimesFromFile() {
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
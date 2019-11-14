package controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class AppController {
	
	private MainController mainController;
	
	private List<String> numbersList = new ArrayList<String>();
	private List<Button> buttonsList = new ArrayList<Button>();
	private Random random = new Random();
	private String firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, sixthNumber, seventhNumber, eighthNumber, ninthNumber;
	private Timeline time = new Timeline();
	private final Integer startTime = 0;
	private Integer seconds = startTime;
	int numberOfClick = 0;
	@FXML
	private ImageView image1, image2, image3, image4, image5, image6;
	
	@FXML
	private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, help;
	
	//komentarz
	
	@FXML
	private Label label;
	
	@FXML
	public void backMenu() {
		mainController.loadMenuScreen();
	}
	
	@FXML
	public void initialize() {
		numbersList.add("1");
		numbersList.add("2");
		numbersList.add("3");
		numbersList.add("4");
		numbersList.add("5");
		numbersList.add("6");
		numbersList.add("7");
		numbersList.add("8");
		numbersList.add(" ");
		
		buttonsList.add(button1);
		buttonsList.add(button2);
		buttonsList.add(button3);
		buttonsList.add(button4);
		buttonsList.add(button5);
		buttonsList.add(button6);
		buttonsList.add(button7);
		buttonsList.add(button8);
		buttonsList.add(button9);
		
		button1.setText(getAndRemoveNumber(1));
		button2.setText(getAndRemoveNumber(2));
		button3.setText(getAndRemoveNumber(3));
		button4.setText(getAndRemoveNumber(4));
		button5.setText(getAndRemoveNumber(5));
		button6.setText(getAndRemoveNumber(6));
		button7.setText(getAndRemoveNumber(7));
		button8.setText(getAndRemoveNumber(8));
		button9.setText(getAndRemoveNumber(9));
		
		checkIfGreen();
		
		
		seconds = 0;
		time.setCycleCount(Timeline.INDEFINITE);
		KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {	
			
			public void handle(ActionEvent event) {
				seconds++;
				label.setText("Time: "+seconds.toString() + " seconds");
			}
		});
		
		time.setCycleCount(Timeline.INDEFINITE);
		time.getKeyFrames().add(frame);
		if(time!=null) {
			time.stop();
		}
		time.play();
	}
	
	@FXML
	public void loadNew() {
		
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
	public void slide1() {
		if(button2.getText().equals(" ")) {
			String stringTmp = button1.getText();
			button1.setText(button2.getText());
			button2.setText(stringTmp);
		}
		if(button4.getText().equals(" ")) {
			String stringTmp = button1.getText();
			button1.setText(button4.getText());
			button4.setText(stringTmp);
		}
		
		checkIfGreen();
		checkIfWin();
		
		
	}
	
	@FXML
	public void slide2() {
		if(button1.getText().equals(" ")) {
			String stringTmp = button2.getText();
			button2.setText(button1.getText());
			button1.setText(stringTmp);
		}
		if(button3.getText().equals(" ")) {
			String stringTmp = button2.getText();
			button2.setText(button3.getText());
			button3.setText(stringTmp);
		}
		if(button5.getText().equals(" ")) {
			String stringTmp = button2.getText();
			button2.setText(button5.getText());
			button5.setText(stringTmp);
		}
		
		checkIfGreen();
		checkIfWin();
	}
	
	@FXML
	public void slide3() {
		if(button2.getText().equals(" ")) {
			String stringTmp = button3.getText();
			button3.setText(button2.getText());
			button2.setText(stringTmp);
		}
		if(button6.getText().equals(" ")) {
			String stringTmp = button3.getText();
			button3.setText(button6.getText());
			button6.setText(stringTmp);
		}
		
		checkIfGreen();
		checkIfWin();
	}
	
	@FXML
	public void slide4() {
		if(button1.getText().equals(" ")) {
			String stringTmp = button4.getText();
			button4.setText(button1.getText());
			button1.setText(stringTmp);
		}
		if(button5.getText().equals(" ")) {
			String stringTmp = button4.getText();
			button4.setText(button5.getText());
			button5.setText(stringTmp);
		}
		if(button7.getText().equals(" ")) {
			String stringTmp = button4.getText();
			button4.setText(button7.getText());
			button7.setText(stringTmp);
		}
		
		checkIfGreen();
		checkIfWin();
		
	}
	
	@FXML
	public void slide5() {
		if(button2.getText().equals(" ")) {
			String stringTmp = button5.getText();
			button5.setText(button2.getText());
			button2.setText(stringTmp);
		}
		if(button4.getText().equals(" ")) {
			String stringTmp = button5.getText();
			button5.setText(button4.getText());
			button4.setText(stringTmp);
		}
		if(button6.getText().equals(" ")) {
			String stringTmp = button5.getText();
			button5.setText(button6.getText());
			button6.setText(stringTmp);
		}
		if(button8.getText().equals(" ")) {
			String stringTmp = button5.getText();
			button5.setText(button8.getText());
			button8.setText(stringTmp);
		}
		
		checkIfGreen();
		checkIfWin();
		
	}
	
	@FXML
	public void slide6() {
		if(button3.getText().equals(" ")) {
			String stringTmp = button6.getText();
			button6.setText(button3.getText());
			button3.setText(stringTmp);
		}
		if(button5.getText().equals(" ")) {
			String stringTmp = button6.getText();
			button6.setText(button5.getText());
			button5.setText(stringTmp);
		}
		if(button9.getText().equals(" ")) {
			String stringTmp = button6.getText();
			button6.setText(button9.getText());
			button9.setText(stringTmp);
		}
		
		checkIfGreen();
		checkIfWin();
		
	}
	
	@FXML
	public void slide7() {
		if(button4.getText().equals(" ")) {
			String stringTmp = button7.getText();
			button7.setText(button4.getText());
			button4.setText(stringTmp);
		}
		if(button8.getText().equals(" ")) {
			String stringTmp = button7.getText();
			button7.setText(button8.getText());
			button8.setText(stringTmp);
		}
		
		checkIfGreen();
		checkIfWin();
	}
	
	@FXML
	public void slide8() {
		if(button5.getText().equals(" ")) {
			String stringTmp = button8.getText();
			button8.setText(button5.getText());
			button5.setText(stringTmp);
		}
		if(button7.getText().equals(" ")) {
			String stringTmp = button8.getText();
			button8.setText(button7.getText());
			button7.setText(stringTmp);
		}
		if(button9.getText().equals(" ")) {
			String stringTmp = button8.getText();
			button8.setText(button9.getText());
			button9.setText(stringTmp);
		}
		
		checkIfGreen();
		checkIfWin();
	}
	
	@FXML
	public void slide9() {
		if(button6.getText().equals(" ")) {
			String stringTmp = button9.getText();
			button9.setText(button6.getText());
			button6.setText(stringTmp);
		}
		if(button8.getText().equals(" ")) {
			String stringTmp = button9.getText();
			button9.setText(button8.getText());
			button8.setText(stringTmp);
		}
		
		checkIfGreen();
		checkIfWin();
	}
	
	@FXML
	public void helpStep() {
		numberOfClick++;
		
		if(numberOfClick == 1) 
			help.setText("Help(2)");
		if(numberOfClick == 2) 
			help.setText("Help(1)");
		if(numberOfClick == 3)
			help.setText("");
			
		if(numberOfClick < 4) {
			
			if(!button1.getText().equals("1")) {
				String strTmp = buttonsList.get(0).getText();
					for(int i=0; i<buttonsList.size(); i++) {
						if("1" == buttonsList.get(i).getText()) {
							buttonsList.get(0).setText("1");
							buttonsList.get(i).setText(strTmp);
							checkIfGreen();
							break;
						}
					}
			} else {
			
				if(button1.getText().equals("1") && !button2.getText().equals("2")) {
					String strTmp = buttonsList.get(1).getText();
					for(int i=0; i<buttonsList.size(); i++) {
						if("2" == buttonsList.get(i).getText()) {
							buttonsList.get(1).setText("2");
							buttonsList.get(i).setText(strTmp);
							checkIfGreen();
							break;
						}
					}
				}
				else {
					if(button1.getText().equals("1") && button2.getText().equals("2") && !button3.getText().equals("3")) {
						String strTmp = buttonsList.get(2).getText();
						for(int i=0; i<buttonsList.size(); i++) {
							if("3" == buttonsList.get(i).getText()) {
								buttonsList.get(2).setText("3");
								buttonsList.get(i).setText(strTmp);
								checkIfGreen();
								break;
							}
						}
					}
					else {
						if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && !button4.getText().equals("4")) {
							String strTmp = buttonsList.get(3).getText();
							for(int i=0; i<buttonsList.size(); i++) {
								if("4" == buttonsList.get(i).getText()) {
									buttonsList.get(3).setText("4");
									buttonsList.get(i).setText(strTmp);
									checkIfGreen();
									checkIfWin();
									break;
								}
							}
						}
						else {
							if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4") && !button5.getText().equals("5")) {
								String strTmp = buttonsList.get(4).getText();
								for(int i=0; i<buttonsList.size(); i++) {
									if("5" == buttonsList.get(i).getText()) {
										buttonsList.get(4).setText("5");
										buttonsList.get(i).setText(strTmp);
										checkIfGreen();
										checkIfWin();
										break;
									}
								}
							}
							else {
								if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4") && button5.getText().equals("5")
										&& !button6.getText().equals("6")) {
									String strTmp = buttonsList.get(5).getText();
									for(int i=0; i<buttonsList.size(); i++) {
										if("6" == buttonsList.get(i).getText()) {
											buttonsList.get(5).setText("6");
											buttonsList.get(i).setText(strTmp);
											checkIfGreen();
											checkIfWin();
											break;
										}
									}
								}
								else {
									if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4") && button5.getText().equals("5")
											&& button6.getText().equals("6") && !button7.getText().equals("7")) {
										String strTmp = buttonsList.get(6).getText();
										for(int i=0; i<buttonsList.size(); i++) {
											if("7" == buttonsList.get(i).getText()) {
												buttonsList.get(6).setText("7");
												buttonsList.get(i).setText(strTmp);
												checkIfGreen();
												checkIfWin();
												break;
											}
										}
									}
									
									else {
										if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4") && button5.getText().equals("5")
												&& button6.getText().equals("6") && button7.getText().equals("7") && !button8.getText().equals("8")) {
											String strTmp = buttonsList.get(7).getText();
											for(int i=0; i<buttonsList.size(); i++) {
												if("8" == buttonsList.get(i).getText()) {
													buttonsList.get(7).setText("8");
													buttonsList.get(i).setText(strTmp);
													checkIfGreen();
													checkIfWin();
													break;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
			
	}
	
	public void checkIfWin() {	
		
		if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3")
				&& button4.getText().equals("4") && button5.getText().equals("5") && button6.getText().equals("6")
				&& button7.getText().equals("7") && button8.getText().equals("8") && button9.getText().equals(" ")) {
		
			saveToFile();
		
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ResultsScreen.fxml"));
			Pane pane = null;
			
			try {
				pane = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			mainController.setScreen(pane);
			
			ResultsController resultsController = loader.getController();
			resultsController.setMainController(mainController);
		}
		
	}
	
	public void checkIfGreen() {
		
		if(button1.getText().equals("1"))
			colorGreen(button1);
		else colorWhite(button1);
		
		if(button1.getText().equals("1") && button2.getText().equals("2"))
			colorGreen(button2);
		else colorWhite(button2);
		
		if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3"))
			colorGreen(button3);
		else colorWhite(button3);
		
		if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4"))
			colorGreen(button4);
		else colorWhite(button4);
		
		if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4")
				&& button5.getText().equals("5"))
			colorGreen(button5);
		else colorWhite(button5);
		
		if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4")
				&& button5.getText().equals("5") && button6.getText().equals("6"))
			colorGreen(button6);
		else colorWhite(button6);
			
		if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4")
				&& button5.getText().equals("5") && button6.getText().equals("6") && button7.getText().equals("7"))
			colorGreen(button7);
		else colorWhite(button7);
		
		if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4")
				&& button5.getText().equals("5") && button6.getText().equals("6") && button7.getText().equals("7") && button8.getText().equals("8"))
			colorGreen(button8);
		else colorWhite(button8);
		
		if(button1.getText().equals("1") && button2.getText().equals("2") && button3.getText().equals("3") && button4.getText().equals("4")
				&& button5.getText().equals("5") && button6.getText().equals("6") && button7.getText().equals("7") && button8.getText().equals("8")
				&& button9.getText().equals(""))
			colorGreen(button9);
		else colorWhite(button9);
	}
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public String getAndRemoveNumber(int index) {
		
		if(index == 1) {
			firstNumber = numbersList.get(random.nextInt(9));
			numbersList.remove(firstNumber);
			return firstNumber;
		}
		if(index == 2) {
			secondNumber = numbersList.get(random.nextInt(8));
			numbersList.remove(secondNumber);
			return secondNumber;
		}
		if(index == 3) {
			thirdNumber = numbersList.get(random.nextInt(7));
			numbersList.remove(thirdNumber);
			return thirdNumber;
		}
		if(index == 4) {
			fourthNumber = numbersList.get(random.nextInt(6));
			numbersList.remove(fourthNumber);
			return fourthNumber;
		}
		if(index == 5) {
			fifthNumber = numbersList.get(random.nextInt(5));
			numbersList.remove(fifthNumber);
			return fifthNumber;
		}
		if(index == 6) {
			sixthNumber = numbersList.get(random.nextInt(4));
			numbersList.remove(sixthNumber);
			return sixthNumber;
		}
		if(index == 7) {
			seventhNumber = numbersList.get(random.nextInt(3));
			numbersList.remove(seventhNumber);
			return seventhNumber;
		}
		if(index == 8) {
			eighthNumber = numbersList.get(random.nextInt(2));
			numbersList.remove(eighthNumber);
			return eighthNumber;
		}
		if(index == 9) {
			ninthNumber = numbersList.get(random.nextInt(1));
			numbersList.remove(ninthNumber);
			return ninthNumber;
		}
		
		return null;
	}
	
	public void colorGreen(Button button) {
		button.setStyle("-fx-background-color:linear-gradient(#f0ff35, #a9ff00),radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);-fx-background-radius: 6, 5;-fx-background-insets: 0, 1;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-text-fill: #395306;");
	}
	public void colorWhite(Button button) {
		button.setStyle("-fx-background-color: #c3c4c4,linear-gradient(#d6d6d6 50%, white 100%),radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);fx-background-radius: 6, 5;-fx-background-insets: 0, 1;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-text-fill: #395306;");
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public void saveToFile() {
		
		Calendar calendar = Calendar.getInstance();
		
		try {
			Writer output  = new BufferedWriter(new FileWriter("times.txt", true));
			output.append(calendar.getTime()+ ":  " + String.valueOf(getSeconds()) + " seconds");
			output.append(System.getProperty("line.separator"));
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
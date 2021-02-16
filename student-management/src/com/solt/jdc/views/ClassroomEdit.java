package com.solt.jdc.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClassroomEdit {
	
	@FXML
	private Label lblTitle;
	@FXML
	private TextField txtGrade;
	@FXML
	private TextField txtYear;
	
	public static void show() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(ClassroomEdit.class.getResource("ClassroomEdit.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		
	}
	
	public void close() {
		
	}

}

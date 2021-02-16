package com.solt.jdc.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class MessageBox {

	public static void errorBox(String fieldName) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Filed cann't be null!");
		alert.setContentText(String.format("%s is null", fieldName));
		alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		alert.show();
	}
	
}

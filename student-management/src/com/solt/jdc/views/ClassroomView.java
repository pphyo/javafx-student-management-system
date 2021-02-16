package com.solt.jdc.views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

public class ClassroomView {
	
	@FXML
	private TextField txtGrade;
	@FXML
	private TextField txtYear;
	@FXML
	private TilePane roomBox;
	
	public void add() {
		ClassroomEdit.show();
	}
	
	public void search() {
		
	}

}

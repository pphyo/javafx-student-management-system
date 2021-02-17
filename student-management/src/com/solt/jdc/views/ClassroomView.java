package com.solt.jdc.views;

import com.solt.jdc.entity.Classroom;
import com.solt.jdc.service.ClassroomService;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class ClassroomView {
	
	@FXML
	private TextField txtGrade;
	@FXML
	private TextField txtYear;
	@FXML
	private TilePane roomBox;
	
	private ClassroomService clsService;
	
	public void initialize() {
		clsService = ClassroomService.getInstance();
		
		search();
	}
	
	public void add() {
		ClassroomEdit.show(c -> {
			clsService.save(c);
			search();
		});
	}
	
	public void search() {
		roomBox.getChildren().clear();
	}
	
	private class ClassroomBox extends VBox {
		public ClassroomBox(Classroom room) {
			
		}
	}

}

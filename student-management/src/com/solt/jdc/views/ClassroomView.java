package com.solt.jdc.views;

import java.util.List;

import com.solt.jdc.entity.Classroom;
import com.solt.jdc.service.ClassroomService;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
		List<Classroom> clazz = clsService.getAll();
		clazz.stream().map(c -> new ClassroomBox(c)).forEach(box -> roomBox.getChildren().add(box));
	}
	
	private class ClassroomBox extends VBox {
		public ClassroomBox(Classroom room) {
			Label grade = new Label(room.getGrade().toString());
			grade.getStyleClass().add("grade");
			
			Label year = new Label(String.valueOf(room.getYear()));
			year.getStyleClass().add("year");
			
			getChildren().addAll(grade, year);
			this.getStyleClass().add("class-box");
		}
	}

}

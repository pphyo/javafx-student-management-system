package com.solt.jdc.views;

import com.solt.jdc.entity.Classroom.Grade;
import com.solt.jdc.entity.Student;
import com.solt.jdc.entity.Student.Gender;
import com.solt.jdc.service.ClassroomService;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StudentView {
	
	@FXML
	private ComboBox<Grade> cbxGrade;
	@FXML
	private ComboBox<Integer> cbxYear;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	@FXML
	private ComboBox<Gender> cbxGender;
	@FXML
	private TableView<Student> tblStudent;
	
	private ClassroomService clsService;
	
	public void initialize() {
		clsService = ClassroomService.getInstance();
		
		cbxYear.getItems().addAll(clsService.getAllYears());
		cbxGrade.getItems().addAll(Grade.values());
		
	}
	
	public void upload() {
		
	}
	
	public void add() {
		
	}
	
	public void search() {
		
	}
	
	public void reload() {
		
	}

}

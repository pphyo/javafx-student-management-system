package com.solt.jdc.views;

import java.util.List;

import com.solt.jdc.entity.Classroom.Grade;
import com.solt.jdc.entity.Student;
import com.solt.jdc.entity.Student.Gender;
import com.solt.jdc.service.ClassroomService;
import com.solt.jdc.service.StudentService;

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
	private StudentService stuService;
	
	private Student stu;
	
	public void initialize() {
		clsService = ClassroomService.getInstance();
		stuService = StudentService.getInstance();
		
		cbxYear.getItems().addAll(clsService.getAllYears());
		cbxGrade.getItems().addAll(Grade.values());
		
		search();
		
	}
	
	public void upload() {
		
	}
	
	public void add() {
		StudentEdit.show(stu, s -> {
			stuService.save(s);
			search();
		});
	}
	
	public void search() {
		tblStudent.getItems().clear();
		List<Student> list = stuService.getAll();
		tblStudent.getItems().addAll(list);
	}
	
	public void reload() {
		
	}

}

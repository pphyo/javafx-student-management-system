package com.solt.jdc.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class RootFrame {

    @FXML
    private StackPane viewHolder;

    @FXML
    void showClassroom(MouseEvent event) {
    	showView("ClassroomView");
    }

    @FXML
    void showExam(MouseEvent event) {
    	showView("ExamView");
    }

    @FXML
    void showResult(MouseEvent event) {
    	showView("ResultView");
    }

    @FXML
    void showStudent(MouseEvent event) {
    	showView("StudentView");
    }

    @FXML
    void showSubject(MouseEvent event) {
    	showView("SubjectView");
    }

    private void showView(String viewName) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource(viewName.concat(".fxml")));
    		viewHolder.getChildren().clear();
    		viewHolder.getChildren().add(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}


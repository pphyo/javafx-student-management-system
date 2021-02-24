package com.solt.jdc.service;

import static com.solt.jdc.util.DatabaseConnection.getSqlConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solt.jdc.entity.Classroom;
import com.solt.jdc.entity.Student;
import com.solt.jdc.entity.Classroom.Grade;
import com.solt.jdc.entity.Student.Gender;

public class StudentService {
	
	private static final String SELECT = "select * from student where 1 = 1";
	private static StudentService INSTANCE;
	
	private StudentService() {}
	
	public static StudentService getInstance() {
		return null == INSTANCE ? INSTANCE = new StudentService() : INSTANCE;
	}
	
	public void save(Student stu) {
		
		String insert = "insert into student (name, gender, dob, phone, classroom_year, classroom_grade) values (?, ?, ?, ?, ?, ?)";
		String update = "update student set name = ?, gender = ?, dob = ?, phone = ?, classroom_year = ?, classroom_grade = ? where id = ?";
		
		boolean isNew = stu.getId() == 0;
		
		try(Connection conn = getSqlConnection();
				PreparedStatement stmt = conn.prepareStatement(isNew ? insert : update)) {
			
			stmt.setString(1, stu.getName());
			stmt.setString(2, stu.getGender().toString());
			stmt.setDate(3, Date.valueOf(stu.getDob()));
			stmt.setString(4, stu.getPhone());
			stmt.setInt(5, stu.getClassroom().getYear());
			stmt.setString(6, stu.getClassroom().getGrade().toString());
			
			if(!isNew)
				stmt.setInt(7, stu.getId());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Student> getAll() {
		
		List<Student> result = new ArrayList<>();
		
		try(Connection conn = getSqlConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT)) {
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
				result.add(getStudentObject(rs));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	private Student getStudentObject(ResultSet rs) throws SQLException {
		Student stu = new Student();
		
		stu.setId(rs.getInt("id"));
		stu.setName(rs.getString("name"));
		stu.setGender(Gender.valueOf(rs.getString("gender")));
		stu.setDob(rs.getDate("dob").toLocalDate());
		stu.setPhone(rs.getString("phone"));
		
		Classroom room = new Classroom();
		room.setYear(rs.getInt("classroom_year"));
		room.setGrade(Grade.valueOf(rs.getString("classroom_grade")));
		
		stu.setClassroom(room);
		
		return stu;
	}

}

package com.solt.jdc.service;

import static com.solt.jdc.util.DatabaseConnection.getSqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.solt.jdc.entity.Classroom;
import com.solt.jdc.entity.Classroom.Grade;

public class ClassroomService {

	private static final String SELECT = "select * from classroom";
	private static ClassroomService INSTANCE;
	
	private ClassroomService() {}
	
	public static ClassroomService getInstance() {
		if(null == INSTANCE)
			INSTANCE = new ClassroomService();
		
		return INSTANCE;
	}
	
	public void save(Classroom room) {
		
		String sql = "insert into classroom (year, grade) values (?, ?)";
		
		try(Connection conn = getSqlConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, room.getYear());
			stmt.setString(2, room.getGrade().toString());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Classroom> getAll() {
		
		List<Classroom> result = new ArrayList<>();
		
		try(Connection conn = getSqlConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT)) {
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Classroom room = new Classroom();
				room.setGrade(Grade.valueOf(rs.getString("grade")));
				room.setYear(rs.getInt("year"));
				
				result.add(room);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}

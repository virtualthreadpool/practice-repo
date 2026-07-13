package com.aeropelican.repository;

import com.aeropelican.database.DBConnection;
import com.aeropelican.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentRepository {

    Connection connection = DBConnection.getConnection();

    public void insert(Student student) {

        try {
            String sql = "INSERT INTO Student VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getCourse());

            preparedStatement.executeUpdate();
            System.out.println("Student Inserted Successfully");

        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }
    public void display() {
        try {
            String sql = "SELECT * FROM Student";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getString("course"));
                System.out.println("-----------------------");

            }

        }

        catch(Exception e) {
            e.printStackTrace();

        }

    }
    public void update(int id,String course) {
        try {
            String sql="UPDATE Student SET course=? WHERE id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,course);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            System.out.println("Student Updated");

        }
        catch(Exception e){
            e.printStackTrace();

        }

    }
    public void delete(int id){
        try{
            String sql="DELETE FROM Student WHERE id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Student Deleted");

        }
        catch(Exception e){
            e.printStackTrace();

        }

    }

}
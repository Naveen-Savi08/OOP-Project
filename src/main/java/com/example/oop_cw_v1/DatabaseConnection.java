package com.example.oop_cw_v1;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sacms";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    // insert data to student table in the database
    public static void insertStudentData(String studentID,String firstName, String lastName, String DoB, String email, String password, String contactNumber, String gender) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String insertQuery = "INSERT INTO student (student_id,first_name,last_name,dob,email,password,contact_number,gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, studentID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, DoB);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, contactNumber);
            preparedStatement.setString(8, gender);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data insertion failed.");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // inserting data to advisor table in the database
    public static void insertAdvisorData(String advisorID,String firstName, String lastName, String DoB, String email, String password, String contactNumber, String gender) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String insertQuery = "INSERT INTO advisor (advisor_id,first_name,last_name,dob,email,password,contact_number,gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, advisorID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, DoB);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, contactNumber);
            preparedStatement.setString(8, gender);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data insertion failed.");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // retrieving data from student to check the user credential.
    public static boolean checkStudentLogin(String inputID, String inputPassword) {
        String insertQuery = "SELECT student_id, password FROM student WHERE student_id = ?";

        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
        ) {
            preparedStatement.setString(1, inputID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // User found, check the password
                    String storedPassword = resultSet.getString("password");
                    return storedPassword.equals(inputPassword);
                } else {
                    // User not found
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }


    // retrieving data from advisor to check the user credential.
    public static boolean checkAdvisorLogin(String inputID, String inputPassword) {
        String insertQuery = "SELECT advisor_id, password FROM advisor WHERE advisor_id = ?";

        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
        ) {
            preparedStatement.setString(1, inputID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // User found, check the password
                    String storedPassword = resultSet.getString("password");
                    return storedPassword.equals(inputPassword);
                } else {
                    // User not found
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }
    // view club data to student
    public static List<Club> getClubData() {
        List<Club> clubList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            String selectQuery = "SELECT * FROM club";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String sport = resultSet.getString("sport");
                String academicType = resultSet.getString("academic_type");

                Club club;
                if (sport != null) {
                    club = new SportClub(
                            resultSet.getString("club_id"),
                            resultSet.getString("club_name"),
                            resultSet.getString("members"),
                            resultSet.getString("advisor_id"),
                            resultSet.getString("description"),
                            sport
                    );
                } else if (academicType != null) {
                    club = new AcademicClub(
                            resultSet.getString("club_id"),
                            resultSet.getString("club_name"),
                            resultSet.getString("members"),
                            resultSet.getString("advisor_id"),
                            resultSet.getString("description"),
                            academicType
                    );
                } else {
                    club = new Club(
                            resultSet.getString("club_id"),
                            resultSet.getString("club_name"),
                            resultSet.getString("members"),
                            resultSet.getString("advisor_id"),
                            resultSet.getString("description")
                    );
                }

                clubList.add(club);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clubList;
    }


    public static void addStudentToClub(String studentId, String selectedClubID) {
        // Check if the student is already a member of the selected club
        if (!isStudentInClub(studentId, selectedClubID)) {
            // If not, proceed with adding the student to the club
            String insertQuery = "INSERT INTO join_club (student_id, club_id) VALUES (?, ?)";

            try (
                    Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                    PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)
            ) {
                preparedStatement.setString(1, studentId);
                preparedStatement.setString(2, selectedClubID);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    HelloController helloController = new HelloController();
                    helloController.showMessage("Success","Student Joined to Club Successfully");
                } else {
                    System.out.println("Failed to add the student to the club.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            HelloController helloAlert = new HelloController();
            helloAlert.showAlert("Club Join","Student is already a member of the selected club.");

        }
    }


    private static boolean isStudentInClub(String studentId, String selectedClubID) {
        String selectQuery = "SELECT * FROM join_club WHERE student_id = ? AND club_id = ?";

        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)
        ) {
            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, selectedClubID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // If resultSet.next() is true, the student is already in the club
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static HashMap<String,String> getAdvisorData(String advisorID) {
        HashMap<String,String> hashMap = new HashMap<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String selectQuery = "SELECT advisor_id, first_name, last_name, dob, email, password, contact_number,gender FROM advisor WHERE advisor_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, advisorID);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the retrieved data
            while (resultSet.next()) {
                String retrievedAdvisorID = resultSet.getString("advisor_id");
                String retrievedFirstName = resultSet.getString("first_name");
                String retrievedLastName = resultSet.getString("last_name");
                String retrievedDoB = resultSet.getString("dob");
                String retrievedEmail = resultSet.getString("email");
                String retrievedPassword = resultSet.getString("password");
                String retrievedContactNumber = resultSet.getString("contact_number");
                String retrievedGender = resultSet.getString("gender");


                // Do something with the retrieved data, e.g., print it or use it in your application
                hashMap.put("Advisor ID",retrievedAdvisorID);
                hashMap.put("First Name" , retrievedFirstName);
                hashMap.put("Last Name" , retrievedLastName);
                hashMap.put("DOB" , retrievedDoB);
                hashMap.put("Email" , retrievedEmail);
                hashMap.put("Password" , retrievedPassword);
                hashMap.put("Contact Number" , retrievedContactNumber);
                hashMap.put("Gender" , retrievedGender);

            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException as needed
        }
        return hashMap;
    }

    public static HashMap<String, String> getStudentData(String studentID) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String selectQuery = "SELECT student_id, first_name, last_name, dob, email, password, contact_number, gender FROM student WHERE student_id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, studentID);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the retrieved data
            while (resultSet.next()) {
                String retrievedStudentID = resultSet.getString("student_id");
                String retrievedFirstName = resultSet.getString("first_name");
                String retrievedLastName = resultSet.getString("last_name");
                String retrievedDoB = resultSet.getString("dob");
                String retrievedEmail = resultSet.getString("email");
                String retrievedPassword = resultSet.getString("password");
                String retrievedContactNumber = resultSet.getString("contact_number");
                String retrievedGender = resultSet.getString("gender");

                // Do something with the retrieved data, e.g., print it or use it in your application
                hashMap.put("Student ID", retrievedStudentID);
                hashMap.put("First Name", retrievedFirstName);
                hashMap.put("Last Name", retrievedLastName);
                hashMap.put("DOB", retrievedDoB);
                hashMap.put("Email", retrievedEmail);
                hashMap.put("Password", retrievedPassword);
                hashMap.put("Contact Number", retrievedContactNumber);
                hashMap.put("Gender", retrievedGender);

                System.out.println(retrievedEmail);
                System.out.println(retrievedLastName);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException as needed
        }
        return hashMap;
    }


}





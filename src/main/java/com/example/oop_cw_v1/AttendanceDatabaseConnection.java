package com.example.oop_cw_v1;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sacms";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    // insert data to student table in the database


    //Getting data to combobox in the attendance
    public List<String> fetchDataForComboBox(String query) {
        List<String> data = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                data.add(resultSet.getString(1));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    //get relevant events for the selected club
    public List<String> fetchEventsForComboBox(String selectedClub) {
        List<String> eventData = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            //query to fetch events based on the selected club
            String query = "SELECT e.scheduleName FROM event e JOIN club c ON c.club_id = e.clubId WHERE c.club_name = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, selectedClub);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                eventData.add(resultSet.getString("scheduleName"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventData;
    }

    //getting student info to tableview of attendance track
    public List<AttendanceData> fetchStudentDetails(String selectedClub) {
        List<AttendanceData> studentDetails = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // Prepare a query to fetch student details based on the selected club
            String query = "SELECT s.student_id, s.first_name, s.last_name, FALSE as attendance FROM student s JOIN join_club jc ON s.student_id = jc.student_id JOIN club cl ON cl.club_id = jc.club_id WHERE cl.club_name = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, selectedClub);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String studentID = resultSet.getString("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                boolean attendance = resultSet.getBoolean("attendance");

                AttendanceData attendanceData = new AttendanceData(studentID, firstName, lastName, attendance);
                studentDetails.add(attendanceData);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentDetails;
    }

    // New method to fetch student details based on the selected club and event
    public List<AttendanceData> fetchStudentDetails(String selectedClub, String selectedEvent, String eventID) {
        List<AttendanceData> studentDetails = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // Prepare a query to fetch student details based on the selected club and event
            String query = "SELECT s.student_id, s.first_name, s.last_name, FALSE as attendance FROM student s JOIN join_club jc ON s.student_id = jc.student_id JOIN club cl ON cl.club_id = jc.club_id JOIN workshop w ON w.clubId = cl.club_id WHERE cl.club_name = ? AND w.scheduleName = ? AND w.scheduleId = ? UNION SELECT s.student_id, s.first_name, s.last_name, FALSE as attendance FROM student s JOIN join_club jc ON s.student_id = jc.student_id JOIN club cl ON cl.club_id = jc.club_id JOIN event e ON e.clubID = cl.club_id WHERE cl.club_name = ? AND e.scheduleName = ? AND e.scheduleId = ? UNION SELECT s.student_id, s.first_name, s.last_name, FALSE as attendance FROM student s JOIN join_club jc ON s.student_id = jc.student_id JOIN club cl ON cl.club_id = jc.club_id JOIN meeting m ON m.clubID = cl.club_id WHERE cl.club_name = ? AND m.scheduleName = ? AND m.scheduleId = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, selectedClub);
            preparedStatement.setString(2, selectedEvent);
            preparedStatement.setString(3, eventID);
            preparedStatement.setString(4, selectedClub);
            preparedStatement.setString(5, selectedEvent);
            preparedStatement.setString(6, eventID);
            preparedStatement.setString(7, selectedClub);
            preparedStatement.setString(8, selectedEvent);
            preparedStatement.setString(9, eventID);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String studentID = resultSet.getString("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                boolean attendance = resultSet.getBoolean("attendance");

                AttendanceData attendanceData = new AttendanceData(studentID, firstName, lastName, attendance, eventID);
                studentDetails.add(attendanceData);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentDetails;
    }

    //fetching the eventID based on club and event name
    public String fetchEventID(String selectedClub, String selectedEvent) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // Prepare a query to fetch the event ID based on the selected club and event name
            String query = "SELECT scheduleId FROM event e JOIN club c ON c.club_id = e.clubId WHERE c.club_name = ? AND e.scheduleName = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, selectedClub);
            preparedStatement.setString(2, selectedEvent);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String eventID = resultSet.getString("scheduleId");
                connection.close();
                return eventID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean saveAttendance(List<AttendanceData> attendanceDataList) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String query = "INSERT INTO attendance (student_id, event_id, attendance_date, is_present) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            int[] results = new int[0];  // Initialize the results array

            for (AttendanceData data : attendanceDataList) {
                preparedStatement.setString(1, data.getStudentID());
                preparedStatement.setString(2, data.getEventID());
                preparedStatement.setDate(3, java.sql.Date.valueOf(LocalDate.now())); // Assuming today's date
                preparedStatement.setBoolean(4, data.getAttendance());

                preparedStatement.addBatch();
            }

            try {
                results = preparedStatement.executeBatch();
            } catch (BatchUpdateException batchUpdateException) {
                // Handle duplicate entry error
                System.out.println("Warning: Attendance already exists for some students in the selected event.");
            }

            connection.close();

            // Check if any rows were affected
            for (int result : results) {
                if (result <= 0) {
                    return false;
                }
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<AttendanceData> getAllAttendanceData() {
        List<AttendanceData> allAttendanceData = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement statement = connection.createStatement()) {

            // Execute a SQL query to retrieve all attendance data
            String query = "SELECT attendance.attendance_date, attendance.event_id, event.scheduleName, attendance.student_id,student.first_name,student.last_name,attendance.is_present FROM `attendance`JOIN`event` ON attendance.event_id = event.scheduleId JOIN `student` ON attendance.student_id = student.student_id ORDER BY `attendance`.`attendance_date` ASC;";

            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and populate the list
            while (resultSet.next()) {
                AttendanceData attendanceData = new AttendanceData();
                attendanceData.setAttendance_date(resultSet.getDate("attendance_date"));
                attendanceData.setEvent_id(resultSet.getString("event_id"));
                attendanceData.setEvent_name(resultSet.getString("scheduleName"));
                attendanceData.setStudent_id(resultSet.getString("student_id"));
                attendanceData.setFirst_name(resultSet.getString("first_name"));
                attendanceData.setLast_name(resultSet.getString("last_name"));
                attendanceData.setIs_present(resultSet.getBoolean("is_present"));

                allAttendanceData.add(attendanceData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allAttendanceData;
    }
}





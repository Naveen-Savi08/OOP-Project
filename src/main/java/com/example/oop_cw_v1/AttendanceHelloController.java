package com.example.oop_cw_v1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;


import java.sql.SQLException;
import java.util.List;


public class AttendanceHelloController {



    @FXML
    private Button btn_save, btn_save1;
    @FXML
    private TableColumn<AttendanceData, Boolean> col_attendance, col_attendance1;
    @FXML
    private TableColumn<AttendanceData, String> col_studentID;
    @FXML
    private TableColumn<AttendanceData, String> col_attendanceID;
    @FXML
    private TableColumn<AttendanceData, String> col_firstName, col_firstName1;
    @FXML
    private TableColumn<AttendanceData, String> col_lastName, col_lastName1;
    @FXML
    private TableView<AttendanceData> table_attendance, table_attendance1;
    @FXML
    private ComboBox<String> combobox_selectClub, combobox_selectClub1;
    @FXML
    private ComboBox<String> combobox_selectEvent, combobox_selectEvent1;
    @FXML
    private Button btn_refresh, btn_refresh1;
    @FXML
    private Button btn_getReport, btn_getReport1;
    @FXML
    private Tab tabPane_advisor, tabPane_student;

    private ObservableList<AttendanceData> attendanceDataList;




    private AttendanceDatabaseConnection databaseConnection;
    public void initialize() {
        // Initialize columns
        col_studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        col_firstName.setCellValueFactory(new PropertyValueFactory<>("studentFirstName"));
        col_lastName.setCellValueFactory(new PropertyValueFactory<>("studentLastName"));

        // Column with a custom cell factory for Yes/No
        col_attendance.setCellValueFactory(new PropertyValueFactory<>("attendance"));
        col_attendance.setCellFactory(CheckBoxTableCell.forTableColumn(col_attendance));

        // Make the col_attendance column editable
        col_attendance.setEditable(true);

        // Set TableView selection mode to SINGLE
        table_attendance.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Handle onEditCommit event for the col_attendance column
        col_attendance.setOnEditCommit(event -> {
            AttendanceData rowData = event.getRowValue();
            rowData.setAttendance(event.getNewValue());
        });

        // Make the TableView editable
        table_attendance.setEditable(true);

        databaseConnection = new AttendanceDatabaseConnection();

        // Initialize ComboBox event listener
        combobox_selectClub.setOnAction(event -> handleClubSelection());
        combobox_selectEvent.setOnAction(event -> handleEventSelection());

        // Populate ComboBoxes with data from the database
        populateComboBoxes();

        // Add sample data (replace this with your actual data)
        attendanceDataList = FXCollections.observableArrayList();
        table_attendance.setItems(attendanceDataList);
    }

    @FXML
    private void handleSaveButton() throws SQLException {
        // Assuming clubComboBox and eventComboBox are your combo boxes
        if (combobox_selectClub.getValue() == null || combobox_selectEvent.getValue() == null) {
            // Display an error message indicating that both club and event must be selected
            showPrompt("Please select both Club and Event before saving attendance.", Alert.AlertType.ERROR);
            return; // Exit the method without attempting to save
        }

        // Iterate through the data list and save attendance to the database
        boolean isSavedSuccessfully = databaseConnection.saveAttendance(attendanceDataList);

        if (isSavedSuccessfully) {
            // Show success prompt
            showPrompt("Attendance saved successfully.", Alert.AlertType.INFORMATION);
            for (AttendanceData data : attendanceDataList) {
                System.out.println("Student ID: " + data.getStudentID() +
                        ", Student Name: " + data.getStudentFirstName() +
                        ", Student Name: " + data.getStudentLastName() +
                        ", Attendance: " + data.getAttendance() +
                        ", eventID: " + data.getEventID());
            }
        } else {
            // Show error prompt
            showPrompt("Error saving attendance. Please check for duplicates.", Alert.AlertType.ERROR);
        }
    }

    private void populateComboBoxes() {
        List<String> clubData = databaseConnection.fetchDataForComboBox("SELECT club_name FROM club");

        // Add data to ComboBox
        combobox_selectClub.setItems(FXCollections.observableArrayList(clubData));
    }

    @FXML
    private void handleClubSelection() {
        // Get the selected club from the ComboBox
        String selectedClub = combobox_selectClub.getValue();

        if (selectedClub != null) {
            // Fetch and display student details for the selected club
            fetchAndDisplayStudentDetails(selectedClub);

            // Fetch and populate events for the selected club
            populateEventsComboBox(selectedClub);

            //Clear the selection for the event comboBox
            combobox_selectEvent.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void handleEventSelection(){
        //Get the selected club and event from the ComboBox
        String selectedClub = combobox_selectClub.getValue();
        String selectedEvent = combobox_selectEvent.getValue();

        if (selectedClub != null && selectedEvent != null){
            // Fetch the event ID from the database based on the selected club and event
            String eventID = databaseConnection.fetchEventID(selectedClub, selectedEvent);

            // Fetch and display student details
            fetchAndDisplayStudentDetails(selectedClub, selectedEvent, eventID);
        }
    }

    private void populateEventsComboBox(String selectedClub) {
        List<String> eventData = databaseConnection.fetchEventsForComboBox(selectedClub);

        // Add data to ComboBox
        combobox_selectEvent.setItems(FXCollections.observableArrayList(eventData));
    }

    private void fetchAndDisplayStudentDetails(String selectedClub) {
        // Fetch student details from the database based on the selected club
        List<AttendanceData> studentDetails = databaseConnection.fetchStudentDetails(selectedClub);

        // Clear existing data in the TableView
        attendanceDataList.clear();

        // Add the fetched student details to the TableView
        attendanceDataList.addAll(studentDetails);
    }

    private void fetchAndDisplayStudentDetails(String selectedClub, String selectedEvent, String eventID) {
        // Fetch student details from the database based on the selected club and event
        List<AttendanceData> studentDetails = databaseConnection.fetchStudentDetails(selectedClub, selectedEvent, eventID);

        // Clear existing data in the TableView
        attendanceDataList.clear();

        // Add the fetched student details to the TableView
        attendanceDataList.addAll(studentDetails);
    }

    private void showPrompt(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle("Attendance System");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleRefreshButton() {
        // Call methods to refresh ComboBoxes and TableView
        refreshClubComboBox();
        refreshTableView();
    }

    private void refreshTableView() {
        // Clear existing data in the TableView
        attendanceDataList.clear();

        String selectedClub = combobox_selectClub.getValue();
        String selectedEvent = combobox_selectEvent.getValue();

        try {
            if (selectedClub != null && selectedEvent != null) {
                String eventID = databaseConnection.fetchEventID(selectedClub, selectedEvent);
                fetchAndDisplayStudentDetails(selectedClub, selectedEvent, eventID);
            } else if (selectedClub != null) {
                fetchAndDisplayStudentDetails(selectedClub);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as needed
        }

        // Refresh the Event ComboBox after updating the TableView
        refreshEventComboBox();

    }

    private void refreshEventComboBox() {
        // Set the value to null to trigger the onAction event
        combobox_selectEvent.getItems().clear();

    }

    private void refreshClubComboBox() {
        // Fetch new data for the Club ComboBox
        List<String> clubData = databaseConnection.fetchDataForComboBox("SELECT club_name FROM club");

        // Clear existing data and add the new data to the ComboBox
        combobox_selectClub.getItems().clear();
        combobox_selectClub.getItems().addAll(clubData);
    }

    @FXML
    private void handleGenerateReportButton() {
        // Generate and display the report
        List<AttendanceData> allAttendanceData = AttendanceDatabaseConnection.getAllAttendanceData();
        AttendanceReportGeneration attendanceReportGeneration = new AttendanceReportGeneration();
        attendanceReportGeneration.generateReport(allAttendanceData);
    }
}

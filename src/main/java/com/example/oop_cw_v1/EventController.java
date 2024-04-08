package com.example.oop_cw_v1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.net.URL;
import java.time.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class EventController implements Initializable {



   @FXML
   void generateReport(ActionEvent event) {
       List<Event> allEventData = EventDataBaseConnection.getAllEventData();
       EventReportGeneration reportGeneration = new EventReportGeneration();
       reportGeneration.generateEventReport(allEventData);

   }



    @FXML
    private Pane createGamePane;

    @FXML
    private Pane createMeetingPane;

    @FXML
    private Pane createWorkshopPane;

    @FXML
    private DatePicker dateInCreateEvents;

    @FXML
    private DatePicker dateInUpdate;

    @FXML
    private TextField descriptionInCreateEvents;

    @FXML
    private Pane eventCreationPane;

    @FXML
    private TextField eventDescriptionInUpdate;

    @FXML
    private TextField eventIdInCreateEvents;

    @FXML
    private TextField eventIdInUpdate;

    @FXML
    private TextField eventLocationInUpdate;

    @FXML
    private TextField eventNameInCreateEvents;

    @FXML
    private TextField eventNameInUpdate;

    @FXML
    private Pane eventPane;

    @FXML
    private TextField eventTimeInUpdate;

    @FXML
    private TextField searchFieldInUpdate;

    @FXML
    private TextField meetingIdIncreatemeeting;

    @FXML
    private DatePicker meetingdateIncreatemeeting;

    @FXML
    private TextField meetingdescriptionIncreatemeeting;

    @FXML
    private TextField meetinglocationIncreatemeeting;

    @FXML
    private TextField meetingnameIncreatemeeting;

    @FXML
    private TextField meetingtimeIncreatemeeting;

    @FXML
    private TextField meetingtypeIncreatemeeting;

    @FXML
    private Pane selectEventTypePane;

    @FXML
    private TextField timeInCreateEvents;

    @FXML
    private Pane updateEvenetPane;

    @FXML
    private Pane selectEventTypeInCreatePane;

    @FXML
    private Pane updateGameDetailsPane;

    @FXML
    private Pane updateMeetingDetailsPane;

    @FXML
    private Pane updateWorkshopDetailsPane;

    @FXML
    private TextField workshopConductorInCreateWorkshop;

    @FXML
    private DatePicker workshopDateInCreateWorkshop;

    @FXML
    private TextField workshopIdInCreateWorkshop;

    @FXML
    private TextField workshopTimeInCreateWorkshop;

    @FXML
    private TextField workshopconductorInupdate;

    @FXML
    private DatePicker workshopdateInupdate;

    @FXML
    private TextField workshopdescriptionInCreateWorkshop;

    @FXML
    private TextField workshopdescriptionInupdate;

    @FXML
    private TextField workshopidInupdate;

    @FXML
    private TextField workshoplocationInCreateWorkshop;

    @FXML
    private TextField workshoplocationInupdate;

    @FXML
    private TextField workshopnameInCreateWorkshop;

    @FXML
    private TextField workshopnameInupdate;

    @FXML
    private TextField workshoptimeInupdate;

    @FXML
    private Pane selectUpdateEventTypePane;

    @FXML
    private DatePicker eventDateincreateevent;

    @FXML
    private TextField eventdescriptionincreateevent;

    @FXML
    private TextField eventidincreateevent;

    @FXML
    private TextField eventlocationincreateevent;

    @FXML
    private TextField eventnameincreateevent;

    @FXML
    private TextField eventtimeincreateevent;

    @FXML
    private TextField eventtypeincreateevent;

    @FXML
    private TextField searchidFieldInMeeting;


    @FXML
    private TextField meetingIdInUpdate;



    @FXML
    private DatePicker meetingdateInUpdate;

    @FXML
    private Pane scheduleEventPane;



    @FXML
    private TextField meetingdescriptionInUpdate;



    @FXML
    private TextField meetinglocationInUpdate;



    @FXML
    private TextField meetingnameInUpdate;

    @FXML
    private Pane updateMeetingPane;

    @FXML
    private Pane updateWorkshopPane;


    @FXML
    private TextField meetingtimeInUpdate;


    @FXML
    private TextField meetingtypeInUpdate;

    @FXML
    private TextField eventTypeInUpdate;

    @FXML
    private TextField workshopIdInSearchField;

    // this is for event
    @FXML
    private TableView<Event> createEventTable;
    @FXML
    private TableColumn<Event, String> dateColumnInCreateEvent;
    @FXML
    private TableColumn<Event, String> descriptionColumnInCreateEvent;
    @FXML
    private TableColumn<Event, String> eventTypeColumnInCreateEvent;
    @FXML
    private TableColumn<Event, String> idColumnInCreateEvent;

    @FXML
    private TableColumn<Event, String> locationColumnInCreateEvent;
    @FXML
    private TableColumn<Event, String> nameColumnInCreateEvent;
    @FXML
    private TableColumn<Event, String> timeColumnInCreateEvent;

    // this is for meeting

    @FXML
    private TableView<Meeting> createMeetingTable;
    @FXML
    private TableColumn<Meeting, String> dateColumnInCreateMeeting;
    @FXML
    private TableColumn<Meeting, String> descriptionColumnInCreateMeeting;
    @FXML
    private TableColumn<Meeting, String> meetingTypeColumnInCreateMeeting;
    @FXML
    private TableColumn<Meeting, String> idColumnInCreateMeeting;

    @FXML
    private TableColumn<Meeting, String> locationColumnInCreateMeeting;
    @FXML
    private TableColumn<Meeting, String> nameColumnInCreateMeeting;
    @FXML
    private TableColumn<Meeting, String> timeColumnInCreateMeeting;


    @FXML
    private TableView<Workshop> createWorkshopTable;
    @FXML
    private TableColumn<Workshop, String> dateColumnInCreateWorkshop;
    @FXML
    private TableColumn<Workshop, String> descriptionColumnInCreateWorkshop;
    @FXML
    private TableColumn<Workshop, String> conductorColumnInCreateWorkshop;
    @FXML
    private TableColumn<Workshop, String> idColumnInCreateWorkshop;

    @FXML
    private TableColumn<Workshop, String> locationColumnInCreateWorkshop;
    @FXML
    private TableColumn<Workshop, String> nameColumnInCreateWorkshop;
    @FXML
    private TableColumn<Workshop, String> timeColumnInCreateWorkshop;

    // for update events
    @FXML
    private TableView<Event> updateEventTable;
    @FXML
    private TableColumn<Event, String> eventDateUpdateEvents;
    @FXML
    private TableColumn<Event, String> eventDescriptionUpdateEvents;
    @FXML
    private TableColumn<Event, String> eventTypeUpdateEvents;
    @FXML
    private TableColumn<Event, String> eventIdUpdateEvents;

    @FXML
    private TableColumn<Event, String> eventLocationUpdateEvents;
    @FXML
    private TableColumn<Event, String> eventNameUpdateEvents;
    @FXML
    private TableColumn<Event, String> eventTimeUpdateEvents;

    // for update meeting
    @FXML
    private TableView<Meeting> updateMeetingTable;
    @FXML
    private TableColumn<Meeting, String> dateInUpdateMeeting;
    @FXML
    private TableColumn<Meeting, String> descriptionInUpdateMeeting;
    @FXML
    private TableColumn<Meeting, String> meetingTypeInUpdateMeeting;
    @FXML
    private TableColumn<Meeting, String> idInUpdateMeeting;

    @FXML
    private TableColumn<Meeting, String> locationInUpdateMeeting;
    @FXML
    private TableColumn<Meeting, String> nameInUpdateMeeting;
    @FXML
    private TableColumn<Meeting, String> timeInUpdateMeeting;


    // update workshop


    @FXML
    private TableView<Workshop> workshopTableInUpdate;
    @FXML
    private TableColumn<Workshop, String> dateInUpdateWorkshop;
    @FXML
    private TableColumn<Workshop, String> descriptionInUpdateWorkshop;
    @FXML
    private TableColumn<Workshop, String> conductorInUpdateWorkshop;
    @FXML
    private TableColumn<Workshop, String> idInUpdateWorkshop;

    @FXML
    private TableColumn<Workshop, String> locationInUpdateWorkshop;
    @FXML
    private TableColumn<Workshop, String> nameInUpdateWorkshop;
    @FXML
    private TableColumn<Workshop, String> timeInUpdateWorkshop;



    @FXML
    void backbtnincreateevents(ActionEvent event) {

    }
    // 2
    @Override
    public void initialize(URL location, ResourceBundle resource){
        idColumnInCreateEvent.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        nameColumnInCreateEvent.setCellValueFactory(new PropertyValueFactory<>("scheduleName"));
        locationColumnInCreateEvent.setCellValueFactory(new PropertyValueFactory<>("scheduleLocation"));
        descriptionColumnInCreateEvent.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        dateColumnInCreateEvent.setCellValueFactory(new PropertyValueFactory<>("scheduleDate"));
        timeColumnInCreateEvent.setCellValueFactory(new PropertyValueFactory<>("scheduleTime"));
        eventTypeColumnInCreateEvent.setCellValueFactory(new PropertyValueFactory<>("eventType"));

        // Meeting Table
        idColumnInCreateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        nameColumnInCreateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleName"));
        locationColumnInCreateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleLocation"));
        descriptionColumnInCreateMeeting.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        dateColumnInCreateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleDate"));
        timeColumnInCreateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleTime"));
        meetingTypeColumnInCreateMeeting.setCellValueFactory(new PropertyValueFactory<>("meetingType"));

        // workshop data

        idColumnInCreateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        nameColumnInCreateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleName"));
        locationColumnInCreateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleLocation"));
        descriptionColumnInCreateWorkshop.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        dateColumnInCreateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleDate"));
        timeColumnInCreateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleTime"));
        conductorColumnInCreateWorkshop.setCellValueFactory(new PropertyValueFactory<>("conductor"));

        // update event

        eventIdUpdateEvents.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        eventNameUpdateEvents.setCellValueFactory(new PropertyValueFactory<>("scheduleName"));
        eventLocationUpdateEvents.setCellValueFactory(new PropertyValueFactory<>("scheduleLocation"));
        eventDescriptionUpdateEvents.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        eventDateUpdateEvents.setCellValueFactory(new PropertyValueFactory<>("scheduleDate"));
        eventTimeUpdateEvents.setCellValueFactory(new PropertyValueFactory<>("scheduleTime"));
        eventTypeUpdateEvents.setCellValueFactory(new PropertyValueFactory<>("eventType"));

        // update meeting

        idInUpdateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        nameInUpdateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleName"));
        locationInUpdateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleLocation"));
        descriptionInUpdateMeeting.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        dateInUpdateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleDate"));
        timeInUpdateMeeting.setCellValueFactory(new PropertyValueFactory<>("scheduleTime"));
        meetingTypeInUpdateMeeting.setCellValueFactory(new PropertyValueFactory<>("meetingType"));


        // workshop update

        idInUpdateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleId"));
        nameInUpdateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleName"));
        locationInUpdateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleLocation"));
        descriptionInUpdateWorkshop.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        dateInUpdateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleDate"));
        timeInUpdateWorkshop.setCellValueFactory(new PropertyValueFactory<>("scheduleTime"));
        conductorInUpdateWorkshop.setCellValueFactory(new PropertyValueFactory<>("conductor"));

    }

    // 3
    public void populateEventTable() {
        List<Event> eventData = EventDataBaseConnection.getEventData();
        System.out.println("Retrieved data: " + eventData);
        createEventTable.getItems().setAll(eventData);
    }

    // for meeting
    public void populateMeetingTable() {
        List<Meeting> meetingData = EventDataBaseConnection.getMeetingData();
        System.out.println("Retrieved data: " + meetingData);
        createMeetingTable.getItems().setAll(meetingData);
    }

    // for workshop

    public void populateWorkshopTable() {
        List<Workshop> workshopData = EventDataBaseConnection.getWorkshopData();
        System.out.println("Retrieved data: " + workshopData);
        createWorkshopTable.getItems().setAll(workshopData);
    }

    public void populateEventUpdate() {
        List<Event> eventData = EventDataBaseConnection.getEventUpdateData();
        System.out.println("Retrieved data: " + eventData);
        updateEventTable.getItems().setAll(eventData);
    }

    public void populateMeetingUpdate() {
        List<Meeting> meetingData = EventDataBaseConnection.getMeetingUpdateData();
        System.out.println("Retrieved data: " + meetingData);
        updateMeetingTable.getItems().setAll(meetingData);
    }


    public void populateWorkshopUpdate() {
        List<Workshop> workshopData = EventDataBaseConnection.getWorkshopUpdateData();
        System.out.println("Retrieved data: " + workshopData);
        workshopTableInUpdate.getItems().setAll(workshopData);
    }


    public void disablePanes(){
        selectEventTypeInCreatePane.setVisible(false);
        scheduleEventPane.setVisible(false);
        eventCreationPane.setVisible(false);
        createMeetingPane.setVisible(false);
        createWorkshopPane.setVisible(false);
        selectUpdateEventTypePane.setVisible(false);
        updateEvenetPane.setVisible(false);
        updateMeetingPane.setVisible(false);
        updateWorkshopPane.setVisible(false);
    }


    @FXML
    private void switchToRegisterNow(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    void clickCreateBtnClick(ActionEvent event) {
        disablePanes();
        selectEventTypeInCreatePane.setVisible(true);
    }

    void backBtninselectingevents(ActionEvent event) {
        disablePanes();
        scheduleEventPane.setVisible(true);
    }

    void onBackbtnincreateevent(ActionEvent event) {
        disablePanes();
        selectEventTypeInCreatePane.setVisible(true);
    }

    void onBackBtnInCreateMeeting(ActionEvent event) {
        disablePanes();
        selectEventTypeInCreatePane.setVisible(true);
    }

    void onBackBtnClickInCreateWorkshop(ActionEvent event) {
        disablePanes();
        selectEventTypeInCreatePane.setVisible(true);
    }

    void onBackBtnClickInselecttoupdate(ActionEvent event) {
        disablePanes();
        scheduleEventPane.setVisible(true);
    }

    void clickDeleteBtnClick(ActionEvent event) {
        disablePanes();
        selectUpdateEventTypePane.setVisible(true);
    }


    public void clickCreateBtnClick() throws IOException {
        disablePanes();
        selectEventTypeInCreatePane.setVisible(true);
    }

    public void clickUpdateBtnClick() throws IOException {
        disablePanes();
        selectUpdateEventTypePane.setVisible(true);
    }
    public void clickDeleteBtnClick() throws IOException {
        disablePanes();
        selectUpdateEventTypePane.setVisible(true);
    }


    public void backBtninselectingevents() throws IOException {
        disablePanes();
        scheduleEventPane.setVisible(true);
    }
    public void onBackBtnClickInselecttoupdate() throws IOException {
        disablePanes();
        scheduleEventPane.setVisible(true);
    }

    public void clickBackToEventPane() throws IOException {
        disablePanes();
        selectUpdateEventTypePane.setVisible(true);
    }

    public void eventBtninselectingevents() throws IOException {
        disablePanes();
        eventCreationPane.setVisible(true);
    }

    @FXML
    void eventBtninselectingevents(ActionEvent event) {
        disablePanes();
        eventCreationPane.setVisible(true);
        populateEventTable();
    }

    @FXML
    public void onEventBtnClickInselecttoupdate(ActionEvent actionEvent) {
        disablePanes();
        updateEvenetPane.setVisible(true);
        populateEventUpdate();
    }

    public void onMeetingBtnClickInselecttoupdate() throws IOException {
        disablePanes();
        updateMeetingPane.setVisible(true);
        populateMeetingUpdate();

    }

    void onEventBtnClickInselecttoupdate() throws IOException {
        disablePanes();
        updateEvenetPane.setVisible(true);
        populateEventUpdate();
    }

    public void meetingBtninselectingevents() throws IOException {
        disablePanes();
        createMeetingPane.setVisible(true);
        populateMeetingTable();

    }

    public void workshopBtninselectingevents() throws IOException {
        disablePanes();
        createWorkshopPane.setVisible(true);
        populateWorkshopTable();
    }

    public void onBackBtnInCreateMeeting() throws IOException {
        disablePanes();
        selectEventTypeInCreatePane.setVisible(true);
    }

    public void onBackBtnClickInCreateWorkshop() throws IOException {
        disablePanes();
        selectEventTypeInCreatePane.setVisible(true);
    }

    public void onBackbtnincreateevent() throws IOException {
        disablePanes();
        selectEventTypeInCreatePane.setVisible(true);
    }

    public void onWorkshopBtnClickInselecttoupdate() throws IOException {
        disablePanes();
        updateWorkshopPane.setVisible(true);
    }


    public void backBtnInUpdateEventPane() throws IOException {
        disablePanes();
        selectUpdateEventTypePane.setVisible(true);
    }

    public void backBtnInUpdateMeeting() throws IOException {
        disablePanes();
        selectUpdateEventTypePane.setVisible(true);
    }

    public void backWorkshopbtninupdate() throws IOException {
        disablePanes();
        selectUpdateEventTypePane.setVisible(true);
    }

    @FXML
    void workshopBtninselectingevents(ActionEvent event) {
        disablePanes();
        createWorkshopPane.setVisible(true);
        populateWorkshopTable();

    }

    @FXML
    void gameBtninselectingevents(ActionEvent event) {
        disablePanes();
        createGamePane.setVisible(true);
    }

    // p+
    @FXML
    void meetingBtninselectingevents(ActionEvent event) {
        disablePanes();
        createMeetingPane.setVisible(true);
        populateMeetingTable();

    }

    public void onWorkshopBtnClickInselecttoupdate(ActionEvent actionEvent) {
       disablePanes();
        updateWorkshopPane.setVisible(true);
        populateWorkshopUpdate();
    }

    public void onBackbtnincreategame(ActionEvent actionEvent) {
        disablePanes();
        selectEventTypePane.setVisible(true);
    }

    public void backWorkshopbtninupdate(ActionEvent actionEvent) {
        disablePanes();
        selectUpdateEventTypePane.setVisible(true);
    }

    // save button in create event and getting date
    public void onsavebtnincreateevent(ActionEvent actionEvent) {
        // Getting data from the text fields
        String eventId = eventidincreateevent.getText();
        String eventName = eventnameincreateevent.getText();
        String eventLocation = eventlocationincreateevent.getText();
        String eventTime = eventtimeincreateevent.getText();
        String clubIdCreateEvent = eventdescriptionincreateevent.getText();
        String eventType = eventtypeincreateevent.getText();
        String eventDate = String.valueOf(eventDateincreateevent.getValue());

        // Validate fields
        if (!eventIdValidationInCreateEvents() || !eventNameValidationInCreateEvents()
                || !eventLocationValidationInCreateEvents() || !eventTimeValidationInCreateEvents()
                || !eventDateValidationInCreateEvents() || !eventTypeValidationInCreateEvents() || !validateClubIdCreateEvent()) {
            // if validation is failed then show alerts
            showAlert(AlertType.ERROR, "Validation Error", "Please fill in all the required fields.");
            return;
        }

        // All fields are valid, then save to the database
        Event event1 = new Event(eventId, eventName, eventLocation, clubIdCreateEvent , eventDate, eventTime, eventType);
        EventDataBaseConnection.insertEventData(event1.getScheduleId(), event1.getScheduleName(),
                event1.getScheduleLocation(), event1.getClubId(), event1.getScheduleDate(),
                event1.getScheduleTime(), event1.getEventType());
        clearTextFieldsInEvent();
        refreshTable();

        // show a success alert
        showAlert(AlertType.INFORMATION, "Success", "Event details saved successfully.");
    }

    public boolean validateClubIdCreateEvent() {
        String clubIdCreateEvent = eventdescriptionincreateevent.getText();

        // Validate clubId in CreateEvent
        if (clubIdCreateEvent == null || clubIdCreateEvent.trim().isEmpty()) {
            showAlert("Validation Error", "Club ID cannot be null or empty. Please enter a valid Club ID.");
            // Set border color to red when indicating  error
            eventdescriptionincreateevent.setStyle("-fx-border-color: red");
            return false; // Validation failed
        } else {
            // Reset the border color for a valid input
            eventdescriptionincreateevent.setStyle("");
            return true; // Validation pass
        }
    }

    public boolean eventIdValidationInCreateEvents() {
        if (eventidincreateevent.getText().isEmpty()) {
            eventidincreateevent.setStyle("-fx-border-color: red");
            return false;
        } else {
            eventidincreateevent.setStyle("");
            return true;
        }
    }

    public boolean eventNameValidationInCreateEvents() {
        String eventName = eventnameincreateevent.getText();
        if (eventName == null || eventName.isEmpty() || !eventName.matches("^[A-Za-z]*$")) {
            eventnameincreateevent.setStyle("-fx-border-color: red");
            return false;
        } else {
            eventnameincreateevent.setStyle("");
            return true;
        }
    }

    public boolean eventLocationValidationInCreateEvents() {
        String eventLocation = eventlocationincreateevent.getText();
        if (eventLocation == null || eventLocation.isEmpty() || !eventLocation.matches("^[A-Za-z]*$")) {
            eventlocationincreateevent.setStyle("-fx-border-color: red");
            return false;
        } else {
            eventlocationincreateevent.setStyle("");
            return true;
        }
    }

    public boolean eventTimeValidationInCreateEvents() {
        String eventTime = eventtimeincreateevent.getText();
        if (!validateEventTime(eventTime)) {
            eventtimeincreateevent.setStyle("-fx-border-color: red");
            return false;
        } else {
            eventtimeincreateevent.setStyle("");
            return true;
        }
    }

    public boolean eventTypeValidationInCreateEvents() {
        String eventType = eventtypeincreateevent.getText();
        if (eventType == null || !eventType.matches("^(online|physical)$")) {
            eventtypeincreateevent.setStyle("-fx-border-color: red");
            return false;
        } else {
            eventtypeincreateevent.setStyle("");
            return true;
        }
    }

    public boolean validateEventTime(String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime.parse(time, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean eventDateValidationInCreateEvents() {
        if (eventDateincreateevent.getValue() == null) {
            showAlert(AlertType.ERROR, "Validation Error", "Please select an event date.");
            return false;
        } else {
            return true;
        }
    }

    private void showAlert(AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }



    public void searchEventIdInUpdate(ActionEvent actionEvent) {
        String searchEventId = searchFieldInUpdate.getText();

        Event foundEvent = MainSchedule.getEventDetailsById(searchEventId);

        if (foundEvent != null){
            // when event found then set text to update
            eventIdInUpdate.setText(foundEvent.getScheduleId());
            eventNameInUpdate.setText(foundEvent.getScheduleName());
            eventLocationInUpdate.setText(foundEvent.getScheduleLocation());
            eventDescriptionInUpdate.setText(foundEvent.getClubId());
            dateInUpdate.setValue( LocalDate.parse(foundEvent.getScheduleDate()));
            eventTimeInUpdate.setText(foundEvent.getScheduleTime());
            eventTypeInUpdate.setText(foundEvent.getEventType());

        } else {
            // When Event not found then provide feedback to the user
            showAlert("Event not found", "The event with ID " + searchEventId + " was not found.");

            // Clear the fields or set them to default values as needed
            eventIdInUpdate.clear();
            eventNameInUpdate.clear();
            eventLocationInUpdate.clear();
            eventTimeInUpdate.clear();
            eventDescriptionInUpdate.clear();
            eventTypeInUpdate.clear();
            dateInUpdate.setValue(null);
        }

    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void deleteEventBtnClick(ActionEvent actionEvent){
        // Get the event ID to delete
        String deleteEventId = searchFieldInUpdate.getText();
        System.out.println(deleteEventId);

        // Confirm deletion from the user
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Deletion");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("Are you sure you want to delete the event with ID " + deleteEventId + "?");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User confirmed the deletion
            // Delete event details from the database
            EventDataBaseConnection.deleteEventData(deleteEventId);



            // Provide feedback to the user (e.g., show an alert)
            showAlert("Event Deleted", "Event details have been successfully deleted.");

            // Optionally, clear the fields or set them to default values
            eventIdInUpdate.clear();
            eventNameInUpdate.clear();
            eventLocationInUpdate.clear();
            eventTimeInUpdate.clear();
            eventDescriptionInUpdate.clear();
            eventTypeInUpdate.clear();
            dateInUpdate.setValue(null);
        }

    }

    private void clearTextFieldsInEvent() {
        // Clear the text fields in meeting
        eventidincreateevent.clear();
        eventnameincreateevent.clear();
        eventlocationincreateevent.clear();
        eventtimeincreateevent.clear();
        eventdescriptionincreateevent.clear();
        eventtypeincreateevent.clear();
        eventDateincreateevent.getEditor().clear();
    }

    boolean createMeetingAllValidation = true;

    public void onsaveBtnIncreatemeeting(ActionEvent actionEvent) {
        // Getting data from the text fields
        String meetingId = meetingIdIncreatemeeting.getText();
        String meetingName = meetingnameIncreatemeeting.getText();
        String meetingLocation = meetinglocationIncreatemeeting.getText();
        String meetingTime = meetingtimeIncreatemeeting.getText();
        String meetingClubId = meetingdescriptionIncreatemeeting.getText();
        String meetingType = meetingtypeIncreatemeeting.getText();
        String meetingDate = String.valueOf(meetingdateIncreatemeeting.getValue());

        // Validate fields
        if (!meetingIdValidationInCreateEvents() || !meetingNameValidationInCreateEvents() || !meetingTimeValidationInCreateEvents()
                || !meetingTypeValidationInCreateEvents() || !meetingDateValidationInCreateEvents() || !validateClubIdCreateMeeting()) {
            // Validation failed, show an alert
            showAlert(AlertType.ERROR, "Validation Error", "Please fill in all the required fields.");
            return;
        }

        // All fields are valid then save to the database
        Meeting meeting1 = new Meeting(meetingId, meetingName, meetingLocation, meetingClubId, meetingDate, meetingTime, meetingType);
        EventDataBaseConnection.insertMeetingData(meeting1.getScheduleId(), meeting1.getScheduleName(),
                meeting1.getScheduleLocation(), meeting1.getClubId(), meeting1.getScheduleDate(),
                meeting1.getScheduleTime(), meeting1.getMeetingType());
        clearTextFieldsInMeeting();
        refreshCreateMeetingTable();

        // show a success message
        showAlert(AlertType.INFORMATION, "Success", "Meeting details saved successfully.");
    }

    public boolean validateClubIdCreateMeeting() {
        String clubIdCreateMeeting = meetingdescriptionIncreatemeeting.getText();

        // Validate clubIdCreateEvent
        if (clubIdCreateMeeting == null || clubIdCreateMeeting.trim().isEmpty()) {
            showAlert("Validation Error", "Club ID cannot be null or empty. Please enter a valid Club ID.");
            // Set border color to red when validating errors
            meetingdescriptionIncreatemeeting.setStyle("-fx-border-color: red");
            return false; // Validation failed
        } else {
            // Reset the border color for a valid input
            meetingdescriptionIncreatemeeting.setStyle("");
            return true; // Validation pass
        }
    }

    public boolean meetingIdValidationInCreateEvents() {
        if (meetingIdIncreatemeeting.getText().isEmpty()) {
            meetingIdIncreatemeeting.setStyle("-fx-border-color: red");
            createMeetingAllValidation = false;
            return false;
        } else {
            meetingIdIncreatemeeting.setStyle("");
            return true;
        }
    }

    public boolean meetingNameValidationInCreateEvents() {
        String eventName = meetingnameIncreatemeeting.getText();

        // Validate event name
        if (eventName == null || eventName.isEmpty() || !eventName.matches("^[A-Za-z]*$")) {
            meetingnameIncreatemeeting.setStyle("-fx-border-color: red");
            createMeetingAllValidation = false;
            return false;
        } else {
            meetingnameIncreatemeeting.setStyle("");
            return true;
        }
    }



    public boolean meetingTimeValidationInCreateEvents() {
        String meetingTime = meetingtimeIncreatemeeting.getText();

        // Validate event time
        if (!validateMeetingTime(meetingTime)) {
            meetingtimeIncreatemeeting.setStyle("-fx-border-color: red");
            createMeetingAllValidation = false;
            return false;
        } else {
            meetingtimeIncreatemeeting.setStyle("");
            return true;
        }
    }

    public boolean validateMeetingTime(String meetingTime) {
        return meetingTime.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    public boolean meetingTypeValidationInCreateEvents() {
        String meetingType = meetingtypeIncreatemeeting.getText();

        // Validate event type
        if (!validateMeetingType(meetingType)) {
            meetingtypeIncreatemeeting.setStyle("-fx-border-color: red");
            createMeetingAllValidation = false;
            return false;
        } else {
            meetingtypeIncreatemeeting.setStyle("");
            return true;
        }
    }

    public boolean validateMeetingType(String meetingType) {
        // Check if the event type is not null and is either "online" or "physical"
        return meetingType != null && (meetingType.equalsIgnoreCase("online") || meetingType.equalsIgnoreCase("physical"));
    }

    public boolean meetingDateValidationInCreateEvents() {
        if (meetingdateIncreatemeeting.getValue() == null) {
            showAlert(AlertType.ERROR, "Validation Error", "Please select a meeting date.");
            return false;
        } else {
            meetingdateIncreatemeeting.setStyle("");
            return true;
        }
    }

    public void onSearchBtnInmeetingUpdate(ActionEvent actionEvent) {
        String searchMeetingId = searchidFieldInMeeting.getText();

        Meeting foundMeeting = MainSchedule.getMeetingDetailsById(searchMeetingId);

        if (foundMeeting != null){
            // if event found then set text to update
            meetingIdInUpdate.setText(foundMeeting.getScheduleId());
            meetingnameInUpdate.setText(foundMeeting.getScheduleName());
            meetinglocationInUpdate.setText(foundMeeting.getScheduleLocation());
            meetingtimeInUpdate.setText(foundMeeting.getScheduleTime());
            meetingdescriptionInUpdate.setText(foundMeeting.getClubId());
            meetingtypeInUpdate.setText(foundMeeting.getMeetingType());
            meetingdateInUpdate.setValue(LocalDate.parse(foundMeeting.getScheduleDate()));
        } else {
            // Event not found, provide feedback to the user
            showAlert("Event not found", "The event with ID " + searchMeetingId + " was not found.");

            // Clear the fields or set them to default values as needed
            meetingIdInUpdate.clear();
            meetingnameInUpdate.clear();
            meetinglocationInUpdate.clear();
            meetingtimeInUpdate.clear();
            meetingdescriptionInUpdate.clear();
            meetingtypeInUpdate.clear();
            searchidFieldInMeeting.clear();
            meetingdateInUpdate.setValue(null);
        }

    }

    public void deleteMeetingdetailsClick(ActionEvent actionEvent){
        // Get the event ID to delete
        String deleteMeetingId = searchidFieldInMeeting.getText();

        // Confirm deletion with the user
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Deletion");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("Are you sure you want to delete the event with ID " + deleteMeetingId + "?");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User confirmed deletion, then deletion

            // Delete event details from the database
            EventDataBaseConnection.deleteMeetingData(deleteMeetingId);



            // Provide feedback to the user
            showAlert("Event Deleted", "Event details have been successfully deleted.");

            // Optionally, clear the fields or set them to default values
            meetingIdInUpdate.clear();
            meetingnameInUpdate.clear();
            meetinglocationInUpdate.clear();
            meetingtimeInUpdate.clear();
            meetingdescriptionInUpdate.clear();
            meetingtypeInUpdate.clear();
            searchidFieldInMeeting.clear();
            meetingdateInUpdate.setValue(null);
        }
    }

    private void clearTextFieldsInMeeting() {
        // Clear the text fields in meeting
        meetingIdIncreatemeeting.clear();
        meetingnameIncreatemeeting.clear();
        meetinglocationIncreatemeeting.clear();
        meetingtimeIncreatemeeting.clear();
        meetingdescriptionIncreatemeeting.clear();
        meetingtypeIncreatemeeting.clear();
        meetingdateIncreatemeeting.getEditor().clear();
    }


    boolean createWorkshopAllValidation = true;

    public void onSaveBtnClickInCreateWorkshop(ActionEvent actionEvent) {
        // Getting data from the text fields
        String workshopId = workshopIdInCreateWorkshop.getText();
        String workshopName = workshopnameInCreateWorkshop.getText();
        String workshopLocation = workshoplocationInCreateWorkshop.getText();
        String workshopTime = workshopTimeInCreateWorkshop.getText();
        String clubIdInWorkshop = workshopdescriptionInCreateWorkshop.getText();
        String workshopConductor = workshopConductorInCreateWorkshop.getText();
        String workshopDate = String.valueOf(workshopDateInCreateWorkshop.getValue());

        // Validate fields
        if (!workshopIdValidationInCreateWorkshop() || !workshopNameValidationInCreateWorkshop()
                || !workshopLocationValidationInCreateWorkshop() || !workshopTimeValidationInCreateWorkshop()
                || !workshopConductorValidationInCreateWorkshop() || !workshopDateValidationInCreateWorkshop() || !validateClubIdCreateWorkshop()) {
            // when Validation failed, show an alert
            showAlert(AlertType.ERROR, "Validation Error", "Please fill in all the required fields.");
            return;
        }

        // All fields are valid, proceed to save to the database
        Workshop workshop1 = new Workshop(workshopId, workshopName, workshopLocation, clubIdInWorkshop, workshopDate, workshopTime, workshopConductor);
        EventDataBaseConnection.insertWorkshopData(workshop1.getScheduleId(), workshop1.getScheduleName(),
                workshop1.getScheduleLocation(), workshop1.getClubId(), workshop1.getScheduleDate(),
                workshop1.getScheduleTime(), workshop1.getConductor());
        clearTextFieldsInWorkshop();
        refreshCreateWorkshopTable();

        //  show a success message
        showAlert(AlertType.INFORMATION, "Success", "Workshop details saved successfully.");
    }

    public boolean validateClubIdCreateWorkshop() {
        String clubIdCreateWorkshop = workshopdescriptionInCreateWorkshop.getText();

        // Validate clubIdCreateEvent
        if (clubIdCreateWorkshop == null || clubIdCreateWorkshop.trim().isEmpty()) {
            showAlert("Validation Error", "Club ID cannot be null or empty. Please enter a valid Club ID.");

            workshopdescriptionInCreateWorkshop.setStyle("-fx-border-color: red");
            return false; // Validation failed
        } else {
            // Reset the border color for a valid input
            workshopdescriptionInCreateWorkshop.setStyle("");
            return true; // Validation pass
        }
    }

    public boolean workshopIdValidationInCreateWorkshop() {
        if (workshopIdInCreateWorkshop.getText().isEmpty()) {
            workshopIdInCreateWorkshop.setStyle("-fx-border-color: red");
            createWorkshopAllValidation = false;
            return false;
        } else {
            workshopIdInCreateWorkshop.setStyle("");
            return true;
        }
    }

    public boolean workshopNameValidationInCreateWorkshop() {
        String eventName = workshopnameInCreateWorkshop.getText();

        // Validate event name
        if (eventName == null || eventName.isEmpty() || !eventName.matches("^[A-Za-z]*$")) {
            workshopnameInCreateWorkshop.setStyle("-fx-border-color: red");
            createWorkshopAllValidation = false;
            return false;
        } else {
            workshopnameInCreateWorkshop.setStyle("");
            return true;
        }
    }

    public boolean workshopLocationValidationInCreateWorkshop() {
        String eventLocation = workshoplocationInCreateWorkshop.getText();

        // Validate event location
        if (eventLocation == null || eventLocation.isEmpty() || !eventLocation.matches("^[A-Za-z]*$")) {
            workshoplocationInCreateWorkshop.setStyle("-fx-border-color: red");
            createWorkshopAllValidation = false;
            return false;
        } else {
            workshoplocationInCreateWorkshop.setStyle("");
            return true;
        }
    }

    public boolean workshopTimeValidationInCreateWorkshop() {
        String workshopTime = workshopTimeInCreateWorkshop.getText();

        // Validate event time
        if (!validateWorkshopTime(workshopTime)) {
            workshopTimeInCreateWorkshop.setStyle("-fx-border-color: red");
            createWorkshopAllValidation = false;
            return false;
        } else {
            workshopTimeInCreateWorkshop.setStyle("");
            return true;
        }
    }

    public boolean validateWorkshopTime(String workshopTime) {
        return workshopTime.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    public boolean workshopConductorValidationInCreateWorkshop() {
        String workshopConductor = workshopConductorInCreateWorkshop.getText();

        // Validate workshop conductor
        if (workshopConductor == null || workshopConductor.isEmpty() || !workshopConductor.matches("^[A-Za-z ]+$")) {
            workshopConductorInCreateWorkshop.setStyle("-fx-border-color: red");
            createWorkshopAllValidation = false;
            return false;
        } else {
            workshopConductorInCreateWorkshop.setStyle("");
            return true;
        }
    }

    public boolean workshopDateValidationInCreateWorkshop() {
        LocalDate selectedDate = workshopDateInCreateWorkshop.getValue();

        // Validate workshop date
        if (selectedDate == null) {
            workshopDateInCreateWorkshop.setStyle("-fx-border-color: red");
            createWorkshopAllValidation = false;
            return false;
        } else {
            workshopDateInCreateWorkshop.setStyle("");
            return true;
        }
    }





    public void searchBtnInUpdateWorkshop(ActionEvent actionEvent) {
        String searchWorkshopId = workshopIdInSearchField.getText();

        Workshop foundWorkshop = MainSchedule.getWorkshopDetailsById(searchWorkshopId);


        if (foundWorkshop != null){
            // if event found then set text to update
            workshopidInupdate.setText(foundWorkshop.getScheduleId());
            workshopnameInupdate.setText(foundWorkshop.getScheduleName());
            workshoplocationInupdate.setText(foundWorkshop.getScheduleLocation());
            workshoptimeInupdate.setText(foundWorkshop.getScheduleTime());
            workshopdescriptionInupdate.setText(foundWorkshop.getClubId());
            workshopconductorInupdate.setText(foundWorkshop.getConductor());
            workshopdateInupdate.setValue(LocalDate.parse(foundWorkshop.getScheduleDate()));

        } else {
            // if Event not found, provide feedback to the user
            showAlert("Event not found", "The event with ID " + searchWorkshopId + " was not found.");

            // Clear the fields or set them to default values as needed
            workshopidInupdate.clear();
            workshopnameInupdate.clear();
            workshoplocationInupdate.clear();
            workshoptimeInupdate.clear();
            workshopdescriptionInupdate.clear();
            workshopconductorInupdate.clear();
            workshopdateInupdate.setValue(null);
        }
    }

    public void deleteWorkshopbtninupdate(ActionEvent actionEvent){
        // Get the event ID to delete
        String deleteWorkshopId = workshopIdInSearchField.getText();

        // Confirm deletion with the user
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm Deletion");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("Are you sure you want to delete the event with ID " + deleteWorkshopId + "?");

        Optional<ButtonType> result = confirmAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User confirmed deletion, proceed with deletion

            // Delete event details from the database
            EventDataBaseConnection.deleteWorkshopData(deleteWorkshopId);

            // Provide feedback to the user
            showAlert("Event Deleted", "Event details have been successfully deleted.");

            // clear the fields or set them to default values
            workshopidInupdate.clear();
            workshopnameInupdate.clear();
            workshoplocationInupdate.clear();
            workshoptimeInupdate.clear();
            workshopdescriptionInupdate.clear();
            workshopconductorInupdate.clear();
            workshopdateInupdate.setValue(null);
        }
    }



    private void clearTextFieldsInWorkshop() {
        // Clear the text fields in meeting
        workshopIdInCreateWorkshop.clear();
        workshopnameInCreateWorkshop.clear();
        workshoplocationInCreateWorkshop.clear();
        workshopTimeInCreateWorkshop.clear();
        workshopdescriptionInCreateWorkshop.clear();
        workshopConductorInCreateWorkshop.clear();
        workshopDateInCreateWorkshop.getEditor().clear();
    }

    boolean updateEventsAllValidation = true;

    public void onSaveBtnClickInUpdateevents(ActionEvent actionEvent) {
        // Get the updated event details from the text fields
        String eventId = eventIdInUpdate.getText();
        String eventName = eventNameInUpdate.getText();
        String location = eventLocationInUpdate.getText();
        String description = eventDescriptionInUpdate.getText();
        String eventDate = String.valueOf(dateInUpdate.getValue());
        String time = eventTimeInUpdate.getText();
        String eventType = eventTypeInUpdate.getText();

        // Validate fields
        if (!eventIdValidationInUpdateEvents() || !eventNameValidationInUpdateEvents()
                || !eventLocationValidationInUpdateEvents()
                || !eventTypeValidationInUpdateEvents() || !eventDateValidationInUpdateEvents() || !eventTimeValidationInUpdateEvents() || !validateClubIdUpdateEvent()) {
            return; // Validation failed, alerts will be shown within the methods
        }

        // Update event data in the database
        EventDataBaseConnection.updateEventData(eventId, eventName, location, description, eventDate, time, eventType);

        // Provide feedback to the user (e.g., show an alert)
        showAlert("Event Updated", "Event details have been successfully updated.");

        // Optionally, clear the fields or set them to default values
        clearFieldsInUpdateEvents();
        refreshUpdateEventTable();
    }

    public boolean validateClubIdUpdateEvent() {
        String clubIdUpdateWorkshop = eventDescriptionInUpdate.getText();

        // Validate clubIdCreateEvent
        if (clubIdUpdateWorkshop == null || clubIdUpdateWorkshop.trim().isEmpty()) {
            showAlert("Validation Error", "Club ID cannot be null or empty. Please enter a valid Club ID.");
            // Set border color to red for indicating validation error
            eventDescriptionInUpdate.setStyle("-fx-border-color: red");
            return false; // Validation failed
        } else {
            // Reset the border color for a valid input
            eventDescriptionInUpdate.setStyle("");
            return true; // Validation passed
        }
    }

    // Validation in updates
    public boolean eventIdValidationInUpdateEvents() {
        if (eventIdInUpdate.getText().isEmpty()) {
            showAlert("Validation Error", "Please enter the Event ID.");
            eventIdInUpdate.setStyle("-fx-border-color: red");
            updateEventsAllValidation = false;
            return false;
        } else {
            eventIdInUpdate.setStyle("");
            return true;
        }
    }

    public boolean eventNameValidationInUpdateEvents() {
        String eventName = eventNameInUpdate.getText();

        // Validate event name
        if (eventName == null || eventName.isEmpty() || !eventName.matches("^[A-Za-z]*$")) {
            showAlert("Validation Error", "Please enter a valid Event Name with only alphabets.");
            eventNameInUpdate.setStyle("-fx-border-color: red");
            updateEventsAllValidation = false;
            return false;
        } else {
            eventNameInUpdate.setStyle("");
            return true;
        }
    }

    public boolean eventLocationValidationInUpdateEvents() {
        String eventLocation = eventLocationInUpdate.getText();

        // Validate event location
        if (!eventLocation.matches("^[A-Za-z]*$")) {
            showAlert("Validation Error", "Please enter a valid Event Location with only alphabets.");
            eventLocationInUpdate.setStyle("-fx-border-color: red");
            updateEventsAllValidation = false;
            return false;
        } else {
            eventLocationInUpdate.setStyle("");
            return true;
        }
    }




    public boolean eventTypeValidationInUpdateEvents() {
        String eventType = eventTypeInUpdate.getText();

        // Validate event type
        if (!validateEventTypeUpdate(eventType)) {
            showAlert("Validation Error", "Please enter a valid Event Type (online/physical).");
            eventTypeInUpdate.setStyle("-fx-border-color: red");
            updateEventsAllValidation = false;
            return false;
        } else {
            eventTypeInUpdate.setStyle("");
            return true;
        }
    }

    public boolean validateEventTypeUpdate(String eventType) {
        // Check if the event type is not null and is either "online" or "physical"
        return eventType != null && (eventType.equalsIgnoreCase("online") || eventType.equalsIgnoreCase("physical"));
    }

    public boolean eventDateValidationInUpdateEvents() {
        LocalDate selectedDate = dateInUpdate.getValue();

        // Validate event date
        if (selectedDate == null) {
            showAlert("Validation Error", "Please select an Event Date.");
            dateInUpdate.setStyle("-fx-border-color: red");
            updateEventsAllValidation = false;
            return false;
        } else {
            dateInUpdate.setStyle("");
            return true;
        }
    }

    public boolean eventTimeValidationInUpdateEvents() {
        String eventTimeUpdate = eventTimeInUpdate.getText();

        // Validate event time
        if (!validateEventUpdateTime(eventTimeUpdate)) {
            eventTimeInUpdate.setStyle("-fx-border-color: red");
            updateEventsAllValidation = false;
            return false;
        } else {
            eventTimeInUpdate.setStyle("");
            return true;
        }
    }

    public boolean validateEventUpdateTime(String eventTimeUpdate) {
        return eventTimeUpdate.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }



    private void clearFieldsInUpdateEvents() {
        eventIdInUpdate.clear();
        eventNameInUpdate.clear();
        eventLocationInUpdate.clear();
        eventTimeInUpdate.clear();
        eventDescriptionInUpdate.clear();
        eventTypeInUpdate.clear();
        dateInUpdate.setValue(null);
    }

    public void onsavebtninupdatemeeting(ActionEvent actionEvent) {
        // Get the updated meeting details from the text fields
        String meetingId = meetingIdInUpdate.getText();
        String meetingName = meetingnameInUpdate.getText();
        String meetingLocation = meetinglocationInUpdate.getText();
        String clubIdMeeting = meetingdescriptionInUpdate.getText();
        String meetingDate = String.valueOf(meetingdateInUpdate.getValue());
        String meetingTime = meetingtimeInUpdate.getText();
        String meetingType = meetingtypeInUpdate.getText();

        if (!eventIdValidationInUpdateMeeting() || !eventNameValidationInUpdateMeeting()
                || !eventLocationValidationInUpdateMeeting() || !validateClubIdUpdateMeeting()
                || !eventDateValidationInUpdateMeeting() || !meetingTimeValidationInUpdateMeeting()
                || !eventTypeValidationInUpdateMeeting()) {
            return;
        }

        // Update meeting data in the database
        EventDataBaseConnection.updateMeetingData(meetingId, meetingName, meetingLocation, clubIdMeeting, meetingDate, meetingTime, meetingType);

        // Provide feedback to the user (e.g., show an alert)
        showAlert("Meeting Updated", "Meeting details have been successfully updated.");

        // Optionally, clear the fields or set them to default values
        clearFieldsInUpdateMeeting();
        refreshUpdateMeetingTable();
    }

    boolean updateMeetingAllValidation = true;

    public boolean eventIdValidationInUpdateMeeting() {
        if (meetingIdInUpdate.getText().isEmpty()) {
            meetingIdInUpdate.setStyle("-fx-border-color: red");
            updateMeetingAllValidation = false;
            return false;
        } else {
            meetingIdInUpdate.setStyle("");
            return true;
        }
    }

    public boolean eventNameValidationInUpdateMeeting() {
        String eventName = meetingnameInUpdate.getText();

        // Validate event name
        if (eventName == null || eventName.isEmpty() || !eventName.matches("^[A-Za-z]*$")) {
            meetingnameInUpdate.setStyle("-fx-border-color: red");
            updateMeetingAllValidation = false;
            return false;
        } else {
            meetingnameInUpdate.setStyle("");
            return true;
        }
    }

    public boolean eventLocationValidationInUpdateMeeting() {
        String eventLocation = meetinglocationInUpdate.getText();

        // Validate event location
        if (eventLocation == null || eventLocation.isEmpty() || !eventLocation.matches("^[A-Za-z]*$")) {
            meetinglocationInUpdate.setStyle("-fx-border-color: red");
            updateMeetingAllValidation = false;
            return false;
        } else {
            meetinglocationInUpdate.setStyle("");
            return true;
        }
    }

    public boolean meetingTimeValidationInUpdateMeeting() {
        String meetingTimeUpdate = meetingtimeInUpdate.getText();

        // Validate meeting time
        if (!validateMeetingUpdateTime(meetingTimeUpdate)) {
            meetingtimeInUpdate.setStyle("-fx-border-color: red");
            updateMeetingAllValidation = false;
            return false;
        } else {
            meetingtimeInUpdate.setStyle("");
            return true;
        }
    }

    public boolean validateMeetingUpdateTime(String meetingTimeUpdate) {
        return meetingTimeUpdate.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    public boolean eventTypeValidationInUpdateMeeting() {
        String eventType = meetingtypeInUpdate.getText();

        // Validate event type
        if (!validateMeetingTypeUpdate(eventType)) {
            meetingtypeInUpdate.setStyle("-fx-border-color: red");
            updateMeetingAllValidation = false;
            return false;
        } else {
            meetingtypeInUpdate.setStyle("");
            return true;
        }
    }

    public boolean validateMeetingTypeUpdate(String eventType) {
        // Check if the event type is not null and is either "online" or "physical"
        return eventType != null && (eventType.equalsIgnoreCase("online") || eventType.equalsIgnoreCase("physical"));
    }

    public boolean eventDateValidationInUpdateMeeting() {
        LocalDate selectedDate = meetingdateInUpdate.getValue();

        // Validate meeting date
        if (selectedDate == null) {
            meetingdateInUpdate.setStyle("-fx-border-color: red");
            updateMeetingAllValidation = false;
            return false;
        } else {
            meetingdateInUpdate.setStyle("");
            return true;
        }
    }

    public boolean validateClubIdUpdateMeeting() {
        String clubIdUpdateMeeting = meetingdescriptionInUpdate.getText();

        // Validate clubIdUpdateMeeting
        if (clubIdUpdateMeeting == null || clubIdUpdateMeeting.trim().isEmpty()) {
            showAlert("Validation Error", "Club ID cannot be null or empty. Please enter a valid Club ID.");
            // Set border color to red for indicating validation error
            meetingdescriptionInUpdate.setStyle("-fx-border-color: red");
            return false; // Validation failed
        } else {
            // Reset the border color for a valid input
            meetingdescriptionInUpdate.setStyle("");
            return true; // Validation passed
        }
    }

    public void clearFieldsInUpdateMeeting() {
        // Clear or set fields to default values
        meetingIdInUpdate.clear();
        meetingnameInUpdate.clear();
        meetinglocationInUpdate.clear();
        meetingtimeInUpdate.clear();
        meetingdescriptionInUpdate.clear();
        meetingtypeInUpdate.clear();
        searchidFieldInMeeting.clear();
        meetingdateInUpdate.setValue(null);
    }





    boolean updateWorkshopAllValidation = true;

    public void saveWorkshopbtninupdate(ActionEvent actionEvent) {
        // Get the updated workshop details from the text fields
        String workshopId = workshopidInupdate.getText();
        String workshopName = workshopnameInupdate.getText();
        String workshopLocation = workshoplocationInupdate.getText();
        String workshopDescription = workshopdescriptionInupdate.getText();
        String date = String.valueOf(workshopdateInupdate.getValue());
        String workshopTime = workshoptimeInupdate.getText();
        String workshopConductor = workshopconductorInupdate.getText();

        // Validate workshop fields
        if (!workshopIdValidationInUpdate() || !workshopNameValidationInUpdate()
                || !workshopLocationValidationInUpdate()
                || !workshopConductorValidationInUpdate() || !workshopDateValidationInUpdate() || !workshopTimeValidationInUpdateWorkshop()) {
            return; // Validation failed, alerts will be shown within the methods
        }

        // Update workshop data in the database
        EventDataBaseConnection.updateWorkshopData(workshopId, workshopName, workshopLocation, workshopDescription, date, workshopTime, workshopConductor);

        // Provide feedback to the user (e.g., show an alert)
        showAlert("Workshop Updated", "Workshop details have been successfully updated.");

        // Optionally, clear the fields or set them to default values
        clearFieldsInUpdateWorkshop();
        refreshUpdateWorkshopTable();
    }

    // Validation for updating workshops
    public boolean workshopIdValidationInUpdate() {
        if (workshopidInupdate.getText().isEmpty()) {
            showAlert("Validation Error", "Please enter the Workshop ID.");
            workshopidInupdate.setStyle("-fx-border-color: red");
            updateWorkshopAllValidation = false;
            return false;
        } else {
            workshopidInupdate.setStyle("");
            return true;
        }
    }

    public boolean workshopNameValidationInUpdate() {
        String workshopName = workshopnameInupdate.getText();

        // Validate workshop name
        if (workshopName == null || workshopName.isEmpty() || !workshopName.matches("^[A-Za-z]*$")) {
            showAlert("Validation Error", "Please enter a valid Workshop Name with only alphabets.");
            workshopnameInupdate.setStyle("-fx-border-color: red");
            updateWorkshopAllValidation = false;
            return false;
        } else {
            workshopnameInupdate.setStyle("");
            return true;
        }
    }

    public boolean workshopLocationValidationInUpdate() {
        String workshopLocation = workshoplocationInupdate.getText();

        // Validate workshop location
        if (!workshopLocation.matches("^[A-Za-z]*$")) {
            showAlert("Validation Error", "Please enter a valid Workshop Location with only alphabets.");
            workshoplocationInupdate.setStyle("-fx-border-color: red");
            updateWorkshopAllValidation = false;
            return false;
        } else {
            workshoplocationInupdate.setStyle("");
            return true;
        }
    }

    public boolean workshopConductorValidationInUpdate() {
        String workshopConductor = workshopconductorInupdate.getText();

        // Validate workshop conductor
        if ( !workshopConductor.matches("^[A-Za-z ]+$")) {
            showAlert("Validation Error", "Please enter a valid Workshop Conductor with only alphabets and spaces.");
            workshopconductorInupdate.setStyle("-fx-border-color: red");
            updateWorkshopAllValidation = false;
            return false;
        } else {
            workshopconductorInupdate.setStyle("");
            return true;
        }
    }

    public boolean workshopDateValidationInUpdate() {
        LocalDate selectedDate = workshopdateInupdate.getValue();

        // Validate workshop date
        if (selectedDate == null) {
            showAlert("Validation Error", "Please select a Workshop Date.");
            workshopdateInupdate.setStyle("-fx-border-color: red");
            updateWorkshopAllValidation = false;
            return false;
        } else {
            workshopdateInupdate.setStyle("");
            return true;
        }
    }

    public boolean workshopTimeValidationInUpdateWorkshop() {
        String workshopTimeUpdate = workshoptimeInupdate.getText();

        // Validate event time
        if (!validateWorkshopUpdateTime(workshopTimeUpdate)) {
            workshoptimeInupdate.setStyle("-fx-border-color: red");
            updateWorkshopAllValidation = false;
            return false;
        } else {
            workshoptimeInupdate.setStyle("");
            return true;
        }
    }

    public boolean validateWorkshopUpdateTime(String workshopTimeUpdate) {
        return workshopTimeUpdate.matches("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    // Clear fields method (call this to clear or reset the fields)
    private void clearFieldsInUpdateWorkshop() {
        workshopidInupdate.clear();
        workshopnameInupdate.clear();
        workshoplocationInupdate.clear();
        workshoptimeInupdate.clear();
        workshopdescriptionInupdate.clear();
        workshopconductorInupdate.clear();
        workshopdateInupdate.setValue(null);
    }

    private void refreshTable(){
        List<Event> events = EventDataBaseConnection.getEventData();
        createEventTable.getItems().clear();
        createEventTable.getItems().addAll(events);
        createEventTable.refresh();
    }

    private void refreshCreateMeetingTable(){
        List<Meeting> createMeeting = EventDataBaseConnection.getMeetingData();
        createMeetingTable.getItems().clear();
        createMeetingTable.getItems().addAll(createMeeting);
        createMeetingTable.refresh();
    }

    private void refreshCreateWorkshopTable(){
        List<Workshop> createWorkshop = EventDataBaseConnection.getWorkshopData();
        createWorkshopTable.getItems().clear();
        createWorkshopTable.getItems().addAll(createWorkshop);
        createWorkshopTable.refresh();
    }

    private void refreshUpdateEventTable(){
        List<Event> updateEvent = EventDataBaseConnection.getEventUpdateData();
        updateEventTable.getItems().clear();
        updateEventTable.getItems().addAll(updateEvent);
        updateEventTable.refresh();
    }

    private void refreshUpdateMeetingTable(){
        List<Meeting> updateMeeting = EventDataBaseConnection.getMeetingUpdateData();
        updateMeetingTable.getItems().clear();
        updateMeetingTable.getItems().addAll(updateMeeting);
        updateMeetingTable.refresh();
    }

    private void refreshUpdateWorkshopTable(){
        List<Workshop> updateWorkshop = EventDataBaseConnection.getWorkshopUpdateData();
        workshopTableInUpdate.getItems().clear();
        workshopTableInUpdate.getItems().addAll(updateWorkshop);
        workshopTableInUpdate.refresh();
    }


    public void backToAdvisorDashboardClick(ActionEvent actionEvent) {

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }
}
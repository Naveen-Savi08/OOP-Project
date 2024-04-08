package com.example.oop_cw_v1;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClubCreationController implements Initializable {


    @FXML
    private Button btnCreate;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnCreateClubData;

    @FXML
    private Button btnCreateSportClubData;
    @FXML
    private Button btnCreateAcademicClub;


    @FXML
    private TextField txtSportAdvisorId;

    @FXML
    private TextField txtSportClubDescription;

    @FXML
    private TextField txtSportClubId;

    @FXML
    private TextField txtSportClubName;

    @FXML
    private TextField txtSportMembers;

    @FXML
    private TextField txtSportSport;

    @FXML
    private TableView<Club> clubTable;
    @FXML
    private TableColumn<Club, String> colClubId;
    @FXML
    private TableColumn<Club, String> colClubName;
    @FXML
    private TableColumn<Club, Integer> colMembers;
    @FXML
    private TableColumn<Club, String> colAdvisorId;
    @FXML
    private TableColumn<Club, String> colClubDescription;
    @FXML
    private TableColumn<SportClub, String> colSportClubSport;
    @FXML
    private TableColumn<AcademicClub, String> colAcademicClubAcademic;

    @FXML
    private TextField txtSearchClubId;

    @FXML
    private TextField txtManageAdvisorId;

    @FXML
    private TextField txtManageClubDescription;

    @FXML
    private TextField txtManageClubName;

    @FXML
    private TextField txtManageMembers;

    @FXML
    private TextField txtManageAcademic;
    @FXML
    private TextField txtManageSport;

    @FXML
    private TextField txtAcademicAcademicType;

    @FXML
    private TextField txtAcademicAdvisorId;

    @FXML
    private TextField txtAcademicClubDescription;

    @FXML
    private TextField txtAcademicClubId;

    @FXML
    private TextField txtAcademicClubMembers;

    @FXML
    private TextField txtAcademicClubName;

    @FXML
    private Group groupFirst;

    @FXML
    private Group groupThree;

    @FXML
    private Group groupFour;
    @FXML
    private Group groupFive;

    @FXML
    private Group groupSix;

    public void disableGroups(){
        groupFirst.setVisible(false);
        groupThree.setVisible(false);
        groupFour.setVisible(false);
        groupFour.setVisible(false);
        groupFive.setVisible(false);
        groupSix.setVisible(false);

    }
    public void onClickCreateClub(ActionEvent actionEvent) {
        disableGroups();
        groupFour.setVisible(true);

    }
    public void backToAdvisorClick(ActionEvent actionEvent) {
        disableGroups();
        groupFirst.setVisible(true);

    }
    public void btnBackToMainClick(ActionEvent actionEvent) {
        disableGroups();
        groupFirst.setVisible(true);
    }
    public void btnBackToChooseA(ActionEvent actionEvent) {
        disableGroups();
        groupFour.setVisible(true);
    }
    public void btnBackToChooseS(ActionEvent actionEvent){
        disableGroups();
        groupFour.setVisible(true);
    }
    public void backToMainMenu(ActionEvent actionEvent) {
        disableGroups();
        groupFirst.setVisible(true);
        clubTable.getItems().clear();

        // Clear the text fields
        txtSearchClubId.clear();
        txtManageClubName.clear();
        txtManageMembers.clear();
        txtManageAdvisorId.clear();
        txtManageClubDescription.clear();
        txtManageSport.clear();
        txtManageAcademic.clear();
    }

    public void manageClick(ActionEvent actionEvent) {
        disableGroups();
        groupThree.setVisible(true);
    }

    public void createSportClub(ActionEvent actionEvent) {
        disableGroups();
        groupFive.setVisible(true);
    }

    public void createAcademicClub(ActionEvent actionEvent) {
        disableGroups();
        groupSix.setVisible(true);
    }
    public void importClubData(ActionEvent actionEvent) {
        populateClubTable();
    }

    private boolean isValidNumber(String input) {
        try {
            int parsedValue = Integer.parseInt(input);
            return parsedValue >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //Create Sport Club And save to the database
    @FXML
    void createSportClubData(ActionEvent actionEvent) {
        String clubID = txtSportClubId.getText();
        if (ClubDatabaseConnection.ClubIdExists(clubID)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate club Id");
            alert.setHeaderText(null);
            alert.setContentText("This club ID is already taken, Try another");
            alert.showAndWait();
            return;
        }
        String clubName = txtSportClubName.getText();
        String members = txtSportMembers.getText();
        String advisorId = txtSportAdvisorId.getText();
        String description = txtSportClubDescription.getText();
        String sport = txtSportSport.getText();

        boolean isValid = true;

        // Validate members
        if (!isValidNumber(members)) {
            txtSportMembers.setStyle("-fx-text-fill: red;");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Members");
            alert.setHeaderText(null);
            alert.setContentText("Enter only integers for Members.");
            alert.showAndWait();
            isValid = false;
        }

        if (isValid) {
            // Add the data to the database
            SportClub sportClub = new SportClub(clubID, clubName, members, advisorId, description,sport);
            ClubDatabaseConnection.testDatabaseConnection();
            ClubDatabaseConnection.insertClubData(sportClub);
            txtSportClubId.clear();
            txtSportClubName.clear();
            txtSportClubName.clear();
            txtSportMembers.clear();
            txtSportAdvisorId.clear();
            txtSportClubDescription.clear();
            txtSportSport.clear();
            populateClubTable();

        }

    }
    //Create academic Club And save to the database
    public void createAcademicClubData(ActionEvent actionEvent) {
        String clubID = txtAcademicClubId.getText();
        //Club ID duplicate validation
        if (ClubDatabaseConnection.ClubIdExists(clubID)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Duplicate club Id");
            alert.setHeaderText(null);
            alert.setContentText("This club ID is already taken, Try another");
            alert.showAndWait();
            return;
        }
        String clubName = txtAcademicClubName.getText();
        String members = txtAcademicClubMembers.getText();
        String advisorId = txtAcademicAdvisorId.getText();
        String description = txtAcademicClubDescription.getText();
        String academicType = txtAcademicAcademicType.getText();

        boolean isValid = true;

        // Validate members
        if (!isValidNumber(members)) {
            txtAcademicClubMembers.setStyle("-fx-text-fill: red;");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Members");
            alert.setHeaderText(null);
            alert.setContentText("Enter only integers for Members.");
            alert.showAndWait();
            isValid = false;
        }

        if (isValid) {
            // Add the data to database
            AcademicClub academicClub = new AcademicClub(clubID, clubName, members, advisorId, description,academicType);
            ClubDatabaseConnection.testDatabaseConnection();
            ClubDatabaseConnection.insertClubData(academicClub);

            txtAcademicClubId.clear();
            txtAcademicClubName.clear();
            txtAcademicClubMembers.clear();
            txtAcademicAdvisorId.clear();
            txtAcademicClubDescription.clear();
            txtAcademicAcademicType.clear();
            populateClubTable();

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){
        //Initial the table columns
        colClubId.setCellValueFactory(new PropertyValueFactory<>("clubId"));
        colClubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));
        colMembers.setCellValueFactory(new  PropertyValueFactory<>("members"));
        colAdvisorId.setCellValueFactory(new PropertyValueFactory<>("advisorId"));
        colClubDescription.setCellValueFactory(new PropertyValueFactory<>("clubDescription"));
        colSportClubSport.setCellValueFactory(cellData -> {
            Club club = cellData.getValue();
            if (club instanceof SportClub) {
                return new SimpleStringProperty(((SportClub) club).getSport());
            } else {
                return new SimpleStringProperty("");
            }
        });
        colAcademicClubAcademic.setCellValueFactory(cellData -> {
            Club club = cellData.getValue();
            if (club instanceof AcademicClub) {
                return new SimpleStringProperty(((AcademicClub) club).getAcademicType());
            } else {
                return new SimpleStringProperty("");
            }
        });


    }
    public void populateClubTable(){
        List<Club> clubList = ClubDatabaseConnection.getClubData();
        clubTable.getItems().setAll(clubList);
    }
    public void handleTable(MouseEvent event) {
        if (event.getClickCount() == 1){
            Club selectedClub = clubTable.getSelectionModel().getSelectedItem();
        }
    }
    public void deleteClub(ActionEvent actionEvent) {
        Club selectedClub = clubTable.getSelectionModel().getSelectedItem();
        if (selectedClub != null){
            ClubDatabaseConnection.deleteClub(selectedClub);
            populateClubTable();

            Alert alertCon = new Alert(Alert.AlertType.INFORMATION);
            alertCon.setTitle("Club Deleted Successfully");
            alertCon.setHeaderText(null);
            alertCon.setContentText("Club has been deleted successfully.");
            alertCon.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No club selected");
            alert.setHeaderText(null);
            alert.setContentText("Select a club to delete");
            alert.showAndWait();
        }
    }
    public void searchClub(ActionEvent actionEvent) {
        String searchId = txtSearchClubId.getText();
        Club club = ClubDatabaseConnection.searchClub(searchId);

        if (club != null) {
            txtManageClubName.setText(club.getClubName());
            txtManageMembers.setText(String.valueOf(club.getMembers()));
            txtManageAdvisorId.setText(club.getAdvisorId());
            txtManageClubDescription.setText(club.getClubDescription());

            if (club instanceof SportClub) {
                // Handle SportClub specific fields
                txtManageSport.setText(((SportClub) club).getSport());
                txtManageAcademic.clear();
            } else if (club instanceof AcademicClub) {
                // Handle AcademicClub specific fields
                txtManageAcademic.setText(((AcademicClub) club).getAcademicType());
                txtManageSport.clear();
            } else {

                txtManageSport.clear();
                txtManageAcademic.clear();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Club Not Found");
            alert.setHeaderText(null);
            alert.setContentText("Club With " + searchId + " Not Found");
            alert.showAndWait();
        }
    }

    public void updateClub(ActionEvent actionEvent) {
        String clubId = txtSearchClubId.getText();
        String clubName = txtManageClubName.getText();
        String membersText = txtManageMembers.getText().trim();
        int members = 0;  // Default value, change it to a suitable default if needed

        // Validate members
        if (!isValidNumber(membersText)) {
            txtManageMembers.setStyle("-fx-text-fill: red;");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Members");
            alert.setHeaderText(null);
            alert.setContentText("Enter only integers for Members.");
            alert.showAndWait();
            return;
        }

        members = Integer.parseInt(membersText);
        String advisorId = txtManageAdvisorId.getText();
        String clubDescription = txtManageClubDescription.getText();

        Club club = ClubDatabaseConnection.getClubDetails(clubId);
        if (club != null) {
            club.setClubName(clubName);
            club.setMembers(members);
            club.setAdvisorId(advisorId);
            club.setClubDescription(clubDescription);

            if (club instanceof SportClub) {
                // Update SportClub specific fields
                ((SportClub) club).setSport(txtManageSport.getText());
                System.out.println(txtManageSport.getText());
            } else if (club instanceof AcademicClub) {
                // Update AcademicClub specific fields
                ((AcademicClub) club).setAcademicType(txtManageAcademic.getText());
                System.out.println(txtManageAcademic.getText());
            }

            ClubDatabaseConnection.updateClubDetails(club);
            refreshClubTable();
        }
    }
    private void refreshClubTable() {
        // Get updated club data from database
        List<Club> updatedClubList = ClubDatabaseConnection.getClubData();

        // Clear the existing items in the TableView
        clubTable.getItems().clear();

        // Add the updated data to the TableView
        clubTable.getItems().addAll(updatedClubList);

        // Refresh the TableView
        clubTable.refresh();
    }

    public void backtoAdvisorDashBoardClick(ActionEvent actionEvent) throws IOException {

        // Get the source of the event (in this case, the button)
        Node source = (Node) actionEvent.getSource();

        // Get the current stage
        Stage stage = (Stage) source.getScene().getWindow();

        // Close the stage
        stage.close();
    }
}




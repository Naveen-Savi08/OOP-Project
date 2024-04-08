package com.example.oop_cw_v1;

import javafx.scene.control.Label;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentTest {

    @Test
    void testGettersAndSetters() {
        User user = new Student();  // Using the actual Student class for testing

        // Set values using setters
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setGender("Male");
        user.setDoB(new Date());
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        user.setContactNumber("123456789");

        // Test getters
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("Male", user.getGender());
        assertNotNull(user.getDoB());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
        assertEquals("123456789", user.getContactNumber());
    }

    @Test
    void testDisplayUserInformation() {
        // Create a mock Student instance for testing
        Student mockStudent = new Student();

        // Set up mock labels for testing
        Label firstNameLabel = new Label();
        Label lastNameLabel = new Label();
        Label genderLabel = new Label();
        Label DoBLabel = new Label();
        Label contactNumberLabel = new Label();
        Label emailLabel = new Label();
        Label studentIDLabel = new Label();

        // Stubbing for the mockStudent
        mockStudent.setFirstName("MockFirstName");
        mockStudent.setLastName("MockLastName");
        mockStudent.setGender("MockGender");
        mockStudent.setDoB(new Date()); // Mocking the date
        mockStudent.setContactNumber("MockContactNumber");
        mockStudent.setEmail("MockEmail");
        mockStudent.setStudentID("MockStudentID");

        // Call the displayUserInformation method
        mockStudent.displayUserInformation("mockID", firstNameLabel, lastNameLabel, genderLabel, DoBLabel, contactNumberLabel, emailLabel, studentIDLabel);

        // Assert that the labels have been updated correctly based on the mock student
        assertEquals("MockFirstName", firstNameLabel.getText());
        assertEquals("MockLastName", lastNameLabel.getText());
        assertEquals("MockGender", genderLabel.getText());
        assertEquals("MockDOB", DoBLabel.getText());
        assertEquals("MockContactNumber", contactNumberLabel.getText());
        assertEquals("MockEmail", emailLabel.getText());
        assertEquals("MockStudentID", studentIDLabel.getText());
    }
}

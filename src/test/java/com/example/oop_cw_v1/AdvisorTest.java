package com.example.oop_cw_v1;

import com.example.oop_cw_v1.Advisor;
import javafx.scene.control.Label;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AdvisorTest {

    @Test
    void testGettersAndSetters() {
        Advisor advisor = new Advisor();

        // Set values using setters
        advisor.setFirstName("Jane");
        advisor.setLastName("Doe");
        advisor.setGender("Female");
        advisor.setDoB(new Date());
        advisor.setEmail("jane.doe@example.com");
        advisor.setPassword("password456");
        advisor.setContactNumber("987654321");
        advisor.setAdvisorID("ADV123");

        // Test getters
        assertEquals("Jane", advisor.getFirstName());
        assertEquals("Doe", advisor.getLastName());
        assertEquals("Female", advisor.getGender());
        assertEquals("jane.doe@example.com", advisor.getEmail());
        assertEquals("password456", advisor.getPassword());
        assertEquals("987654321", advisor.getContactNumber());
        assertEquals("ADV123", advisor.getAdvisorID());
    }

    @Test
    void testDisplayUserInformation() {
        Advisor mockAdvisor = new Advisor();

        Label firstNameLabel = new Label();
        Label lastNameLabel = new Label();
        Label genderLabel = new Label();
        Label DoBLabel = new Label();
        Label contactNumberLabel = new Label();
        Label emailLabel = new Label();
        Label advisorIDLabel = new Label();

        HashMap<String, String> mockData = new HashMap<>();
        mockData.put("First Name", "MockFirstName");
        mockData.put("Last Name", "MockLastName");
        mockData.put("Gender", "MockGender");
        mockData.put("DOB", "MockDOB");
        mockData.put("Contact Number", "MockContactNumber");
        mockData.put("Email", "MockEmail");
        mockData.put("Advisor ID", "MockAdvisorID");

        mockAdvisor.displayUserInformation("mockID", firstNameLabel, lastNameLabel, genderLabel, DoBLabel, contactNumberLabel, emailLabel, advisorIDLabel);

        assertEquals("MockFirstName", firstNameLabel.getText());
        assertEquals("MockLastName", lastNameLabel.getText());
        assertEquals("MockGender", genderLabel.getText());
        assertEquals("MockDOB", DoBLabel.getText());
        assertEquals("MockContactNumber", contactNumberLabel.getText());
        assertEquals("MockEmail", emailLabel.getText());
        assertEquals("MockAdvisorID", advisorIDLabel.getText());
    }
}

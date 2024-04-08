package com.example.oop_cw_v1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClubTest {

    @Test
    public void testGetClubId() {
        Club club = new Club("123", "Chess Club", "20", "456", "A club for chess enthusiasts");
        assertEquals("123", club.getClubId());
    }



    @Test
    public void testGetClubName() {
        Club club = new Club("789", "Football Club", "30", "101", "A club for football fans");
        assertEquals("Football Club", club.getClubName());
    }



    // Add similar tests for other getters and setters

    @Test
    public void testConstructor() {
        Club club = new Club("111", "Coding Club", "25", "222", "A club for coding enthusiasts");
        assertEquals("111", club.getClubId());
        assertEquals("Coding Club", club.getClubName());
        assertEquals(25, club.getMembers());
        assertEquals("222", club.getAdvisorId());
        assertEquals("A club for coding enthusiasts", club.getClubDescription());
    }
}

package com.example.oop_cw_v1;

public class Club {
    private String clubId;
    private String clubName;
    private int members;
    private String advisorId;
    private String clubDescription;

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(String advisorId) {
        this.advisorId = advisorId;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }



    public Club(String clubId, String clubName, String members, String advisorId, String clubDescription){
        this.clubId = clubId;
        this.clubName = clubName;
        this.advisorId = advisorId;
        this.members = Integer.parseInt(members);
        this.clubDescription = clubDescription;
    }


}

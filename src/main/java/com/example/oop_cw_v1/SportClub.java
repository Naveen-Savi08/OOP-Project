package com.example.oop_cw_v1;

public class SportClub extends Club {
    private String sport;



    public SportClub(String clubId,String clubName,String members,String advisorId,String clubDescription,String sport){
        super(clubId,clubName,members,advisorId,clubDescription);
        this.sport = sport;
    }
    public String getSport(){
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}

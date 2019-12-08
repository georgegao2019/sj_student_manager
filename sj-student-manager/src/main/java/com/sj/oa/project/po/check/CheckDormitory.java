package com.sj.oa.project.po.check;

import com.sj.oa.framework.web.po.BasePo;

public class CheckDormitory extends BasePo {

    private Integer id;
    private String weeks;
    private String roomCode;
    private String studentId;
    private String reasonsPointsSelf;
    private String reasonsPointsCensusHealth;
    private String reasonsPointsCensusSafe;
    private String gradeSelf;
    private String gradeCensus;
    private String gradeFinal;
    private String rankFinal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getReasonsPointsSelf() {
        return reasonsPointsSelf;
    }

    public void setReasonsPointsSelf(String reasonsPointsSelf) {
        this.reasonsPointsSelf = reasonsPointsSelf;
    }

    public String getReasonsPointsCensusHealth() {
        return reasonsPointsCensusHealth;
    }

    public void setReasonsPointsCensusHealth(String reasonsPointsCensusHealth) {
        this.reasonsPointsCensusHealth = reasonsPointsCensusHealth;
    }

    public String getReasonsPointsCensusSafe() {
        return reasonsPointsCensusSafe;
    }

    public void setReasonsPointsCensusSafe(String reasonsPointsCensusSafe) {
        this.reasonsPointsCensusSafe = reasonsPointsCensusSafe;
    }

    public String getGradeSelf() {
        return gradeSelf;
    }

    public void setGradeSelf(String gradeSelf) {
        this.gradeSelf = gradeSelf;
    }

    public String getGradeCensus() {
        return gradeCensus;
    }

    public void setGradeCensus(String gradeCensus) {
        this.gradeCensus = gradeCensus;
    }

    public String getGradeFinal() {
        return gradeFinal;
    }

    public void setGradeFinal(String gradeFinal) {
        this.gradeFinal = gradeFinal;
    }

    public String getRankFinal() {
        return rankFinal;
    }

    public void setRankFinal(String rankFinal) {
        this.rankFinal = rankFinal;
    }

    //public void set

}

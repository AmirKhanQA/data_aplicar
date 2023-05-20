package io.aplicar.web.carina.automation.utils;

import java.util.List;

public class StudyPortalsCampusDetails {


    private String InstituteURL;

    private String InstituteName;

    private String Country;

    private String State;

    private String City;

    private String CourseName;

    private String TuitionFee;

    private String Description;

    private String ProgramImage;

    private String ProgramLevel;

    private String StudyMode;

    private String StudyType;

    private String Duration;

    private String StartDate;

    private String IntakeDate;



    public StudyPortalsCampusDetails(String instituteURL, String instituteName, String country, String state, String city, String courseName, String tuitionFee, String description, String programImage, String programLevel, String studyMode, String studyType, String duration, String startDate, String intakeDate) {
        InstituteURL = instituteURL;
        InstituteName = instituteName;
        Country = country;
        State = state;
        City = city;
        CourseName = courseName;
        TuitionFee = tuitionFee;
        Description = description;
        ProgramImage = programImage;
        ProgramLevel = programLevel;
        StudyMode = studyMode;
        StudyType=studyType;
        Duration = duration;
        StartDate = startDate;
        IntakeDate = intakeDate;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getTuitionFee() {
        return TuitionFee;
    }

    public void setTuitionFee(String tuitionFee) {
        TuitionFee = tuitionFee;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public String getProgramImage() {
        return ProgramImage;
    }

    public void setProgramImage(String programImage) {
        ProgramImage = programImage;
    }

    public String getProgramLevel() {
        return ProgramLevel;
    }

    public void setProgramLevel(String programLevel) {
        ProgramLevel = programLevel;
    }

    public String getStudyMode() {
        return StudyMode;
    }

    public void setStudyMode(String studyMode) {
        StudyMode = studyMode;
    }

    public String getStudyType() {
        return StudyType;
    }

    public void setStudyType(String studyType) {
        StudyType = studyType;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getIntakeDate() {
        return IntakeDate;
    }

    public void setIntakeDate(String intakeDate) {
        IntakeDate = intakeDate;
    }
}

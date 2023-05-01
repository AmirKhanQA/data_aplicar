package io.aplicar.web.carina.automation.utils;

public class StudyPortalsCampusDetails {

    private String Study_Course_Name;

    private String Study_Course_Summary;
    private String Tuition_Fee_Value;
    private String Duration_Value;

    private String Study_Course_Type;

    private String Organisation_Name;

    private String Organisation_Location;

    private String Organisation_Logo;

    private String studyOrganisationLink;



    public StudyPortalsCampusDetails(String Study_Course_Name,String Study_Course_Summary, String Tuition_Fee_Value, String Duration_Value,String Study_Course_Type, String Organisation_Name,String Organisation_Location,String Organisation_Logo, String studyOrganisationLink) {
        this.Study_Course_Name = Study_Course_Name;
        this.Study_Course_Summary=Study_Course_Summary;
        this.Tuition_Fee_Value = Tuition_Fee_Value;
        this.Duration_Value = Duration_Value;
        this.Study_Course_Type = Study_Course_Type;
        this.Organisation_Name = Organisation_Name;
        this.Organisation_Location = Organisation_Location;
        this.Organisation_Logo = Organisation_Logo;
        this.studyOrganisationLink = studyOrganisationLink;
    }


    public String getStudy_Course_Name() {
        return Study_Course_Name;
    }

    public void setStudy_Course_Name(String study_Course_Name) {
        Study_Course_Name = study_Course_Name;
    }

    public String getStudy_Course_Summary() {
        return Study_Course_Summary;
    }

    public void setStudy_Course_Summary(String study_Course_Summary) {
        Study_Course_Summary = study_Course_Summary;
    }

    public String getTuition_Fee_Value() {
        return Tuition_Fee_Value;
    }

    public void setTuition_Fee_Value(String tuition_Fee_Value) {
        Tuition_Fee_Value = tuition_Fee_Value;
    }

    public String getDuration_Value() {
        return Duration_Value;
    }

    public void setDuration_Value(String duration_Value) {
        Duration_Value = duration_Value;
    }

    public String getStudy_Course_Type() {
        return Study_Course_Type;
    }

    public void setStudy_Course_Type(String study_Course_Type) {
        Study_Course_Type = study_Course_Type;
    }

    public String getOrganisation_Name() {
        return Organisation_Name;
    }

    public void setOrganisation_Name(String organisation_Name) {
        Organisation_Name = organisation_Name;
    }

    public String getOrganisation_Location() {
        return Organisation_Location;
    }

    public void setOrganisation_Location(String organisation_Location) {
        Organisation_Location = organisation_Location;
    }

    public String getOrganisation_Logo() {
        return Organisation_Logo;
    }

    public void setOrganisation_Logo(String organisation_Logo) {
        Organisation_Logo = organisation_Logo;
    }

    public String getStudyOrganisationLink() {
        return studyOrganisationLink;
    }

    public void setStudyOrganisationLink(String studyOrganisationLink) {
        this.studyOrganisationLink = studyOrganisationLink;
    }
}

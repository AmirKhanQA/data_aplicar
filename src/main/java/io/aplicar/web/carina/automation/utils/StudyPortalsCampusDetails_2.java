package io.aplicar.web.carina.automation.utils;

public class StudyPortalsCampusDetails_2 {

    private String InstituteURL;

    private String InstituteName;

    private String Country;

    private String State;

    private String City;


    public StudyPortalsCampusDetails_2(String instituteURL, String instituteName, String country, String state, String city) {
        InstituteURL = instituteURL;
        InstituteName = instituteName;
        Country = country;
        State = state;
        City = city;
    }

    public String getInstituteURL() {
        return InstituteURL;
    }

    public void setInstituteURL(String instituteURL) {
        InstituteURL = instituteURL;
    }

    public String getInstituteName() {
        return InstituteName;
    }

    public void setInstituteName(String instituteName) {
        InstituteName = instituteName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

}

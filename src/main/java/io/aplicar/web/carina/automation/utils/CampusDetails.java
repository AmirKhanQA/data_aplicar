package io.aplicar.web.carina.automation.utils;

public class CampusDetails {

    private String campusURL;
    private String campusName;
    private String CampusAddress;

    public CampusDetails(String campusURL, String campusName, String CampusAddress) {
        this.campusURL = campusURL;
        this.campusName = campusName;
        this.CampusAddress = CampusAddress;
    }

    public String getCampusURL() {
        return campusURL;
    }

    public void setCampusURL(String campusURL) {
        this.campusURL = campusURL;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusAddress() {
        return CampusAddress;
    }

    public void setCampusAddress(String campusAddress) {
        CampusAddress = campusAddress;
    }
}

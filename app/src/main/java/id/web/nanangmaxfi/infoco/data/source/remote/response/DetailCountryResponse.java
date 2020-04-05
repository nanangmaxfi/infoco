package id.web.nanangmaxfi.infoco.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class DetailCountryResponse {
    @SerializedName("OBJECTID")
    private String id;
    @SerializedName("Country_Region")
    private String country;
    @SerializedName("Last_Update")
    private String lastUpdate;
    @SerializedName("Confirmed")
    private String positif;
    @SerializedName("Recovered")
    private String sembuh;
    @SerializedName("Deaths")
    private String meninggal;

    public DetailCountryResponse() {
    }

    public DetailCountryResponse(String id, String country, String lastUpdate, String positif, String sembuh, String meninggal) {
        this.id = id;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.positif = positif;
        this.sembuh = sembuh;
        this.meninggal = meninggal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }
}

package id.web.nanangmaxfi.infoco.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class DetailProvinceResponse {
    @SerializedName("FID")
    private String FID;
    @SerializedName("Kode_Provi")
    private String kode_prov;
    @SerializedName("Provinsi")
    private String name;
    @SerializedName("Kasus_Posi")
    private String positif;
    @SerializedName("Kasus_Semb")
    private String sembuh;
    @SerializedName("Kasus_Meni")
    private String meninggal;

    public DetailProvinceResponse() {
    }

    public DetailProvinceResponse(String FID, String kode_prov, String name, String positif, String sembuh, String meninggal) {
        this.FID = FID;
        this.kode_prov = kode_prov;
        this.name = name;
        this.positif = positif;
        this.sembuh = sembuh;
        this.meninggal = meninggal;
    }

    public String getFID() {
        return FID;
    }

    public void setFID(String FID) {
        this.FID = FID;
    }

    public String getKode_prov() {
        return kode_prov;
    }

    public void setKode_prov(String kode_prov) {
        this.kode_prov = kode_prov;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

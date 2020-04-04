package id.web.nanangmaxfi.infoco.data.source.local.entity;

public class ProvinceEntity {
    private String FID;
    private String kode_prov;
    private String provinsi;
    private String positif;
    private String sembuh;
    private String meninggal;

    public ProvinceEntity() {
    }

    public ProvinceEntity(String FID, String kode_prov, String provinsi, String positif, String sembuh, String meninggal) {
        this.FID = FID;
        this.kode_prov = kode_prov;
        this.provinsi = provinsi;
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

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
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

package id.web.nanangmaxfi.infoco.data;

public class IndonesiaEntity {
    private String name;
    private String positif;
    private String sembuh;
    private String meninggal;

    public IndonesiaEntity() {
    }

    public IndonesiaEntity(String name, String positif, String sembuh, String meninggal) {
        this.name = name;
        this.positif = positif;
        this.sembuh = sembuh;
        this.meninggal = meninggal;
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

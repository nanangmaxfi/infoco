package id.web.nanangmaxfi.infoco.data.source.local.entity;

public class GlobalDataEntity {
    private String name;
    private String value;

    public GlobalDataEntity() {
    }

    public GlobalDataEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

package id.web.nanangmaxfi.infoco.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class GlobalDataResponse {
    @SerializedName("name")
    private String name;
    @SerializedName("value")
    private String value;

    public GlobalDataResponse() {
    }

    public GlobalDataResponse(String name, String value) {
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

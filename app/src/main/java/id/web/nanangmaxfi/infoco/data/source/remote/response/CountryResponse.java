package id.web.nanangmaxfi.infoco.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class CountryResponse {
    @SerializedName("attributes")
    private DetailCountryResponse attributes;

    public CountryResponse() {
    }

    public CountryResponse(DetailCountryResponse attributes) {
        this.attributes = attributes;
    }

    public DetailCountryResponse getAttributes() {
        return attributes;
    }

    public void setAttributes(DetailCountryResponse attributes) {
        this.attributes = attributes;
    }
}

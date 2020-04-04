package id.web.nanangmaxfi.infoco.data.source.remote.response;

import com.google.gson.annotations.SerializedName;

public class ProvinceResponse {
    @SerializedName("attributes")
    private DetailProvinceResponse attributes;

    public ProvinceResponse() {
    }

    public ProvinceResponse(DetailProvinceResponse attributes) {
        this.attributes = attributes;
    }

    public DetailProvinceResponse getAttributes() {
        return attributes;
    }

    public void setAttributes(DetailProvinceResponse attributes) {
        this.attributes = attributes;
    }
}

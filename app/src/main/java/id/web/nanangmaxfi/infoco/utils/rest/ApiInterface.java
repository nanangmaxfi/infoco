package id.web.nanangmaxfi.infoco.utils.rest;

import java.util.List;

import id.web.nanangmaxfi.infoco.data.source.remote.response.CountryResponse;
import id.web.nanangmaxfi.infoco.data.source.remote.response.IndonesiaResponse;
import id.web.nanangmaxfi.infoco.data.source.remote.response.ProvinceResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/indonesia")
    Call<List<IndonesiaResponse>> getIndonesia();

    @GET("/indonesia/provinsi")
    Call<List<ProvinceResponse>> getProvince();

    @GET("/")
    Call<List<CountryResponse>> getCountry();
}

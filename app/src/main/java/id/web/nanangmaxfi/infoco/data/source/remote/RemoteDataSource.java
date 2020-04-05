package id.web.nanangmaxfi.infoco.data.source.remote;

import android.util.Log;

import java.util.List;

import id.web.nanangmaxfi.infoco.data.source.remote.response.CountryResponse;
import id.web.nanangmaxfi.infoco.data.source.remote.response.GlobalDataResponse;
import id.web.nanangmaxfi.infoco.data.source.remote.response.IndonesiaResponse;
import id.web.nanangmaxfi.infoco.data.source.remote.response.ProvinceResponse;
import id.web.nanangmaxfi.infoco.utils.rest.ApiClient;
import id.web.nanangmaxfi.infoco.utils.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {
    private final static String TAG = RemoteDataSource.class.getSimpleName();
    private static RemoteDataSource INSTANCE;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public static RemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    public void getDataIndonesia(LoadIndonesiaCallback callback){
        apiInterface.getIndonesia().enqueue(new Callback<List<IndonesiaResponse>>() {
            @Override
            public void onResponse(Call<List<IndonesiaResponse>> call, Response<List<IndonesiaResponse>> response) {
                Log.i(TAG,"RC: "+ response.code());
                if (response.isSuccessful()){
                    List<IndonesiaResponse> indo = response.body();
                    callback.onDataReceived(indo);
                }
            }

            @Override
            public void onFailure(Call<List<IndonesiaResponse>> call, Throwable t) {
                Log.e(TAG,t.getMessage());
                callback.onDataReceived(null);
            }
        });
    }

    public void getGlobalPositif(LoadGlobalCallback callback){
        apiInterface.getGlobalPositif().enqueue(new Callback<GlobalDataResponse>() {
            @Override
            public void onResponse(Call<GlobalDataResponse> call, Response<GlobalDataResponse> response) {
                if (response.isSuccessful()){
                    GlobalDataResponse data = response.body();
                    callback.onDataReceived(data);
                }
            }

            @Override
            public void onFailure(Call<GlobalDataResponse> call, Throwable t) {
                Log.e(TAG,t.getMessage());
                callback.onDataReceived(null);
            }
        });
    }

    public void getGlobalSembuh(LoadGlobalCallback callback){
        apiInterface.getGlobalSembuh().enqueue(new Callback<GlobalDataResponse>() {
            @Override
            public void onResponse(Call<GlobalDataResponse> call, Response<GlobalDataResponse> response) {
                if (response.isSuccessful()){
                    GlobalDataResponse data = response.body();
                    callback.onDataReceived(data);
                }
            }

            @Override
            public void onFailure(Call<GlobalDataResponse> call, Throwable t) {
                Log.e(TAG,t.getMessage());
                callback.onDataReceived(null);
            }
        });
    }

    public void getGlobalMeninggal(LoadGlobalCallback callback){
        apiInterface.getGlobalMeninggal().enqueue(new Callback<GlobalDataResponse>() {
            @Override
            public void onResponse(Call<GlobalDataResponse> call, Response<GlobalDataResponse> response) {
                if (response.isSuccessful()){
                    GlobalDataResponse data = response.body();
                    callback.onDataReceived(data);
                }
            }

            @Override
            public void onFailure(Call<GlobalDataResponse> call, Throwable t) {
                Log.e(TAG,t.getMessage());
                callback.onDataReceived(null);
            }
        });
    }

    public void getDataProvince(LoadProvinceCallback callback){
        apiInterface.getProvince().enqueue(new Callback<List<ProvinceResponse>>() {
            @Override
            public void onResponse(Call<List<ProvinceResponse>> call, Response<List<ProvinceResponse>> response) {
                Log.i(TAG,"RC: "+ response.code());
                if (response.isSuccessful()){
                    List<ProvinceResponse> provinceResponses = response.body();
                    callback.onDataReceived(provinceResponses);
                }
            }

            @Override
            public void onFailure(Call<List<ProvinceResponse>> call, Throwable t) {
                Log.e(TAG,t.getMessage());
                callback.onDataReceived(null);
            }
        });
    }

    public void getDataCountry(LoadCountryCallback callback){
        apiInterface.getCountry().enqueue(new Callback<List<CountryResponse>>() {
            @Override
            public void onResponse(Call<List<CountryResponse>> call, Response<List<CountryResponse>> response) {
                Log.i(TAG,"RC: "+ response.code());
                if (response.isSuccessful()){
                    List<CountryResponse> countryResponses = response.body();
                    callback.onDataReceived(countryResponses);
                }
            }

            @Override
            public void onFailure(Call<List<CountryResponse>> call, Throwable t) {
                Log.e(TAG,t.getMessage());
                callback.onDataReceived(null);
            }
        });
    }

    public interface LoadIndonesiaCallback{
        void onDataReceived(List<IndonesiaResponse> indonesiaResponse);
    }

    public interface LoadProvinceCallback{
        void onDataReceived(List<ProvinceResponse> provinceResponses);
    }

    public interface LoadCountryCallback{
        void onDataReceived(List<CountryResponse> countryResponses);
    }

    public interface LoadGlobalCallback{
        void onDataReceived(GlobalDataResponse globalDataResponse);
    }
}

package id.web.nanangmaxfi.infoco.data.source.remote;

import android.util.Log;

import java.util.List;

import id.web.nanangmaxfi.infoco.data.source.remote.response.IndonesiaResponse;
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

    public interface LoadIndonesiaCallback{
        void onDataReceived( List<IndonesiaResponse> indonesiaResponse);
    }
}

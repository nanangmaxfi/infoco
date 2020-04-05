package id.web.nanangmaxfi.infoco.data.source;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import id.web.nanangmaxfi.infoco.data.source.local.entity.CountryEntity;
import id.web.nanangmaxfi.infoco.data.source.local.entity.IndonesiaEntity;
import id.web.nanangmaxfi.infoco.data.source.local.entity.ProvinceEntity;
import id.web.nanangmaxfi.infoco.data.source.remote.RemoteDataSource;
import id.web.nanangmaxfi.infoco.data.source.remote.response.CountryResponse;
import id.web.nanangmaxfi.infoco.data.source.remote.response.IndonesiaResponse;
import id.web.nanangmaxfi.infoco.data.source.remote.response.ProvinceResponse;

public class InfoRepository implements InfoDataSource{
    private final static String TAG = InfoRepository.class.getSimpleName();
    private volatile static InfoRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;

    public InfoRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static InfoRepository getInstance(RemoteDataSource remoteData) {
        if (INSTANCE == null) {
            synchronized (InfoRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new InfoRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public LiveData<IndonesiaEntity> getIndonesia() {
        MutableLiveData<IndonesiaEntity> result = new MutableLiveData<>();
        remoteDataSource.getDataIndonesia(indonesiaResponse -> {
            IndonesiaEntity entity = new IndonesiaEntity();
            if (indonesiaResponse != null){
                entity.setName(indonesiaResponse.get(0).getName());
                entity.setPositif(indonesiaResponse.get(0).getPositif());
                entity.setSembuh(indonesiaResponse.get(0).getSembuh());
                entity.setMeninggal(indonesiaResponse.get(0).getMeninggal());
            }
            else {
                entity = null;
            }

            result.postValue(entity);
        });
        return result;
    }

    @Override
    public LiveData<List<ProvinceEntity>> getAllProvince() {
        MutableLiveData<List<ProvinceEntity>> result = new MutableLiveData<>();
        remoteDataSource.getDataProvince(provinceResponses -> {
            List<ProvinceEntity> provinceEntities = new ArrayList<>();
            for (ProvinceResponse item: provinceResponses) {
                ProvinceEntity entity = new ProvinceEntity();
                entity.setFID(item.getAttributes().getFID());
                entity.setKode_prov(item.getAttributes().getKode_prov());
                entity.setProvinsi(item.getAttributes().getName());
                entity.setPositif(item.getAttributes().getPositif());
                entity.setSembuh(item.getAttributes().getSembuh());
                entity.setMeninggal(item.getAttributes().getMeninggal());
                provinceEntities.add(entity);
            }
            result.postValue(provinceEntities);
        });
        return result;
    }

    @Override
    public LiveData<List<CountryEntity>> getAllCountry() {
        MutableLiveData<List<CountryEntity>> result = new MutableLiveData<>();
        remoteDataSource.getDataCountry(countryResponses -> {
            List<CountryEntity> countryEntities = new ArrayList<>();
            for (CountryResponse response: countryResponses) {
                CountryEntity entity = new CountryEntity();
                entity.setId(response.getAttributes().getId());
                entity.setCountry(response.getAttributes().getCountry());
                entity.setLastUpdate(response.getAttributes().getLastUpdate());
                entity.setPositif(response.getAttributes().getPositif());
                entity.setSembuh(response.getAttributes().getSembuh());
                entity.setMeninggal(response.getAttributes().getMeninggal());
                countryEntities.add(entity);
            }
            result.postValue(countryEntities);
        });
        return result;
    }
}

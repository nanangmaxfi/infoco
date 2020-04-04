package id.web.nanangmaxfi.infoco.data.source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import id.web.nanangmaxfi.infoco.data.source.local.entity.IndonesiaEntity;
import id.web.nanangmaxfi.infoco.data.source.local.entity.ProvinceEntity;
import id.web.nanangmaxfi.infoco.data.source.remote.RemoteDataSource;
import id.web.nanangmaxfi.infoco.data.source.remote.response.IndonesiaResponse;

public class InfoRepository implements InfoDataSource{
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
        return null;
    }
}

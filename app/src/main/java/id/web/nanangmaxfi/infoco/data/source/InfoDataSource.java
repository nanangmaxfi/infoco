package id.web.nanangmaxfi.infoco.data.source;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.web.nanangmaxfi.infoco.data.source.local.entity.CountryEntity;
import id.web.nanangmaxfi.infoco.data.source.local.entity.GlobalDataEntity;
import id.web.nanangmaxfi.infoco.data.source.local.entity.IndonesiaEntity;
import id.web.nanangmaxfi.infoco.data.source.local.entity.ProvinceEntity;

public interface InfoDataSource {
    LiveData<IndonesiaEntity> getIndonesia();
    LiveData<List<ProvinceEntity>> getAllProvince();
    LiveData<List<CountryEntity>> getAllCountry();
    LiveData<GlobalDataEntity> getGlobalPositif();
    LiveData<GlobalDataEntity> getGlobalSembuh();
    LiveData<GlobalDataEntity> getGlobalMeninggal();
}

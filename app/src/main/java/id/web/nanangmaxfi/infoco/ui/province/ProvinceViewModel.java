package id.web.nanangmaxfi.infoco.ui.province;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.web.nanangmaxfi.infoco.data.source.InfoRepository;
import id.web.nanangmaxfi.infoco.data.source.local.entity.ProvinceEntity;

public class ProvinceViewModel extends ViewModel {
    private InfoRepository infoRepository;

    public ProvinceViewModel(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public LiveData<List<ProvinceEntity>> getProvince(){
        return infoRepository.getAllProvince();
    }
}

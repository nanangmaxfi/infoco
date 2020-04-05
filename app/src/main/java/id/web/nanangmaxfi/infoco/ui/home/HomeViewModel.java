package id.web.nanangmaxfi.infoco.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import id.web.nanangmaxfi.infoco.data.source.InfoRepository;
import id.web.nanangmaxfi.infoco.data.source.local.entity.GlobalDataEntity;
import id.web.nanangmaxfi.infoco.data.source.local.entity.IndonesiaEntity;

public class HomeViewModel extends ViewModel {
    private InfoRepository infoRepository;

    public HomeViewModel(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public LiveData<IndonesiaEntity> getIndonesia(){
        return infoRepository.getIndonesia();
    }

    public LiveData<GlobalDataEntity> getGlobalPositif(){
        return infoRepository.getGlobalPositif();
    }

    public LiveData<GlobalDataEntity> getGlobalSembuh(){
        return infoRepository.getGlobalSembuh();
    }

    public LiveData<GlobalDataEntity> getGlobalMeninggal(){
        return infoRepository.getGlobalMeninggal();
    }
}

package id.web.nanangmaxfi.infoco.ui.country;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import id.web.nanangmaxfi.infoco.data.source.InfoRepository;
import id.web.nanangmaxfi.infoco.data.source.local.entity.CountryEntity;

public class CountryViewModel extends ViewModel {
    private InfoRepository infoRepository;

    public CountryViewModel(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public LiveData<List<CountryEntity>> getCountry(){
        return infoRepository.getAllCountry();
    }
}

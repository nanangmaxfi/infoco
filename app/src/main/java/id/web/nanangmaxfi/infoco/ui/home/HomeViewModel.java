package id.web.nanangmaxfi.infoco.ui.home;

import androidx.lifecycle.ViewModel;

import id.web.nanangmaxfi.infoco.data.IndonesiaEntity;
import id.web.nanangmaxfi.infoco.utils.DataDummy;

public class HomeViewModel extends ViewModel {

    public IndonesiaEntity getIndonesia(){
        return DataDummy.generateDummy();
    }
}

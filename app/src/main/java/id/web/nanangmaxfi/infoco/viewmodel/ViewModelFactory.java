package id.web.nanangmaxfi.infoco.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.web.nanangmaxfi.infoco.data.source.InfoRepository;
import id.web.nanangmaxfi.infoco.di.Injection;
import id.web.nanangmaxfi.infoco.ui.home.HomeViewModel;
import id.web.nanangmaxfi.infoco.ui.province.ProvinceViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final InfoRepository infoRepository;

    public ViewModelFactory(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public static ViewModelFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository());
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)){
            return (T) new HomeViewModel(infoRepository);
        }
        else if (modelClass.isAssignableFrom(ProvinceViewModel.class)){
            return (T) new ProvinceViewModel(infoRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}

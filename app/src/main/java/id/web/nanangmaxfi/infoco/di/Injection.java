package id.web.nanangmaxfi.infoco.di;

import id.web.nanangmaxfi.infoco.data.source.InfoRepository;
import id.web.nanangmaxfi.infoco.data.source.remote.RemoteDataSource;

public class Injection {
    public static InfoRepository provideRepository(){
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance();
        return InfoRepository.getInstance(remoteDataSource);
    }
}

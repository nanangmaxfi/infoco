package id.web.nanangmaxfi.infoco.ui.country;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.List;

import id.web.nanangmaxfi.infoco.R;
import id.web.nanangmaxfi.infoco.data.source.local.entity.CountryEntity;
import id.web.nanangmaxfi.infoco.utils.ConfigUtils;
import id.web.nanangmaxfi.infoco.viewmodel.ViewModelFactory;

public class CountryActivity extends AppCompatActivity {
    private ContentLoadingProgressBar progressBar;
    private RecyclerView rvCountry;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ConfigUtils.toolbar(this,getString(R.string.data_per_negara),true);

        progressBar = findViewById(R.id.progress_bar);
        rvCountry = findViewById(R.id.rv_country);
        refreshLayout = findViewById(R.id.swipe_refresh);

        ViewModelFactory factory = ViewModelFactory.getInstance();
        CountryViewModel viewModel = new ViewModelProvider(this,factory).get(CountryViewModel.class);
        showLoading(true);

        viewModel.getCountry().observe(this, this::loadData);

        refreshLayout.setOnRefreshListener(() -> {
            new Handler().postDelayed(() -> {
                viewModel.getCountry().observe(this, data -> {
                    loadData(data);
                    refreshLayout.setRefreshing(false);
                });
            }, 1000);
        });
    }

    private void loadData(List<CountryEntity> data){
        CountryAdapter adapter = new CountryAdapter();
        adapter.setListCountry(data);
        rvCountry.setLayoutManager(new LinearLayoutManager(this));
        rvCountry.setHasFixedSize(true);
        rvCountry.setAdapter(adapter);
        showLoading(false);
    }

    private void showLoading(Boolean bool){
        if (bool){
            progressBar.setVisibility(View.VISIBLE);
            rvCountry.setVisibility(View.INVISIBLE);
        }
        else {
            progressBar.setVisibility(View.GONE);
            rvCountry.setVisibility(View.VISIBLE);
        }
    }
}

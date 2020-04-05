package id.web.nanangmaxfi.infoco.ui.province;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import id.web.nanangmaxfi.infoco.R;
import id.web.nanangmaxfi.infoco.data.source.local.entity.ProvinceEntity;
import id.web.nanangmaxfi.infoco.utils.ConfigUtils;
import id.web.nanangmaxfi.infoco.viewmodel.ViewModelFactory;

public class ProvinceActivity extends AppCompatActivity {
    private ContentLoadingProgressBar progressBar;
    private RecyclerView rvProvince;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);
        ConfigUtils.toolbar(this,getString(R.string.data_per_provinsi),true);

        progressBar = findViewById(R.id.progress_bar);
        rvProvince = findViewById(R.id.rv_province);
        refreshLayout = findViewById(R.id.swipe_refresh);

        ViewModelFactory factory = ViewModelFactory.getInstance();
        ProvinceViewModel viewModel = new ViewModelProvider(this,factory).get(ProvinceViewModel.class);
        showLoading(true);

        viewModel.getProvince().observe(this, this::loadData);

        refreshLayout.setOnRefreshListener(() -> {
            new Handler().postDelayed(() -> {
                viewModel.getProvince().observe(this, data -> {
                    loadData(data);
                    refreshLayout.setRefreshing(false);
                });
            }, 1000);
        });
    }

    private void loadData(List<ProvinceEntity> data){
        ProvinceAdapter adapter = new ProvinceAdapter();
        adapter.setListProvince(data);
        rvProvince.setLayoutManager(new LinearLayoutManager(this));
        rvProvince.setHasFixedSize(true);
        rvProvince.setAdapter(adapter);
        showLoading(false);
    }

    private void showLoading(Boolean bool){
        if (bool){
            progressBar.setVisibility(View.VISIBLE);
            rvProvince.setVisibility(View.INVISIBLE);
        }
        else {
            progressBar.setVisibility(View.GONE);
            rvProvince.setVisibility(View.VISIBLE);
        }
    }
}

package id.web.nanangmaxfi.infoco.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import id.web.nanangmaxfi.infoco.R;
import id.web.nanangmaxfi.infoco.data.source.local.entity.IndonesiaEntity;
import id.web.nanangmaxfi.infoco.ui.country.CountryActivity;
import id.web.nanangmaxfi.infoco.ui.province.ProvinceActivity;
import id.web.nanangmaxfi.infoco.viewmodel.ViewModelFactory;

public class HomeActivity extends AppCompatActivity {
    private TextView txtPositifIndo, txtSembuhIndo, txtMeninggalIndo, txtPositif, txtSembuh, txtMeninggal, txtUpdate;
    private MaterialButton btnProvinsi, btnNegara;
    private LinearLayout layoutDetail;
    private ContentLoadingProgressBar progressBar;
    private SwipeRefreshLayout refreshLayout;
    private HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setCustomView(R.layout.custom_toolbar);

            TextView actionTitle = findViewById(R.id.txt_title);
            actionTitle.setText(getString(R.string.app_name));
        }

        txtPositifIndo = findViewById(R.id.txt_positif_indo);
        txtSembuhIndo = findViewById(R.id.txt_sembuh_indo);
        txtMeninggalIndo = findViewById(R.id.txt_meninggal_indo);
        txtPositif = findViewById(R.id.txt_positif);
        txtSembuh = findViewById(R.id.txt_sembuh);
        txtMeninggal = findViewById(R.id.txt_meninggal);
        txtUpdate = findViewById(R.id.txt_update);
        btnProvinsi = findViewById(R.id.btn_provinsi);
        btnNegara = findViewById(R.id.btn_negara);
        layoutDetail = findViewById(R.id.layout_detail);
        progressBar = findViewById(R.id.progress_bar);
        refreshLayout = findViewById(R.id.swipe_refresh);

        ViewModelFactory factory = ViewModelFactory.getInstance();
        viewModel = new ViewModelProvider(this,factory).get(HomeViewModel.class);
        showLoading(true);
        viewModel.getIndonesia().observe(this, data -> {
            showLoading(false);
            loadIndonesia(data);
        });

        btnProvinsi.setOnClickListener(view -> {
            Intent intent = new Intent(this, ProvinceActivity.class);
            startActivity(intent);
        });

        btnNegara.setOnClickListener(view -> {
            Intent intent = new Intent(this, CountryActivity.class);
            startActivity(intent);
        });

        refreshLayout.setOnRefreshListener(() -> {
            new Handler().postDelayed(() -> {
                viewModel.getIndonesia().observe(this, data -> {
                    refreshLayout.setRefreshing(false);
                    showLoading(false);
                    loadIndonesia(data);
                });
            }, 1000);
        });
    }

    private void loadIndonesia(IndonesiaEntity entity){
        if (entity != null){
            txtPositifIndo.setText(entity.getPositif());
            txtSembuhIndo.setText(entity.getSembuh());
            txtMeninggalIndo.setText(entity.getMeninggal());
        }
        else {
            loadFailed();
        }

    }

    private void loadFailed(){
        txtPositifIndo.setText(R.string.no_data);
        txtSembuhIndo.setText(R.string.no_data);
        txtMeninggalIndo.setText(R.string.no_data);
    }

    private void showLoading(Boolean bool){
        if (bool){
            progressBar.setVisibility(View.VISIBLE);
            layoutDetail.setVisibility(View.INVISIBLE);
        }
        else {
            progressBar.setVisibility(View.GONE);
            layoutDetail.setVisibility(View.VISIBLE);
        }
    }
}

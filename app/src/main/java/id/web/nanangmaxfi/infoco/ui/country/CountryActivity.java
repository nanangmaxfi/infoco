package id.web.nanangmaxfi.infoco.ui.country;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import id.web.nanangmaxfi.infoco.R;
import id.web.nanangmaxfi.infoco.utils.ConfigUtils;

public class CountryActivity extends AppCompatActivity {
    private ContentLoadingProgressBar progressBar;
    private RecyclerView rvProvince;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ConfigUtils.toolbar(this,getString(R.string.data_per_negara),true);

        progressBar = findViewById(R.id.progress_bar);
        rvProvince = findViewById(R.id.rv_province);
    }
}

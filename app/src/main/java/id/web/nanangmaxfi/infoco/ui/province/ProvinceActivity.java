package id.web.nanangmaxfi.infoco.ui.province;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import id.web.nanangmaxfi.infoco.R;

public class ProvinceActivity extends AppCompatActivity {
    private ContentLoadingProgressBar progressBar;
    private RecyclerView rvProvince;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setCustomView(R.layout.custom_toolbar);

            TextView actionTitle = findViewById(R.id.txt_title);
            actionTitle.setText(getString(R.string.data_per_provinsi));
        }

        progressBar = findViewById(R.id.progress_bar);
        rvProvince = findViewById(R.id.rv_province);
    }
}

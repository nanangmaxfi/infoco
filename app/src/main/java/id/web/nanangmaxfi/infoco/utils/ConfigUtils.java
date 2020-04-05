package id.web.nanangmaxfi.infoco.utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import id.web.nanangmaxfi.infoco.R;

public class ConfigUtils {

    //menampilkan actionbar
    public static void toolbar(final AppCompatActivity activity, String title, boolean back){
        if (activity.getSupportActionBar() != null) {
            activity.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            activity.getSupportActionBar().setDisplayShowCustomEnabled(true);
            activity.getSupportActionBar().setCustomView(R.layout.custom_toolbar);
            View view = activity.getSupportActionBar().getCustomView();

            TextView actionTitle = view.findViewById(R.id.txt_title);
            actionTitle.setText(title);

            if (back) {
                ImageView backMenu = view.findViewById(R.id.backmenu);
                backMenu.setVisibility(View.VISIBLE);
                backMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.finish();
                    }
                });
            }
        }
    }
}

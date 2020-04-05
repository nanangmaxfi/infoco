package id.web.nanangmaxfi.infoco.ui.country;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.web.nanangmaxfi.infoco.R;
import id.web.nanangmaxfi.infoco.data.source.local.entity.CountryEntity;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<CountryEntity> listCountry = new ArrayList<>();

    void setListCountry(List<CountryEntity> countryEntities){
        if (countryEntities == null) return;
        listCountry.clear();
        listCountry.addAll(countryEntities);
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_province, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        CountryEntity countryEntity = listCountry.get(position);
        holder.bind(countryEntity,position+1);
    }

    @Override
    public int getItemCount() {
        return listCountry.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView txtNo, txtName, txtPositif, txtSembuh, txtMeninggal;
        CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNo = itemView.findViewById(R.id.txt_no);
            txtName = itemView.findViewById(R.id.txt_name);
            txtPositif = itemView.findViewById(R.id.txt_positif);
            txtSembuh = itemView.findViewById(R.id.txt_sembuh);
            txtMeninggal = itemView.findViewById(R.id.txt_meninggal);
        }

        void bind(CountryEntity countryEntity, int position){
            txtNo.setText(String.valueOf(position));
            txtName.setText(countryEntity.getCountry());
            txtPositif.setText(countryEntity.getPositif());
            txtSembuh.setText(countryEntity.getSembuh());
            txtMeninggal.setText(countryEntity.getMeninggal());
        }
    }
}

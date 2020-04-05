package id.web.nanangmaxfi.infoco.ui.province;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.web.nanangmaxfi.infoco.R;
import id.web.nanangmaxfi.infoco.data.source.local.entity.ProvinceEntity;

public class ProvinceAdapter extends RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder> {
    private List<ProvinceEntity> listProvince = new ArrayList<>();

    void setListProvince(List<ProvinceEntity> provinces){
        if (provinces == null) return;
        listProvince.clear();
        listProvince.addAll(provinces);
    }

    @NonNull
    @Override
    public ProvinceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_province, parent, false);
        return new ProvinceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProvinceViewHolder holder, int position) {
        ProvinceEntity provinceEntity = listProvince.get(position);
        holder.bind(provinceEntity,position+1);
    }

    @Override
    public int getItemCount() {
        return listProvince.size();
    }

    class ProvinceViewHolder extends RecyclerView.ViewHolder {
        TextView txtNo, txtName, txtPositif, txtSembuh, txtMeninggal;
        ProvinceViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNo = itemView.findViewById(R.id.txt_no);
            txtName = itemView.findViewById(R.id.txt_name);
            txtPositif = itemView.findViewById(R.id.txt_positif);
            txtSembuh = itemView.findViewById(R.id.txt_sembuh);
            txtMeninggal = itemView.findViewById(R.id.txt_meninggal);
        }

        void bind(ProvinceEntity provinceEntity, int position){
            txtNo.setText(String.valueOf(position));
            txtName.setText(provinceEntity.getProvinsi());
            txtPositif.setText(provinceEntity.getPositif());
            txtSembuh.setText(provinceEntity.getSembuh());
            txtMeninggal.setText(provinceEntity.getMeninggal());
        }
    }
}

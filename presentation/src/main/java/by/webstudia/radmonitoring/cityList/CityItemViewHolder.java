package by.webstudia.radmonitoring.cityList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.base.BaseItemViewHolder;
import by.webstudia.radmonitoring.cityPage.CityPageActivity;
import by.webstudia.radmonitoring.databinding.CityItemBinding;
import by.webstudia.radmonitoring.domain.entity.CityModel;



public class CityItemViewHolder extends BaseItemViewHolder<CityModel,
       CityItemVM,  CityItemBinding> {

    Context context;
    TextView itemName;
    TextView itemMz;

    public CityItemViewHolder( CityItemBinding binding,CityItemVM viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
        context = itemView.getContext();



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CityPageActivity.class);
                itemName =(TextView)itemView.findViewById(R.id.cityName);
                itemMz = (TextView) itemView.findViewById(R.id.cityMz);


                intent.putExtra("itemName", itemName.getText());
                intent.putExtra("itemMz", itemMz.getText());
                context.startActivity(intent);

            }
        });
    }

    public static CityItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                            CityItemVM viewModel) {


        CityItemBinding binding =  CityItemBinding.inflate(inflater, parent, false);
        return new CityItemViewHolder(binding, viewModel);
    }


}


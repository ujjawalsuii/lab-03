package com.example.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {

    private final ArrayList<City> cities;
    private final Context context;

    public CityArrayAdapter(@NonNull Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.context = context;
        this.cities = cities;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        City city = cities.get(position);

        TextView cityNameView = view.findViewById(android.R.id.text1);
        TextView provinceNameView = view.findViewById(android.R.id.text2);

        cityNameView.setText(city.getCityName());
        provinceNameView.setText(city.getProvinceName());

        return view;
    }
}

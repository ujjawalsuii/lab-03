package com.example.listycity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EditCityFragment extends DialogFragment {

    public interface EditCityDialogListener {
        void updateCity(int position, City updatedCity);
    }

    private static final String ARG_CITY_NAME = "city_name";
    private static final String ARG_PROVINCE_NAME = "province_name";
    private static final String ARG_POSITION = "position";

    public static EditCityFragment newInstance(City city, int position) {
        EditCityFragment fragment = new EditCityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CITY_NAME, city.getCityName());
        args.putString(ARG_PROVINCE_NAME, city.getProvinceName());
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_add_city, null);

        EditText editCityName = view.findViewById(R.id.edit_text_city_text);
        EditText editProvinceName = view.findViewById(R.id.edit_text_province_text);

        String cityName = getArguments().getString(ARG_CITY_NAME);
        String provinceName = getArguments().getString(ARG_PROVINCE_NAME);
        int position = getArguments().getInt(ARG_POSITION);

        editCityName.setText(cityName);
        editProvinceName.setText(provinceName);

        return new AlertDialog.Builder(getContext())
                .setView(view)
                .setTitle("Edit City")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Save", (dialog, which) -> {
                    String updatedCityName = editCityName.getText().toString();
                    String updatedProvinceName = editProvinceName.getText().toString();
                    if (getActivity() instanceof EditCityDialogListener) {
                        ((EditCityDialogListener) getActivity())
                                .updateCity(position, new City(updatedCityName, updatedProvinceName));
                    }
                })
                .create();
    }
}

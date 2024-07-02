package com.example.vitrualtour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class Asrama_F_Fragment extends Fragment {

    private ImageView image360F;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758744628790644";
    private String longitude = "112.72867987912718";
    private String photo360Url = "https://www.google.co.id/maps/place/Asrama+E+Dan+F,+Pp.NGALAH/@-7.758788,112.7285755,3a,75y,100h,100t/data=!3m8!1e1!3m6!1sAF1QipPwwz2UrYxRVxxJnlNpb7nWvPi9zrgatE9I49pt!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPwwz2UrYxRVxxJnlNpb7nWvPi9zrgatE9I49pt%3Dw900-h600-k-no-pi-10-ya350-ro0-fo90!7i8704!8i4352!4m9!3m8!1s0x2dd7d31272a0e07f:0x14bb78abd2e65f06!8m2!3d-7.758788!4d112.7285755!10e5!14m1!1BCgIgAQ!16s%2Fg%2F11y444j838?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_f, container, false);

        image360F = view.findViewById(R.id.image_360F);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360F.setOnClickListener(v -> {
            view360Image();
        });

        return view;
    }

    private void directionFromCurrentMap(String destinationLatitude, String destinationLongitude) {
        Uri mapUri = Uri.parse("https://maps.google.com/maps?daddr=" + destinationLatitude + "," + destinationLongitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(intent);
    }

    private void view360Image() {
        Uri mapUri = Uri.parse(photo360Url);
        Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(intent);
    }

}

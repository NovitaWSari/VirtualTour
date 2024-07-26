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

public class Asrama_P_Fragment extends Fragment {

    private ImageView image360P;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758813771845956";
    private String longitude = "112.7275451810897";
    private String photo360Url = "https://www.google.co.id/maps/place/ASRAMA+P+PONDOK+PESANTREN+NGALAH/@-7.7589945,112.727513,3a,75y,300h,100t/data=!3m8!1e1!3m6!1sAF1QipN39T-tBpRgrjD6Jm0Zu7YmjoT1AczUE2Emdm5C!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipN39T-tBpRgrjD6Jm0Zu7YmjoT1AczUE2Emdm5C%3Dw900-h600-k-no-pi-10-ya162-ro0-fo90!7i8704!8i4352!4m9!3m8!1s0x2dd7d3d767977d9b:0xc3226c7fa01e82e9!8m2!3d-7.7589945!4d112.727513!10e5!14m1!1BCgIgAQ!16s%2Fg%2F11s4wy4f71?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_p, container, false);

        image360P = view.findViewById(R.id.image_360P);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360P.setOnClickListener(v -> {
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

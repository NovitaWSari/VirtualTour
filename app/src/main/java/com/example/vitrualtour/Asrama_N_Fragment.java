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

public class Asrama_N_Fragment extends Fragment {

    private ImageView image360N;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.757052854733472";
    private String longitude = "112.73071625756987";
    private String photo360Url = "https://www.google.com/maps/place/Asrama+N+ponpes+Ngalah/@-7.7571558,112.7307037,3a,75y,20h,90t/data=!3m8!1e1!3m6!1sAF1QipN-EAQfEkcn4FcCaqfvwUq_N2NNVJLTmJKoWB5_!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipN-EAQfEkcn4FcCaqfvwUq_N2NNVJLTmJKoWB5_%3Dw900-h600-k-no-pi0-ya55-ro0-fo90!7i8704!8i4352!4m13!1m2!2m1!1sASRAMA+n+PONDOK+PESANTREN+NGALAH!3m9!1s0x2dd7d3003b2028d1:0x36311e1b933f7aab!8m2!3d-7.7571379!4d112.7306948!10e5!14m1!1BCgIgAQ!15sCiJBU1JBTUEgZGFuIFBPTkRPSyBQRVNBTlRSRU4gTkdBTEFIkgEGc2Nob29s4AEA!16s%2Fg%2F11vx0w8r9h?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_n, container, false);

        image360N = view.findViewById(R.id.image_360N);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360N.setOnClickListener(v -> {
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

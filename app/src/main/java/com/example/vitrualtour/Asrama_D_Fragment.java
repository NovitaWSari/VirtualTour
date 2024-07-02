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

public class Asrama_D_Fragment extends Fragment {

    private ImageView image360D;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758001";
    private String longitude = "112.729899";
    private String photo360Url = "https://www.google.com/maps/place/Asrama+D+ponpes+Ngalah/@-7.758001,112.729899,3a,75y,220h,90t/data=!3m8!1e1!3m6!1sAF1QipP96nJodcwySNdWp5yXb5Fhzfn3SVgvDIDk93Pj!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipP96nJodcwySNdWp5yXb5Fhzfn3SVgvDIDk93Pj%3Dw900-h600-k-no-pi0-ya257-ro0-fo90!7i8704!8i4352!4m17!1m7!3m6!1s0x2dd7d30073410dbd:0x9f9ab0dfdcfb9d25!2sAsrama+D+ponpes+Ngalah!8m2!3d-7.758001!4d112.729899!16s%2Fg%2F11vz7s1mrl!3m8!1s0x2dd7d30073410dbd:0x9f9ab0dfdcfb9d25!8m2!3d-7.758001!4d112.729899!10e5!14m1!1BCgIgAQ!16s%2Fg%2F11vz7s1mrl?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_d, container, false);

        image360D = view.findViewById(R.id.image_360D);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360D.setOnClickListener(v -> {
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

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

public class Asrama_C_Fragment extends Fragment {

    private ImageView image360C;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.757807306839655";
    private String longitude = "112.72900946884421";
    private String photo360Url = "https://www.google.co.id/maps/place/Asrama+C+Ponpes+Ngalah/@-7.7578606,112.7289886,3a,75y,160h,100t/data=!3m8!1e1!3m6!1sAF1QipOk23DP_TkE_ZwRxMdbR2wPsHz__uXFYWcM-SLb!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipOk23DP_TkE_ZwRxMdbR2wPsHz__uXFYWcM-SLb%3Dw900-h600-k-no-pi-10-ya176-ro0-fo90!7i8704!8i4352!4m17!1m7!3m6!1s0x2dd7d38390529889:0x16667eb0a24b5944!2sAsrama+C+Ponpes+Ngalah!8m2!3d-7.7578374!4d112.7289918!16s%2Fg%2F11hdsmrtd6!3m8!1s0x2dd7d38390529889:0x16667eb0a24b5944!8m2!3d-7.7578374!4d112.7289918!10e5!14m1!1BCgIgAQ!16s%2Fg%2F11hdsmrtd6?coh=205410&entry=ttu#";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_c, container, false);

        image360C = view.findViewById(R.id.image_360C);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360C.setOnClickListener(v -> {
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
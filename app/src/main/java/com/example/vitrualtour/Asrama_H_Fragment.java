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

public class Asrama_H_Fragment extends Fragment {

    private ImageView image360H;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758054780676805";
    private String longitude = "112.73078916983764";
    private String photo360Url = "https://www.google.co.id/maps/place/Asrama+H+ponpes+Ngalah/@-7.7581281,112.7307659,3a,75y,280h,100t/data=!3m8!1e1!3m6!1sAF1QipPy84bBQySurROSwgCDGxcJuapU4HChRj0JOEIq!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPy84bBQySurROSwgCDGxcJuapU4HChRj0JOEIq%3Dw900-h600-k-no-pi-10-ya305-ro0-fo90!7i8704!8i4352!4m17!1m7!3m6!1s0x2dd7d3569fa392a5:0xfe4146df79e3537e!2sAsrama+H+ponpes+Ngalah!8m2!3d-7.7580907!4d112.7307504!16s%2Fg%2F11sz4cwx88!3m8!1s0x2dd7d3569fa392a5:0xfe4146df79e3537e!8m2!3d-7.7580907!4d112.7307504!10e5!14m1!1BCgIgARICGAI!16s%2Fg%2F11sz4cwx88?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_h, container, false);

        image360H = view.findViewById(R.id.image_360H);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360H.setOnClickListener(v -> {
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

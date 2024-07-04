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

public class Asrama_J_Fragment extends Fragment {

    private ImageView image360J;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.75777105061418";
    private String longitude = "112.73108169458408";
    private String photo360Url = "https://www.google.co.id/maps/place/Asrama+J+Ponpes+Ngalah/@-7.7580625,112.731056,3a,75y,319.89h,90.11t/data=!3m8!1e1!3m6!1sAF1QipPedxeJjDMvMPvAVBIS2vE6GqOeSZFdPowKTRgs!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPedxeJjDMvMPvAVBIS2vE6GqOeSZFdPowKTRgs%3Dw900-h600-k-no-pi-0.11253999999999564-ya299.88745-ro0-fo90!7i8704!8i4352!4m17!1m7!3m6!1s0x2dd7d300059f61b3:0x1987d05cfe749906!2sAsrama+J+Ponpes+Ngalah!8m2!3d-7.7581325!4d112.7310817!16s%2Fg%2F11vz7qq_hg!3m8!1s0x2dd7d300059f61b3:0x1987d05cfe749906!8m2!3d-7.7581325!4d112.7310817!10e5!14m1!1BCgIgAQ!16s%2Fg%2F11vz7qq_hg?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_j, container, false);

        image360J = view.findViewById(R.id.image_360J);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360J.setOnClickListener(v -> {
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

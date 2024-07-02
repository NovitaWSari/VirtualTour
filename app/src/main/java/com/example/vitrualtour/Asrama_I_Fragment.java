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

public class Asrama_I_Fragment extends Fragment {

    private ImageView image360I;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758252110530023";
    private String longitude = "112.72971508674722";
    private String photo360Url = "https://www.google.co.id/maps/place/Asrama+I+Ponpes+Ngalah/@-7.7582717,112.7297118,3a,75y,340h,100t/data=!3m8!1e1!3m6!1sAF1QipPisY3Fbu4ja9dpfYsP2m08QrHaeoD_DfdKBPT6!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPisY3Fbu4ja9dpfYsP2m08QrHaeoD_DfdKBPT6%3Dw900-h600-k-no-pi-10-ya1-ro0-fo90!7i8704!8i4352!4m11!1m2!2m1!1sAsrama+i+ponpes+Ngalah!3m7!1s0x2dd7d38634bbf737:0x9e31f323b7c458f6!8m2!3d-7.7582717!4d112.7297118!10e5!15sChZBc3JhbWEgaSBwb25wZXMgTmdhbGFokgETcmVzaWRlbnRpYWxfY29sbGVnZeABAA!16s%2Fg%2F11ks2nhz29?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_i, container, false);

        image360I = view.findViewById(R.id.image_360I);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360I.setOnClickListener(v -> {
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

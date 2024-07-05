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

public class Asrama_O_Fragment extends Fragment {

    private ImageView image360O;
    private MaterialButton directionOneBtn;

    private String latitude = "";
    private String longitude = "";
    private String photo360Url = "https://www.google.co.id/maps/place/Asrama+O+Pondok+Ngalah/@-7.7568226,112.7304886,3a,75y,140h,110t/data=!3m8!1e1!3m6!1sAF1QipMRacDBqB32xUsAP2i-47vHmTlJ8d6YcFOhjfp8!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipMRacDBqB32xUsAP2i-47vHmTlJ8d6YcFOhjfp8%3Dw900-h600-k-no-pi-20-ya167-ro0-fo90!7i8704!8i4352!4m13!1m2!2m1!1sAsrama+o+ponpes+Ngalah!3m9!1s0x2dd7d3789a60f401:0x108e630c2dcbb6b8!8m2!3d-7.7568492!4d112.7304916!10e5!14m1!1BCgIgARICGAI!15sChZBc3JhbWEgbyBwb25wZXMgTmdhbGFokgERc3R1ZGVudF9kb3JtaXRvcnngAQA!16s%2Fg%2F11jfbw0sgy?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_o, container, false);

        image360O = view.findViewById(R.id.image_360O);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360O.setOnClickListener(v -> {
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

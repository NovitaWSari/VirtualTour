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

    private String latitude = "-7.758017231511479";
    private String longitude = "112.72889927020297";
    private String photo360Url = "https://www.google.co.id/maps/place/Asrama+D+Pondok+Ngalah/@-7.7580757,112.7288705,3a,75y,340h,110t/data=!3m8!1e1!3m6!1sAF1QipP7OgjdRps4hbzjEIRdoBeNxkZ3Jhsqfb3t5_WH!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipP7OgjdRps4hbzjEIRdoBeNxkZ3Jhsqfb3t5_WH%3Dw900-h600-k-no-pi-20-ya188-ro0-fo90!7i8704!8i4352!4m9!3m8!1s0x2dd7d3e5554f41c7:0x9acb139bbd986b77!8m2!3d-7.7580757!4d112.7288705!10e5!14m1!1BCgIgAQ!16s%2Fg%2F1pzq94l1w?coh=205410&entry=ttu#";  // URL foto 360

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

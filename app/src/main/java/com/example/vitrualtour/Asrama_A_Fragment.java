package com.example.vitrualtour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class Asrama_A_Fragment extends Fragment {

    private ImageView image360;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.7578893361576835";
    private String longitude = "112.72880717614514";
    private String photo360Url = "https://www.google.com/maps/place/Pondok+Pesantren+Ngalah/@-7.7579139,112.7288043,3a,75y,340h,90t/data=!3m8!1e1!3m6!1sAF1QipNXarrZ93oq1Ke5Fa5a5gA24T1r-B4QQQHDGdJ8!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipNXarrZ93oq1Ke5Fa5a5gA24T1r-B4QQQHDGdJ8%3Dw900-h600-k-no-pi0-ya353-ro0-fo90!7i8704!8i4352!4m17!1m7!3m6!1s0x2dd7d3e4a0151741:0xaa4ec707ee970700!2sPondok+Pesantren+Ngalah!8m2!3d-7.7579058!4d112.7288027!16s%2Fg%2F11c5sy3c3w!3m8!1s0x2dd7d3e4a0151741:0xaa4ec707ee970700!8m2!3d-7.7579058!4d112.7288027!10e5!14m1!1BCgIgARICGAI!16s%2Fg%2F11c5sy3c3w?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_a, container, false);

        image360 = view.findViewById(R.id.image_360);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360.setOnClickListener(v -> {
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


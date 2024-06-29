package com.example.vitrualtour;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

import java.util.List;

public class Asrama_A_Fragment extends Fragment {

    private ImageView image360;
    private TextView address;
    private MaterialButton directionOneBtn;
    private MaterialButton directionTwoBtn;

    private String latitudeSaygon = "-7.74777128178355";  // Koordinat Saygon
    private String longitudeSaygon = "112.73866026944174"; // Koordinat Saygon
    private String photo360Url = "https://www.google.com/maps/place/Asrama+I+Ponpes+Ngalah/@-7.7582717,112.7297118,3a,75y,340h,100t/data=!3m8!1e1!3m6!1sAF1QipPisY3Fbu4ja9dpfYsP2m08QrHaeoD_DfdKBPT6!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipPisY3Fbu4ja9dpfYsP2m08QrHaeoD_DfdKBPT6%3Dw900-h600-k-no-pi-10-ya1-ro0-fo90!7i8704!8i4352!4m13!1m2!2m1!1sasrama+i!3m9!1s0x2dd7d38634bbf737:0x9e31f323b7c458f6!8m2!3d-7.7582717!4d112.7297118!10e5!14m1!1BCgIgARICEAI!15sCghhc3JhbWEgaZIBE3Jlc2lkZW50aWFsX2NvbGxlZ2XgAQA!16s%2Fg%2F11ks2nhz29?coh=205410&entry=ttu";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_a, container, false);

        image360 = view.findViewById(R.id.image_360);
        address = view.findViewById(R.id.address);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);
        directionTwoBtn = view.findViewById(R.id.directionTwoBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitudeSaygon, longitudeSaygon);
        });

        directionTwoBtn.setOnClickListener(v -> {
            directionBetweenTwoMap(latitudeSaygon, longitudeSaygon, latitudeSaygon, longitudeSaygon); // Menjaga method tetap aktif
        });

        image360.setOnClickListener(v -> {
            view360Image();
        });

        address.setOnClickListener(v -> {
            openGoogleMaps();
        });

        return view;
    }

    private void directionFromCurrentMap(String destinationLatitude, String destinationLongitude) {
        Uri mapUri = Uri.parse("https://maps.google.com/maps?daddr=" + destinationLatitude + "," + destinationLongitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(intent);
    }

    private void directionBetweenTwoMap(String sourceLatitude, String sourceLongitude, String destinationLatitude, String destinationLongitude) {
        Uri mapUri = Uri.parse("https://maps.google.com/maps?saddr=" + sourceLatitude + "," + sourceLongitude + "&daddr=" + destinationLatitude + "," + destinationLongitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(intent);
    }

    private void view360Image() {
        Uri uri = Uri.parse(photo360Url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");

        PackageManager packageManager = requireActivity().getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(intent);
        } else {
            Toast.makeText(requireContext(), "Aplikasi Google Maps tidak terpasang.", Toast.LENGTH_SHORT).show();
        }
    }

    private void openGoogleMaps() {
        String googleMapsUrl = "https://maps.google.com/maps?q=-7.74777128178355,112.73866026944174";

        Uri uri = Uri.parse(googleMapsUrl);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");

        PackageManager packageManager = requireActivity().getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;

        if (isIntentSafe) {
            startActivity(intent);
        } else {
            Toast.makeText(requireContext(), "Aplikasi Google Maps tidak terpasang.", Toast.LENGTH_SHORT).show();
        }
    }
}

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

import java.util.List;

public class Asrama_A_Fragment extends Fragment {

    private ImageView image360;
    private ImageView iconLocation;
    private TextView address;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_a, container, false);

        image360 = view.findViewById(R.id.image_360);
        address = view.findViewById(R.id.address);
        iconLocation = view.findViewById(R.id.icon_address);

        image360.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view360Image();
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMaps();
            }
        });

        iconLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLocationInMap(-7.7577463326634195, 112.72877050807833); // Ganti dengan koordinat Anda
            }
        });

        return view;
    }

    private void view360Image() {
        // Fungsi ini kosong sementara karena masalah dependensi foto 360
    }

    private void openGoogleMaps() {
        String googleMapsUrl = "https://maps.app.goo.gl/xi2TRraaTjbtBiim6";

        // Membuat Uri dari Google Maps URL
        Uri uri = Uri.parse(googleMapsUrl);

        // Membuat Intent untuk membuka aplikasi Google Maps
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");

        // Memeriksa apakah aplikasi Google Maps terpasang
        PackageManager packageManager = requireActivity().getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Menampilkan daftar aplikasi yang bisa menangani intent
        for (ResolveInfo resolveInfo : activities) {
            String packageName = resolveInfo.activityInfo.packageName;
            String activityName = resolveInfo.activityInfo.name;
            Log.d("IntentHandler", "Found app to handle intent: " + packageName + ", " + activityName);
        }

        // Jika aplikasi Google Maps terpasang, maka buka alamat tersebut
        if (isIntentSafe) {
            startActivity(intent);
        } else {
            Toast.makeText(requireContext(), "Aplikasi Google Maps tidak terpasang.", Toast.LENGTH_SHORT).show();
        }
    }

    private void openLocationInMap(double latitude, double longitude) {
        // Membuat URI untuk lokasi
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude + "(Label+Peta)");

        // Membuat intent untuk Google Maps
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        // Memeriksa apakah aplikasi Google Maps terpasang
        PackageManager packageManager = requireActivity().getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Menampilkan daftar aplikasi yang bisa menangani intent
        for (ResolveInfo resolveInfo : activities) {
            String packageName = resolveInfo.activityInfo.packageName;
            String activityName = resolveInfo.activityInfo.name;
            Log.d("IntentHandler", "Found app to handle intent: " + packageName + ", " + activityName);
        }

        // Jika aplikasi Google Maps terpasang, maka buka alamat tersebut
        if (isIntentSafe) {
            startActivity(mapIntent);
        } else {
            Toast.makeText(requireContext(), "Aplikasi Google Maps tidak terpasang.", Toast.LENGTH_SHORT).show();
        }
    }
}

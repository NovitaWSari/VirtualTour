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

public class Asrama_G_Fragment extends Fragment {

    private ImageView image360G;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758859740824484";
    private String longitude = "112.72793912198748";
    private String photo360Url = "https://www.google.com/maps/place/ASRAMA+G+PONDOK+NGALAH/@-7.7590137,112.7279383,3a,75y,80h,100t/data=!3m8!1e1!3m6!1sAF1QipNe6BPfsNMGUyzqdqH6_4IhTwRjbwMLhmKo-iM8!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipNe6BPfsNMGUyzqdqH6_4IhTwRjbwMLhmKo-iM8%3Dw900-h600-k-no-pi-10-ya6-ro0-fo90!7i8704!8i4352!4m13!1m2!2m1!1sASRAMA+g+PONDOK+PESANTREN+NGALAH!3m9!1s0x2dd7d3aed3112e8f:0x665339c7bccb2e7!8m2!3d-7.7590192!4d112.7279123!10e5!14m1!1BCgIgARICGAI!15sCiBBU1JBTUEgZyBQT05ET0sgUEVTQU5UUkVOIE5HQUxBSFoiIiBhc3JhbWEgZyBwb25kb2sgcGVzYW50cmVuIG5nYWxhaJIBBWhvdGVsmgEkQ2hkRFNVaE5NRzluUzBWSlEwRm5TVU5QTTNKUWVXMUJSUkFC4AEA!16s%2Fg%2F11nn345gb3?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_g, container, false);

        image360G = view.findViewById(R.id.image_360G);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360G.setOnClickListener(v -> {
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

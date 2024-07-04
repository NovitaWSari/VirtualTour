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

public class Asrama_K_Fragment extends Fragment {

    private ImageView image360K;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758255588367384";
    private String longitude = "112.73121198761736";
    private String photo360Url = "https://www.google.co.id/maps/place/Asrama+K+ponpes+Ngalah/@-7.7583229,112.7311958,3a,75y,340h,90t/data=!3m8!1e1!3m6!1sAF1QipN-WxOyvKOc2AaMMvjBBe4EC9uwl7A0E4z-N_-g!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipN-WxOyvKOc2AaMMvjBBe4EC9uwl7A0E4z-N_-g%3Dw900-h600-k-no-pi0-ya309-ro0-fo90!7i8704!8i4352!4m17!1m7!3m6!1s0x2dd7d3000816e317:0xfdecbb20f5b84e73!2sAsrama+K+ponpes+Ngalah!8m2!3d-7.7583229!4d112.7311958!16s%2Fg%2F11vz7qwx2h!3m8!1s0x2dd7d3000816e317:0xfdecbb20f5b84e73!8m2!3d-7.7583229!4d112.7311958!10e5!14m1!1BCgIgAQ!16s%2Fg%2F11vz7qwx2h?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_k, container, false);

        image360K = view.findViewById(R.id.image_360K);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360K.setOnClickListener(v -> {
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

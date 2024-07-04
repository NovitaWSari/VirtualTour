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

public class Asrama_L_Fragment extends Fragment {

    private ImageView image360L;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758190994595536";
    private String longitude = "112.72901878518336";
    private String photo360Url = "https://www.google.co.id/maps/place/Asrama+L+Ponpes+Ngalah/@-7.7582478,112.7290206,3a,75y,240h,90t/data=!3m8!1e1!3m6!1sAF1QipOdFbqKMKFq1I6uh2hITy98jIKvAVlwYvBVC_U7!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipOdFbqKMKFq1I6uh2hITy98jIKvAVlwYvBVC_U7%3Dw900-h600-k-no-pi0-ya105-ro0-fo90!7i8704!8i4352!4m13!1m2!2m1!1sAsrama+L+ponpes+Ngalah!3m9!1s0x2dd7d3c31003053b:0x9e771b55c9f11363!8m2!3d-7.7582189!4d112.729014!10e5!14m1!1BCgIgAQ!15sChZBc3JhbWEgSSBwb25wZXMgTmdhbGFokgEQZWR1Y2F0aW9uX2NlbnRlcuABAA!16s%2Fg%2F11l2zdcyd0?coh=205410&entry=ttu#";  // URL foto 360

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_l, container, false);

        image360L = view.findViewById(R.id.image_360L);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        image360L.setOnClickListener(v -> {
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

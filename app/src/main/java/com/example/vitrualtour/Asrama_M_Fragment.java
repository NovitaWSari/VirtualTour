package com.example.vitrualtour;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;

public class Asrama_M_Fragment extends Fragment {

    private WebView webView360;
    private ProgressBar progressBar;
    private MaterialButton directionOneBtn;

    private String latitude = "-7.758163071935637";
    private String longitude = "112.72889770551367";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asrama_m, container, false);

        webView360 = view.findViewById(R.id.webview_360);
        progressBar = view.findViewById(R.id.progressBar);
        directionOneBtn = view.findViewById(R.id.directionOneBtn);

        initView();

        webView360.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
            }
        });

        directionOneBtn.setOnClickListener(v -> {
            directionFromCurrentMap(latitude, longitude);
        });

        return view;
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initView() {
        WebSettings webSettings = webView360.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Ubah URL di sini dengan URL yang ingin Anda tampilkan di WebView
        webView360.loadUrl("https://www.google.com/maps/place/Asrama+M+ponpes+Ngalah/@-7.758264,112.7290963,3a,75y,100h,100t/data=!3m8!1e1!3m6!1sAF1QipOrA3QtIJFmV7sTg0szfNfGeUz_neBOD2n_6fss!2e10!3e11!6shttps:%2F%2Flh5.googleusercontent.com%2Fp%2FAF1QipOrA3QtIJFmV7sTg0szfNfGeUz_neBOD2n_6fss%3Dw900-h600-k-no-pi-10-ya297-ro0-fo90!7i8704!8i4352!4m13!1m2!2m1!1sASRAMA+m+PONDOK+PESANTREN+NGALAH!3m9!1s0x2dd7d3000db798c9:0xce054b25601fc7!8m2!3d-7.7582671!4d112.7290828!10e5!14m1!1BCgIgAQ!15sCiBBU1JBTUEgbSBQT05ET0sgUEVTQU5UUkVOIE5HQUxBSJIBBnNjaG9vbOABAA!16s%2Fg%2F11y446w0rg?coh=205410&entry=ttu");
    }

    private void directionFromCurrentMap(String destinationLatitude, String destinationLongitude) {
        Uri mapUri = Uri.parse("https://maps.google.com/maps?daddr=" + destinationLatitude + "," + destinationLongitude);
        Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
        startActivity(intent);
    }
}

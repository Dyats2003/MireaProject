package ru.mirea.yatsenko.mireaproject.ui.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ru.mirea.yatsenko.mireaproject.R;

public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener {
    protected static GoogleMap map;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            MapsFragment.map = googleMap;

            LatLng Mirea1 = new LatLng(55.7938058, 37.7000664);
            map.addMarker(new MarkerOptions().position(Mirea1).title("РТУ МИРЭА (МГУПИ). ул. Стромынка, д. 20, 1936")
                    .snippet("ул. Стромынка, д. 20, 107076, 55.7938058,37.7000664"));

            LatLng Mirea2 = new LatLng(55.6695953, 37.4798824);
            map.addMarker(new MarkerOptions().position(Mirea2).title("РТУ МИРЭА. Проспект Вернадского, 78, 1947г")
                    .snippet("Проспект Вернадского, д. 78, 119454, 55.6695953,37.4798824"));


            LatLng Mirea3 = new LatLng(55.6618971, 37.4745255);
            map.addMarker(new MarkerOptions().position(Mirea3).title("РТУ МИРЭА (МИТХТ). Проспект Вернадского, 86, 1980")
                    .snippet("Проспект Вернадского, 86, 119571, 55.6618971,37.4745255"));


            LatLng Mirea4 = new LatLng(55.728676, 37.5708812);
            map.addMarker(new MarkerOptions().position(Mirea4).title("РТУ МИРЭЫ (ВУЦ). ул. Усачева, д. 7/1, -")
                    .snippet("ул. Усачева, д. 7/1, 119048, 55.728676, 37.5708812"));


            LatLng Mirea5 = new LatLng(55.7317977, 37.5745506);
            map.addMarker(new MarkerOptions().position(Mirea5).title("РТУ МИРЭА. ул. Малая Пироговская, д. 1, стр. 5, 1908")
                    .snippet("ул. Малая Пироговская, д. 1, стр. 5, 119435, 55.7317977, 37.5745506"));

            LatLng Mirea6 = new LatLng(55.7648399, 37.7392163);
            map.addMarker(new MarkerOptions().position(Mirea6).title("РТУ МИРЭА. 5-ая ул. Соколиной Горы, д.22, -")
                    .snippet("5-ая ул. Соколиной Горы, д.22, 105275, 55.7648399, 37.7392163"));

            LatLng Mirea7 = new LatLng(55.9604333, 38.049562);
            map.addMarker(new MarkerOptions().position(Mirea7).title("ФИЛИАЛ РТУ МИРЭА. Московская область, г. Фрязино, ул. Вокзальная, д. 2а,  -")
                    .snippet("Московская область, г. Фрязино, ул. Вокзальная, д. 2а, 141190, 55.9604333, 38.049562"));

            LatLng Mirea8 = new LatLng(45.0508385, 41.9097125);
            map.addMarker(new MarkerOptions().position(Mirea8).title("ФИЛИАЛ РТУ МИРЭА. Ставропольский край, г. Ставрополь, пр. Кулакова, д. 8, -")
                    .snippet("Ставропольский край, г. Ставрополь, пр. Кулакова, д. 8, 355035, 45.0508385, 41.9097125"));

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapClickListener(this);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        // добавление кнопки определения местоположения
        map.setMyLocationEnabled(true);
// добавление кнопок изменнеия масштаба
        map.getUiSettings().setZoomControlsEnabled(true);
// отображение слоя загруженно
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                latLng).zoom(12).build();
        map.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        map.addMarker(new MarkerOptions().title("Где я?")
                .snippet("Новое место").position(latLng));
    }
}

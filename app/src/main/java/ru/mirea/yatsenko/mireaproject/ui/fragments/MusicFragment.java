package ru.mirea.yatsenko.mireaproject.ui.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ru.mirea.yatsenko.mireaproject.R;
import ru.mirea.yatsenko.mireaproject.services.PlayerService;


public class MusicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_music, container, false);
        view.findViewById(R.id.buttonStart).setOnClickListener(this::onClickPlayMusic);
        view.findViewById(R.id.buttonStop).setOnClickListener(this::onClickStopMusic);
        return view;
    }

    public void onClickPlayMusic(View view) {
        getActivity().startService(new Intent(getActivity(), PlayerService.class));
        Toast toast = Toast.makeText(getContext(),
                "И ноги, ноги-то сами в пляс!",
                Toast.LENGTH_SHORT);
        toast.show();
    }
    public void onClickStopMusic(View view) {
        getActivity().stopService(new Intent(getActivity(), PlayerService.class));
        Toast toast = Toast.makeText(getContext(),
                "Конец веселью(",
                Toast.LENGTH_SHORT);
        toast.show();
    }
}
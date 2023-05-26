package ru.mirea.serebriakovaea.mireaproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NewsFragment extends Fragment {
    public NewsFragment(){
        super(R.layout.fragment_news);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn_weather = view.findViewById(R.id.btn_go_to_form);
        EditText city = view.findViewById(R.id.edit_city);
        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(getClass().getSimpleName(), "Click");
                Intent intent = new Intent(getActivity(), Weather.class);
                intent.putExtra("city", city.getText().toString());
                startActivity(intent);
            }
        });
    }
}

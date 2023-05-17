package ru.mirea.serebriakovaea.mireaproject.workdata;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.mirea.serebriakovaea.mireaproject.R;
import ru.mirea.serebriakovaea.mireaproject.workdata.WorkDataForm;

public class WorkDataFragment extends Fragment {
    public WorkDataFragment(){
        super(R.layout.fragment_work_data);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn_go_to_form = view.findViewById(R.id.btn_go_to_form);
        btn_go_to_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(getClass().getSimpleName(), "on Click!");
                Intent intent = new Intent(getActivity(), WorkDataForm.class);
                startActivity(intent);
            }
        });
    }
}

package ru.mirea.serebriakovaea.mireaproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private final String TAG = getClass().getSimpleName();
    String name;
    String age;
    String sex;
    String hobbie;

    public ProfileFragment(){
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("profile_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();

        Button btn_save = view.findViewById(R.id.btn_save);
        EditText edit_name = view.findViewById(R.id.edit_name);
        EditText edit_age = view.findViewById(R.id.edit_age);
        EditText edit_sex = view.findViewById(R.id.edit_sex);
        EditText edit_hobbie = view.findViewById(R.id.edit_hobbie);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edit_name.getText().toString();
                age = edit_age.getText().toString();
                sex = edit_sex.getText().toString();
                hobbie = edit_hobbie.getText().toString();

                editor.putString("NAME", name);
                editor.putString("AGE", age);
                editor.putString("SEX", sex);
                editor.putString("HOBBIE", hobbie);

                editor.apply();

                Log.d(TAG, sharedPreferences.getString("NAME", "no inf"));
                Log.d(TAG, sharedPreferences.getString("AGE", "no inf"));
                Log.d(TAG, sharedPreferences.getString("SEX", "no inf"));
                Log.d(TAG, sharedPreferences.getString("HOBBIE", "no inf"));
            }
        });
    }
}

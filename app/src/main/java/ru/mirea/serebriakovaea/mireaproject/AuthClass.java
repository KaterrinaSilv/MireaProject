package ru.mirea.serebriakovaea.mireaproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import ru.mirea.serebriakovaea.mireaproject.databinding.ActivityAuthenticationBinding;


public class AuthClass extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private ActivityAuthenticationBinding binding;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthenticationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        binding.btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount(binding.editEmail.getText().toString(), binding.editPassword.getText().toString());
            }
        });

    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if(! validateForm(email)){
            Log.d(TAG, "Invalid email form");
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "createAccount is successful");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "createAccount is fail", task.getException());
                            Toast.makeText(AuthClass.this, "account creation failed", Toast.LENGTH_LONG).show();
                            updateUI(null);

                        }
                    }
                });
    }

    private boolean validateForm(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        updateUI(firebaseUser);
    }


    private void updateUI(FirebaseUser user) {
        if(user != null){
            Intent intent = new Intent(AuthClass.this, MainActivity.class);
            startActivity(intent);
            finish();

        }else{
            binding.editEmail.setVisibility(View.VISIBLE);
            binding.editPassword.setVisibility(View.VISIBLE);
        }
    }
}

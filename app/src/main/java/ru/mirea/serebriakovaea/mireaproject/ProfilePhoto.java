package ru.mirea.serebriakovaea.mireaproject;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class ProfilePhoto extends Activity {

    private ImageView profilePhoto;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);
        profilePhoto = findViewById(R.id.imageViewProfilePhoto);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String uri = bundle.getString("imageUri");
            Log.d(getClass().getSimpleName(), "string uri" + uri);
            Uri imageUri = Uri.parse(uri);
            profilePhoto.setImageURI(imageUri);


        }

    }
}

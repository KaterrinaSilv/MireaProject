package ru.mirea.serebriakovaea.mireaproject.workdata;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.room.Entity;

import ru.mirea.serebriakovaea.mireaproject.App;
import ru.mirea.serebriakovaea.mireaproject.MainActivity;
import ru.mirea.serebriakovaea.mireaproject.R;

public class WorkDataForm extends AppCompatActivity {

    EditText edit_name;
    EditText edit_tel;
    EditText edit_email;

    String name;
    String tel;
    String email;

    Button save;
    int i = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_data_form);

        AppDatabase db = App.getInstance().getDatabase();
        ClientDao clientDao = db.clientDao;

        edit_name = findViewById(R.id.edit_name_data);
        edit_tel = findViewById(R.id.edit_telephone_data);
        edit_email = findViewById(R.id.edit_email_data);

        save = findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edit_name.getText().toString();
                tel = edit_tel.getText().toString();
                email = edit_email.getText().toString();

                Client client = new Client();
                client.id = i;
                client.name = name;
                client.telephone = tel;
                client.email = email;

                clientDao.insert(client);

                Toast toast = Toast.makeText(getApplicationContext(), "Данные сохранены", Toast.LENGTH_LONG);
                toast.show();
                Log.d(getClass().getSimpleName(), "id" + i + " name " + name + " phone " + tel + " email " + email);

                Intent intent = new Intent(WorkDataForm.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}

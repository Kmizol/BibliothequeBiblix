package com.example.millet.gestionbiblix.view;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import com.example.millet.gestionbiblix.R;
import com.example.millet.gestionbiblix.modele.BackgroundWorks;



public class LoginActivity extends AppCompatActivity {

    EditText tName, tPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tName = findViewById(R.id.TxtName);
        tPassword = findViewById(R.id.TxtPassword);
    }

    public void OnLogin(View view) {
        String user_name = tName.getText().toString();
        String password = tPassword.getText().toString();
        String type = "login";
        BackgroundWorks backgroundWorks = new BackgroundWorks(this);
        backgroundWorks.execute(type, user_name, password);
    }
}

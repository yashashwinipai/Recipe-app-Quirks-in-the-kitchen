package com.example.quirksinthekitchen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signUpButton;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        usernameEditText = findViewById(R.id.editPersonName);
        passwordEditText = findViewById(R.id.editPassword);
        signUpButton = findViewById(R.id.button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signUp();
            }
        });
    }
    private void signUp() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
if (!username.isEmpty() || !password.isEmpty()) {


    // Store the credentials using shared preferences
    storeCredentials(username, password);

    Toast.makeText(this, "signup successful", Toast.LENGTH_SHORT).show();

    Intent intent = new Intent(signup.this, popup.class);
    startActivity(intent);
}
else{
    Toast.makeText(this, "please eneter the details", Toast.LENGTH_SHORT).show();
}
    }
    private void storeCredentials(String username, String password) {
        // Store the credentials using shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }
    public void Meow(View view){
        Intent intent = new Intent(signup.this, LoginActivity.class);
        startActivity(intent);
    }
}
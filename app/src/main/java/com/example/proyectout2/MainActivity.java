package com.example.proyectout2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsuario;
    EditText editTextEmail;
    EditText editTextContraseña;
    CheckBox checkBoxTerminosYCondiciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextUsuario = findViewById(R.id.editText_Usuario);
        editTextContraseña = findViewById(R.id.editText_Contraseña);
        editTextEmail = findViewById(R.id.editText_CorreoElectronico);
        checkBoxTerminosYCondiciones = findViewById(R.id.checkBox_TerminosYPrivacidad);
    }

    public void iniciarApp(View view){
        String email = editTextEmail.getText().toString();
        String contraseña = editTextContraseña.getText().toString();
        String usuario = editTextUsuario.getText().toString();
        boolean checkBoxActivado = checkBoxTerminosYCondiciones.isChecked();

        if(email.isEmpty() && contraseña.isEmpty() && usuario.isEmpty() && !checkBoxActivado){
            Toast.makeText(this, "Tienes que rellenar estos campos y aceptar las condiciones", Toast.LENGTH_SHORT).show();
        }else {
            if(email.isEmpty()){
                Toast.makeText(this, "Introduzca su correo electrónico", Toast.LENGTH_SHORT).show();
            }else if (contraseña.isEmpty()){
                Toast.makeText(this, "Introduzca su contraseña", Toast.LENGTH_SHORT).show();
            }else if (usuario.isEmpty()){
                Toast.makeText(this, "Introduzca su nombre de usuario", Toast.LENGTH_SHORT).show();
            }else if (!checkBoxActivado){
                Toast.makeText(this, "Debes aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
            }else{
                Intent i = new Intent(MainActivity.this, Inicio.class);
                startActivity(i);
            }
        }
    }
}
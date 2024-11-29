package com.example.proyectout2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GestionarEquipos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gestionar_equipos);

        Toolbar toolbar = findViewById(R.id.toolbar_gestion_equipos);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void volverPantallaPrincipal(View view){
        Intent i = new Intent(GestionarEquipos.this, Inicio.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.gestion_jugadores){
            Intent intentJugadores = new Intent(this, GestionJugadores.class);
            startActivity(intentJugadores);
            return true;
        }else if(item.getItemId()==R.id.clasificacion){
            Intent intentClasificacion = new Intent(this, ClasificacionEquipos.class);
            startActivity(intentClasificacion);
            return true;
        }else if(item.getItemId()==R.id.simular_partidos) {
            Intent intentSimularPartidos = new Intent(this, SimularPartidos.class);
            startActivity(intentSimularPartidos);
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }
}
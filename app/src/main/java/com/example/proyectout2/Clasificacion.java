package com.example.proyectout2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Clasificacion extends AppCompatActivity {

    EditText editTextNombreEquipo;
    EditText editTextPosicionEquipo;
    EditText editTextPuntosEquipo;
    ListView clasificacion;
    ArrayList<String> clasificacionEquipos;
    ArrayAdapter<String> adaptadorClasificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gestion_clasificacion);

        editTextNombreEquipo = findViewById(R.id.editText_NombreEquipo);
        editTextPosicionEquipo = findViewById(R.id.editText_PosicionEquipo);
        editTextPuntosEquipo = findViewById(R.id.editText_PuntosEquipo);
        clasificacion = findViewById(R.id.ListView_Clasificacion);

        cargarClasificacion();

        clasificacionEquipos = new ArrayList<>();
        adaptadorClasificacion = new ArrayAdapter<>(this, R.layout.item_clasificacion, R.id.textView_ClasificacionEquipo, clasificacionEquipos);
        clasificacion.setAdapter(adaptadorClasificacion);
        clasificacion.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        Toolbar toolbar = findViewById(R.id.toolbar_clasificacion);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void cargarClasificacion(){
        clasificacionEquipos.add("1º  FC Barcelona - 88");
        clasificacionEquipos.add("2º  Real Madrid - 85");
        clasificacionEquipos.add("3º  Liverpool - 80");
        clasificacionEquipos.add("4º  Bayern Múnich - 76");
        clasificacionEquipos.add("5º  Manchester City - 73");
        clasificacionEquipos.add("6º  Atlético de Madrid - 68");
        clasificacionEquipos.add("7º  AC Milan - 64");
        clasificacionEquipos.add("8º  Inter de Milán - 58");
        clasificacionEquipos.add("9º  Bayer Leverkusen - 55");
        clasificacionEquipos.add("10º  Borussia Dortmund - 47");

    }

    public void volverPantallaPrincipal(View view){
        Intent i = new Intent(Clasificacion.this, Inicio.class);
        startActivity(i);
    }

    public void añadirEquipoClasificacion(View view){
        String nombreEquipo = editTextNombreEquipo.getText().toString();
        String posicion = editTextPosicionEquipo.getText().toString();
        String puntos = editTextPuntosEquipo.getText().toString();

        if(!nombreEquipo.isEmpty() && !posicion.isEmpty() && !puntos.isEmpty()){
            String nuevoEquipo = String.format("%sº %s - %s", posicion, nombreEquipo, puntos);

            if(clasificacionEquipos.contains(nuevoEquipo)){
                clasificacionEquipos.add(nuevoEquipo);
                adaptadorClasificacion.notifyDataSetChanged();
                editTextPuntosEquipo.setText("");
                editTextNombreEquipo.setText("");
                editTextPosicionEquipo.setText("");
                Toast.makeText(this, "Clasificación actualizada", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "El equipo está en la clasificación", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Completa todos los campos para añadir un equipo a la clasificación", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarEquipoClasificacion(View view){
       int indice = clasificacion.getCheckedItemPosition();

       if(indice != ListView.INVALID_POSITION){
           clasificacionEquipos.remove(indice);
           adaptadorClasificacion.notifyDataSetChanged();
           editTextPuntosEquipo.setText("");
           editTextNombreEquipo.setText("");
           editTextPosicionEquipo.setText("");
           Toast.makeText(this, "Equipo eliminado de la clasificación", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(this, "Selecciona un equipo para eliminarlo de la clasificación", Toast.LENGTH_SHORT).show();
       }
    }

    public void editarEquipoClasificacion(View view){
        String nombreEquipo = editTextNombreEquipo.getText().toString();
        String posicion = editTextPosicionEquipo.getText().toString();
        String puntos = editTextPuntosEquipo.getText().toString();

        if(!nombreEquipo.isEmpty() && !posicion.isEmpty() && !puntos.isEmpty()){
           int indice = clasificacion.getCheckedItemPosition();
           if(indice != ListView.INVALID_POSITION){
               String equipoEditado = String.format("%sº %s - %s", posicion, nombreEquipo, puntos);
               clasificacionEquipos.set(indice, equipoEditado);
               adaptadorClasificacion.notifyDataSetChanged();
               editTextPuntosEquipo.setText("");
               editTextNombreEquipo.setText("");
               editTextPosicionEquipo.setText("");
               Toast.makeText(this, "Equipo editado en la clasificación correctamente", Toast.LENGTH_SHORT).show();
           }else{
               Toast.makeText(this, "Selecciona un equipo para editarlo de la clasificación", Toast.LENGTH_SHORT).show();
           }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.gestion_equipos){
            Intent intentJugadores = new Intent(this, GestionarEquipos.class);
            startActivity(intentJugadores);
            return true;
        }else if(item.getItemId()==R.id.gestion_jugadores){
            Intent intentJugadores = new Intent(this, GestionJugadores.class);
            startActivity(intentJugadores);
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }
}
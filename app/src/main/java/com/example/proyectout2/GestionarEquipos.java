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

public class GestionarEquipos extends AppCompatActivity {

    EditText editTextNombreEquipo;
    EditText editTextPaisEquipo;
    ListView listaEquipos;
    ArrayList<String> equipos;
    ArrayList<String> paises;
    ArrayList<String> listaCompleta;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gestionar_equipos);

        editTextNombreEquipo = findViewById(R.id.editTextNombreEquipo);
        editTextPaisEquipo = findViewById(R.id.editTextPais);
        listaEquipos = findViewById(R.id.ListView_listaEquipos);

        Toolbar toolbar = findViewById(R.id.toolbar_gestion_equipos);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        equipos = new ArrayList<>();
        paises = new ArrayList<>();

        cargarEquipos();

        listaCompleta = new ArrayList<>();

        for(int i=0; i<equipos.size(); i++){
            String linea = String.format("%-38s %s", equipos.get(i), paises.get(i));
            listaCompleta.add(linea);
        }

        adaptador = new ArrayAdapter<>(this, R.layout.item_equipos_lista, R.id.textView_NombreEquipo, listaCompleta);

        listaEquipos.setAdapter(adaptador);
        listaEquipos.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listaEquipos.setOnItemClickListener((parent, view, position, id) -> {
            String equipoSeleccionado = equipos.get(position);
            String paisSeleccionado = paises.get(position);

            editTextNombreEquipo.setText(equipoSeleccionado);
            editTextPaisEquipo.setText(paisSeleccionado);
        });

    }

    public void volverPantallaPrincipal(View view){
        Intent i = new Intent(GestionarEquipos.this, Inicio.class);
        startActivity(i);
    }

    public void cargarEquipos(){
        equipos.add("FC Barcelona");
        paises.add("España");

        equipos.add("Real Madrid");
        paises.add("España");

        equipos.add("Liverpool");
        paises.add("Inglaterra");

        equipos.add("AC Milan");
        paises.add("Italia");

        equipos.add("Bayern Múnich");
        paises.add("Alemania");

        equipos.add("Borussia Dortmund");
        paises.add("Alemania");

        equipos.add("Manchester City");
        paises.add("Inglaterra");

        equipos.add("Inter de Milán");
        paises.add("Italia");

        equipos.add("Bayer Leverkusen");
        paises.add("Alemania");

        equipos.add("Atlético de Madrid");
        paises.add("España");
    }

    public void editarEquipo(View view){
        String equipo = editTextNombreEquipo.getText().toString();
        String pais = editTextPaisEquipo.getText().toString();

        if(!equipo.isEmpty() && !pais.isEmpty()){
            int indice = listaEquipos.getCheckedItemPosition();

            if(indice != ListView.INVALID_POSITION){
                equipos.set(indice, equipo);
                paises.set(indice, pais);

                listaCompleta.set(indice, String.format("%-38s %s", equipos.get(indice), paises.get(indice)));

                editTextPaisEquipo.setText("");
                editTextNombreEquipo.setText("");

                adaptador.notifyDataSetChanged();
                Toast.makeText(this, "Equipo editado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Selecciona un equipo para editarlo", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Campos vacios, selecciona algún equipo", Toast.LENGTH_SHORT).show();
        }
    }

    public void añadirEquipo(View view){
        String equipo = editTextNombreEquipo.getText().toString();
        String pais = editTextPaisEquipo.getText().toString();

        if(!equipo.isEmpty() && !pais.isEmpty()){
            boolean existe = false;

            for(int i=0; i<equipos.size(); i++){
                if(equipos.get(i).equalsIgnoreCase(equipo) && paises.get(i).equalsIgnoreCase(pais)) {
                    existe = true;
                }
            }
            if(existe){
                Toast.makeText(this, "El equipo ya existe. Introduzca uno diferente", Toast.LENGTH_SHORT).show();
            }else{
                equipos.add(equipo);
                paises.add(pais);
                listaCompleta.add(String.format("%-38s %s", equipo, pais));
                editTextPaisEquipo.setText("");
                editTextNombreEquipo.setText("");
                adaptador.notifyDataSetChanged();
                Toast.makeText(this, "Equipo añadido correctamente", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Completa los 2 campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarEquipo(View view){
        String equipo = editTextNombreEquipo.getText().toString();
        String pais = editTextPaisEquipo.getText().toString();

        if(!equipo.isEmpty() && !pais.isEmpty()){
            int indice = listaEquipos.getCheckedItemPosition();

            if(indice != ListView.INVALID_POSITION){
                if(equipos.get(indice).equalsIgnoreCase(equipo) && paises.get(indice).equalsIgnoreCase(pais)){
                    equipos.remove(indice);
                    paises.remove(indice);
                    listaCompleta.remove(indice);
                    editTextPaisEquipo.setText("");
                    editTextNombreEquipo.setText("");
                    adaptador.notifyDataSetChanged();
                    Toast.makeText(this, "Equipo eliminado correctamente", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Selecciona un equipo para eliminarlo", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Selecciona un equipo para eliminarlo", Toast.LENGTH_SHORT).show();
        }

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
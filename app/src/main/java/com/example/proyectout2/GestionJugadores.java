package com.example.proyectout2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class GestionJugadores extends AppCompatActivity {

    ArrayList<String> jugadores = new ArrayList<>();
    ArrayAdapter<String> adaptadorJugadores;

    ArrayList<String> jugadoresBarcelona = new ArrayList<>();
    ArrayList<String> jugadoresRealMadrid = new ArrayList<>();
    ArrayList<String> jugadoresLiverpool = new ArrayList<>();
    ArrayList<String> jugadoresCity = new ArrayList<>();
    ArrayList<String> jugadoresBayern = new ArrayList<>();
    ArrayList<String> jugadoresAtletico = new ArrayList<>();
    ArrayList<String> jugadoresDortmund = new ArrayList<>();
    ArrayList<String> jugadoresInter = new ArrayList<>();
    ArrayList<String> jugadoresMilan = new ArrayList<>();
    ArrayList<String> jugadoresLeverkusen = new ArrayList<>();
    ImageButton btnBarcelona;
    ImageButton btnRealMadrid;
    ImageButton btnAtleticoMadrid;
    ImageButton btnBayern;
    ImageButton btnLiverpool;
    ImageButton btnCity;
    ImageButton btnInter;
    ImageButton btnMilan;
    ImageButton btnDortmund;
    ImageButton btnLeverkusen;
    EditText editTextNombre;
    EditText editTextDorsal;
    EditText editTextPosicion;
    ListView listaJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gestion_jugadores);

        editTextDorsal = findViewById(R.id.editTextDorsal);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextPosicion = findViewById(R.id.editTextPosicion);

        Toolbar toolbar = findViewById(R.id.toolbar_gestion_jugadores);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cargarJugadores();

        listaJugadores = findViewById(R.id.listViewJugadores);
        adaptadorJugadores = new ArrayAdapter<>(this, R.layout.item_jugadores, R.id.textView_jugador, jugadores);
        listaJugadores.setAdapter(adaptadorJugadores);
        listaJugadores.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listaJugadores.setOnItemClickListener((parent, view, position, id) ->{
            String jugadorSeleccionado = jugadores.get(position);
            String [] partes = jugadorSeleccionado.split(" - Dorsal: | - Posición: ");
            editTextNombre.setText(partes[0]);
            editTextDorsal.setText(partes[1]);
            editTextPosicion.setText(partes[2]);
        });

        btnBarcelona = findViewById(R.id.imageButton_Barcelona);
        btnRealMadrid = findViewById(R.id.imageButton_RealMadrid);
        btnBayern = findViewById(R.id.imageButton_Bayern);
        btnCity = findViewById(R.id.imageButton_City);
        btnAtleticoMadrid = findViewById(R.id.imageButton_Atleti);
        btnLiverpool = findViewById(R.id.imageButton_Liverpool);
        btnDortmund = findViewById(R.id.imageButton_Dortmund);
        btnInter = findViewById(R.id.imageButton_Inter);
        btnLeverkusen = findViewById(R.id.imageButton_Leverkusen);
        btnMilan = findViewById(R.id.imageButton_Milan);

        btnAtleticoMadrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresAtletico);
            }
        });

        btnBayern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresBayern);
            }
        });

        btnBarcelona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresBarcelona);
            }
        });

        btnRealMadrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresRealMadrid);
            }
        });

        btnMilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresMilan);
            }
        });

        btnInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresInter);
            }
        });

        btnCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresCity);
            }
        });

        btnLiverpool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresLiverpool);
            }
        });

        btnLeverkusen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresLeverkusen);
            }
        });

        btnDortmund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarJugadores(jugadoresDortmund);
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle datos) {
        datos.putStringArrayList("jugadores",jugadores);
        super.onSaveInstanceState(datos);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle datos) {

        ArrayList<String> jugadores=datos.getStringArrayList("jugadores");
       mostrarJugadores(jugadores);
        super.onRestoreInstanceState(datos);

    }

    public void cargarJugadores(){
        jugadoresBarcelona.add("Lewandowski - Dorsal: 9 - Posición: DC");
        jugadoresBarcelona.add("Lamine Yamal - Dorsal: 19 - Posición: EI");
        jugadoresBarcelona.add("Raphinha - Dorsal: 11 - Posición: ED");
        jugadoresBarcelona.add("Pedri - Dorsal: 8 - Posición: MC");
        jugadoresBarcelona.add("Cubarsí - Dorsal: 2 - Posición: DFC");
        jugadoresBarcelona.add("Casadó - Dorsal: 17 - Posición: MC");
        jugadoresBarcelona.add("Koundé - Dorsal: 23 - Posición: DFC");

        jugadoresRealMadrid.add("Mbappé - Dorsal: 9 - Posición: DC");
        jugadoresRealMadrid.add("Vinicius JR - Dorsal: 11 - Posición: EI");
        jugadoresRealMadrid.add("Bellingham - Dorsal: 5 - Posición: MC");
        jugadoresRealMadrid.add("Modric - Dorsal: 10 - Posición: MC");
        jugadoresRealMadrid.add("Courtois - Dorsal: 1 - Posición: POR");
        jugadoresRealMadrid.add("Carvajal - Dorsal: 2 - Posición: DFC");
        jugadoresRealMadrid.add("Camavinga - Dorsal: 6 - Posición: MC");

        jugadoresAtletico.add("Griezmann - Dorsal: 7 - Posición: DC");
        jugadoresAtletico.add("Julián Álvarez - Dorsal: 9 - Posición: DC");
        jugadoresAtletico.add("Marcos Llorente - Dorsal: 14 - Posición: MC");
        jugadoresAtletico.add("Samuel Lino - Dorsal: 12 - Posición: MC");
        jugadoresAtletico.add("De Paul - Dorsal: 5 - Posición: MC");
        jugadoresAtletico.add("Reinildo - Dorsal: 23 - Posición: DFC");
        jugadoresAtletico.add("Giuliano - Dorsal: 22 - Posición: ED");

        jugadoresLiverpool.add("Salah - Dorsal: 11 - Posición: EI");
        jugadoresLiverpool.add("Van Dijk - Dorsal: 4 - Posición: DFC");
        jugadoresLiverpool.add("Mac Allister - Dorsal: 10 - Posición: MC");
        jugadoresLiverpool.add("Allison - Dorsal: 1 - Posición: POR");
        jugadoresLiverpool.add("Bradley - Dorsal: 84 - Posición: LD");
        jugadoresLiverpool.add("Gakpo - Dorsal: 18 - Posición: EI");
        jugadoresLiverpool.add("Konaté - Dorsal: 5 - Posición: DFC");

        jugadoresCity.add("De Bruyne - Dorsal: 17 - Posición: MCO");
        jugadoresCity.add("Haaland - Dorsal: 9 - Posición: DC");
        jugadoresCity.add("Walker - Dorsal: 2 - Posición: DFC");
        jugadoresCity.add("Rodri - Dorsal: 16 - Posición: MCD");
        jugadoresCity.add("Bernardo Silva - Dorsal: 20 - Posición: MC");
        jugadoresCity.add("Foden - Dorsal: 47 - Posición: EI");
        jugadoresCity.add("Gundogan - Dorsal: 19 - Posición: MC");

        jugadoresBayern.add("Musiala - Dorsal: 42 - Posición: MCO");
        jugadoresBayern.add("Harry Kane - Dorsal: 9 - Posición: DC");
        jugadoresBayern.add("Davies - Dorsal: 19 - Posición: LI");
        jugadoresBayern.add("Kimmich - Dorsal: 6 - Posición: MCD");
        jugadoresBayern.add("Sane - Dorsal: 10 - Posición: ED");
        jugadoresBayern.add("Neuer - Dorsal: 1 - Posición: POR");
        jugadoresBayern.add("Upamecano - Dorsal: 2 - Posición: DFC");

        jugadoresLeverkusen.add("Grimaldo - Dorsal: 20 - Posición: LI");
        jugadoresLeverkusen.add("Wirtz - Dorsal: 10 - Posición: MCO");
        jugadoresLeverkusen.add("Frimpong - Dorsal: 30 - Posición: LD");
        jugadoresLeverkusen.add("Tah - Dorsal: 4 - Posición: DFC");
        jugadoresLeverkusen.add("Xhaka - Dorsal: 34 - Posición: MC");
        jugadoresLeverkusen.add("Boniface - Dorsal: 22 - Posición: DC");
        jugadoresLeverkusen.add("Schick - Dorsal: 14 - Posición: DC");

        jugadoresMilan.add("Rafael Leao - Dorsal: 10 - Posición: EI");
        jugadoresMilan.add("Morata - Dorsal: 7 - Posición: DC");
        jugadoresMilan.add("Pulisic - Dorsal: 11 - Posición: ED");
        jugadoresMilan.add("Reijnders - Dorsal: 14 - Posición: MC");
        jugadoresMilan.add("Theo Hernández - Dorsal: 19 - Posición: LI");
        jugadoresMilan.add("Tomori - Dorsal: 23 - Posición: DFC");
        jugadoresMilan.add("Maignan - Dorsal: 16 - Posición: POR");

        jugadoresInter.add("Lautaro - Dorsal: 10 - Posición: DC");
        jugadoresInter.add("Barella - Dorsal: 23 - Posición: MC");
        jugadoresInter.add("Thuram - Dorsal: 9 - Posición: DC");
        jugadoresInter.add("Calhanoglu - Dorsal: 20 - Posición: MC");
        jugadoresInter.add("Dumfries - Dorsal: 2 - Posición: LD");
        jugadoresInter.add("Darmian - Dorsal: 36 - Posición: DFC");
        jugadoresInter.add("DiMarco - Dorsal: 32 - Posición: LI");

        jugadoresDortmund.add("Brandt - Dorsal: 10 - Posición: MCO");
        jugadoresDortmund.add("Guirassy - Dorsal: 9 - Posición: DC");
        jugadoresDortmund.add("Malen - Dorsal: 21 - Posición: DC");
        jugadoresDortmund.add("Nmecha - Dorsal: 8 - Posición: MC");
        jugadoresDortmund.add("Sule - Dorsal: 25 - Posición: DFC");
        jugadoresDortmund.add("Schlotterbeck - Dorsal: 4 - Posición: DFC");
        jugadoresDortmund.add("Sabitzer - Dorsal: 20 - Posición: MC");
    }

    public void mostrarJugadores(ArrayList<String> jugadoresEquipo){
        jugadores.clear();
        jugadores.addAll(jugadoresEquipo);
        adaptadorJugadores.notifyDataSetChanged();
    }

    public void volverPantallaPrincipal(View view){
        Intent i = new Intent(GestionJugadores.this, Inicio.class);
        startActivity(i);
    }

    public void añadirJugador(View view){
        String nombre = editTextNombre.getText().toString();
        String dorsal = editTextDorsal.getText().toString();
        String posicion = editTextPosicion.getText().toString();

        if(!nombre.isEmpty() && !dorsal.isEmpty() && !posicion.isEmpty()) {
            String nuevoJugador = String.format("%s - Dorsal: %s - Posición: %s", nombre, dorsal, posicion);

            if (!jugadores.contains(nuevoJugador)) {
                jugadores.add(nuevoJugador);
                adaptadorJugadores.notifyDataSetChanged();
                editTextDorsal.setText("");
                editTextPosicion.setText("");
                editTextNombre.setText("");
                Toast.makeText(this, "Jugador añadido correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El jugador ya existe en la lista", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Completa todos los campos para añadir un nuevo jugador", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminarJugador(View view){
        String nombre = editTextNombre.getText().toString();
        String dorsal = editTextDorsal.getText().toString();
        String posicion = editTextPosicion.getText().toString();

        if(!nombre.isEmpty() && !dorsal.isEmpty() && !posicion.isEmpty()) {
            int indice = listaJugadores.getCheckedItemPosition();
            if (indice != ListView.INVALID_POSITION) {
                jugadores.remove(indice);
                adaptadorJugadores.notifyDataSetChanged();
                editTextDorsal.setText("");
                editTextPosicion.setText("");
                editTextNombre.setText("");
                Toast.makeText(this, "Jugador eliminado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Selecciona cualquier jugador para eliminarlo", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Selecciona un jugador para poder eliminarlo", Toast.LENGTH_SHORT).show();
        }
    }

    public void editarJugador(View view){
        String nombre = editTextNombre.getText().toString();
        String dorsal = editTextDorsal.getText().toString();
        String posicion = editTextPosicion.getText().toString();

        if(!nombre.isEmpty() && !dorsal.isEmpty() && !posicion.isEmpty()) {
            int indice = listaJugadores.getCheckedItemPosition();
            if (indice != ListView.INVALID_POSITION) {

                jugadores.set(indice, String.format("%s - Dorsal: %s - Posición: %s", nombre, dorsal, posicion));
                adaptadorJugadores.notifyDataSetChanged();
                editTextDorsal.setText("");
                editTextPosicion.setText("");
                editTextNombre.setText("");
                Toast.makeText(this, "Jugador editado correctamente", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Selecciona un jugador para editarlo", Toast.LENGTH_SHORT).show();
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
        }else if(item.getItemId()==R.id.clasificacion){
            Intent intentClasificacion = new Intent(this, Clasificacion.class);
            startActivity(intentClasificacion);
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }
}
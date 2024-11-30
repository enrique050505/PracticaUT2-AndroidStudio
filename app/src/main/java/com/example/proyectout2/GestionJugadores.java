package com.example.proyectout2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gestion_jugadores);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listaJugadores = findViewById(R.id.listViewJugadores);
        adaptadorJugadores = new ArrayAdapter<>(this, R.layout.item_jugadores, R.id.textView_jugador, jugadores);
        listaJugadores.setAdapter(adaptadorJugadores);
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
        jugadoresAtletico.add("Van Dijk - Dorsal: 4 - Posición: DFC");
        jugadoresAtletico.add("Mac Allister - Dorsal: 10 - Posición: MC");
        jugadoresAtletico.add("Allison - Dorsal: 1 - Posición: POR");
        jugadoresAtletico.add("Bradley - Dorsal: 86 - Posición: LD");
        jugadoresAtletico.add("Gakpo - Dorsal: 18 - Posición: EI");
        jugadoresAtletico.add("Konaté - Dorsal: 5 - Posición: DFC");

        jugadoresCity.add("De Bruyne - Dorsal: 17 - Posición: MCO");
        jugadoresCity.add("Haaland - Dorsal: 9 - Posición: DC");
        jugadoresCity.add("Walker - Dorsal: 2 - Posición: DFC");
        jugadoresCity.add("Rodri - Dorsal: 16 - Posición: MCD");
        jugadoresCity.add("Bernardo Silva - Dorsal: 20 - Posición: MC");
        jugadoresCity.add("Foden - Dorsal: 47 - Posición: EI");
        jugadoresCity.add("Gundogan - Dorsal: 19 - Posición: MC");

        jugadoresBayern.add("De Bruyne - Dorsal: 17 - Posición: MCO");
        jugadoresBayern.add("Haaland - Dorsal: 9 - Posición: DC");
        jugadoresBayern.add("Walker - Dorsal: 2 - Posición: DFC");
        jugadoresBayern.add("Rodri - Dorsal: 16 - Posición: MCD");
        jugadoresBayern.add("Bernardo Silva - Dorsal: 20 - Posición: MC");
        jugadoresBayern.add("Foden - Dorsal: 47 - Posición: EI");
        jugadoresBayern.add("Gundogan - Dorsal: 19 - Posición: MC");

        jugadoresCity.add("De Bruyne - Dorsal: 17 - Posición: MCO");
        jugadoresCity.add("Haaland - Dorsal: 9 - Posición: DC");
        jugadoresCity.add("Walker - Dorsal: 2 - Posición: DFC");
        jugadoresCity.add("Rodri - Dorsal: 16 - Posición: MCD");
        jugadoresCity.add("Bernardo Silva - Dorsal: 20 - Posición: MC");
        jugadoresCity.add("Foden - Dorsal: 47 - Posición: EI");
        jugadoresCity.add("Gundogan - Dorsal: 19 - Posición: MC");

        jugadoresCity.add("De Bruyne - Dorsal: 17 - Posición: MCO");
        jugadoresCity.add("Haaland - Dorsal: 9 - Posición: DC");
        jugadoresCity.add("Walker - Dorsal: 2 - Posición: DFC");
        jugadoresCity.add("Rodri - Dorsal: 16 - Posición: MCD");
        jugadoresCity.add("Bernardo Silva - Dorsal: 20 - Posición: MC");
        jugadoresCity.add("Foden - Dorsal: 47 - Posición: EI");
        jugadoresCity.add("Gundogan - Dorsal: 19 - Posición: MC");
    }
}
package fr.r4a11_tp2_initdeboggage;

import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "TP2"; // Tag pour les logcats
    public static final String[] DAYS_OF_WEEK = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};


    private TextView day_textview;
    private Button next_day_button;

    private String current_day_name;
    private static int current_day_index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * On relie l'activité au layout /res/layout/activity_main.xml
         * On parle de désérialisation du layout
         */
        setContentView(R.layout.activity_main);

        Log.i(MainActivity.TAG, "La layout a été désérialisé");

        /**
         * Désérialisation des composants graphiques XML
         *
         * On transforme la description XML de chaque composant graphique
         * en objet Java
         */

        /*
         * TextView ayant pour android:id="@+id/tv_day" est transformé en objet Java
         */
        this.day_textview = this.findViewById(R.id.tv_day);
        Log.i(MainActivity.TAG, "Le champ de texte a été désérialisé");

        /*
         * Bouton ayant pour android:id="@+id/bt_next_day" est transformé en objet Java
         */
        this.next_day_button = this.findViewById(R.id.bt_next_day);
        Log.i(MainActivity.TAG, "Le bouton a été désérialisé");


        /*
         * On rajoute un gestionnaire d'évènement au bouton
         */
        this.next_day_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(MainActivity.TAG, "Affichage du prochain jour");
                MainActivity.this.calculate_next_day();
                MainActivity.this.display();

            }
        });
        Log.i(MainActivity.TAG, "Le gestionnaire d'évènements a été installé sur le bouton");

    }

    private void calculate_next_day() {
        this.current_day_name = MainActivity.DAYS_OF_WEEK[MainActivity.current_day_index];

        MainActivity.current_day_index++;

        Log.i(MainActivity.TAG, "Valeur jour courant " + this.current_day_name);

        if (MainActivity.current_day_index >= MainActivity.DAYS_OF_WEEK.length){
            MainActivity.current_day_index = 0;
    }

}

    private void display(){
        MainActivity.this.day_textview.setText(this.current_day_name);
    }
}
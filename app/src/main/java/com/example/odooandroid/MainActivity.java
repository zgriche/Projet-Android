package com.example.odooandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Assurez-vous de mettre le bon nom de fichier XML ici

        // Vous pouvez maintenant accéder aux vues déclarées dans le fichier XML
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        Button buttonFunctionality = findViewById(R.id.buttonFunctionality);
        ImageView imageViewWelcome = findViewById(R.id.imageView);

        // Vous pouvez ajouter des écouteurs d'événements aux boutons ou d'autres vues ici
        buttonFunctionality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code à exécuter lorsque le bouton est cliqué
                // Par exemple, vous pouvez ouvrir une nouvelle activité, afficher un message, etc.
                Intent acceder_app = new Intent(getApplicationContext(), search.class);
                startActivity(acceder_app);
                finish();
            }
        });
    }
}
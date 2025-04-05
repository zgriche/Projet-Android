package com.example.odooandroid;

import static com.example.odooandroid.R.id.rech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.odooandroid.HTTPRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class search_fournisseur extends Activity {
    private JSONArray jArray;
    private JSONObject json_data;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_fournisseur);

        EditText rech = findViewById(R.id.rech);
        Button left_button = findViewById(R.id.left_button);
        Button right_button = findViewById(R.id.right_button);

        findViewById(R.id.button).setOnClickListener(view -> {

            try {
                String adresse = "http://192.168.92.1:81/test/fournisseur.php?rech=" + rech.getText().toString();
                String response = new HTTPRequest.HTTPSELECTRequest().execute(adresse).get();
                Log.d("OdooAndroid", "Réponse : " + response); // Journaliser la réponse pour le débogage

                jArray = new JSONArray(response);

                if (jArray.length() > 0) {
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.name)).setText(json_data.getString("name"));
                    ((TextView) findViewById(R.id.function)).setText(json_data.getString("function"));
                    ((TextView) findViewById(R.id.street)).setText(json_data.getString("street"));
                    ((TextView) findViewById(R.id.city)).setText(json_data.getString("city"));
                    ((TextView) findViewById(R.id.email)).setText(json_data.getString("email"));
                    ((TextView) findViewById(R.id.phone)).setText(json_data.getString("phone"));

                } else {
                    Toast.makeText(getApplicationContext(), "Aucun partenaire trouvé", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Erreur de recherche", Toast.LENGTH_SHORT).show();
            }
        });

        // ... (code pour les boutons précédent et suivant)
        findViewById(R.id.button2).setOnClickListener(view -> {
            try {
                if (i > 0) {
                    i--;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.name)).setText(json_data.getString("name"));
                    ((TextView) findViewById(R.id.function)).setText(json_data.getString("function"));
                    ((TextView) findViewById(R.id.street)).setText(json_data.getString("street"));
                    ((TextView) findViewById(R.id.city)).setText(json_data.getString("city"));
                    ((TextView) findViewById(R.id.email)).setText(json_data.getString("email"));
                    ((TextView) findViewById(R.id.phone)).setText(json_data.getString("phone"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        findViewById(R.id.button3).setOnClickListener(view -> {
            try {
                if (i < jArray.length() - 1) {
                    i++;
                    json_data = jArray.getJSONObject(i);
                    ((TextView) findViewById(R.id.name)).setText(json_data.getString("name"));
                    ((TextView) findViewById(R.id.function)).setText(json_data.getString("function"));
                    ((TextView) findViewById(R.id.street)).setText(json_data.getString("street"));
                    ((TextView) findViewById(R.id.city)).setText(json_data.getString("city"));
                    ((TextView) findViewById(R.id.email)).setText(json_data.getString("email"));
                    ((TextView) findViewById(R.id.phone)).setText(json_data.getString("phone"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Vous pouvez ajouter des écouteurs d'événements aux boutons ou d'autres vues ici
        right_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code à exécuter lorsque le bouton est cliqué
                // Par exemple, vous pouvez ouvrir une nouvelle activité, afficher un message, etc.
                Intent acceder_partenaire2 = new Intent(getApplicationContext(), search.class);
                startActivity(acceder_partenaire2);
                finish();
            }
        });
        left_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent acceder_client2 = new Intent(getApplicationContext(), search_client.class);
                startActivity(acceder_client2);
                finish();
            }
        });
    }
}


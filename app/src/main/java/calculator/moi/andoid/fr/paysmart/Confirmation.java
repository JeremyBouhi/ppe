package calculator.moi.andoid.fr.paysmart;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by jerem on 11/04/2018.
 */

public class Confirmation extends AppCompatActivity {

    public static final String DATA_RECEIVE = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation);

        Button valider = (Button) findViewById(R.id.buttonValider);
        Button annuler = (Button) findViewById(R.id.buttonAnnuler);

        //String ch = getArguments().getString(DATA_RECEIVE);

        String ch;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                ch = null;
            } else {
                ch = extras.getString("data");
            }
        } else {
            ch = (String) savedInstanceState.getSerializable("data");
        }

        String[] parts = ch.split(" ");
        String montant = parts[0];
        String commerce = parts[1]; //= "La boulangerie 'La Duchesse'";

        TextView textConfirm = (TextView) findViewById(R.id.textConfirm);
        textConfirm.setText("Confirmez-vous la transaction de " + montant + " € à " + commerce + " ?");

        valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent(Confirmation.this, Validation.class);  //Lancer l'activité
                startActivity(intent);    //Afficher la vue
            }
        });

        annuler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent intent = new Intent(Confirmation.this, MenuDuTurfu.class);  //Lancer l'activité
                startActivity(intent);    //Afficher la vue
            }

        });
    }
}
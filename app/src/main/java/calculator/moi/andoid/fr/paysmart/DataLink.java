package calculator.moi.andoid.fr.paysmart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jerem on 11/04/2018.
 */

//Cette classe permet l'envoi des données de EcranPaiement à Confirmation

public class DataLink extends AppCompatActivity {

    //@TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_du_turfu);

        if (findViewById(R.id.container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new EcranPaiement()).commit();
        }
    }
/*
    @Override
    public void passData(String data) {
        Confirmation fragmentB = new Confirmation ();
        Bundle args = new Bundle();
        args.putString(Confirmation.DATA_RECEIVE, data);
        fragmentB .setArguments(args);

        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragmentB )
                .commit();
    }*/
}


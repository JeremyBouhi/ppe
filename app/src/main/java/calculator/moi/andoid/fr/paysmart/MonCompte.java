package calculator.moi.andoid.fr.paysmart;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * Created by jerem on 21/03/2018.
 */

public class MonCompte extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mon_compte);

        TextView solde = (TextView) findViewById(R.id.textView2);
        solde.setText("Solde Total");

        TextView varSolde = (TextView) findViewById(R.id.textView3);
        varSolde.setText("50€");
    }
}

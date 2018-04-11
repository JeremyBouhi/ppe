package calculator.moi.andoid.fr.paysmart;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by jerem on 11/04/2018.
 */

public class Confirmation extends Fragment {

    public static final String DATA_RECEIVE = "data";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.confirmation, container, false);

        String ch = getArguments().getString(DATA_RECEIVE);

        String[] parts = ch.split(" ");
        String montant = parts[0];
        String commerce= parts[1]; //= "La boulangerie 'La Duchesse'";


        TextView textConfirm = (TextView) view.findViewById(R.id.textConfirm);
        textConfirm.setText("Confirmez-vous la transaction de "+ montant + " € à " + commerce + " ?");

        return view;

    }
}

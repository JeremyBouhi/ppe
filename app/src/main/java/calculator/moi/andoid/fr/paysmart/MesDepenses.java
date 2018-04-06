package calculator.moi.andoid.fr.paysmart;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jerem on 26/03/2018.
 */

public class MesDepenses extends FragmentActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mon_compte);

        TextView dep = (TextView) findViewById(R.id.textViewDepenses);
        dep.setText("Coucou mes deppp");


    }
}



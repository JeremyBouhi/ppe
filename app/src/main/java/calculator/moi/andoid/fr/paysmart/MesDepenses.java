package calculator.moi.andoid.fr.paysmart;

<<<<<<< HEAD
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

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
=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MesDepenses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mes_depenses);
    }
}
>>>>>>> 27eeedbfe13ff78fe6aea042744a1729203d73a8

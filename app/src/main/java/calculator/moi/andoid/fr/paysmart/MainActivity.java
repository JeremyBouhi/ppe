package calculator.moi.andoid.fr.paysmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mail = (EditText) findViewById(R.id.editText);
        mail.setHint("Email");

        EditText mdp = (EditText) findViewById(R.id.editText2);
        mdp.setHint("Mot de passe");

        Button connexion = (Button) findViewById(R.id.button);
        connexion.setText("SE CONNECTER");
    }
}

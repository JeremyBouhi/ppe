package calculator.moi.andoid.fr.paysmart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by jerem on 21/03/2018.
 */

public class MenuFrag extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu, container, false);

        Button boutonCompte = (Button) view.findViewById(R.id.buttonCompte);
        boutonCompte.setText("Mon Compte");

        /*boutonCompte.setOnClickListener(new View.OnClickListener()      //Creation du listener sur ce bouton
        {
            public void onClick(View actuelView)    //au clic sur le bouton
            {
                Intent intent = new Intent(MenuFrag.this, MonCompte.class);  //Lancer l'activité DisplayVue
                startActivity(intent);    //Afficher la vue

            }});*/


                Button boutonDepense = (Button) view.findViewById(R.id.buttonDepense);
        boutonDepense.setText("Mes Dépenses");

        Button boutonPayer = (Button) view.findViewById(R.id.buttonPayer);
        boutonPayer.setText("Payer");

        return view;
    }


}

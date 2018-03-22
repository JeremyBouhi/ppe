package calculator.moi.andoid.fr.paysmart;

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

        Button button = (Button) view.findViewById(R.id.buttonCompte);
        return view;
    }


}

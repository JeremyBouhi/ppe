package calculator.moi.andoid.fr.paysmart;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by jerem on 21/03/2018.
 */

public class MonCompte extends Fragment {

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mon_compte, container, false);
        //ButterKnife.bind(this, view);
            return view;

    }
}

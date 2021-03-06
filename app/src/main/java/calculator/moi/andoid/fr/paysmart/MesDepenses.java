package calculator.moi.andoid.fr.paysmart;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

/**
 * Created by jerem on 26/03/2018.
 */

public class MesDepenses extends Fragment {

    PieChart graphe;
    int[] yData = {40,55,22,18,9}; //datas a recup dans la BDD
    String[] xData  = {"Alimentation","Transport","Restauration","Shopping","Loisir"};  //datas a recup dans la BDD

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mes_depenses, container, false);

        graphe = (PieChart) view.findViewById(R.id.IDgraphe);
        addDataSet();

        return view;
    }

    private void addDataSet(){
        //le conseil du jour : utiliser des log.d pour checker

        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length ; i++)
        {
            yEntrys.add(new PieEntry(yData[i], i));
        }

        for(int i = 1; i < xData.length ; i++)
        {
            xEntrys.add(xData[i]);
        }

        PieDataSet pieDataSet = new PieDataSet(yEntrys,"Catégorisation");
        pieDataSet.setSliceSpace(3); //espace entre les datas
        pieDataSet.setValueTextSize(13); //taille des datas
        pieDataSet.setValueTextColor(Color.WHITE); //taille des datas

        ArrayList<Integer> couleurs = new ArrayList<>();

        couleurs.add(Color.parseColor("#f49441"));
        couleurs.add(Color.parseColor("#00c5db"));
        couleurs.add(Color.parseColor("#00ba22"));
        couleurs.add(Color.parseColor("#a06b00"));
        couleurs.add(Color.parseColor("#f44141"));

        pieDataSet.setColors(couleurs);

        //pieDataSet.setDrawValues(false);
        //Legend legende = graphe.getLegend();
        //legende.setForm(Legend.LegendForm.CIRCLE);
        //legende.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //graphe.setDrawHoleEnabled(false); //pour enlever le trou du milieu

        graphe.getDescription().setEnabled(false);
        //on set les data au graphe
        PieData pieData =  new PieData(pieDataSet);
        graphe.setData(pieData);
        //graphe.setNoDataText("Aucune sortie d'argent pour le moment");
        graphe.setCenterText("144€");
        graphe.setCenterTextSize(30);
        graphe.invalidate();

    }
}

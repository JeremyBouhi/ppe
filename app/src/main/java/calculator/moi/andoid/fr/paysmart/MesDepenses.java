package calculator.moi.andoid.fr.paysmart;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

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

        graphe.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                int pos1 = e.toString().indexOf("y: ");
                String montant = e.toString().substring(pos1 + 3);

                for (int i = 0; i < yData.length; i++) {
                    if (yData[i] == Float.parseFloat(montant))
                    {
                        pos1 = i;
                        break;
                    }
                }

                String categorie = xData[pos1];
                Toast.makeText(getActivity(), categorie +": " + montant + "0€", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        return view;
    }

    private void addDataSet(){
        //le conseil du jour : utiliser des log.d pour checker


        Drawable[] icons = {
                ContextCompat.getDrawable(getActivity(), R.drawable.alim_icon),
                ContextCompat.getDrawable(getActivity(), R.drawable.transport_icon),
                ContextCompat.getDrawable(getActivity(), R.drawable.restau_icon),
                ContextCompat.getDrawable(getActivity(), R.drawable.shop_icon),
                ContextCompat.getDrawable(getActivity(), R.drawable.loisir_icon)
        };

        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length ; i++)
        {
            yEntrys.add(new PieEntry(yData[i], icons[i]));
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

        pieDataSet.setDrawValues(false);
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
        graphe.setHoleColor(Color.parseColor("#ffeede"));
        graphe.setCenterTextSize(40);
        graphe.invalidate();

    }
}

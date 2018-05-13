package calculator.moi.andoid.fr.paysmart;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import calculator.moi.andoid.fr.paysmart.Helpers.CheckNetworkStatus;
import calculator.moi.andoid.fr.paysmart.Helpers.HttpJsonParser;

/**
 * Created by jerem on 21/03/2018.
 */

public class MonCompte extends Fragment {

    private ArrayList<HashMap<String, String>> utilisateurList;
    private ListView utilisateurListView;
    private ProgressDialog pDialog;
    private static final String BASE_URL="https://paysmartppe.000webhostapp.com/?dir=Paysmart/";
    private static final String KEY_SUCCESS = "success";
    private static final String KEY_DATA = "data";
    private static final String EMAIL = "Email";
    private static final String NOM ="Nom";
    private static final String PRENOM = "Prenom";
    private static final String NOM_SOCIETE = "Nom_societe";
    private static final String VILLE = "Ville";
    private static final String CATEGORIE = "Categorie";
    private static final String MOT_DE_PASSE = "Mot_de_passe";
    private static final String CODE_PIN = "Code_PIN";
    private static final String RIB = "RIB";
    private static final String TELEPHONE = "Telephone";
    private static final String BUDGET_TOTAL = "Budget_total";


    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mon_compte, container, false);
        //ButterKnife.bind(this, view);
        //utilisateurListView = (ListView) view.findViewById(R.id.soldeListView);
        //new FetchUtilisateurAsyncTask().execute();
        TableLayout tableLayout = view.findViewById(R.id.compteListe);

        TableRow tablerow1 = new TableRow(getActivity());
        TableRow tablerow2 = new TableRow(getActivity());
        TableRow tablerow3 = new TableRow(getActivity());
        TableRow tablerow4 = new TableRow(getActivity());

        TextView cat1 = new TextView(getActivity());
        TextView montant1 = new TextView(getActivity());
        TextView cat2 = new TextView(getActivity());
        TextView montant2 = new TextView(getActivity());
        TextView cat3 = new TextView(getActivity());
        TextView montant3 = new TextView(getActivity());
        TextView cat4 = new TextView(getActivity());
        TextView montant4 = new TextView(getActivity());

        cat1.setText("Alimentation");
        montant1.setText("40€");
        cat2.setText("Transport");
        montant2.setText("30€");
        cat3.setText("Shopping");
        montant3.setText("25€");
        cat4.setText("Loisir");
        montant4.setText("20€");

        cat1.setTextAppearance(getActivity(),R.style.ListeCategoriesCompte);
        cat2.setTextAppearance(getActivity(),R.style.ListeCategoriesCompte);
        cat3.setTextAppearance(getActivity(),R.style.ListeCategoriesCompte);
        cat4.setTextAppearance(getActivity(),R.style.ListeCategoriesCompte);
        montant1.setTextAppearance(getActivity(),R.style.ListeCategoriesCompteMontant);
        montant2.setTextAppearance(getActivity(),R.style.ListeCategoriesCompteMontant);
        montant3.setTextAppearance(getActivity(),R.style.ListeCategoriesCompteMontant);
        montant4.setTextAppearance(getActivity(),R.style.ListeCategoriesCompteMontant);

        tablerow1.addView(cat1);
        tablerow1.addView(montant1);
        tablerow2.addView(cat2);
        tablerow2.addView(montant2);
        tablerow3.addView(cat3);
        tablerow3.addView(montant3);
        tablerow4.addView(cat4);
        tablerow4.addView(montant4);

        tablerow1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), MapDuTurfu.class);
                intent.putExtra("keyName","supermarket");
                startActivity(intent);
            }
        });
        tablerow2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), MapDuTurfu.class);
                intent.putExtra("keyName","subway_station");
                startActivity(intent);
            }
        });
        tablerow3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), MapDuTurfu.class);
                intent.putExtra("keyName","clothing_store");
                startActivity(intent);
            }
        });
        tablerow4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), MapDuTurfu.class);
                intent.putExtra("keyName","night_club");
                startActivity(intent);
            }
        });

        tableLayout.addView(tablerow1);
        tableLayout.addView(tablerow2);
        tableLayout.addView(tablerow3);
        tableLayout.addView(tablerow4);
        return view;

    }

    private class FetchUtilisateurAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Display progress bar
            if (CheckNetworkStatus.isNetworkAvailable(getActivity().getApplicationContext())) {
                pDialog = new ProgressDialog(getActivity());
                pDialog.setMessage("Loading. Please wait...");
                pDialog.setIndeterminate(false);
                pDialog.setCancelable(false);
                pDialog.show();
            }
            else {
                Toast.makeText(getActivity(),
                        "Unable to connect to internet",
                        Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            HttpJsonParser httpJsonParser = new HttpJsonParser();
            JSONObject jsonObject = httpJsonParser.makeHttpRequest(
                    BASE_URL + "fetch.php", "GET", null);
            if(jsonObject==null)
            {
                //Toast.makeText(getActivity(),"JSON",Toast.LENGTH_SHORT).show();
                Log.d("ERREUR", "JSoN m'a tuer: ");
                return "";
            }
            try {
                int success = jsonObject.getInt(KEY_SUCCESS);
                JSONArray utilisateurs;
                if (success == 1) {
                    utilisateurList = new ArrayList<>();
                    utilisateurs = jsonObject.getJSONArray(KEY_DATA);
                    //Iterate through the response and populate utilisateur list
                    for (int i = 0; i < utilisateurs.length(); i++) {
                        JSONObject utilisateur = utilisateurs.getJSONObject(i);
                        String utilisateurEmail = utilisateur.getString(EMAIL);
                        String utilisateurNom = utilisateur.getString(NOM);
                        String utilisateurPrenom = utilisateur.getString(PRENOM);
                        String utilisateurNomSociete = utilisateur.getString(NOM_SOCIETE);
                        String utilisateurVille = utilisateur.getString(VILLE);
                        String utilisateurCategorie = utilisateur.getString(CATEGORIE);
                        String utilisateurMDP = utilisateur.getString(MOT_DE_PASSE);
                        Integer utilisateurPIN = utilisateur.getInt(CODE_PIN);
                        Integer utilisateurRIB = utilisateur.getInt(RIB);
                        String utilisateurTelephone = utilisateur.getString(TELEPHONE);
                        Integer utilisateurBudget = utilisateur.getInt(BUDGET_TOTAL);

                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put(EMAIL, utilisateurEmail);
                        map.put(NOM, utilisateurNom);
                        map.put(PRENOM, utilisateurPrenom);
                        map.put(NOM_SOCIETE, utilisateurNomSociete);
                        map.put(VILLE, utilisateurVille);
                        map.put(CATEGORIE, utilisateurCategorie);
                        map.put(MOT_DE_PASSE, utilisateurMDP);
                        map.put(CODE_PIN, utilisateurPIN.toString());
                        map.put(RIB, utilisateurRIB.toString());
                        map.put(TELEPHONE, utilisateurTelephone);
                        map.put(BUDGET_TOTAL, utilisateurBudget.toString());
                        utilisateurList.add(map);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String result) {
            pDialog.dismiss();
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    populateUtilisateurList();
                }
            });
        }

    }

    /**
     * Updating parsed JSON data into ListView
     * */
    private void populateUtilisateurList() {
        ListAdapter adapter = new SimpleAdapter(
                getActivity(), utilisateurList,
                R.layout.list_item, new String[]{EMAIL,NOM,PRENOM,NOM_SOCIETE,VILLE,CATEGORIE,MOT_DE_PASSE,CODE_PIN,RIB,TELEPHONE,BUDGET_TOTAL},
                new int[]{R.id.utilisateurEmail, R.id.utilisateurNom, R.id.utilisateurPrenom, R.id.utilisateurNomdesociete, R.id.utilisateurVille, R.id.utilisateurCategorie, R.id.utilisateurMDP,
                        R.id.utilisateurPin, R.id.utilisateurRIB, R.id.utilisateurTelephone, R.id.utilisateurBudget});
        // updating listview
        utilisateurListView.setAdapter(adapter);
        //Call MovieUpdateDeleteActivity when a movie is clicked
        /*
        utilisateurListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Check for network connectivity
                if (CheckNetworkStatus.isNetworkAvailable(getActivity().getApplicationContext())) {
                    String utilisateurEmail = ((TextView) view.findViewById(R.id.utilisateurEmail))
                            .getText().toString();
                    Intent intent = new Intent(getActivity().getApplicationContext(),
                            MovieUpdateDeleteActivity.class);
                    intent.putExtra(KEY_MOVIE_ID, movieId);
                    startActivityForResult(intent, 20);

                } else {
                    Toast.makeText(utilisateurListingActivity.this,
                            "Unable to connect to internet",
                            Toast.LENGTH_LONG).show();

                }


            }
        });*/

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 20) {
            // If the result code is 20 that means that
            // the user has deleted/updated the movie.
            // So refresh the movie listing
            Intent intent = getActivity().getIntent();
            getActivity().finish();
            startActivity(intent);
        }
    }
}

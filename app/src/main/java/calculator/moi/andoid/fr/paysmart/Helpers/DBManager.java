package calculator.moi.andoid.fr.paysmart.Helpers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import calculator.moi.andoid.fr.paysmart.Modeles.Utilisateur;

public class DBManager extends AsyncTask <String,Void,Utilisateur[]> {
    InputStream is = null;
    String result = "";
    String link = "https://paysmart.000webhostapp.com/Paysmart/connexion.php";
    public Context context;

    public DBManager(Context context) {
        this.context = context;

    }

    @Override
    protected Utilisateur[] doInBackground(String... strings) {
        try {

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(link);

            //httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");

            }
            is.close();
            result = sb.toString();
            System.out.println("coucou" + result);
        } catch (Exception e) {
            Log.e("log_tag", "Error converting result " + e.toString());
        }
        // Parse les données JSON
        String returnString = null;
        try {
            JSONArray jArray = new JSONArray(result);
            Utilisateur[] user = new Utilisateur[jArray.length()];
            System.out.println(jArray.length());
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);

                user[i] = new Utilisateur();
                user[i].setEmail(json_data.getString("email"));
                user[i].setNom(json_data.getString("nom"));
                user[i].setPrenom(json_data.getString("prenom"));
                user[i].setNom_societe(json_data.getString("nom_societe"));
                user[i].setVille(json_data.getString("ville"));
                user[i].setCategorie(json_data.getString("categorie"));
                user[i].setMot_de_passe(json_data.getString("geocoding"));
                user[i].setCode_PIN(json_data.getInt("Code_PIN"));
                user[i].setRIB(json_data.getInt("RIB"));
                user[i].setTelephone(json_data.getString("telephone"));
                user[i].setBudget_total(json_data.getInt("budget_total"));


                returnString += "\n\t" + jArray.getJSONObject(i);


            }
            System.out.println("coucou2" + returnString);
            return user;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new Utilisateur[0];
    }
}
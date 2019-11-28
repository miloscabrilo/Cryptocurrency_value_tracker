package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private CoinArrayAdapter coinArrayAdapter;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = Volley.newRequestQueue(this);
        //coinArrayAdapter = new CoinArrayAdapter(getApplicationContext(), R.layout.listview_row_layout);
        /*listView = (ListView) findViewById(R.id.listView);
        listView.setFastScrollEnabled(true);
        coinArrayAdapter = new CoinArrayAdapter(getApplicationContext(), R.layout.listview_row_layout);
        listView.setAdapter(coinArrayAdapter);
        Coin btc = new Coin("dd", "ja", "ti");
        coinArrayAdapter.add(btc);
        TextView textView = (TextView) findViewById(R.id.coinName);
        TextView textView2 = (TextView) findViewById(R.id.coinSymbol);

        File image = new File("https://www.cryptocompare.com/media/19633/btc.png");
        if(image.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(image.getAbsolutePath());

            ImageView myImage = (ImageView) findViewById(R.id.coinImage);

            myImage.setImageBitmap(myBitmap);
        }*/
        listView = (ListView) findViewById(R.id.listView);
        coinArrayAdapter = new CoinArrayAdapter(getApplicationContext(), R.layout.listview_row_layout);
        listView.setAdapter(coinArrayAdapter);

        /*List<String[]> coinList = readData();
        for(String[] coinData:coinList) {
            String image = coinData[0];
            String name = coinData[1];
            String symbol = coinData[2];
            //int fruitImgResId = getResources().getIdentifier(fruitImg, "drawable", "com.javapapers.android.listviewcustomlayout.app");

            Coin coin = new Coin(name,symbol);
            coinArrayAdapter.add(coin);
        }*/

        try {
            jsonParse();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*
        File imgFile = new File("C:\\Users\\Milos Cabrilo\\AndroidStudioProjects\\TestProject\\btc.png");
        ImageView imageView = (ImageView) findViewById(R.id.coinImage);
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        imageView.setImageBitmap(myBitmap);
        listView.addView(imageView);
        */
        //imageView.

    }

    public List<String[]> readData() {
        List<String[]> resultList = new ArrayList<String[]>();

        String[] fruit7 = new String[3];
        fruit7[0] = "orange";
        fruit7[1] = "Orange";
        fruit7[2] = "47 Calories";
        resultList.add(fruit7);

        String[] fruit1 = new String[3];
        fruit1[0] = "cherry";
        fruit1[1] = "Cherry";
        fruit1[2] = "50 Calories";
        resultList.add(fruit1);


        String[] fruit3 = new String[3];
        fruit3[0] = "banana";
        fruit3[1] = "Banana";
        fruit3[2] = "89 Calories";
        resultList.add(fruit3);

        String[] fruit4 = new String[3];
        fruit4[0] = "apple";
        fruit4[1] = "Apple";
        fruit4[2] = "52 Calories";
        resultList.add(fruit4);

        String[] fruit10 = new String[3];
        fruit10[0] = "kiwi";
        fruit10[1] = "Kiwi";
        fruit10[2] = "61 Calories";
        resultList.add(fruit10);

        String[] fruit5 = new String[3];
        fruit5[0] = "pear";
        fruit5[1] = "Pear";
        fruit5[2] = "57 Calories";
        resultList.add(fruit5);


        String[] fruit2 = new String[3];
        fruit2[0] = "strawberry";
        fruit2[1] = "Strawberry";
        fruit2[2] = "33 Calories";
        resultList.add(fruit2);

        String[] fruit6 = new String[3];
        fruit6[0] = "lemon";
        fruit6[1] = "Lemon";
        fruit6[2] = "29 Calories";
        resultList.add(fruit6);

        String[] fruit8 = new String[3];
        fruit8[0] = "peach";
        fruit8[1] = "Peach";
        fruit8[2] = "39 Calories";
        resultList.add(fruit8);

        String[] fruit9 = new String[3];
        fruit9[0] = "apricot";
        fruit9[1] = "Apricot";
        fruit9[2] = "48 Calories";
        resultList.add(fruit9);

        String[] fruit11 = new String[3];
        fruit11[0] = "mango";
        fruit11[1] = "Mango";
        fruit11[2] = "60 Calories";
        resultList.add(fruit11);

        return resultList;
    }


    private void jsonParse() throws JSONException {
        //textView.setText("");
        String url = "https://min-api.cryptocompare.com/data/top/totaltoptiervolfull?limit=10&tsym=USD&page=0";
        //JSONObject jObj = new JSONObject(url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    //JSONObject data = response.getJSONObject("Data");
                    JSONArray data = response.getJSONArray("Data");
                    //JSONArray ja = data.getJSONArray("CoinInfo");
                    //JSONObject object = jsonArray.getJSONObject(0);
                    //JSONObject ja = jsonArray.getJSONObject("CoinInfo");
                    //JsonArray ja = jsonArray.getJSONArray("CoinInfo");
                    for(int i=0; i<data.length();i++) {
                        //JSONObject kkk= new JSONObject("sdasdasd");
                        JSONObject objectData = data.getJSONObject(i);
                        JSONObject coinInfo = objectData.getJSONObject("CoinInfo");
                        String symbol = coinInfo.getString("Name");
                        String coinName = coinInfo.getString("FullName");
                        Coin coin = new Coin(coinName, symbol);
                        coinArrayAdapter.add(coin);

                        //String filename = employees.getString("CoinInfo");
                        //textView.append(filename + " ");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    //textView.setText("nisam upseo kurac");
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);

    }
}

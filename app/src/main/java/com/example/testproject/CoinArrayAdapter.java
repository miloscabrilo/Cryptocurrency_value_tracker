package com.example.testproject;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class CoinArrayAdapter extends ArrayAdapter<Coin> {
    private static final String TAG= "CoinArrayAdapter";
    private List<Coin> coinList= new ArrayList<>();

    private RequestQueue mQueue;


    static class CoinViewHolder {
        //ImageView imageCoin;
        TextView nameCoin;
        TextView symbolCoin;
    }


    public CoinArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);

    }

    @Override
    public void add(Coin object) {
        coinList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.coinList.size();
    }

    @Override
    public Coin getItem(int index) {
        return this.coinList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CoinViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.listview_row_layout, parent, false);
            viewHolder = new CoinViewHolder();
            //viewHolder.imageCoin = (ImageView) row.findViewById(R.id.coinImage);
            viewHolder.nameCoin = (TextView) row.findViewById(R.id.coinName);
            viewHolder.symbolCoin = (TextView) row.findViewById(R.id.coinSymbol);
            row.setTag(viewHolder);
        } else {
            viewHolder = (CoinViewHolder)row.getTag();
        }
        Coin coin = getItem(position);
        //File imgFile = new File("C:\\Users\\Milos Cabrilo\\AndroidStudioProjects\\TestProject\\btc.png");
        //Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

        //viewHolder.imageCoin.setImageBitmap(myBitmap);
        viewHolder.nameCoin.setText(coin.getNameCoin());
        viewHolder.symbolCoin.setText(coin.getSymbolCoin());
        return row;
    }



}

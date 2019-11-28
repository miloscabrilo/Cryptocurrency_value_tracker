package com.example.testproject;


public class Coin {
    private static final String TAG = "Coin";

    //private String imageCoin;
    private String nameCoin;
    private String symbolCoin;

    public Coin(/*String image, */String name,String symbol) {
        super();
        //this.setImageCoin(image);
        this.setNameCoin(name);
        this.setSymbolCoin(symbol);
    }
    public String getNameCoin() { return nameCoin; }

    public void setNameCoin(String nameCoin) { this.nameCoin = nameCoin;}

    public String getSymbolCoin() { return symbolCoin; }

    public void setSymbolCoin(String symbolCoin) { this.symbolCoin = symbolCoin;}

    /*public String getImageCoin() { return imageCoin; }

    public void setImageCoin(String imageCoin) { this.imageCoin = imageCoin;}
    */

}

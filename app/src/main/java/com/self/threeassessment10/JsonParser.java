package com.self.threeassessment10;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.GridView;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public  class JsonParser extends AsyncTask <String,String,Void>
{


    public List<FoodItems> fooddetails = new ArrayList<>();

    //  json array to contain json file
    JSONArray jsonArray;
    JsonParsingAdapter adapter;
    // string variable to store  final json data converted
    String result="";

    // declare context and activity , final result store which activity and ....

    @SuppressLint("StaticFieldLeak")
    Activity activity;

    @SuppressLint("StaticFieldLeak")
    Context context;

    // reading the streaming data from url
    BufferedInputStream bufferedInputStream;

    // for showing the progress before dynamic data is fetched and updated to UI
    public ProgressDialog progressDialog;

    // constructor


    public JsonParser(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
        this.progressDialog = new ProgressDialog(this.context);
    }



    // before
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        progressDialog.dismiss();
        progressDialog.setMessage("Loading ....Hold On.....");
        progressDialog.show();
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                JsonParser.this.cancel(true);
            }
        });


    }



    // connect URL and reading json
    @Override
    protected Void doInBackground(String... strings)

    {

            HttpURLConnection httpURLConnection = null;
            try{
                 //
                //try
                //{

                // pass url inside this instance
                URL url = new URL(DataUrl.fetchData);
                // open web page json file on server
                //HttpURLConnection urlConnection =(HttpURLConnection) url.openConnection();

                 httpURLConnection = (HttpURLConnection)url.openConnection();
                //httpURLConnection = (HttpURLConnection)url.openConnection();
                // start reading data get string bytes to inputStream
                //BufferedInputStream bufferedInputStream;
               // bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
               bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());

                result = readStream();
                Log.i("a", result);

                result = result.substring
                        (result.indexOf("(") + 1, result.lastIndexOf(")"));


            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            return null;

    }

    // reading json file from url in form of bytes ,line by line and appending lines
    private String readStream() throws IOException
    {

        BufferedReader bufferedReader = new
                BufferedReader( new InputStreamReader(bufferedInputStream));

        StringBuilder stringBuilder = new StringBuilder();

        //reading line by line and appending to stringBuider
        String line;
        try
        {

            while((line = bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line);
            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return  stringBuilder.toString();
        //Log.i("d", String stringBuilder.toString());
    }

    // fetch data to gridview do background after reading stream  from
    @Override
    protected void onPostExecute(Void unused)
    {
        super.onPostExecute(unused);

        try
        {
            jsonArray = new JSONArray(result);
            if(jsonArray != null)
            {
                for (int index=0; index<jsonArray.length();index++)
                {

                    //FoodItems foodItems = new FoodItems();
                    FoodItems foodItems = new FoodItems();
                    //ProductID , ProductName........ should same as name as in json file
                    foodItems.id = jsonArray.getJSONObject(index).getInt("ProductID");
                    foodItems.name = jsonArray.getJSONObject(index).getString("ProductName");
                    foodItems.price = jsonArray.getJSONObject(index).getString("UnitPrice");

                    // get image url, appending 1.jpg, 2.jpg, ......10.jpg,11.jpg.....
                    foodItems.imageurl = DataUrl.imageData + foodItems.id + ".jpg";

                    // pass into array, which is array<fooddetial>,    finally!!!
                    fooddetails.add(foodItems);


                }
            }

            GridView gridView;
            gridView = (GridView) this.activity.findViewById(R.id.listviewfetchfooddetails);


            adapter = new JsonParsingAdapter(this.context ,fooddetails);
            gridView.setAdapter(adapter);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        this.progressDialog.dismiss();



    }

}

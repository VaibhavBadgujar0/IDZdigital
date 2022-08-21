package com.example.idzdigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    // Json link
    private static String JSON_URL="http://aamras.com/dummy/EmployeeDetails.json";

    List<EmployeeDetailsClass> employees;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        employees = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);


        GetData getData = new GetData();
        getData.execute();

    }

    public class GetData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            String current="";

            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url=new URL(JSON_URL);
                    urlConnection=(HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1){

                        current += (char) data;
                        data = isr.read();
                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null){
                        urlConnection.disconnect();

                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("employees");

                for(int i=0; i<jsonArray.length(); i++){

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    EmployeeDetailsClass model = new EmployeeDetailsClass();

                    model.setName(jsonObject1.getString("name"));
                    model.setAge(jsonObject1.getString("age"));
                    model.setSalary(jsonObject1.getString("salary"));

                    employees.add(model);

                }

                PutDataIntoRecyclerView(employees);


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

    private void PutDataIntoRecyclerView(List<EmployeeDetailsClass> employees){

        Adaptery adaptery = new Adaptery("this", employees);
        recyclerView.setLayoutManager(new LinearLayoutManager("this"));


        recyclerView.setAdapter(adaptery);
    }



}
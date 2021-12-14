package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Model.BloodGlucose;
import com.example.login.Model.BloodPressure;
import com.example.login.Service.DataBaseService;

import java.util.ArrayList;

public class BloodPresureGlucoseActivity extends AppCompatActivity {
      TextView title,daytext,mothtext,weektext,datatext;
      Button addbtn;
      ListView listview;
      RecyclerView bloodRecylerview;
    String[] weekArray = {"Monday","Tuesday","Wednesday","Thursday",
            "Friday","Saturday","Sunday"};
    String[] monthArray = {"January","February","March","April",
            "May","June","July","August","September","October","November","December"};
    ArrayAdapter weekAdapter,mothAdapter;
    ArrayList<BloodPressure> bloodpressuredata = new ArrayList<BloodPressure>();
    ArrayList<BloodGlucose> bloodGlucosesdata = new ArrayList<BloodGlucose>();
    DataBaseService dataBaseService;
    PressureArrayAdapter pressureArrayAdapter;
    GlucoseArrayAdapter glucoseArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_presure_glucose);
        title=findViewById(R.id.title);
        daytext=findViewById(R.id.daytext);
        mothtext=findViewById(R.id.mothtext);
        weektext=findViewById(R.id.weektext);
        daytext.setBackgroundResource(R.drawable.text_bg);
        datatext=findViewById(R.id.datatext);
        addbtn=findViewById(R.id.addbtn);
        listview=findViewById(R.id.listview);
        weekAdapter = new ArrayAdapter<String>(this,
                R.layout.item_list, weekArray);
        mothAdapter = new ArrayAdapter<String>(this,
                R.layout.item_list, monthArray);
        weektext.setBackgroundResource(0);
        mothtext.setBackgroundResource(0);
        listview.setVisibility(View.GONE);
        dataBaseService=new DataBaseService(this);
        bloodRecylerview=findViewById(R.id.bloodRecylerview);
        bloodRecylerview.setLayoutManager(new LinearLayoutManager(this));
        bloodRecylerview.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    protected void onStart() {
        title.setText(getIntent().getStringExtra("title"));
        if(getIntent().getStringExtra("title").equals("Blood Pressure")){
            bloodpressuredata=dataBaseService.getBloodPrusreData();
            if(bloodpressuredata.size()>0){
                addbtn.setVisibility(View.VISIBLE);
                datatext.setVisibility(View.GONE);
                bloodRecylerview.setVisibility(View.VISIBLE);
                pressureArrayAdapter =new PressureArrayAdapter();
                bloodRecylerview.setAdapter(pressureArrayAdapter);
            }
            else{
                addbtn.setVisibility(View.VISIBLE);
                datatext.setVisibility(View.VISIBLE);
                bloodRecylerview.setVisibility(View.GONE);
            }
        }
       else{
            bloodGlucosesdata=dataBaseService.getBloodGlucoseData();
            if(bloodGlucosesdata.size()>0){
                addbtn.setVisibility(View.VISIBLE);
                datatext.setVisibility(View.GONE);
                bloodRecylerview.setVisibility(View.VISIBLE);
                glucoseArrayAdapter=new GlucoseArrayAdapter();
                bloodRecylerview.setAdapter(glucoseArrayAdapter);
            }
            else{
                addbtn.setVisibility(View.VISIBLE);
                datatext.setVisibility(View.VISIBLE);
                bloodRecylerview.setVisibility(View.GONE);
            }
        }

        super.onStart();
    }

    public void closScreen(View view) {
        finish();
    }

    public void dayTextClicked(View view) {
        daytext.setBackgroundResource(R.drawable.text_bg);
        weektext.setBackgroundResource(0);
        mothtext.setBackgroundResource(0);
        addbtn.setVisibility(View.VISIBLE);
        datatext.setVisibility(View.VISIBLE);
        listview.setVisibility(View.GONE);
    }

    public void weekTextClicked(View view) {
        weektext.setBackgroundResource(R.drawable.text_bg);
        daytext.setBackgroundResource(0);
        mothtext.setBackgroundResource(0);
        addbtn.setVisibility(View.GONE);
        datatext.setVisibility(View.GONE);
        listview.setAdapter(weekAdapter);
        listview.setVisibility(View.VISIBLE);
    }

    public void mothTextClicked(View view) {
        mothtext.setBackgroundResource(R.drawable.text_bg);
        weektext.setBackgroundResource(0);
        daytext.setBackgroundResource(0);
        addbtn.setVisibility(View.GONE);
        datatext.setVisibility(View.GONE);
        listview.setAdapter(mothAdapter);
        listview.setVisibility(View.VISIBLE);
    }

    public void openBloodPressureGlucoseScreen(View view) {
        if(getIntent().getStringExtra("title").equals("Blood Pressure")){
            startActivity(new Intent(this,BloodPressureActivity.class));
        }else{
            startActivity(new Intent(this,BloodGlucoseActivity.class));
        }

    }
    public class PressureArrayAdapter extends RecyclerView.Adapter<PressureArrayAdapter.ViewHolder> {

        public ArrayList<BloodPressure> bloodPressureArrayList;
        public PressureArrayAdapter() {
           this.bloodPressureArrayList = bloodpressuredata;
        }

        // get the size of the list
        @Override
        public int getItemCount() {
            return bloodPressureArrayList == null ? 0 : bloodPressureArrayList.size();
        }

        // specify the row layout file and click for each row
        @Override
        public PressureArrayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blood_pressure, parent, false);
            PressureArrayAdapter.ViewHolder myViewHolder = new PressureArrayAdapter.ViewHolder(view);
            return myViewHolder;
        }

        // load data in each row element
        @Override
        public void onBindViewHolder(final PressureArrayAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int listPosition) {
            holder.time.setText(bloodPressureArrayList.get(listPosition).getTime());
            holder.dia.setText(bloodPressureArrayList.get(listPosition).getDia());
            holder.pul.setText(bloodPressureArrayList.get(listPosition).getPul());
            holder.sys.setText(bloodPressureArrayList.get(listPosition).getSys());

            if(bloodPressureArrayList.get(listPosition).getTimestatus().equals("true")){
                holder.aptimestatus.setText("am");
            }
            else  {
                holder.aptimestatus.setText("pm");
            }

        }


        // Static inner class to initialize the views of rows
        class ViewHolder extends RecyclerView.ViewHolder  {

            CardView tfcardview;
            TextView time,sys,dia,pul,aptimestatus;
            public ViewHolder(View itemView) {
                super(itemView);
                time=itemView.findViewById(R.id.aptime);
                sys=itemView.findViewById(R.id.apsis);
                dia=itemView.findViewById(R.id.apdiv);
                pul=itemView.findViewById(R.id.appul);
                aptimestatus=itemView.findViewById(R.id.aptimestatus);

            }
        }
    }
    public class GlucoseArrayAdapter extends RecyclerView.Adapter<GlucoseArrayAdapter.ViewHolder> {

        public ArrayList<BloodGlucose> bloodGlucoseArrayList;
        public GlucoseArrayAdapter() {
            this.bloodGlucoseArrayList = bloodGlucosesdata;
        }

        // get the size of the list
        @Override
        public int getItemCount() {
            return bloodGlucoseArrayList == null ? 0 : bloodGlucoseArrayList.size();
        }

        // specify the row layout file and click for each row
        @Override
        public GlucoseArrayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blood_glucose, parent, false);
            GlucoseArrayAdapter.ViewHolder myViewHolder = new GlucoseArrayAdapter.ViewHolder(view);
            return myViewHolder;
        }

        // load data in each row element
        @Override
        public void onBindViewHolder(final GlucoseArrayAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int listPosition) {
            holder.time.setText(bloodGlucoseArrayList.get(listPosition).getTime());
            holder.bloodg.setText(bloodGlucoseArrayList.get(listPosition).getBloodg());

            if(bloodGlucoseArrayList.get(listPosition).getTimestatus().equals("true")){
                holder.aptimestatus.setText("am");
            }
            else  {
                holder.aptimestatus.setText("pm");
            }
            if(bloodGlucoseArrayList.get(listPosition).getMealtime().equals("true")){
                holder.mealstatus.setBackgroundResource(R.drawable.ic_baseline_circle);

            }
            else  {
                holder.mealstatus.setBackgroundResource(R.drawable.ic_baseline_circle_24);
            }

        }


        // Static inner class to initialize the views of rows
        class ViewHolder extends RecyclerView.ViewHolder  {

            CardView tfcardview;
            TextView time,bloodg,aptimestatus;
            ImageView mealstatus;
            public ViewHolder(View itemView) {
                super(itemView);
                time=itemView.findViewById(R.id.avtime);
                bloodg=itemView.findViewById(R.id.avbloodg);
                aptimestatus=itemView.findViewById(R.id.avtimestatus);
                mealstatus=itemView.findViewById(R.id.avmealStatus);

            }
        }
    }
}
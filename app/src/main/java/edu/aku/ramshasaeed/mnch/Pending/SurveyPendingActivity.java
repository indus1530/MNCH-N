package edu.aku.ramshasaeed.mnch.Pending;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import edu.aku.ramshasaeed.mnch.R;
import edu.aku.ramshasaeed.mnch.activities.Qoc1;
import edu.aku.ramshasaeed.mnch.activities.Qoc2;
import edu.aku.ramshasaeed.mnch.activities.Qoc3;
import edu.aku.ramshasaeed.mnch.activities.Rsd01;
import edu.aku.ramshasaeed.mnch.activities.Rsd02;
import edu.aku.ramshasaeed.mnch.activities.Rsd03;
import edu.aku.ramshasaeed.mnch.activities.Rsd04;
import edu.aku.ramshasaeed.mnch.activities.Rsd05;
import edu.aku.ramshasaeed.mnch.activities.Rsd06;
import edu.aku.ramshasaeed.mnch.core.MainApp;
import edu.aku.ramshasaeed.mnch.data.DAO.GetFncDAO;
import edu.aku.ramshasaeed.mnch.get.db.GetAllDBData;

import static edu.aku.ramshasaeed.mnch.activities.LoginActivity.db;

//import data.LocalDataManager;


public class SurveyPendingActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pending_interviews);

        //List<String> list = new LocalDataManager(this).getLogListPending("0");
        //qoccollection = new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getUnSyncedForms").execute(MainApp.QOC).get();
        Collection<String> collection = null;
        try {
            collection = (Collection<String>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getPendingForms").execute(MainApp.FORM_TYPE, MainApp.FORM_SUB_TYPE).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (collection == null)
            return;

        //Collections.sort(collection);

        mRecyclerView = findViewById(R.id.list_survey_completed);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new SurveyPendingCustomAdapter(this, (List<String>) collection);
        mRecyclerView.setAdapter(mAdapter);
    }
}


class SurveyPendingCustomAdapter extends RecyclerView.Adapter {

    Context mContext;
    List<String> mList;

    public SurveyPendingCustomAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_survey_pending, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final ViewHolder vh = (ViewHolder) holder;

        //rejected items..
        if (mList.get(position).contains("--00")) {
            vh.itemView.setBackgroundColor(Color.parseColor("#FFB7BC"));
        }

        vh.textName.setText(mList.get(position).split("--")[0]);
        vh.textId.setText(position + 1 + "");


        vh.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder b = new AlertDialog.Builder(mContext);
                b.setTitle("Upload Interview");
                b.setMessage("Do you want to upload this interview ");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String memberId = vh.textName.getText().toString();


                        String[] arrr = memberId.split("/");

                        String rm = arrr[0];
                        int curentSection = Integer.valueOf(arrr[1]);
                        int interviewType = Integer.valueOf(arrr[2]);

                        //here call activity
                        Intent intent = null;
                        if (interviewType == 2) {

                            if (curentSection == 2) {

                                intent = new Intent(mContext, Rsd01.class);
                                intent.putExtra("rm", rm);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 3) {

                                intent = new Intent(mContext, Rsd02.class);
                                intent.putExtra("rm", rm);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 4) {

                                intent = new Intent(mContext, Rsd03.class);
                                intent.putExtra("rm", rm);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 5) {

                                intent = new Intent(mContext, Rsd04.class);
                                intent.putExtra("rm", rm);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 6) {

                                intent = new Intent(mContext, Rsd05.class);
                                intent.putExtra("rm", rm);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 8) {

                                intent = new Intent(mContext, Rsd06.class);
                                intent.putExtra("rm", rm);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 9) {

                                intent = new Intent(mContext, Qoc1.class);
                                intent.putExtra("rm", rm);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 10) {

                                intent = new Intent(mContext, Qoc2.class);
                                intent.putExtra("rm", rm);
                                mContext.startActivity(intent);
                            }
                            if (curentSection == 11) {

                                intent = new Intent(mContext, Qoc3.class);
                                intent.putExtra("rm", rm);
                                mContext.startActivity(intent);
                            }
                        }

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // Intent intent = null;

                        //    intent = new Intent(this, SurveyPendingActivity.class);
                    }
                }).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName, textId;

        public ViewHolder(View v) {
            super(v);
            textName = v.findViewById(R.id.text_item_survey_pending_name);
            textId = v.findViewById(R.id.text_item_survey_pending_id);
        }
    }


}
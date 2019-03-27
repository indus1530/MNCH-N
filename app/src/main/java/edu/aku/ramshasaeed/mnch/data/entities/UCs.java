package edu.aku.ramshasaeed.mnch.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.ramshasaeed.mnch.data.AppDatabase;

//@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_UCs)
public class UCs {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String UCs_code = "";
    private String UCs_name = "";
    private String tehsil_code = "";
    private String uen_code = "";

    public UCs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUCs_code() {
        return UCs_code;
    }

    public void setUCs_code(String UCs_code) {
        this.UCs_code = UCs_code;
    }

    public String getUCs_name() {
        return UCs_name;
    }

    public void setUCs_name(String UCs_name) {
        this.UCs_name = UCs_name;
    }

    public String getTehsil_code() {
        return tehsil_code;
    }

    public void setTehsil_code(String tehsil_code) {
        this.tehsil_code = tehsil_code;
    }

    public String getUen_code() {
        return uen_code;
    }

    public void setUen_code(String uen_code) {
        this.uen_code = uen_code;
    }

    public UCs Sync(JSONObject jsonObjectCls) throws JSONException {

        this.UCs_code = jsonObjectCls.getString("hf_uc_code");
        this.UCs_name = jsonObjectCls.getString("hf_uc_name");
        this.tehsil_code = jsonObjectCls.getString("hf_tehsil_code");
        this.uen_code = jsonObjectCls.getString("hf_uen_code");
        return this;
    }
}

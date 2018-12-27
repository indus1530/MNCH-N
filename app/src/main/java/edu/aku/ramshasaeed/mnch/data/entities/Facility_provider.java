package edu.aku.ramshasaeed.mnch.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.ramshasaeed.mnch.data.AppDatabase;

@Entity(tableName = AppDatabase.Sub_DBConnection.TABLE_FACILITY_PROVIDER)
public class Facility_provider {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String provider_code = "";
    private String provider_name = "";
    private String uc_code = "";

    public Facility_provider() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvider_code() {
        return provider_code;
    }

    public void setProvider_code(String provider_code) {
        this.provider_code = provider_code;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getUc_code() {
        return uc_code;
    }

    public void setUc_code(String uc_code) {
        this.uc_code = uc_code;
    }

    public Facility_provider Sync(JSONObject jsonObjectCls) throws JSONException {

        this.provider_code = jsonObjectCls.getString("hf_provider_code");
        this.provider_name = jsonObjectCls.getString("hf_provider_name");
        this.uc_code = jsonObjectCls.getString("hf_uc_code");
        return this;
    }
}

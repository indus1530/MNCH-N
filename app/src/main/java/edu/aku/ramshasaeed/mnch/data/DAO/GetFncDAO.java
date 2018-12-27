package edu.aku.ramshasaeed.mnch.data.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import edu.aku.ramshasaeed.mnch.data.AppDatabase;
import edu.aku.ramshasaeed.mnch.data.entities.District;
import edu.aku.ramshasaeed.mnch.data.entities.Facility_provider;
import edu.aku.ramshasaeed.mnch.data.entities.Forms;
import edu.aku.ramshasaeed.mnch.data.entities.Tehsil;
import edu.aku.ramshasaeed.mnch.data.entities.UCs;
import edu.aku.ramshasaeed.mnch.data.entities.Users;

@Dao
public interface GetFncDAO {

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS)
    List<Forms> getAll();

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE id=:id")
    Forms getLastForm(int id);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE formDate LIKE :date")
    List<Forms> getTodaysForms(String date);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE synced = ''")
    List<Forms> getUnSyncedForms();
    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_DISTRICT)
    List<District> getAllDistricts();

   /* @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_TEHSIL)
    List<Tehsil> getAllTehsils();
    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_UCs)
    List<UCs> getAllUCs();*/

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS)
    List<Forms> getForms();


    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE synced = '' AND formType = :formType")
    List<Forms> getUnSyncedForms(String formType);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " WHERE formType = :formType")
    List<Forms> getForms(String formType);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_USERS + " where ROW_USERNAME=:username AND ROW_PASSWORD=:password")
    Users login(String username, String password);
/*

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_DISTRICT )
    District getDistrictRecord();
*/

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_TEHSIL + " where district_code=:district_code")
    List<Tehsil> getTehsil(String district_code);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_UCs + " where tehsil_code=:tehsil_code")
    List<UCs> getUCs(String tehsil_code);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FACILITY_PROVIDER + " where uc_code=:hf_uc_code")
    List<Facility_provider> getFacilityProvider(String hf_uc_code);

  /*  @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " where youthID=:part_id and pdeviation = '1' and istatus = '1' and formType != '14' order by id DESC")
    Forms getParticipantRecordForm7(String part_id);

    @Query("SELECT * FROM " + AppDatabase.Sub_DBConnection.TABLE_FORMS + " where youthID=:youth_id and formType='7' and istatus = '1' order by id DESC")
    Forms getYouthRecord(String youth_id);*/

}

package com.example.appepicnovels.Firebase;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.appepicnovels.AdminActivity;
import com.example.appepicnovels.PostStory;
import com.example.appepicnovels.SearchStory;
import com.example.appepicnovels.models.Truyen;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBHelperF {
    private String username;
    private String password;

    public DBHelperF(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public DBHelperF(SearchStory searchStory) {
        super();
    }

    public DBHelperF(PostStory postStory) {
        super();
    }

    public DBHelperF(AdminActivity adminActivity) {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void AddTruyen(Truyen truyen) {
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("Truyens");
        String idtruyen = databaseRef.push().getKey();
        databaseRef.child(idtruyen).setValue(truyen)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.e("Add Truyện : ", "Thành công");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Add Truyện : ", "Thất bại", e);
                    }
                });
    }
    public static Cursor getData2() {

        return null;
    }

    public void Delete(int idtruyen) {
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("truyen");
        databaseRef.child(String.valueOf(idtruyen)).removeValue()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Xóa thành công
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Xảy ra lỗi khi xóa
                    }
                });
    }
}
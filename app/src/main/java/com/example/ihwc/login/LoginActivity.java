package com.example.ihwc.login;

import androidx.annotation.NonNull;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ihwc.game.FullscreenGameActivity;
import com.example.ihwc.R;
import com.example.ihwc.game.GuessGame;
import com.example.ihwc.ui.schedule.Game;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.Share;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN=123;
    private FirebaseUser fUser;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        List<AuthUI.IdpConfig> providers=Arrays.asList(
          new AuthUI.IdpConfig.EmailBuilder().build(),
          new AuthUI.IdpConfig.FacebookBuilder().build(),
          new AuthUI.IdpConfig.GoogleBuilder().build()
        );

        startActivityForResult(AuthUI.getInstance()
        .createSignInIntentBuilder().setIsSmartLockEnabled(false).setAvailableProviders(providers).build(), RC_SIGN_IN);


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            IdpResponse response=IdpResponse.fromResultIntent(data);
            if(resultCode==RESULT_OK){
                fUser=FirebaseAuth.getInstance().getCurrentUser();
                SharedPreferences pref=getSharedPreferences("MyPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor= pref.edit();
                editor.putString("userID", fUser.getUid());
                editor.apply();
                searchUser(fUser.getEmail(), fUser.getUid());

            }else{
                if(response==null){
                    finish();
                }

            }
        }

    }
    public void searchUser(String email, String userId){

        Intent intent = new Intent(LoginActivity.this, FullscreenGameActivity.class);
        DatabaseReference databaseReference=FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference("users");
        databaseReference.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                if(snapshot.getValue() !=null){
                Log.i("Snapshot", snapshot.getValue().toString());
                for(DataSnapshot userSnapshot:snapshot.getChildren()){
                    User user=userSnapshot.getValue(User.class);

                intent.putExtra("User", user.username);
                Log.i("Username", user.email);
                startActivity(intent);
               Log.i("Snapshot", user.email);
                }}
                else{
                    EditText editText=new EditText(LoginActivity.this);
                    setUsername(editText, userId, email);
                    Log.i("User", editText.getText().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Log.i("Error", error.getMessage());
            }
        });



    }

    public void setUsername(EditText editText, String userId, String email){
        Intent intent = new Intent(LoginActivity.this, FullscreenGameActivity.class);
        AlertDialog dialog=new MaterialAlertDialogBuilder(LoginActivity.this).setView(editText).setTitle("Username").setPositiveButton("OK", null).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                startActivity(intent);

            }
        }).create();
        dialog.setOnShowListener(dialog1 -> {
            Button button=((AlertDialog) dialog1).getButton(AlertDialog.BUTTON_POSITIVE);
            button.setOnClickListener(v -> {

                DatabaseReference database= FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference("users");
                database.orderByChild("username").equalTo(editText.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        if(snapshot.getValue()==null){
                            List<GuessGame> guessGames=new ArrayList<>();
                            DatabaseReference database2= FirebaseDatabase.getInstance("https://ihwc-app-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
                                database2.child("Games").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                                        if(snapshot.getValue()!=null) {
                                            for (DataSnapshot gameSnapshot : snapshot.getChildren()) {
                                                Game game = gameSnapshot.getValue(Game.class);

                                                guessGames.add(new GuessGame(game.getGameNo_time()));
                                                User user=new User(email, editText.getText().toString(), guessGames);
                                                database.child(userId).setValue(user);
                                            }

                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                                    }
                                });

                            intent.putExtra("User", editText.getText().toString());
                            dialog1.dismiss();
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this,"Username taken choose another", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });
            });
        });
        dialog.show();
    }

}
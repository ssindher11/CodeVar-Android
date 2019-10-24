package com.vit.codevar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity
{
    private TextInputEditText emailEditText, passwordEditText;
    private String email, password;
    private MaterialButton logInButton;
    private CoordinatorLayout view;
    public static Boolean logInStatus;

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://api.codepark.in/auth/")
            .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit retrofit = builder.build();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().setStatusBarColor(getApplicationContext().getColor(R.color.background));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        logInButton = findViewById(R.id.logInButton);
        view = findViewById(R.id.layout);

        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        Gson gson = new Gson();
        Type type = new TypeToken<Boolean>(){}.getType();
        String json = sharedPreferences.getString("logInStatus","false");
        logInStatus = gson.fromJson(json,type);

        if(logInStatus)
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailEditText.getText().toString();
                password = passwordEditText.getText().toString();

                executeSendFeedbackForm(email,password);
            }
        });
    }
    private void executeSendFeedbackForm(String email, String password){
        API api = retrofit.create(API.class);

        Call<Account> call = api.userLogin(
                email,
                password
        );

        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                Log.i("INFO","Response Recvd");
                Account account = response.body();
                String code = account.getCode();
                String message = account.getMessage();

                if(code.equals("0"))
                {
                    logInStatus = true;
                    SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(),MODE_PRIVATE);
                    Gson gson = new Gson();
                    String json = gson.toJson(logInStatus);
                    sharedPreferences.edit().putString("logInStatus",json).apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                else
                {
                    Snackbar.make(view,message,Snackbar.LENGTH_LONG)
                            .setActionTextColor(Color.WHITE).show();
                    Log.i("INFO",message);
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.i("INFO",t.getMessage());
                Snackbar.make(view,"Error occurred! Try again",Snackbar.LENGTH_LONG)
                        .setActionTextColor(Color.WHITE).show();
            }
        });
    }
}
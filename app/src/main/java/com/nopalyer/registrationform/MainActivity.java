package com.nopalyer.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText tvUsername,tvPassword;
    Button btnRegister;
    ImageView img1,img2,img3,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.et_userName);
        tvPassword = findViewById(R.id.et_password);

        btnRegister = findViewById(R.id.btnRegister);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);

        tvPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (hasLength(s)){
                    img1.setImageResource(R.drawable.checked);
                }else{
                    img1.setImageResource(R.drawable.unchecked);
                }

                if (hasSymbol(s)){
                    img4.setImageResource(R.drawable.checked);
                }else{
                    img4.setImageResource(R.drawable.unchecked);
                }

                if (hasDigit(s)){
                    img3.setImageResource(R.drawable.checked);
                }else{
                    img3.setImageResource(R.drawable.unchecked);
                }

                if (hasUppercase(s)){
                    img2.setImageResource(R.drawable.checked);
                }else{
                    img2.setImageResource(R.drawable.unchecked);
                }

                if (hasLength(s) && hasUppercase(s) && hasDigit(s) && hasSymbol(s)){
                    btnRegister.setVisibility(View.VISIBLE);
                }else{
                    btnRegister.setVisibility(View.GONE);
                }



            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public boolean hasLength(CharSequence value){
        return String.valueOf(value).length() >=8;
    }

    public boolean hasDigit(CharSequence value){
        return String.valueOf(value).matches("(.*\\d.*)");
    }

    public boolean hasUppercase(CharSequence value){
        String s = String.valueOf(value);
        return !s.equals(s.toLowerCase());
    }

    public boolean hasSymbol(CharSequence value){
        String s = String.valueOf(value);
        return !s.matches("[A-Za-z0-9 ]*");
    }


}

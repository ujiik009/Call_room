package com.example.phobia.call_room;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private Button okButton, backButton;
    private String fnameString;
    private String lnameString;
    private String surnameString;
    private String telString;
    private String userString;
    private String passwordString;
    private EditText fnameEditText, lnameEditText, surnameEditText, telEditText, userEditText, passwordEditText;
    private ImageView personImageView;
    private Uri uri;
    private Boolean statusimage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bindwidget();
        buttoncontroller();

    }//main method

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            statusimage = false;

            uri = data.getData();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                personImageView.setImageBitmap(bitmap);

            } catch (Exception e) {
            }

        }

    }

    private void buttoncontroller() {


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }


        });


personImageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent,"โปรดเลือกรูปภาพ"),1);
    }
});



        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fnameString = fnameEditText.getText().toString().trim();
                lnameString = lnameEditText.getText().toString().trim();
                surnameString = surnameEditText.getText().toString().trim();
                telString = telEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                if (fnameString.equals("") || lnameString.equals("") || surnameString.equals("")
                        || telString.equals("") || userString.equals("") || passwordString.equals("")) {
                    Toast.makeText(Register.this, "กรุณากรอกข้อมูลให้ครบ", Toast.LENGTH_LONG).show();

                } else if (statusimage == true) {
                    Toast.makeText(Register.this, "กรุณาเลือกรูปภาพ", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(Register.this, "สมัครสมาชิกสำเร็จ", Toast.LENGTH_LONG).show();


                }
                //Toast.makeText(Register.this,fnameString,Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void bindwidget() {
        backButton = (Button) findViewById(R.id.back);
        personImageView = (ImageView) findViewById(R.id.person);
        okButton = (Button) findViewById(R.id.ok);
        fnameEditText = (EditText) findViewById(R.id.fname);
        lnameEditText = (EditText) findViewById(R.id.lname);
        surnameEditText = (EditText) findViewById(R.id.surname);
        telEditText = (EditText) findViewById(R.id.tel);
        userEditText = (EditText) findViewById(R.id.user);
        passwordEditText = (EditText) findViewById(R.id.password);
    }
}//Class Method

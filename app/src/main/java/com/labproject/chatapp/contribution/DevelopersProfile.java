package com.labproject.chatapp.contribution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.labproject.chatapp.databinding.ActivityDevelopersProfileBinding;

public class DevelopersProfile extends AppCompatActivity {

    ActivityDevelopersProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDevelopersProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListener();

    }

    public void setListener(){
        binding.imageBack.setOnClickListener(view -> onBackPressed());
        binding.btFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/veryGOODmusfique/");
            }
        });
        binding.btGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/musfique113");
            }
        });
        // for developer two
        binding.btFacebookd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/sanim.official.fb");
            }
        });
        binding.btGithubd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://github.com/arfhsanim?fbclid=IwAR3FHbkEgAYhCEU5f3cmrfHBXuB6fRgaIXsiybrsFrb0y9i-7INx82IcMcc");
            }
        });

        binding.devOneEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.devOneEmail.getText().toString();
                String[] addresses = email.split(",");
                //broadcast receiver from Email app
                Intent c = new Intent(Intent.ACTION_SENDTO);
                c.setData(Uri.parse("mailto:"));
                c.putExtra(Intent.EXTRA_EMAIL,addresses);
                startActivity(c);
//                if (c.resolveActivity(getPackageManager()) !=null){
//                    startActivity(c);
//                }else {
//                    Toast.makeText(Devinfox.this,"No email app",Toast.LENGTH_SHORT).show();
//                }

            }
        });

        binding.devTwoEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.devTwoEmail.getText().toString();
                String[] addresses = email.split(",");
                //broadcast receiver from Email app
                Intent c = new Intent(Intent.ACTION_SENDTO);
                c.setData(Uri.parse("mailto:"));
                c.putExtra(Intent.EXTRA_EMAIL,addresses);
                startActivity(c);
//                if (c.resolveActivity(getPackageManager()) !=null){
//                    startActivity(c);
//                }else {
//                    Toast.makeText(Devinfox.this,"No email app",Toast.LENGTH_SHORT).show();
//                }

            }
        });



    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
package com.example.dynamicuilive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.container);
        addCountry("USA", R.drawable.usa, layout);
        addCountry("South Korea", R.drawable.southkorea, layout);
        addCountry("Singapore", R.drawable.singapore, layout);
        addCountry("UK", R.drawable.unitedkingdom, layout);
    }

    public void addCountry(String name, int imageID, LinearLayout parent){
        View country = getLayoutInflater().inflate(R.layout.country, null);

        ImageView img = (ImageView) country.findViewById(R.id.flag_image);
        img.setImageResource(imageID);

        TextView countryNameView = (TextView) country.findViewById(R.id.country_name);
        countryNameView.setText(name);

        Button okButton = (Button) country.findViewById(R.id.country_ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You clicked on " + name, Toast.LENGTH_SHORT).show();
            }
        });

        parent.addView(country);
    }
}
package ru.mirea.sidorov_m.practice_6;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import ru.mirea.sidorov_m.practice_6.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPref = getSharedPreferences("sidorov_m_settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        if(!sharedPref.getString("group", "unknown").equals("unknown") || !sharedPref.getString("number", "unknown").equals("unknown") || !sharedPref.getString("serial", "unknown").equals("unknown"))

        {

            binding.editgroup.setText(sharedPref.getString("group", "unknown"));
            binding.editnumber.setText(sharedPref.getString("number", "unknown"));
            binding.editfilm.setText(sharedPref.getString("film", "unknown"));

        }
        binding.btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                editor.putString("group", binding.editgroup.getText().toString());
                editor.putString("number", binding.editnumber.getText().toString());
                editor.putString("film", binding.editfilm.getText().toString());
                editor.apply();

            }
        });

    }
}
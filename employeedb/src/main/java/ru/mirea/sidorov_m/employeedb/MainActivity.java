package ru.mirea.sidorov_m.employeedb;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import ru.mirea.sidorov_m.employeedb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        AppDatabase db = App.getInstance().getDatabase();
        MarvelDao marvelDao = db.employeeDao();

        binding.insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarvelSuperheroes marvelSuperheroe = new MarvelSuperheroes();

                marvelSuperheroe.name = binding.editTextTextPersonName.getText().toString();
                marvelSuperheroe.superpower = binding.editTextTextPersonName2.getText().toString();
                marvelSuperheroe.team = binding.editTextTextPersonName3.getText().toString();

                marvelDao.insert(marvelSuperheroe);
            }
        });

        binding.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarvelSuperheroes marvelSuperheroe = marvelDao.getById(Integer.parseInt(binding.editTextTextPersonName4.getText().toString()));
                Snackbar.make(v, String.format("имя - %s  суперсила - %s\nкоманда - %s", marvelSuperheroe.name, marvelSuperheroe.superpower, marvelSuperheroe.team), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
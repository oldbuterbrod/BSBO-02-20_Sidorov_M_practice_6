package ru.mirea.sidorov_m.employeedb;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;
import android.util.Log;

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
        EmployeeDao employeeDao = db.employeeDao();
        Employee employee = new Employee();

        employee.name = "Tony Soprano";
        employee.salary = 15000;

        employeeDao.insert(employee);

        List<Employee> employees = employeeDao.getAll();

        employee = employeeDao.getById(1);

        employee.salary = 35000;

        employeeDao.update(employee);

        Log.d(TAG, employee.name + " " + employee.salary);
    }
}
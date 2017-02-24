package com.samvel1024.databindingrv_sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.samvel1024.databindingrv_sample.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements MainViewModel.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new MainViewModel(this));
    }

    @Override
    public void onItemClicked(ListItemViewModel item) {
        Toast.makeText(
                this,
                String.format("Buying %s for %s", item.getName(), item.getPrice()),
                Toast.LENGTH_SHORT
        ).show();
    }
}

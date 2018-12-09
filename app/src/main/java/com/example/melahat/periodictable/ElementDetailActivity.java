package com.example.melahat.periodictable;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.melahat.periodictable.databinding.ActivityElementDetailBinding;

public class ElementDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_element_detail);

        ActivityElementDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_element_detail);

        PeriodicTable.Element element = getIntent().getParcelableExtra("element");

        binding.textView.setText(element.name);

    }
}

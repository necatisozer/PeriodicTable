package com.example.melahat.periodictable;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.melahat.periodictable.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        PeriodicTable periodicTable = JsonParser.loadJSONFromAsset(this);
        Pair<Integer, Integer> dimensions = periodicTable.getTableDimensions();
        List<PeriodicTable.Element> recyclerViewElements = new ArrayList<>();

        for (int i = 0; i <= dimensions.first; i++) {
            for (int j = 0; j <= dimensions.second; j++) {
                PeriodicTable.Element element = periodicTable.getElementAtIndex(i, j);

                if (element != null) {
                    recyclerViewElements.add(element);
                } else if (i == 5 && j == 2) {
                    recyclerViewElements.add(null);
                } else if (i == 6 && j == 2) {
                    recyclerViewElements.add(null);
                } else {
                    recyclerViewElements.add(null);
                }

            }
        }

        ElementsAdapter adapter = new ElementsAdapter(recyclerViewElements, this::openDetailPage);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, dimensions.second));
        binding.recyclerView.setAdapter(adapter);

    }

    private void openDetailPage(PeriodicTable.Element element) {
        Intent intent = new Intent(this, ElementDetailActivity.class);
        intent.putExtra("element", element);
        startActivity(intent);
    }
}

package com.example.melahat.periodictable;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;
import androidx.databinding.DataBindingUtil;
import com.example.melahat.periodictable.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        PeriodicTable periodicTable = JsonParser.loadJSONFromAsset(this);
        Pair<Integer, Integer> dimensions = periodicTable.getTableDimensions();

        for (int i = 0; i <= dimensions.first; i++) {
            TableRow tableRow = new TableRow(this);

            for (int j = 0; j <= dimensions.second; j++) {
                PeriodicTable.Element element = periodicTable.getElementAtIndex(i, j);
                View view = getLayoutInflater().inflate(R.layout.layout_element, null);
                TextView atomicNumber = view.findViewById(R.id.element_atomic_number);
                TextView symbol = view.findViewById(R.id.element_symbol);
                TextView atomicMass = view.findViewById(R.id.element_atomic_mass);
                TextView name = view.findViewById(R.id.element_name);

                if (element != null) {
                    atomicNumber.setText(element.number.toString());
                    symbol.setText(element.symbol);
                    atomicMass.setText(element.atomic_mass.toString());
                    name.setText(element.name);
                    view.setOnClickListener(v -> openDetailPage(element));
                } else if (i == 5 && j == 2) {
                    atomicNumber.setText(R.string.lanthanides_range);
                    name.setText(R.string.lanthanides);
                    name.setTypeface(name.getTypeface(), Typeface.BOLD);
                    symbol.setVisibility(View.GONE);
                    atomicMass.setVisibility(View.GONE);
                } else if (i == 6 && j == 2) {
                    atomicNumber.setText(R.string.actinides_range);
                    name.setText(R.string.actinides);
                    name.setTypeface(name.getTypeface(), Typeface.BOLD);
                    symbol.setVisibility(View.GONE);
                    atomicMass.setVisibility(View.GONE);
                } else {
                    view.setVisibility(View.INVISIBLE);
                }

                tableRow.addView(view);

                //tableRow.addView(new ElementView(this, element));
            }

            binding.tableLayout.addView(tableRow);
        }

        Log.d("", "");
    }

    private void openDetailPage(PeriodicTable.Element element) {
        Intent intent = new Intent(this, ElementDetailActivity.class);
        intent.putExtra("element", element);
        startActivity(intent);
    }
}

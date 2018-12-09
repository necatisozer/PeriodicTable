package com.example.melahat.periodictable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.example.melahat.periodictable.databinding.LayoutElementBinding;
import com.google.android.material.card.MaterialCardView;

import java.text.NumberFormat;

public class ElementView extends MaterialCardView {

    private LayoutElementBinding binding;
    private PeriodicTable.Element element;

    public ElementView(Context context) {
        super(context);
        init();
    }

    public ElementView(Context context, PeriodicTable.Element element) {
        super(context);
        this.element = element;
        init();
    }

    public ElementView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ElementView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = LayoutElementBinding.inflate(inflater);

        setElement(element);
    }

    public void setElement(PeriodicTable.Element element) {
        this.element = element;

        binding.elementName.setText(element.name);
        binding.elementSymbol.setText(element.symbol);
        binding.elementAtomicNumber.setText(element.number.toString());
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(5);
        binding.elementAtomicMass.setText(numberFormat.format(element.atomic_mass));
    }
}

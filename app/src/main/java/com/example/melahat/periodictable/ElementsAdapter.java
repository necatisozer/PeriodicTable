package com.example.melahat.periodictable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.melahat.periodictable.databinding.LayoutElementBinding;

import java.util.List;

public class ElementsAdapter extends RecyclerView.Adapter<ElementsAdapter.ElementViewHolder> {

    private List<PeriodicTable.Element> elements;
    private OnElementClickListener listener;

    public ElementsAdapter(List<PeriodicTable.Element> elements, OnElementClickListener listener) {
        this.elements = elements;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutElementBinding binding = LayoutElementBinding.inflate(layoutInflater, parent, false);
        return new ElementViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
        PeriodicTable.Element element = elements.get(position);

        if (element != null) {
            holder.binding.elementName.setText(element.name);
            holder.binding.elementAtomicMass.setText(element.atomic_mass.toString());
            holder.binding.elementAtomicNumber.setText(element.number.toString());
            holder.binding.elementSymbol.setText(element.symbol);
            holder.binding.getRoot().setOnClickListener(v -> listener.onElementClick(element));
        } else {
            holder.binding.getRoot().setVisibility(View.INVISIBLE);
            holder.binding.getRoot().setOnClickListener(null);
        }



        /*atomicNumber.setText(R.string.lanthanides_range);
        name.setText(R.string.lanthanides);
        name.setTypeface(name.getTypeface(), Typeface.BOLD);
        symbol.setVisibility(View.GONE);
        atomicMass.setVisibility(View.GONE);

        atomicNumber.setText(R.string.actinides_range);
        name.setText(R.string.actinides);
        name.setTypeface(name.getTypeface(), Typeface.BOLD);
        symbol.setVisibility(View.GONE);
        atomicMass.setVisibility(View.GONE);*/

    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public interface OnElementClickListener {
        void onElementClick(PeriodicTable.Element element);
    }

    public static class ElementViewHolder extends RecyclerView.ViewHolder {
        private final LayoutElementBinding binding;

        public ElementViewHolder(@NonNull LayoutElementBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

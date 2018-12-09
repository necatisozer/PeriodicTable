package com.example.melahat.periodictable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class PeriodicTable {

    public Localization localization;
    public List<Element> elements;

    public Pair<Integer, Integer> getTableDimensions() {
        int maxRow = 0;
        int maxColumn = 0;

        for (PeriodicTable.Element element : elements) {
            if (element.xpos - 1 > maxColumn) maxColumn = element.xpos - 1;
            if (element.ypos - 1 > maxRow) maxRow = element.ypos - 1;
        }

        return new Pair<>(maxRow, maxColumn);
    }

    public Element getElementAtIndex(int row, int column) {
        for (Element element : elements) {
            if (element.xpos - 1 == column && element.ypos - 1 == row)
                return element;
        }

        return null;
    }

    public static class Localization {
        /**
         * language : en
         * country : null
         */

        public String language;
        public String country;
    }

    public static class Element implements Parcelable {
        public static final Parcelable.Creator<Element> CREATOR = new Parcelable.Creator<Element>() {
            @Override
            public Element createFromParcel(Parcel source) {
                return new Element(source);
            }

            @Override
            public Element[] newArray(int size) {
                return new Element[size];
            }
        };
        /**
         * name : Hydrogen
         * appearance : colorless gas
         * atomic_mass : 1.008
         * boil : 20.271
         * category : diatomic nonmetal
         * color : null
         * density : 0.08988
         * discovered_by : Henry Cavendish
         * melt : 13.99
         * molar_heat : 28.836
         * named_by : Antoine Lavoisier
         * number : 1
         * period : 1
         * phase : Gas
         * source : https://en.wikipedia.org/wiki/Hydrogen
         * spectral_img : https://en.wikipedia.org/wiki/File:Hydrogen_Spectra.jpg
         * summary : Hydrogen is a chemical element with chemical symbol H and atomic number 1. With an atomic weight of 1.00794 u, hydrogen is the lightest element on the periodic table. Its monatomic form (H) is the most abundant chemical substance in the Universe, constituting roughly 75% of all baryonic mass.
         * symbol : H
         * xpos : 1
         * ypos : 1
         * shells : [1]
         */

        public String name;
        public String appearance;
        public Double atomic_mass;
        public Double boil;
        public String category;
        public String color;
        public Double density;
        public String discovered_by;
        public Double melt;
        public Double molar_heat;
        public String named_by;
        public Integer number;
        public Integer period;
        public String phase;
        public String source;
        public String spectral_img;
        public String summary;
        public String symbol;
        public Integer xpos;
        public Integer ypos;
        public List<Integer> shells;

        public Element() {
        }

        protected Element(Parcel in) {
            this.name = in.readString();
            this.appearance = in.readString();
            this.atomic_mass = (Double) in.readValue(Double.class.getClassLoader());
            this.boil = (Double) in.readValue(Double.class.getClassLoader());
            this.category = in.readString();
            this.color = in.readString();
            this.density = (Double) in.readValue(Double.class.getClassLoader());
            this.discovered_by = in.readString();
            this.melt = (Double) in.readValue(Double.class.getClassLoader());
            this.molar_heat = (Double) in.readValue(Double.class.getClassLoader());
            this.named_by = in.readString();
            this.number = (Integer) in.readValue(Integer.class.getClassLoader());
            this.period = (Integer) in.readValue(Integer.class.getClassLoader());
            this.phase = in.readString();
            this.source = in.readString();
            this.spectral_img = in.readString();
            this.summary = in.readString();
            this.symbol = in.readString();
            this.xpos = (Integer) in.readValue(Integer.class.getClassLoader());
            this.ypos = (Integer) in.readValue(Integer.class.getClassLoader());
            this.shells = new ArrayList<>();
            in.readList(this.shells, Integer.class.getClassLoader());
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.appearance);
            dest.writeValue(this.atomic_mass);
            dest.writeValue(this.boil);
            dest.writeString(this.category);
            dest.writeString(this.color);
            dest.writeValue(this.density);
            dest.writeString(this.discovered_by);
            dest.writeValue(this.melt);
            dest.writeValue(this.molar_heat);
            dest.writeString(this.named_by);
            dest.writeValue(this.number);
            dest.writeValue(this.period);
            dest.writeString(this.phase);
            dest.writeString(this.source);
            dest.writeString(this.spectral_img);
            dest.writeString(this.summary);
            dest.writeString(this.symbol);
            dest.writeValue(this.xpos);
            dest.writeValue(this.ypos);
            dest.writeList(this.shells);
        }
    }

}

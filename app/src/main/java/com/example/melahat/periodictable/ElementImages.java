package com.example.melahat.periodictable;

import java.util.Arrays;
import java.util.List;

public class ElementImages {

    public static List<List<Integer>> imageList = Arrays.asList(
            Arrays.asList(
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background
            ),
            Arrays.asList(
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background
            ),
            Arrays.asList(
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background
            )
    );

    public static List<Integer> getImagesByAtomicNumber(int atomicNumber) {
        return imageList.get(atomicNumber - 1);
    }

}

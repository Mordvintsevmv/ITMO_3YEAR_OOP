package com.company;

import java.util.Comparator;

 public class FigureComparator implements Comparator<Figure> {

    public int compare(Figure a, Figure b){
        return a.compareTo(b);
    }

}

package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class History implements Serializable {

    ArrayList<String> history = new ArrayList<>();
    private static final long serialVersionUID = 1L;

    public void addOperation(String s){
        System.out.print(s);
        history.add(s);
    }

    public String getHistory(){
        String sr ="";
        for (String s : history) {
            sr += String.format(s);
        }
        return sr;
    }


}

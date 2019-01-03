package com.axehome.zhw.myfirstktapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Axehome_Mr.Z on 2018/12/15
 */
public class Main2Activity extends AppCompatActivity {
    //2019-1-3 pull

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] mName = new String[]{"s", "h", "o", "p", "p", "i", "n", "g"};

        shuffSort(ints);

        boolean isFirst = true;
        String string = "";


        for (int i = 0; i < ints.length; i++) {
            Log.e("aaa", "(Main2Activity.java:22)<---->" + ints[i]);
            if (ints[i] < mName.length) {
                if (isFirst) {
                    isFirst = false;
                    String s = mName[ints[i]].toUpperCase();
                    string = s;
                } else
                    string += mName[ints[i]];
                Log.e("aaa", "(Main2Activity.java:26)<---->" + mName[ints[i]]);
            }
        }

        Log.e("aaa", "(Main2Activity.java:40)<--最后需要的string-->" + string);


    }


    private void shuffSort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {

            int j = (int) (data.length * Math.random());
            swap(data, i, j);
        }


    }

    private void swap(int[] data, int i, int j) {

        if (i == j) {
            return;
        }

        data[i] = data[i] + data[j];

        data[j] = data[i] - data[j];

        data[i] = data[i] - data[j];
    }

}

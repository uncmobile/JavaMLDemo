package com.example.nirjon.javamldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testJavaML();
    }

    void testJavaML()
    {
        Instance ex1 = new DenseInstance(new double[]{170, 137}, "human");
        Instance ex2 = new DenseInstance(new double[]{165, 145}, "human");

        Instance ex3 = new DenseInstance(new double[]{120, 2000}, "cow");
        Instance ex4 = new DenseInstance(new double[]{127, 2200}, "cow");

        Dataset data = new DefaultDataset();
        data.add(ex1);
        data.add(ex2);
        data.add(ex3);
        data.add(ex4);

        Classifier c = new KNearestNeighbors(3);
        c.buildClassifier(data);

        Instance ex = new DenseInstance(new double[]{167, 140});
        Object result = c.classify(ex);
        Log.v("Tag", result.toString());
    }
}

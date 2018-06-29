package com.example.shauryamanocha.cosmicraymerged;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class Stats extends AppCompatActivity {

//    static LineGraphSeries<DataPoint> series;
    BarChart graph;
    static ArrayList<graphPoint> points = new ArrayList<>();
    static BarChart _graph;
    static List<BarEntry> entries = new ArrayList<>();
    static BarDataSet dataset;
    static BarData barData;
    static ArrayList<String> xLabels = new ArrayList<>();
    static int numPoints = 0;
    static float bars;
    static graphPoint _point;
    SeekBar scaleBar;
    static int[] colors = new int[]{
            Color.parseColor("#bb6175"),
            Color.parseColor("#6c9b84"),
            Color.parseColor("#3b6871"),
            Color.parseColor("#1f2e48"),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        graph = findViewById(R.id.chart);
        _graph = graph;
        _graph.setAutoScaleMinMaxEnabled(true);
//        scaleBar = findViewById(R.id.chartScale);
//        scaleBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                float scale = numPoints/100f;
//                 bars = progress*scale;
//                _graph.setVisibleXRangeMaximum(bars-1);
//                _graph.setVisibleXRangeMinimum(bars);
//                _graph.notifyDataSetChanged();
//                _graph.invalidate();
//                _graph.setData(barData);
//
//
//                Log.w("test",40f/bars/3+"");
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
    }

     static void populate(graphPoint point) {
         if(_graph!=null) {
             _point = point;
             entries.add(new BarEntry(numPoints, point.amount));
             Log.w("Stats", numPoints + "");
//        xLabels.clear();
             xLabels.add(point.label);

             XAxis xAxis = _graph.getXAxis();
             xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
             xAxis.setLabelCount(3);
             xAxis.setDrawGridLines(false);
             xAxis.setLabelRotationAngle(45f);
             xAxis.setTextSize(40.0f);
             xAxis.setValueFormatter(new IAxisValueFormatter() {
                 @Override
                 public String getFormattedValue(float value, AxisBase axis) {
                     if(value<xLabels.size()) {
                         return xLabels.get((int) value);
                     }
                     else{
                         return "error";
                     }

                 }
             });

             dataset = null;
             dataset = new BarDataSet(entries, "Detections");
             dataset.setColors(colors);
             dataset.setValueTextSize(30.0f);
             barData = new BarData(dataset);
             _graph.setVisibleXRangeMaximum(2.5f);
             _graph.notifyDataSetChanged();
             _graph.invalidate();
             _graph.setData(barData);
             _graph.animateXY(1000,1000);
             numPoints++;

         }
    }
}

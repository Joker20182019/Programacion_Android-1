package com.sebamartinez.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements  SensorEventListener {
    TextView txtSensores, txtProximidad, txtLuz;
    SensorManager sensorManager;
    List<Sensor> sensores;
    Sensor sensorP, sensorLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtProximidad = (TextView) findViewById(R.id.txt_proximidad);
        txtLuz = (TextView) findViewById(R.id.txt_luz);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensores = sensorManager.getSensorList(Sensor.TYPE_ALL);


        sensorP = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensorP, SensorManager.SENSOR_DELAY_NORMAL);

        sensorLuz = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, sensorLuz, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                txtProximidad.setText(String.format(" %.0f", sensorEvent.values[0]));
                break;
            case Sensor.TYPE_GYROSCOPE:
                txtLuz.setText(String.format(" %.0f", sensorEvent.values[0]));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
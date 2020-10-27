package com.example.entendendothreads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoIniciar;
    private int numero;
    private Handler handler = new Handler();
    private Button button22;
    private  Boolean pararExecução = false;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoIniciar = findViewById(R.id.Button1);
        button22 = findViewById(R.id.Button22);

    }

    public void iniciarThread(View view) {

      /* MyTread tread = new MyTread();
       tread.start();

*/         pararExecução = false;
        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
    }


    class MyRunnable implements Runnable {

        @Override
        public void run() {
           // Handler handler = new Handler();

            for (int i = 0; i <= 15; i++) {
                if (pararExecução )
                    return;
                numero = i;
                Log.d("Tread", "Contador" + i);

/*
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        botaoIniciar.setText("Contador: " + numero);
                    }
                }); */
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                botaoIniciar.setText("Contador: " + numero);



                            }
                        });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    public void pararThread(View view){
            pararExecução = true;
    }

        class MyTread extends Thread {

            public void run() {

                for (int i = 0; i <= 15; i++) {
                    Log.d("Tread", "Contador" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

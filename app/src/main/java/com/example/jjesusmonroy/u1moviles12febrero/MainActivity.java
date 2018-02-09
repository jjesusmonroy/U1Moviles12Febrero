package com.example.jjesusmonroy.u1moviles12febrero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView progress;
    ListView listview;
    ArrayList<String>contenido = new ArrayList<String>();
    ArrayAdapter<String>adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.seekBar=findViewById(R.id.seekbar);
        this.progress=findViewById(R.id.progress);
        this.listview=findViewById(R.id.listview);
        adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contenido);
        listview.setAdapter(adaptador);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int val = (i * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                progress.setText("" + i);
                progress.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                contenido = new ArrayList<>();

                for(int j=1;j<31;j++){
                    contenido.add(i+"x"+j+" = "+i*j);
                }
                adaptador.notifyDataSetChanged();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

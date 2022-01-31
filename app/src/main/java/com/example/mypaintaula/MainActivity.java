package com.example.mypaintaula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SimplePaint simplePaint;
    ImageView ivColorPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simplePaint = findViewById(R.id.simplePaint);
        ivColorPicker = findViewById(R.id.ivColorPicker);
        ivColorPicker.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                colorPickerSelectColor();
            }
        });
    }

//    ivColorPicker.setColorListener(new ColorListener(Color color) {
//        @Override
//        public void onColorSelected(int color, boolean fromUser) {
//            GridLayout gridLayout = findViewById(R.id.gridLayout);
//            gridLayout.setBackgroundColor(color);
//        }
//        return color;
//    });
//
//    ivColorPicker.setColorListener(new ColorEnvelopeListener() {
//        @Override
//        public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
//            linearLayout.setBackgroundColor(envelope.getColor());
//            textView.setText("#" + envelope.getHexCode());
//        }
//    });

    public void colorPickerSelectColor(){
       new ColorPickerDialog.Builder(this)
               .setTitle("ColorPicker Dialog")
               .setPreferenceName("MyColorPickerDialog")
               .setPositiveButton("Confirmar",
                new ColorEnvelopeListener() {
                    @Override
                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                        setColor(envelope);
                    }
                })
               .setNegativeButton( "Cancelar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
               .attachAlphaSlideBar(true)// the default value is true.
               .attachBrightnessSlideBar(true)// set a bottom space between the last slidebar and buttons.
               .setBottomSpace(12)// set a bottom space between the last sidebar and buttons.
               .show();// the default value is true.


// the default value is true.

    }

    private void setColor(ColorEnvelope envelope) {
        simplePaint.setColor(Color.valueOf(envelope.getColor()));
        ivColorPicker.setColorFilter(Color.valueOf(envelope.getColor()).toArgb());
    }

}
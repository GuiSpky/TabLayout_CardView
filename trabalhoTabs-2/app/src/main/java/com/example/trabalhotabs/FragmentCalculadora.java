package com.example.trabalhotabs;

import static java.lang.Integer.*;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class FragmentCalculadora extends Fragment {
    int intNota2;
    int intNota1;
   EditText nota1;
   EditText nota2;
   Button btnCalcular;
   View vista;
    FrameLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_calculadora, container, false);
//        btnReset = (Button) vista.findViewById(R.id.btnReset);
        btnCalcular = (Button) vista.findViewById(R.id.btnCalc);
        nota1 = (EditText) vista.findViewById(R.id.notaPrimeira);
        nota2 = (EditText) vista.findViewById(R.id.notaSegunda);
        layout = (FrameLayout) vista.findViewById(R.id.layout);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intNota1= parseInt((nota1.getText().toString()));
                intNota2= parseInt((nota2.getText().toString()));
                int media = (intNota1 + intNota2) / 2;


                if (media < 40){
                    Snackbar snackbar
                            = Snackbar
                            .make(
                                    layout,
                                    "Média final "+media+", reprovado",
                                    Snackbar.LENGTH_LONG)
                            .setAction(
                                    "Resetar",
                                    new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view)
                                        {
                                            nota1.setText(" ");
                                            nota2.setText(" ");
                                        }
                                    });

                    snackbar.show();
                } else if (media >= 40 && media < 60) {
                    Snackbar snackbar
                            = Snackbar
                            .make(
                                    layout,
                                    "Média final "+media+", recuperação",
                                    Snackbar.LENGTH_LONG)
                            .setAction(
                                    "Resetar",
                                    new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view)
                                        {
                                            nota1.setText(" ");
                                            nota2.setText(" ");
                                        }
                                    });

                    snackbar.show();
                } else if (media >= 60 && media <= 100) {
                    Snackbar snackbar
                            = Snackbar
                            .make(
                                    layout,
                                    "Média final "+media+", aprovado",
                                    Snackbar.LENGTH_LONG)
                            .setAction(
                                    "Resetar",
                                    new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view)
                                        {
                                            nota1.setText(" ");
                                            nota2.setText(" ");
                                        }
                                    });

                    snackbar.show();
                }else  {
                    Snackbar snackbar
                            = Snackbar
                            .make(
                                    layout,
                                    "valor incorreto, corrija!",
                                    Snackbar.LENGTH_LONG)
                            .setAction(
                                    "Resetar",
                                    new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view)
                                        {
                                            nota1.setText(" ");
                                            nota2.setText(" ");
                                        }
                                    });

                    snackbar.show();
                }
            }



    });

        return vista;
    }

}
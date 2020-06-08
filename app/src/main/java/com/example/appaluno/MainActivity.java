package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase bd = openOrCreateDatabase("dbPessoas", MODE_PRIVATE, null);


            bd.execSQL("CREATE TABLE IF NOT EXISTS tbPessoa (nome VARCHAR, idade INT(3))");

            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Renata', 46) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Pedro', 54) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Matheus', 18) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Nilda', 30) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Vitor', 15) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Guilherme', 20) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Regina', 72) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Josefa', 68) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Kaique', 10) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Gabriel', 22) ");
            bd.execSQL("INSERT INTO tbPessoas(nome,idade) VALUES ('Maria', 83) ");

            Cursor cursor =bd.rawQuery("SELECT nome, idade FROM tbPessoas", null);

            int indiceNome =cursor.getColumnIndex("nome");
            int indiceIdade =cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null){
                Log.i("Resultado do nome: ", cursor.getString(indiceNome));
                Log.i("Resultado da idade: ", cursor.getString(indiceIdade));

                cursor.moveToNext();
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }
}

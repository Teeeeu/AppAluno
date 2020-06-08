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

            SQLiteDatabase bd = openOrCreateDatabase("tbAluno", MODE_PRIVATE, null);


            bd.execSQL("CREATE TABLE IF NOT EXISTS tbAluno (nome VARCHAR, email VARCHAR, telefone VARCHAR)");

            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Renata', 'renata@hotmail.com', '9468998765')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Gabriel', 'gabriel@hotmail.com', '9468991715')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Gabriela', 'gabriela@hotmail.com', '9468968787')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Matheus', 'mrs.11@hotmail.com', '9468993776')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Guilherme', 'midas.brasil@hotmail.com', '9468298748')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Vinicius', 'vinicius1001@hotmail.com', '9468918735')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Pedro', 'pedro@hotmail.com', '9468568784')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Giovanna', 'giovanna@hotmail.com', '9878958734')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Joana', 'joana@hotmail.com', '9418588784')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Luiza', 'luiza@hotmail.com', '9466798751')");



            Cursor cursor =bd.rawQuery("SELECT nome, idade FROM tbAluno", null);

            int indiceNome =cursor.getColumnIndex("nome");
            int indiceIdade =cursor.getColumnIndex("email");
            int indiceTelefone =cursor.getColumnIndex("telefone");

            cursor.moveToFirst();

            while (cursor != null){
                Log.i("Resultado do nome: ", cursor.getString(indiceNome));
                Log.i("Resultado da idade: ", cursor.getString(indiceIdade));
                Log.i("Resultado do telefone: ", cursor.getString(indiceTelefone));

                cursor.moveToNext();
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }
}

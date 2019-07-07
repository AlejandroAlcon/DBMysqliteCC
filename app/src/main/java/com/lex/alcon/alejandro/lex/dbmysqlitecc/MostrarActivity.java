package com.lex.alcon.alejandro.lex.dbmysqlitecc;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

public class MostrarActivity extends AppCompatActivity {

    final String Descripcion[]=new String[100];

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
            listView=(ListView)findViewById(R.id.listViewDatos);



        llenar();

        DatoAdapter adapter=new DatoAdapter(this, Descripcion);
        listView.setAdapter(adapter);
    }

    public void llenar()
    {
        DataBaseHelper mydb=new DataBaseHelper(getApplicationContext());

        Cursor res=mydb.getAllData();

        if (res.getCount()==0)
        {
            Toast.makeText(this,"ERROR FATAL "+" NO SE ENCONTRO NADA",Toast.LENGTH_SHORT).show();
            return;
        }
        int j=0;
        String all="";
        while (res.moveToNext()) {

            //Hora[j]=res.getString(1);
            Descripcion[j]=res.getString(0)+" "+res.getString(1)+" "+res.getString(2)+" "+res.getString(3);
            //all=all+res.getString(0)+" "+res.getString(1)+" "+res.getString(2);
            j++;
        }
    }
}

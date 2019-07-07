package com.lex.alcon.alejandro.lex.dbmysqlitecc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper mydb;
    EditText etxtnom,etxtappat,etxtapmat;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb=new DataBaseHelper(this);

        etxtnom=(EditText)findViewById(R.id.editText);
        etxtappat=(EditText)findViewById(R.id.editText2);
        etxtapmat=(EditText)findViewById(R.id.editText3);
        id=(EditText)findViewById(R.id.editText4);

    }
    public void guardar(View v)
    {
        boolean isInsterted= mydb.insertData(etxtnom.getText().toString(),
                etxtappat.getText().toString(),
                etxtapmat.getText().toString());
        if (isInsterted)
        {
            Toast.makeText(this,"DATO INSERTADO",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"NO SE INSERTARON LOS DATOS ERROR FATAL",Toast.LENGTH_SHORT).show();
        }

    }

    public void mostrar(View v)
    {
        Intent intent=new Intent(this,MostrarActivity.class);
        startActivity(intent);
       /* Cursor res=mydb.getAllData();
        if (res.getCount()==0)
        {
            showMessage("ERROR FATAL","NO SE ENCONTRO NADA");
            return;
        }
        StringBuffer stringBuffer=new StringBuffer();
        while(res.moveToNext())
        {
            stringBuffer.append("ID : "+res.getString(0)+" \n");
            stringBuffer.append("NOMBRES : "+res.getString(1)+" \n");
            stringBuffer.append("AP PATERNO : "+res.getString(2)+" \n");
            stringBuffer.append("AP MATERNO : "+res.getString(3)+" \n\n");
            showMessage("DATOS",stringBuffer.toString());
        }
        */

    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void modificar(View v)
    {
        boolean isUpdated=mydb.updateData(id.getText().toString(),
                etxtnom.getText().toString(),
                etxtappat.getText().toString(),
                etxtapmat.getText().toString());
        if (isUpdated)
        {
            Toast.makeText(this,"DATO MODIFICADO",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"NO SE MODIFICO LOS DATOS ERROR FATAL",Toast.LENGTH_SHORT).show();
        }

    }

    public void eliminar(View v)
    {
        Integer deletedata= mydb.deleteData(id.getText().toString());
        if (deletedata>0)
        {
            Toast.makeText(this,"DATO ELIMINADO",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"NO SE ELIMINO EL DATO ERROR FATAL",Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar(View v)
    {
        id.setText("");
        etxtnom.setText("");
        etxtappat.setText("");
        etxtapmat.setText("");
    }
}

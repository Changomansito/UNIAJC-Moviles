package appg711.com.edu.uniajc.appg711;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import appg711.com.edu.uniajc.appg711.dao.DBHandler;


public class InicioAcitivity extends ActionBarActivity {

    private ListView lvContacts;
    private DBHandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_layout);

        dbhandler = new DBHandler(this);

        Bundle data = this.getIntent().getExtras();

        String username = data.get("usuario").toString();

        this.lvContacts = (ListView) this.findViewById(R.id.lvContactos);

        try {
            ArrayList contactos = dbhandler.getListaContactos();

            ArrayAdapter contactosAdapter = new ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,contactos);

            this.lvContacts.setAdapter(contactosAdapter);
        }
        catch (Exception ex){

            Toast.makeText(this.getApplicationContext(),ex.getMessage(),Toast.LENGTH_LONG).show();

        }


        //creamos la base de datos dentro del contexto actual
        dbhandler = new DBHandler(this.getApplicationContext());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio_acitivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

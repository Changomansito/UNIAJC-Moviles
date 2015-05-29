package appg711.com.edu.uniajc.appg711;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText txtLogin;
    private EditText txtPassword;


    //Event Handlers
    public  void onClickbtnLogin(View sender){
        //Toast.makeText(getApplicationContext(),"Hello world ",Toast.LENGTH_LONG).show();
        String login = txtLogin.getText().toString();
        String password = txtPassword.getText().toString();

            if(login.equals("haruiz") && password.equals("1234")){

                Intent goToHome = new Intent(this,InicioAcitivity.class);
                goToHome.putExtra("usuario", login );
                goToHome.putExtra("password", password);
                this.startActivity(goToHome);
            }
            else{
                Toast.makeText(getApplicationContext(),"Acceso denegado",Toast.LENGTH_LONG).show();
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //enlance con el control txtLogin que esta en mi layout
        txtLogin = (EditText) this.findViewById(R.id.txtLogin);
        txtPassword = (EditText) this.findViewById(R.id.txtPassword);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

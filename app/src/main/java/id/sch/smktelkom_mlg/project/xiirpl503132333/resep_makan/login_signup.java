package id.sch.smktelkom_mlg.project.xiirpl503132333.resep_makan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Priski on 11/20/2016.
 */

public class login_signup extends Activity
{
    EditText editTextUserName, editTextPassword, editTextComfirmPassword;
    Button btnCreateAccount;
    Context context = this;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextComfirmPassword = (EditText) findViewById(R.id.editTextComfirmPassword);

    btnCreateAccount = (Button) findViewById(R.id.buttonCreateAccount);
    btnCreateAccount.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            String userName = editTextUserName.getText().toString();
            String password = editTextPassword.getText().toString();
            String comfirmPassword = editTextComfirmPassword.getText().toString();
            if(userName.equals("")||password.equals("")||comfirmPassword.equals("")){
                Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                return;
            }
            if (!password.equals(comfirmPassword)){
                Toast.makeText(getApplicationContext(),"Password does not match", Toast.LENGTH_LONG).show();
                return;
            }else {
                loginDataBaseAdapter.insertEntry(userName, password);
                Toast.makeText(getApplicationContext(), "Account Successfully Create", Toast.LENGTH_LONG).show();
                Intent i = new Intent(login_signup.this, Home.class);
                startActivity(i);
                finish();
            }

        }
    });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}

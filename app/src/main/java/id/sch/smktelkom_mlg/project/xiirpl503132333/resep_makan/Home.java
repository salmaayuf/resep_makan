package id.sch.smktelkom_mlg.project.xiirpl503132333.resep_makan;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Priski on 11/20/2016.
 */

public class Home extends Activity
{
    Button btnSignIn, btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        btnSignIn = (Button) findViewById(R.id.buttonSignIn);
        btnSignUp = (Button) findViewById(R.id.buttonSignUP);

        btnSignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentSignUP = new Intent(getApplicationContext(),
                        login_signup.class);
                startActivity(intentSignUP);
            }
        });
    }

    public void signIn(View v)
    {
        final Dialog dialog = new Dialog(Home.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");
        final EditText editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword = (EditText) dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                String storedPassword = loginDataBaseAdapter.getSignInEntry(userName);
                if (password.equals(storedPassword)){
                    Toast.makeText(Home.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
    Intent main = new Intent(Home.this, MainActivity.class);
    startActivity(main);
}else {
        Toast.makeText(Home.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
        }
        }
        });

        dialog.show();
        }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        loginDataBaseAdapter.close();
    }
}

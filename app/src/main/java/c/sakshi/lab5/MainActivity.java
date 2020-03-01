package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){
        EditText myTextField= (EditText) findViewById(R.id.userName);
        String str = myTextField.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", str).apply();

        goToActivity2(str);
    }

    public void goToActivity2(String s){
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("message", s);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        if(!username.equals("")){
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        }else{
            setContentView(R.layout.activity_main);
        }

    }
}

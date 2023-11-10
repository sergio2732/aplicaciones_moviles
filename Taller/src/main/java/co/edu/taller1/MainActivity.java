package co.edu.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnMainPunto1;
    private Button btnMainPunto2;
    private Button btnMainPunto3;
    private Button btnMainPunto4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin();
        this.btnMainPunto2.setOnClickListener(this::irPunto2);
    }

    private void irPunto2(View view) {
        Intent irPunto2 = new Intent(getApplicationContext(), MainPunto2.class);
        startActivity(irPunto2);
    }

    private void begin(){
        this.btnMainPunto1 = findViewById(R.id.btnMainPunto1);
        this.btnMainPunto2 = findViewById(R.id.btnMainPunto2);
        this.btnMainPunto3 = findViewById(R.id.btnMainPunto3);
        this.btnMainPunto4 = findViewById(R.id.btnMainPunto4);
    }
}
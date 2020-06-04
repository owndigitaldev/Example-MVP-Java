package id.owndigital.mvpexamplejava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.owndigital.mvpexamplejava.model.MainPresenterImp;
import id.owndigital.mvpexamplejava.presenter.MainPresenter;
import id.owndigital.mvpexamplejava.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {

    // var presenter
    MainPresenter presenter;

    private EditText edFirstName, edLastName;
    private Button btnAdd, btnShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edFirstName = findViewById(R.id.edFirstName);
        edLastName = findViewById(R.id.edLastName);
        btnAdd = findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnShow);

        presenter = new MainPresenterImp(MainActivity.this);

        // event click listener pada btnAdd
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // memanggil method addData pada presenter
                presenter.addData(edFirstName.getText().toString(),edLastName.getText().toString());
            }
        });

        // event click listener pada btnShow
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // memanggil method loadData pada presenter
                presenter.loadData();
            }
        });
    }

    // view menampilkan pesan toast
    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    // view menampilkan data
    @Override
    public void showData(String data) {
        // meanmpilkan data pada dialog
        new AlertDialog.Builder(this)
                .setTitle("Data")
                .setMessage(data)
                .setPositiveButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.dismiss();
                    }
                });
        Log.e("data", data);
    }

    // view utk clear edittext
    @Override
    public void clearField() {
        edFirstName.setText("");
        edLastName.setText("");
    }
}

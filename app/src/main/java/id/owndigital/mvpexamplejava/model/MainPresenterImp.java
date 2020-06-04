package id.owndigital.mvpexamplejava.model;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;

import id.owndigital.mvpexamplejava.presenter.MainPresenter;
import id.owndigital.mvpexamplejava.view.MainView;

public class MainPresenterImp implements MainPresenter {


    private MainView view;

    // sebuah arraylist utk menampung data
    private ArrayList<HashMap<String, String>> DATA;

    public MainPresenterImp( MainView view) {
        this.view = view;
        this.DATA = new ArrayList<>();
    }

    // overide mthod add data yang ada pada interface presenter
    @Override
    public void addData(String firstName, String lastName) {
        if (firstName.isEmpty() || lastName.isEmpty()){
            // meamanggil view untuk menampilkan pesan saat salah satu dari edittext kosong
            view.showMessage("Field tidak boleh kosong");
        }else{
            //hashmap
            HashMap<String, String> map = new HashMap<String, String>();

            // menambahkan 2 value pada hashmap
            map.put("firstname",firstName);
            map.put("lastname",lastName);

            // data hashmap yang telah diisi value ditampung ke arraylist
            DATA.add(map);

            // memanggil view untuk menampilkan pesan saat data ditambahkan
            view.showMessage("Data ditambahkan");

            // memanggil view untuk clear edittext
            view.clearField();
        }
    }

    @Override
    public void loadData() {
        if(DATA.size() == 0){
            // memanggil view untuk menampilkan pesan saat data pada arraylist masih kosong
            view.showMessage("Data kosong");
        }else{

            // sebuah variable string dengan nama allData
            String allData = "";

            // melakukan for loop untuk mengisi sebuah variabel allData dengan setiap value yang ada pada arraylist
            for(int i=0;i<DATA.size();i++){
                allData += "Nama Depan : "+ DATA.get(i).get("firstname")+"\nNama Belakang : "+ DATA.get(i).get("lastname")+"\n\n";
            }

            // menampilkan jumlah value yang ada pada arraylist
            allData += "Total : "+DATA.size();

            // memanggil view untuk menampilkan data
            view.showData(allData);

        }
    }
}
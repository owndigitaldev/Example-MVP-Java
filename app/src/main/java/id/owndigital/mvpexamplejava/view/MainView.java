package id.owndigital.mvpexamplejava.view;

public interface MainView {

    // method utk menampilkan pesan toast
    void showMessage(String message);

    // method utk menampilkan data yang telah diproses pada presenter
    void showData(String data);

    // method utk clear edittext
    void clearField();
}

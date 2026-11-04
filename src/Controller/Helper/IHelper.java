package Controller.Helper;

public interface IHelper<T> {
    T obterModelo();
    void setarModelo(T modelo);
    void limparTela();
}

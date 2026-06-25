import java.util.List;

public interface Facturador {
    void generarFactura(String cliente, List<LineaPedido> lineas, double subtotal, double desc, double imp,double total);
}
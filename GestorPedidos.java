// GestorPedidos.java
import java.util.List;

public class GestorPedidos {
    private final PedidoRepository repository;
    private final Facturador facturador;
    private final Notificador notificador;

    // Las dependencias se inyectan, no se crean aquí
    public GestorPedidos(PedidoRepository repository, Facturador facturador, Notificador notificador) {
        this.repository = repository;
        this.facturador = facturador;
        this.notificador = notificador;
    }

    public void procesarPedido(Cliente cliente, List<LineaPedido> lineas) {
        double subtotal = lineas.stream().mapToDouble(LineaPedido::getSubtotal).sum();
        double descuento = Descuento.obtenerDescuento(cliente.getTipo(), subtotal);
        double impuesto = (subtotal - descuento) * 0.12;
        double total = subtotal - descuento + impuesto;

        repository.guardar(cliente.getNombre(), total);
        facturador.generarFactura(cliente.getNombre(), lineas, subtotal, descuento, impuesto, total);
        
        notificador.enviarCorreo(cliente.getEmail(), 
            "Confirmación de pedido", 
            "Estimado " + cliente.getNombre() + ", su pedido por $" + total + " ha sido procesado.");
    }

    public void cancelarPedido(Cliente cliente, int idPedido) {
        repository.eliminar(idPedido);
        notificador.enviarCorreo(cliente.getEmail(), 
            "Cancelación de pedido", 
            "Estimado " + cliente.getNombre() + ", su pedido #" + idPedido + " ha sido cancelado.");
    }
}
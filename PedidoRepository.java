public interface PedidoRepository {
    void guardar(String cliente, double total);

    void eliminar(int idPedido);
}
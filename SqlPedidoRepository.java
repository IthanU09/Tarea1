import java.sql.*;

public class SqlPedidoRepository implements PedidoRepository {
    private final Connection conexion;

    public SqlPedidoRepository(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void guardar(String cliente, double total) {
        String sql = "INSERT INTO pedidos (cliente, total) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente);
            stmt.setDouble(2, total);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int idPedido) {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idPedido);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        }
    }
}
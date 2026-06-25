public class Descuento {
    public static double obtenerDescuento(String tipoCliente, double subtotal) {
        switch (tipoCliente) {
            case "VIP": return subtotal * 0.20;
            case "FRECUENTE": return subtotal * 0.10;
            case "REGULAR": return subtotal * 0.05;
            default: return 0.0;
        }
    }
}

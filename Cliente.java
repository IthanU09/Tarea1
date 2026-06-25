public class Cliente {
    private String nombre;
    private String email;
    private String tipo;

    public Cliente(String nombre, String email, String tipo) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("Nombre inválido");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Email inválido");
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTipo() {
        return tipo;
    }
}
package co.edu.unipiloto.loginsqlite;

public class Usuarios {
    private String nombreCompleto;
    private String usuarioRegistrado;
    private String correo;
    private String fecha;
    private String contrasena;
    private String confirmarContrasena;
    private String sexo;

    public Usuarios(String nombreCompleto, String usuarioRegistrado, String correo, String fecha, String contrasena, String confirmarContrasena, String sexo) {
        this.nombreCompleto = nombreCompleto;
        this.usuarioRegistrado = usuarioRegistrado;
        this.correo = correo;
        this.contrasena = contrasena;
        this.confirmarContrasena = confirmarContrasena;
        this.sexo = sexo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public void setUsuarioRegistrado(String usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmarContrasena() {
        return confirmarContrasena;
    }

    public void setConfirmarContrasena(String confirmarContrasena) {
        this.confirmarContrasena = confirmarContrasena;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

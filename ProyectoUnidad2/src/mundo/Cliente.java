package mundo;

public class Cliente {

	private String nombre;
    private int edad;
    private String cedula;
    private String correoElectronico;
    private String numeroTelefono;
    
    private String apellido;

    public Cliente(String nombre,String apellido, String cedula, int edad, String correoElectronico, String numeroTelefono) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
    }

    // Métodos getters y setters para los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

	@Override
	public String toString() {
		return "--Datos de Cliente-- [\n Nombre= " + nombre + "\n Apellido= " + apellido + ",\n Edad= " + edad + ",\n Cedula= " + cedula + ",\n Correo electronico= "
				+ correoElectronico + ",\n Numero de telefono= " + numeroTelefono + "]";
	}

}



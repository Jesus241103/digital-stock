
package object;


public class User_sesion {
    private String nombre, rol;
    private int cedula;

    public User_sesion(){
    }
    public User_sesion(String nombre, int cedula, String rol){
        this.nombre=nombre;
        this.cedula=cedula;
        this.rol=rol;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    
    
    
}

package parciales;

public class Cliente {
    long cedula;

    public Cliente(long cedula) {
        this.cedula = cedula;
    }

    public long getCedula() {
        return cedula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cedula == cliente.cedula;
    }
}

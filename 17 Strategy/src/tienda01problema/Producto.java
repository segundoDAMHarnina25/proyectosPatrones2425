package tienda01problema;

public class Producto {
    private String nombre;
    private double precio;
    private String tipoDescuento;
    private double valorDescuento;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Método para establecer el tipo de descuento
    public void setDescuento(String tipoDescuento, double valorDescuento) {
        this.tipoDescuento = tipoDescuento;
        this.valorDescuento = valorDescuento;
    }

    public double calcularPrecioFinal() {
        double precioFinal = precio;

        if ("fijo".equals(tipoDescuento)) {
            precioFinal -= valorDescuento;
        } else if ("porcentaje".equals(tipoDescuento)) {
            precioFinal -= precio * (valorDescuento / 100);
        } else if ("temporada".equals(tipoDescuento)) {
            // Suponiendo que verificamos la temporada dentro de este mismo método
            boolean esTemporada = true; // Simplificación para el ejemplo
            if (esTemporada) {
                precioFinal -= valorDescuento;
            }
        }

        return precioFinal > 0 ? precioFinal : 0; // Evitar precios negativos
    }
    public static void main(String[] args) {
        Producto producto = new Producto("Televisor", 1000.0);

        // Aplicando un descuento fijo
        producto.setDescuento("fijo", 50.0);
        System.out.println("Precio con descuento fijo: " + producto.calcularPrecioFinal());

        // Aplicando un descuento porcentual
        producto.setDescuento("porcentaje", 10.0);
        System.out.println("Precio con descuento porcentual: " + producto.calcularPrecioFinal());

        // Aplicando un descuento de temporada
        producto.setDescuento("temporada", 200.0);
        System.out.println("Precio con descuento de temporada: " + producto.calcularPrecioFinal());
    }
}

package tienda01enum;

//Clase Producto que utiliza la estrategia de descuento
class Producto {
 private String nombre;
 private double precio;

 public Producto(String nombre, double precio) {
     this.nombre = nombre;
     this.precio = precio;
 }

 public double calcularPrecioFinal(Descuento descuento) {
    return descuento.aplicarDescuento(precio);
 }
}
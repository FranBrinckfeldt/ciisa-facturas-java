package facturas;

import java.util.ArrayList;

public class Factura {

    private Cabecera cabecera;
    ArrayList<Detalle> detalles = new ArrayList<>();

    public Factura(Cabecera cabecera, ArrayList<Detalle> detalles) {
        this.cabecera = cabecera;
        this.detalles = detalles;
    }

    public Cabecera getCabecera() {
        return cabecera;
    }

    public void setCabecera(Cabecera cabecera) {
        this.cabecera = cabecera;
    }

    public ArrayList<Detalle> getDetalle() {
        return detalles;
    }

    public void setDetalle(Detalle detalle) {
        this.detalles.add(detalle);
    }

    private String formaDePago(int formaPago) {
        String formaDePago = " ";
        switch (formaPago) {
            case 1:
                formaDePago = "Efectivo";
                break;
            case 2:
                formaDePago = "TC";
                break;
            case 3:
                formaDePago = "TD";
                break;
            case 4:
                formaDePago = "Transferencia";
                break;
            case 5:
                formaDePago = "Chirlitos";
                break;
        }
        return formaDePago;
    }

    public void mostrarFactura() {
        System.out.println(" ");
        System.out.print("Número de Factura:  ");
        System.out.println(cabecera.getNumeroFactura());
        System.out.print("Nombre de Cliente:  ");
        System.out.println(cabecera.getNombreCliente());
        System.out.print("RUT de Cliente:     ");
        System.out.println(cabecera.getRutCliente());
        System.out.print("Fecha de Emisión:   ");
        System.out.println(cabecera.getFechaEmision());
        System.out.print("Forma de Pago:      ");
        System.out.println(this.formaDePago(cabecera.getFormaPago()));
        System.out.print("Monto Bruto:        ");
        System.out.println(cabecera.getTotalBruto());
        System.out.print("IVA (19%):          ");
        System.out.println(cabecera.getIva());
        System.out.print("TOTAL FACTURA:      ");
        System.out.println(cabecera.getTotalCompra());

        int contador = 1;
        String leftAlignFormat = "| %-3d | %-20s | %-3d | %-20g | %-20g |%n";

        System.out.format("+-----+----------------------+-----+----------------------+----------------------+%n");
        System.out.format("|     | PRODUCTO             |  Q  |           P          |         P*Q          |%n");
        System.out.format("+-----+----------------------+-----+----------------------+----------------------+%n");
        for (Detalle detalle: detalles) {
            System.out.format(leftAlignFormat, contador, detalle.getNombreProducto(), detalle.getCantidad(), detalle.getPrecioUnitario(), detalle.getMontoTotal());
            contador++;
        }
        System.out.format("+-----+----------------------+-----+----------------------+----------------------+%n");

        System.out.print("Número de Factura:  ");
        System.out.println(cabecera.getNumeroFactura());
        System.out.print("Nombre de Cliente:  ");
        System.out.println(cabecera.getNombreCliente());
        System.out.print("Fecha de Emisión:   ");
        System.out.println(cabecera.getFechaEmision());
        System.out.println(" ");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
    }
}

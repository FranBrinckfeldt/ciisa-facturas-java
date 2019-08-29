package facturas;

import java.util.ArrayList;

public class FacturaFactory {

    ArrayList<Factura> facturas = new ArrayList<>();

    int numeroFactura = 20190001;

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    private double calcularTotalBruto(ArrayList<Detalle> detalles) {
        double montoBruto = 0;
        for (Detalle detalle: detalles) {
            montoBruto = montoBruto + detalle.getMontoTotal();
        }
        return montoBruto;
    }

    public void registrarFactura(String nombreCliente, String rutCliente, String fechaEmision, int formaPago, ArrayList<Detalle> detalles) {
        Cabecera cabecera = new Cabecera(numeroFactura, nombreCliente, rutCliente, fechaEmision, formaPago, calcularTotalBruto(detalles));
        Factura factura = new Factura(cabecera, detalles);
        this.facturas.add(factura);
        this.numeroFactura++;
    }

    public void mostrarFacturas() {
        for (Factura factura: facturas) {
            factura.mostrarFactura();
        }
    }

    public void calcularTotalFacturas() {
        int contador = 0;
        for (Factura factura: facturas) {
            contador++;
        }
        System.out.println("La cantidad total de facturas emitidas es de: " + contador);
    }

    public void calcularMontoBrutoTotalFacturado() {
        double montoBruto = 0;
        for (Factura factura: facturas) {
            montoBruto = factura.getCabecera().getTotalBruto() + montoBruto;
        }
        System.out.println("El monto bruto total facturado es de: " + montoBruto);
    }

    public void calcularMontoTotalIVAFacturado() {
        double montoIVA = 0;
        for (Factura factura: facturas) {
            montoIVA = factura.getCabecera().getIva() + montoIVA;
        }
        System.out.println("El monto total de IVA facturado es de: " + montoIVA);
    }

    public void calcularMontoTotalFacturado() {
        double montoTotal = 0;
        for (Factura factura: facturas) {
            montoTotal = factura.getCabecera().getTotalCompra() + montoTotal;
        }
        System.out.println("El monto total facturado es de: " + montoTotal);
    }
}

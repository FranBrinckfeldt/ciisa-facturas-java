package facturas;

import java.util.ArrayList;

public class Cabecera {

    private int numeroFactura;
    private String nombreCliente;
    private String rutCliente;
    private String fechaEmision;
    private int formaPago;
    private double iva;
    private double totalBruto;
    private double totalCompra;

    public Cabecera(int numeroFactura, String nombreCliente, String rutCliente, String fechaEmision, int formaPago, double totalBruto) {
        this.numeroFactura = numeroFactura;
        this.nombreCliente = nombreCliente;
        this.rutCliente = rutCliente;
        this.fechaEmision = fechaEmision;
        this.formaPago = formaPago;
        this.totalBruto = totalBruto;
        this.iva = totalBruto * 0.19;
        this.totalCompra = totalBruto + iva;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(double totalBruto) {
        this.totalBruto = totalBruto;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public double calcularIVA() {
        iva = (totalBruto * 0.19);
        return iva;
    }

    public double calcularTotalCompra() {
        totalCompra = iva + totalBruto;
        return totalCompra;
    }

}

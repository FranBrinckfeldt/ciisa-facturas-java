package vista;

import facturas.Detalle;
import facturas.FacturaFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        //Factory Method.
        FacturaFactory evilCorp = new FacturaFactory();

        //Inicialización de variables.
        int opcion = 0;
        boolean error = false;
        String nombreCliente = "";
        String rut = "";
        String fecha = "";
        int formaPago = 0;
        int ingresoProductos = 0;
        String nombreProducto = "";
        int cantidad = 0;
        double precioUnitario = 0;

        do {
            System.out.println("----- MENÚ -----");
            System.out.println("1: Nueva factura.");
            System.out.println("2: Mostrar facturas en sistema.");
            System.out.println("3: Salir y mostrar resumen de las facturas emitidas.");

            do {
                try {
                    opcion = leer.nextInt();
                    if(opcion == 1 || opcion == 2 || opcion == 3) {
                        error = false;
                    } else {
                        System.out.println("Ingrese una opción válida");
                        error = true;
                    }
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida");
                    error = true;
                    leer.next();
                }
            } while(error);

            leer.nextLine();

            switch(opcion) {
                case 1:
                    System.out.println(" ");
                    System.out.println("----- NUEVA FACTURA -----");

                    System.out.print("Ingrese el nombre del cliente: ");
                    do {
                        try {
                            nombreCliente = leer.nextLine();
                            error = false;
                        } catch (Exception e) {
                            System.out.println("Ingrese un nombre válido");
                            error = true;
                            leer.next();
                        }
                    } while(error);

                    System.out.print("Ingrese RUT del cliente: ");
                    do {
                        try {
                            rut = leer.next();
                            error = false;
                        } catch (Exception e) {
                            System.out.println("Ingrese un RUT válido");
                            error = true;
                            leer.next();
                        }
                    } while(error);

                    System.out.print("Ingresar fecha de emisión: ");
                    do {
                        try {
                            fecha = leer.next();
                            error = false;
                        } catch (Exception e) {
                            System.out.println("Ingrese una fecha válida");
                            error = true;
                            leer.next();
                        }
                    } while(error);

                    System.out.println("Seleccione forma de pago: ");
                    System.out.println("1: Efectivo.");
                    System.out.println("2: TC.");
                    System.out.println("3: TD.");
                    System.out.println("4: Transferencia.");
                    System.out.println("5: Chirlitos.");

                    do {
                        try {
                            formaPago = leer.nextInt();
                            if(formaPago == 1 || formaPago == 2 || formaPago == 3 || formaPago == 4 || formaPago == 5) {
                                error = false;
                            } else {
                                System.out.println("Ingrese una opción válida");
                                error = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Ingrese una opción válida");
                            error = true;
                            leer.next();
                        }
                    } while(error);

                    ArrayList<Detalle> detalles = new ArrayList<>();

                    do {
                        System.out.println("Ingresar los productos: ");
                        System.out.println("1: Ingresar producto.");
                        System.out.println("2: No ingresar más productos.");
                        do {
                            try {
                                ingresoProductos = leer.nextInt();
                                if (ingresoProductos == 1 || ingresoProductos == 2) {
                                    error = false;
                                } else {
                                    System.out.println("Ingrese una opción válida");
                                    error = true;
                                }
                            } catch (Exception e) {
                                System.out.println("Ingrese una opción válida");
                                error = true;
                                leer.next();
                            }
                        } while(error);


                        switch (ingresoProductos) {
                            case 1:
                                System.out.print("Ingrese el nombre del producto: ");
                                do {
                                    try {
                                        nombreProducto = leer.next();
                                        error = false;
                                    } catch (Exception e) {
                                        System.out.println("Ingrese un nombre de producto válido");
                                        error = true;
                                        leer.next();
                                    }
                                } while(error);

                                System.out.print("Ingrese la cantidad de este tipo de producto: ");
                                do {
                                    try {
                                        cantidad = leer.nextInt();
                                        if (cantidad <= 0) {
                                            error = true;
                                        } else {
                                            error = false;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Ingrese una cantidad válida");
                                        error = true;
                                        leer.next();
                                    }
                                } while(error);

                                System.out.print("Ingrese precio unitario: ");
                                do {
                                    try {
                                        precioUnitario = leer.nextDouble();
                                        if (precioUnitario < 0) {
                                            error = true;
                                        } else {
                                            error = false;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Ingrese un precio unitario válido");
                                        error = true;
                                        leer.next();
                                    }
                                } while(error);

                                detalles.add(new Detalle(nombreProducto, cantidad, precioUnitario));
                                break;
                        }
                    } while (ingresoProductos != 2);

                    evilCorp.registrarFactura(nombreCliente, rut, fecha, formaPago, detalles);

                    break;
                case 2:
                    System.out.println("----- FACTURAS EN SISTEMA -----");
                    evilCorp.mostrarFacturas();
                    break;
                case 3:
                    System.out.println("----- RESUMEN DE LAS FACTURAS EMITIDAS -----");
                    evilCorp.calcularTotalFacturas();
                    evilCorp.calcularMontoBrutoTotalFacturado();
                    evilCorp.calcularMontoTotalIVAFacturado();
                    evilCorp.calcularMontoTotalFacturado();
                    break;
            }
        } while(opcion != 3);
    }
}

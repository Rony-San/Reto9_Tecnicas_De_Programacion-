/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.reto9;
import java.io.BufferedWriter;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ronys
 */
public class NewMain {

    public static void main(String[] args) {
        // Rutas del archivo excel y del archivo de destino
        String rutaDatos = ("C:\\Users\\ronys\\OneDrive\\Escritorio\\RETO 9\\ETH-USD.csv");
        String rutaArchivo = ("C:\\Users\\ronys\\OneDrive\\Escritorio\\RETO 9\\resultado.txt");
        String salida;

        // listas donde vamos a guardar los elementos por separado 
        List<String> elementos;
        List<String> fechas = new ArrayList<>();
        List<Double> preciosDeCierre = new ArrayList<>();
        List<String> volumenTransado = new ArrayList<>();

        List<String> lineasArchivo;

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(rutaArchivo))) {

            // Leemos el archivo, separamos la informacion y la guardamos en las listas 
            lineasArchivo = Files.readAllLines(Paths.get(rutaDatos));
            lineasArchivo.remove(0);
            writer.write("fecha" + "     " + "Open" + "\n");

            for (String linea : lineasArchivo) {
                // organizamos la informacion de fecha y la clasificacion del precio de apertura para escribir en el nuevo archivo
                String data[] = linea.split(",");
                elementos = Arrays.asList(data);
                salida = elementos.get(0) + "     " + funciones.ClasificacionDeprecioApertura(elementos.get(1)) + "\n";
                writer.write(salida);

                fechas.add(elementos.get(0));
                preciosDeCierre.add(parseDouble(elementos.get(4)));
                volumenTransado.add(elementos.get(6));

            }
        } catch (IOException e) {
            System.err.println("Se produjo un error");
        }

        // información pedida punto 2 y 3
        System.out.println("El promecio del precio de cierre es " + funciones.calcularMedia(preciosDeCierre));
        System.out.println("La desviacion estandar del precio de cierre es " + funciones.calcularDesviacionEst(preciosDeCierre));
        System.out.println("El volumen transado más alto de Ethereum es: " + Collections.max(volumenTransado) + " en " + fechas.get(volumenTransado.indexOf(Collections.max(volumenTransado))));
        System.out.println("El volumen transado más alto de Ethereum es: " + Collections.min(volumenTransado) + " en " + fechas.get(volumenTransado.indexOf(Collections.min(volumenTransado))));

        // Punto 4
        Double[] array = {5.548, 3.57, 42.5};
        List<Double> listaInicial = new ArrayList<>();
        List<Double> listaFinal;
        Collections.addAll(listaInicial, array);
        listaFinal = funciones.raiz(listaInicial);
        listaFinal.forEach(e -> System.out.println(e));

        // Punto5
        Set<String> set = new HashSet<String>();
        set.add("punto");
        set.add("quinto");
        set.add("tecnicas");
        set.add("de");
        set.add("programacion");
        List<String> listaFinalQuinto;
        listaFinalQuinto = funciones.filtroCaracteres(set);
        listaFinalQuinto.forEach(e -> System.out.println(e));
    }

}

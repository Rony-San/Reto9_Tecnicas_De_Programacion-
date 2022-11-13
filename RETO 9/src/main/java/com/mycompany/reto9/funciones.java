/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto9;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author ronys
 */
public class funciones {
    
    public static List<Double> raiz(List<Double> listaIn) {

        return listaIn.stream().map(e -> Math.sqrt(e)).collect(Collectors.toList());

    }

    public static List<String> filtroCaracteres(Set<String> setsActual) {

        return setsActual.stream().filter(e -> e.length() >= 5).collect(Collectors.toList());
    }

    public static String precioApertura(String precio) {
        double precioActual = Double.parseDouble(precio);
        if (precioActual < 1200) {
            return "MUY BAJO";
        }
        if (precioActual >= 1200 && precioActual < 2100) {
            return "BAJO";
        }
        if (precioActual >= 2100 && precioActual < 3100) {
            return "MEDIO";
        }
        if (precioActual >= 3100 && precioActual < 4600) {
            return "ALTO";
        }
        if (precioActual >= 4600) {
            return "MUY ALTO";
        }
        return "--";
    }

    public static double calcularMedia(List<Double> elementos) {
        double suma = 0;
        for (double elemento : elementos) {
            suma += elemento;
        }
        return suma / elementos.size();
    }

    public static double calcularDesviacionEst(List<Double> elementos) {
        double promedio = calcularMedia(elementos);
        double sumatoria = 0;
        for (double elem : elementos) {
            sumatoria += Math.pow(elem - promedio, 2);
        }
        double resultado = Math.sqrt(sumatoria / (elementos.size() - 1));
        return resultado;
    }
}

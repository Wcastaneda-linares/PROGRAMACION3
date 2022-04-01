/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploColecciones;

import pkg.ListaPuntos.ClsAlumno;
import pkg.ListaPuntos.ClsLista;
import pkg.ListaPuntos.Nodo;

/**
 *
 * @author Wcastañeda
 */
public class Principal {

    public static void main(String[] args) {
        ClsLista list = new ClsLista();//instanciamos y creamos lista vacia

        Nodo ultimo = null;

        ClsAlumno alumnoInsertarCabeza = new ClsAlumno();
        alumnoInsertarCabeza.setCarnet("101010");
        alumnoInsertarCabeza.setNombre("wagner");
        alumnoInsertarCabeza.setPromedio(65.1);
        list.insertarCabezaLista(alumnoInsertarCabeza);

        ClsAlumno alumnoInsertarCabeza2 = new ClsAlumno();
        alumnoInsertarCabeza2.setCarnet("202020");
        alumnoInsertarCabeza2.setNombre("Julio");
        alumnoInsertarCabeza2.setPromedio(70.2);
        list.insertarCabezaLista(alumnoInsertarCabeza2);

        ClsAlumno alumnoInsertarCabeza3 = new ClsAlumno();
        alumnoInsertarCabeza3.setCarnet("303030");
        alumnoInsertarCabeza3.setNombre("Juan");
        alumnoInsertarCabeza3.setPromedio(80.3);
        list.insertarCabezaLista(alumnoInsertarCabeza3);
        
        
        
        ClsAlumno alumnoInsertarCola = new ClsAlumno();
        alumnoInsertarCola.setCarnet("111111");
        alumnoInsertarCola.setNombre("wilson");
        alumnoInsertarCola.setPromedio(81.1);
        list.insertarUltimo(ultimo, alumnoInsertarCola);

        ClsAlumno alumnoInsertarCola2 = new ClsAlumno();
        alumnoInsertarCola2.setCarnet("121212");
        alumnoInsertarCola2.setNombre("Jorge");
        alumnoInsertarCola2.setPromedio(82.2);
        list.insertarUltimo(ultimo, alumnoInsertarCola2);

        ClsAlumno alumnoInsertarCola3 = new ClsAlumno();
        alumnoInsertarCola3.setCarnet("131313");
        alumnoInsertarCola3.setNombre("Jhony");
        alumnoInsertarCola3.setPromedio(83.3);
        list.insertarUltimo(ultimo, alumnoInsertarCola3);
        list.visualizar();

        Nodo nodo = new Nodo();
        nodo = list.buscarLista("111111");
        System.out.println("PROCESO DE BUSCAR ALUMNO");
        System.out.println(nodo.getDato());

        System.out.println("PROCESO DE ELIMINAR ALUMNO");
        String carnet = "111111";
        nodo = list.buscarLista(carnet);
        list.eliminar(carnet);
        System.out.println("Alumno a Eliminar" + nodo.getDato() + "\n");
        System.out.println("Lista Nueva de Alumnos");
        list.visualizar();

    }
}

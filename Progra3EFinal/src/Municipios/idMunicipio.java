/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Municipios;

/**
 *
 * @author Wcastañeda
 */
public class idMunicipio {

    public char MunicipiosJutiapa(String op) {
        char id = '&';
        switch (op) {
            case "Jutiapa":
                id = 'a';
                break;
            case "El Progreso":
                id = 'b';
                break;
            case "Santa Catarina Mita":
                id = 'c';
                break;
            case "Agua Blanca":
                id = 'd';
                break;
            case "Asunción Mita":
                id = 'e';
                break;
            case "Yupiltepeque":
                id = 'f';
                break;
            case "Atescatempa":
                id = 'g';
                break;
            case "Jerez":
                id = 'h';
                break;
            case "El Adelanto":
                id = 'i';
                break;
            case "Zapotitlán":
                id = 'j';
                break;
            case "Comapa":
                id = 'k';
                break;
            case "Jalpatagua":
                id = 'l';
                break;
            case "Conguaco":
                id = 'm';
                break;
            case "Moyuta":
                id = 'n';
                break;
            case "Pasaco":
                id = 'o';
                break;
            case "San José Acatempa":
                id = 'p';
                break;
            case "Quezada":
                id = 'g';
                break;
        }

        return id;

    }
}

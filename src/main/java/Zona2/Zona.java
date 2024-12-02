/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Zona2;

public class Zona {
    private String idZona;
    private String distrito;
    private char disponibilidad;
    private double area;
    private int poblacion;

    // Constructor
    public Zona(String idZona, String distrito, char disponibilidad, double area, int poblacion) {
        this.idZona = idZona;
        this.distrito = distrito;
        this.disponibilidad = disponibilidad;
        this.area = area;
        this.poblacion = poblacion;
    }

    // Getters y Setters
    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public char getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(char disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Zona{" +
                "idZona='" + idZona + '\'' +
                ", distrito='" + distrito + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", area=" + area +
                ", poblacion=" + poblacion +
                '}';
    }
}

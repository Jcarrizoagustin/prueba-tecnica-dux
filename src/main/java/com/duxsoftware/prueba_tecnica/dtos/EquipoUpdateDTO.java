package com.duxsoftware.prueba_tecnica.dtos;

public class EquipoUpdateDTO {

    private String nombre;
    private String liga;
    private String pais;

    public EquipoUpdateDTO() {}

    public EquipoUpdateDTO(String nombre, String liga, String pais) {
        this.nombre = nombre;
        this.liga = liga;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "EquipoUpdateDTO{" +
                "nombre='" + nombre + '\'' +
                ", liga='" + liga + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

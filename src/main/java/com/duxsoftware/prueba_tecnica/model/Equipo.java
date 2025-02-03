package com.duxsoftware.prueba_tecnica.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipo {

    @Schema(example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(example = "Barcelona FC")
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Schema(example = "La Liga")
    @Column(name = "liga", nullable = false)
    private String liga;
    @Schema(example = "España")
    @Column(name = "pais", nullable = false)
    private String pais;

    public Equipo() {
    }

    public Equipo(Long id, String nombre, String liga, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.liga = liga;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", liga='" + liga + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

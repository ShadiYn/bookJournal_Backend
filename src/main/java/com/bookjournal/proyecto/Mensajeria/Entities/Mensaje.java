package com.bookjournal.proyecto.Mensajeria.Entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "remitente_id")
    private Usuario remitente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Usuario destinatario;

    private String texto;

    @Transient
    private Integer[] ids = new Integer[0]; // Inicializar como un arreglo vacío

    // Método para obtener el nombre del remitente
    public String getRemitenteNombre() {
        return remitente != null ? remitente.getNombre() : null; // Retorna el nombre del remitente
    }

    // Método para obtener el ID del remitente
    public Long getRemitenteId() {
        return remitente != null ? remitente.getId() : null;
    }

    // Método para obtener el ID del destinatario
    public Long getDestinatarioId() {
        return destinatario != null ? destinatario.getId() : null;
    }

    // Métodos getter y setter adicionales
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }
}

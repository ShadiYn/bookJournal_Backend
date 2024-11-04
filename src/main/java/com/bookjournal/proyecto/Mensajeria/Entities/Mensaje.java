// Mensaje.java
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "remitente_id", nullable = false)
    private Usuario remitente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destinatario_id", nullable = false)
    @JsonIgnoreProperties({"mensajesEnviados", "mensajesRecibidos"})
    private Usuario destinatario;

    private String texto;



    @Transient
    private Integer[] ids = new Integer[0]; // Inicializar como un arreglo vacío

    public String getRemitenteNombre() {
        return remitente != null ? remitente.getNombre() : null; // Retorna el nombre del remitente
    }

    public Integer getDestinatarioId() {
        return destinatario != null ? destinatario.getId() : null; // Retorna el ID del destinatario
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

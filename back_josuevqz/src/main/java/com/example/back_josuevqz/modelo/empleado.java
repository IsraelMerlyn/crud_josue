package com.example.back_josuevqz.modelo;


import javax.persistence.*;

@Entity
//agregamos el nombre de la tabla para relacionarla
@Table (name = "informacion")
public class empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    declaramos Column ya que especificamos la columna de la tabla correspondiente
    declaramos unique que el nombre va ser unico
    declaramos length para el maximo del nombre o localidad
    */
    @Column(name = "nombre", length = 60,unique = true)
    private  String nombre;
    @Column(name = "localidad",length = 160)
    private  String localidad;
    @Column(name = "municipio",length = 160)
    private  String municipio;

    @Column(name = "cp",length = 160)
    private  String cp;

    @Column(name = "idioma",length = 160)
    private  String idoma;

    @Column(name = "pais",length = 160)
    private  String pais;



    public empleado() {
    }

    public empleado(Long id, String nombre, String localidad, String municipio, String cp, String idoma, String pais) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.municipio = municipio;
        this.cp = cp;
        this.idoma = idoma;
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getIdoma() {
        return idoma;
    }

    public void setIdoma(String idoma) {
        this.idoma = idoma;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}

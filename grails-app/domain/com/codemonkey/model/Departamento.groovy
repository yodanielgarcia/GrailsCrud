package com.codemonkey.model
class Departamento {
    int iddepartamento
    String nombre
    String responsable

    static constraints = {
        nombre(blank: false)
        responsable(blank: false)
    }

    //Un Departamento tiene muchos Tickets
    static hasMany = [tickets: Ticket]

    String toString(){
        "**Departamento\nId:"+id+"\nNombre:"+nombre+"\nResponsable:"+responsable
    }
}


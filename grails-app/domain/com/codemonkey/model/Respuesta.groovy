package com.codemonkey.model
class Respuesta {
    int idrespuesta
    boolean solucionado
    String descripcion

    static constraints = {
        descripcion(blank: false)
    }

    //Una Respuesta pertenece a un Tickets
    static belongsTo = [tickets: Ticket]

    String toString(){
        String result = solucionado == true? "Solucionado" : "En espera"
        "**Respuesta\nId:"+id+"\nDescripcion:"+descripcion+"\nSolucionado:"+result
    }
}
package com.codemonkey.model
class Ticket {
    int idticket
    Date fecha
    String asunto
    String descripcion

    static constraints = {
        asunto(blank: false)
        descripcion(black: false)
    }

    //Una Tickets pertenece a un Departamento
    static belongsTo = [departamentos: Departamento]

    String toString(){
        "**Ticket\nId:"+id+"\nFecha:"+fecha+"\nAsunto:"+asunto+"\nDescripcion:"+descripcion
    }
}
package com.codemonkey.model

import grails.gorm.services.Service

@Service(Respuesta)
interface RespuestaService {

    Respuesta get(Serializable id)

    List<Respuesta> list(Map args)

    Long count()

    void delete(Serializable id)

    Respuesta save(Respuesta respuesta)

}
package com.codemonkey.model

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RespuestaController {

    RespuestaService respuestaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond respuestaService.list(params), model:[respuestaCount: respuestaService.count()]
    }

    def show(Long id) {
        respond respuestaService.get(id)
    }

    def create() {
        respond new Respuesta(params)
    }

    def save(Respuesta respuesta) {
        if (respuesta == null) {
            notFound()
            return
        }

        try {
            respuestaService.save(respuesta)
        } catch (ValidationException e) {
            respond respuesta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'respuesta.label', default: 'Respuesta'), respuesta.id])
                redirect respuesta
            }
            '*' { respond respuesta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond respuestaService.get(id)
    }

    def update(Respuesta respuesta) {
        if (respuesta == null) {
            notFound()
            return
        }

        try {
            respuestaService.save(respuesta)
        } catch (ValidationException e) {
            respond respuesta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'respuesta.label', default: 'Respuesta'), respuesta.id])
                redirect respuesta
            }
            '*'{ respond respuesta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        respuestaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'respuesta.label', default: 'Respuesta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'respuesta.label', default: 'Respuesta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

package com.codemonkey.model

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RespuestaServiceSpec extends Specification {

    RespuestaService respuestaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Respuesta(...).save(flush: true, failOnError: true)
        //new Respuesta(...).save(flush: true, failOnError: true)
        //Respuesta respuesta = new Respuesta(...).save(flush: true, failOnError: true)
        //new Respuesta(...).save(flush: true, failOnError: true)
        //new Respuesta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //respuesta.id
    }

    void "test get"() {
        setupData()

        expect:
        respuestaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Respuesta> respuestaList = respuestaService.list(max: 2, offset: 2)

        then:
        respuestaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        respuestaService.count() == 5
    }

    void "test delete"() {
        Long respuestaId = setupData()

        expect:
        respuestaService.count() == 5

        when:
        respuestaService.delete(respuestaId)
        sessionFactory.currentSession.flush()

        then:
        respuestaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Respuesta respuesta = new Respuesta()
        respuestaService.save(respuesta)

        then:
        respuesta.id != null
    }
}

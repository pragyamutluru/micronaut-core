package org.particleframework.inject.constructor

import org.particleframework.context.BeanContext
import org.particleframework.context.DefaultBeanContext
import spock.lang.Specification

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by graemerocher on 12/05/2017.
 */
class ConstructorSimpleInjectionSpec extends Specification {


    void "test injection with constructor"() {
        given:
        BeanContext context = new DefaultBeanContext()
        context.start()

        when:"A bean is obtained that has a constructor with @Inject"
        B b =  context.getBean(B)

        then:"The implementation is injected"
        b.a != null
    }

    static interface A {

    }

    @Singleton
    static class AImpl implements A {

    }

    static class B {
        private A a

        @Inject
        B(A a) {
            this.a = a
        }

        A getA() {
            return this.a
        }
    }

}



package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class PersonTest {
    @Test
    public void testPerson(){
        // given
        Person person = new Person("xujie");

        // when
        String name = person.getName();

        // then
        assertThat(name, CoreMatchers.is("xujie"));

    }
}

package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;
public class ItemTest {
    @Test
    public void testItem(){
        //given
        Item item = new Item("test");

        //when
        item.setTitle("test2");
        item.setAvailable(false);

        //then
        assertThat(item.getTitle(), CoreMatchers.is("test2"));
        assertThat(item.isAvailable(), CoreMatchers.is(false));
    }
}

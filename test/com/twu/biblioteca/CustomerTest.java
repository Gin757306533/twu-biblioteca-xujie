package com.twu.biblioteca;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    @Test
    public void testCustomer(){
        // given
        Customer customer = new Customer("xujie", "757306533@qq.com","17674013080", "333");

        // when
        String name = customer.getName();
        String email = customer.getEmail();
        String phone = customer.getPhone();
        String password = customer.getPassword();

        // then
        assertThat(name, CoreMatchers.is("xujie"));
        assertThat(email, CoreMatchers.is("757306533@qq.com"));
        assertThat(phone, CoreMatchers.is("17674013080"));
        assertThat(password, CoreMatchers.is("333"));

    }
}

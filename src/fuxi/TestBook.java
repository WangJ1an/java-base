package fuxi;

import org.junit.Test;

/**
 * Created by 1 on 2017/7/9.
 */
public class TestBook {

    @Test
    public void testBookPage2() throws Exception {
        int page = 200;
        Book book = new Book();
        book.setName("java并发编程实战");
        book.setPage(page);
        System.out.println(book.toString());
    }

    @Test
    public void testBookPage1() throws Exception {
        int page = 99;
        Book book = new Book();
        book.setName("java编程思想");
        book.setPage(page);
        System.out.println(book.toString());
    }

}

package com.dapeng.cloud.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author diaopengwei
 * @date 2022/12/30
 * @apiNote
 */
public class StreamDemo {

    private static List<Author> getAuthors(){

        Author author1 = new Author(1L,"mogo1",31,"一个介绍",null);
        Author author2 = new Author(2L,"mogo2",20,"两个介绍",null);
        Author author3 = new Author(3L,"mogo3",33,"三个介绍",null);
        Author author4 = new Author(4L,"mogo4",17,"四个介绍",null);
        Author author5 = new Author(5L,"mogo5",16,"五个介绍",null);


        Book book1 = new Book(1L,"书名1","哲学,文言",79,"这是书的介绍");
        Book book2 = new Book(2L,"书名2","哲学,文言",79,"这是书的介绍");
        Book book3 = new Book(3L,"书名3","哲学",79,"这是书的介绍");
        Book book4 = new Book(4L,"书名4","哲学,文言",79,"这是书的介绍");
        Book book5 = new Book(5L,"书名5","哲学,文言",79,"这是书的介绍");
        Book book6 = new Book(6L,"书名6","哲",79,"这是书的介绍");
        Book book7 = new Book(7L,"书名7","哲学,文言",79,"这是书的介绍");
        Book book8 = new Book(8L,"书名8","哲学",79,"这是书的介绍");
        Book book9 = new Book(9L,"书名9","哲学,文言",79,"这是书的介绍");

        List<Book> books1 = new ArrayList<>(Arrays.asList(book1,book2,book3));
        List<Book> books2 = new ArrayList<>(Arrays.asList(book4,book5,book6));
        List<Book> books3 = new ArrayList<>(Arrays.asList(book7,book8,book9));

        author1.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books2);
        author5.setBooks(books3);

        List<Author> authors = new ArrayList<>(Arrays.asList(author1,author2,author3,author4,author5));
        return authors;

    }

    //public static void main(String[] args) {
    //
    //    List<Author> authors = getAuthors();
    //    authors.stream().distinct()
    //                    .filter(author -> author.getAge() < 18)
    //                    .forEach(author -> System.out.println(author.getName()));
    //
    //}

    /**
     * 打印姓名长度大于1的作者
     * @param args
     */
    public static void main(String[] args) {

        List<Author> authors = getAuthors();
        authors.stream().filter(author -> author.getName().length() > 1).forEach(author -> System.out.println(author));

    }
}

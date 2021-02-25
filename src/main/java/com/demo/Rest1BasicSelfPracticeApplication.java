package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.bookapp.dao.Book;
import com.demo.bookapp.service.BookService;

@SpringBootApplication
public class Rest1BasicSelfPracticeApplication implements CommandLineRunner{
	@Autowired
	private BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(Rest1BasicSelfPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//bookService.addBook(new Book("Aq12", "Java in action", "Katthey", 200));
	   // bookService.addBook(new Book("Aq13", "Spring in action", "tom", 500));
	}

}

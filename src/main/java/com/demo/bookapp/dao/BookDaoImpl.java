package com.demo.bookapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.bookapp.exceptions.BookNotFoundException;

@Repository
public class BookDaoImpl implements BookDao{
	
	private EntityManager em;
	
	@Autowired
	public BookDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books =  em.createQuery("from Book",Book.class).getResultList();
		if(books.size() == 0) {
			throw new BookNotFoundException("The booklist is empty!");
		}else {
			return books;
		}
	}

	@Override
	public Book getBookById(int bookId) {
		Book book =  em.find(Book.class, bookId);
		if(book==null) {
			throw new BookNotFoundException("book of id: " + bookId + " not found");
		}else {
			return book;
		}
	}

	@Override
	public Book addBook(Book book) {
		 em.persist(book);
		 return book;
	}

	@Override
	public Book updateBook(Book book) {
		return em.merge(book);
	}

	@Override
	public Book removeBook(int bookId) {
		Book bookToDelete = getBookById(bookId);
	
		if(bookToDelete==null) {
			throw new BookNotFoundException("There is no such book of book id " + bookId + " to remove");
		}else {
			em.remove(bookToDelete);
			return bookToDelete;
		}
		
	}

}

package com.capgemini.librarymanagementsystemspringmvc.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystemspringmvc.dto.BookBeans;
import com.capgemini.librarymanagementsystemspringmvc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemspringmvc.dto.BorrowBook;
import com.capgemini.librarymanagementsystemspringmvc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemspringmvc.dto.UserBeans;
import com.capgemini.librarymanagementsystemspringmvc.exception.LMSException;

public class UserDAOImplement implements UserDAO{
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	List<BookBeans> list = null;
	
	public boolean register(UserBeans user) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			isAdded = true;
			System.out.println("Added");
		} catch (Exception e) {
			e.printStackTrace();
			throw new LMSException("Employee ID already exists!");
		} finally {
			manager.close();
		}
		return isAdded;

	}
	public UserBeans login(String email, String password) {
		
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select u from UsersBean u where u.email=:email and u.password=:password";
			TypedQuery<UserBeans> query = manager.createQuery(jpql, UserBeans.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UserBeans bean = query.getSingleResult();
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		} finally {
			manager.close();
			factory.close();
		}


	}
	public boolean addBook(BookBeans book) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(book);
			transaction.commit();
			isAdded = true;
			System.out.println("Added");
		} catch (Exception e) {
			// TODO: handle exceptionentityClass
			e.printStackTrace();
			throw new LMSException("Book already exists!");
		} finally {
			manager.close();
		}
		return isAdded;

	}
	public boolean removeBook(int bId) {
		
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBeans record = manager.find(BookBeans.class, bId);
			manager.remove(record);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}

	}
	public boolean updateBook(BookBeans book) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BookBeans record = manager.find(BookBeans.class, book.getBId());
			record.setBookName(book.getBookName());
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}

	}
	public List<BorrowBook> borrowedBook(int uId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<BookBeans> searchBookById(int bId) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBeans> query = manager.createQuery(jpql, BookBeans.class);
			query.setParameter("bId", bId);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return list;
	}
	
	public List<BookBeans> searchBookByTitle(String bookName) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.bookName=:bookName";
			TypedQuery<BookBeans> query = manager.createQuery(jpql, BookBeans.class);
			query.setParameter("bookName", bookName);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}

		manager.close();
		factory.close();
		return list;

	}
	public List<BookBeans> searchBookByAuthor(String author) {

		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookBean b where b.author=:author";
			TypedQuery<BookBeans> query = manager.createQuery(jpql, BookBeans.class);
			query.setParameter("author", author);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}

		manager.close();
		factory.close();
		return list;


	}
	@SuppressWarnings("unchecked")
	public List<BookBeans> getBooksInfo() {
		@SuppressWarnings("rawtypes")
		List bookBeans = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.getTransaction();
			Query q = manager.createQuery("from BookBean");
			bookBeans = q.getResultList();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		factory.close();
		return bookBeans;

	}
	@SuppressWarnings("unused")
	public boolean returnBook(int bId, int uId) {
		String status=null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBeans> query = manager.createQuery(jpql, BookBeans.class);
			query.setParameter("bId", bId);
			BookBeans rs = query.getSingleResult();
			if (rs != null) {
				String jpql1 = "select b from BookIssueDetailsBean b where b.bId=:bId and b.uId=:uId ";
				TypedQuery<BookIssueDetails> query1 = manager.createQuery(jpql1, BookIssueDetails.class);
				query1.setParameter("bId", bId);
				query1.setParameter("uId", uId);
				BookIssueDetails rs1 = query1.getSingleResult();
				if (rs1 != null) {
					Date issueDate = rs1.getIssueDate();
					Calendar cal = Calendar.getInstance();
					Date returnDate = cal.getTime();
					long difference = issueDate.getTime() - returnDate.getTime();
					float daysBetween = (difference / (1000 * 60 * 60 * 24));
					if (daysBetween > 7.0) {
						// transaction.begin();
						float fine = daysBetween * 5;
						System.out.println("The user has to pay the fine of the respective book of Rs:" + fine);
						if (status == "yes") {
							transaction.begin();
							manager.remove(rs1);
							transaction.commit();

							transaction.begin();
							String jpql3 = "select b from BorrowedBooksBean b  where b.bId=:bId and b.uId=:uId";
							Query query3 = manager.createQuery(jpql3);
							query3.setParameter("bId", bId);
							query3.setParameter("uId", uId);
							BorrowBook bbb = (BorrowBook) query3.getSingleResult();
							manager.remove(bbb);
							transaction.commit();

							transaction.begin();
							String jpql4 = "select r from RequestBean r where r.bId=:bId and r.uId=:uId";
							Query query4 = manager.createQuery(jpql4);
							query4.setParameter("bId", bId);
							query4.setParameter("uId", uId);
							RequestDetails rdb = (RequestDetails) query4.getSingleResult();
							manager.remove(rdb);
							transaction.commit();
							return true;
						} else {
							throw new LMSException("The User has to pay fine for delaying book return");
						}
					} else {
						transaction.begin();
						manager.remove(rs1);
						transaction.commit();

						transaction.begin();
						String jpql3 = "select b from BorrowedBooksBean b  where b.bId=:bId and b.uId=:uId";
						Query query3 = manager.createQuery(jpql3);
						query3.setParameter("bId", bId);
						query3.setParameter("uId", uId);
						BorrowBook bbb = (BorrowBook) query3.getSingleResult();
						manager.remove(bbb);
						transaction.commit();

						transaction.begin();
						String jpql4 = "select r from RequestBean r where r.bId=:bId and r.uId=:uId";
						Query query4 = manager.createQuery(jpql4);
						query4.setParameter("bId", bId);
						query4.setParameter("uId", uId);
						RequestDetails rdb = (RequestDetails) query4.getSingleResult();
						manager.remove(rdb);
						transaction.commit();
						return true;
					}

				} else {
					throw new LMSException("This respective user hasn't borrowed any book");
				}
			} else {
				throw new LMSException("book doesnt exist");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}

	}
	public LinkedList<Integer> bookHistoryDetails(int uId) {
		int count = 0;
		int noOfBooks=0;
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from BookIssueDetailsBean b";
		TypedQuery<BookIssueDetails> query = manager.createQuery(jpql, BookIssueDetails.class);
		List<BookIssueDetails> recordList = query.getResultList();
		for (@SuppressWarnings("unused") BookIssueDetails p : recordList) {
			noOfBooks = count++;
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(noOfBooks);
		manager.close();
		factory.close();
		return list;
	}
	@Override
	public boolean issueBook(int bId, int uId) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBeans> query = manager.createQuery(jpql, BookBeans.class);
			query.setParameter("bId", bId);
			BookBeans rs = query.getSingleResult();
			if (rs != null) {
				String jpql1 = "select r from RequestBean r where r.uId=:uId and r.bId=:bId";
				TypedQuery<RequestDetails> query1 = manager.createQuery(jpql1, RequestDetails.class);
				query1.setParameter("uId", uId);
				query1.setParameter("bId", bId);
				List<RequestDetails> rs1 = query1.getResultList();
				if (!rs1.isEmpty() && rs1 != null) {
					transaction.begin();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar cal = Calendar.getInstance();
					String issueDate = sdf.format(cal.getTime());
					cal.add(Calendar.DAY_OF_MONTH, 7);
					String returnDate = sdf.format(cal.getTime());
					BookIssueDetails issueBook = new BookIssueDetails();
					issueBook.setUserId(uId);
					issueBook.setBookId(bId);
					issueBook.setIssueDate(java.sql.Date.valueOf(issueDate));
					issueBook.setReturnDate(java.sql.Date.valueOf(returnDate));
					manager.persist(issueBook);
					transaction.commit();
					if (!rs1.isEmpty() && rs1 != null) {
						transaction.begin();
						Query bookName = manager.createQuery("select b.bookName from BookBean b where b.bId=:bId");
						bookName.setParameter("bId", bId);
						@SuppressWarnings({ "rawtypes", "unused" })
						List book = bookName.getResultList();
						BorrowBook borrowedBooks = new BorrowBook();
						borrowedBooks.setuId(uId);
						borrowedBooks.setbId(bId);
						manager.persist(borrowedBooks);
						transaction.commit();
						return true;
					} else {
						throw new LMSException("Book Not issued");
					}
				} else {
					throw new LMSException("The respective user have not placed any request");
				}
			} else {
				throw new LMSException("There is no book exist with bookId" + bId);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	
	}
	@Override
	public boolean request(int uId, int bId) {
		int noOfBooks = 0;
		int count=0;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select b from BookBean b where b.bId=:bId";
			TypedQuery<BookBeans> query = manager.createQuery(jpql, BookBeans.class);
			query.setParameter("bId", bId);
			@SuppressWarnings("rawtypes")
			List rs = query.getResultList();
			if (rs != null) {
				String jpql1 = "select b from BorrowedBooksBean b where b.uId=:uId and b.bId=:bId";
				TypedQuery<BorrowBook> query1 = (TypedQuery<BorrowBook>) manager.createQuery(jpql1,
						BorrowBook.class);
				query1.setParameter("uId", uId);
				query1.setParameter("bId", bId);
				@SuppressWarnings("rawtypes")
				List rs1 = query1.getResultList();
				if (rs1.isEmpty() || rs1 == null) {
					String jpql2 = "select b from BookIssueDetailsBean b where b.uId=:uId";
					TypedQuery<BookIssueDetails> query2 = (TypedQuery<BookIssueDetails>) manager
							.createQuery(jpql2, BookIssueDetails.class);
					query2.setParameter("uId", uId);
					List<BookIssueDetails> rs2 = query2.getResultList();
					for (@SuppressWarnings("unused") BookIssueDetails p : rs2) {
						noOfBooks = count++;
					}
					if (noOfBooks < 3) {
						Query bookName = manager.createQuery("select b.bookName from BookBean b where b.bId=:bookId");
						bookName.setParameter("bookId", bId);
						@SuppressWarnings("rawtypes")
						List book = bookName.getResultList();
						Query email = manager.createQuery("select u.email from UsersBean u where u.uId=:user_Id");
						email.setParameter("user_Id", uId);
						@SuppressWarnings({ "rawtypes", "unused" })
						List userEmail = email.getResultList();
						transaction.begin();
						RequestDetails request = new RequestDetails();
						request.setuId(uId);
						request.setbId(bId);
						request.setBookName(book.get(0).toString());
						manager.persist(request);
						transaction.commit();
						return true;

					} else {
						throw new LMSException("You have crossed the book limit");
					}
				} else {
					throw new LMSException("You have already borrowed the requested book");
				}
			} else {
				throw new LMSException("The book with requested id is not present");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}
	}


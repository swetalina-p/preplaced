// library management system
// 1. Add Books--> id, title, author, count,
//     list of all books with filter count > 5,
//     search by title,
//     sort book based on the title

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Book b1=new Book(1, "t1", "a1",5);
        Book b2=new Book(2, "t2", "a2", 6);
        Book b3=new Book(3, "t3", "a3", 2);
        Book b4=new Book(4, "t4", "a4", 7);
        Book b5=new Book(5, "t5", "a5", 3);
        Bookdb db=new Bookdb();
        db.bookMapping(b1);
        db.bookMapping(b2);
        db.bookMapping(b3);
        db.bookMapping(b4);
        db.bookMapping(b5);
        System.out.println(db.booksByTitleCount());
        System.out.println(db.searchByTitle("t2"));
        System.out.println(db.sortByTitle());
        
    }
}

class Book{
    private int id;
    private String title;
    private String author;
    private int count;
    
    public Book(int id, String title, String author, int count) {
        this.id=id;
        this.title=title;
        this.author=author;
        this.count=count;
    }
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
    
}

class Bookdb {
    public List<Book> books;
    public Map<String, Book> map;
    public Bookdb() {
        books=new ArrayList<>();
        map=new HashMap<>();
    }
    public void bookMapping(Book bk) {
        books.add(bk);
        map.put(bk.getTitle(),bk);
    }
    
    //filterBookByCount
    public List<Book> booksByTitleCount() {
        List<Book> filteredBooksList=books.stream()
                                        .filter(book->book.getCount()>=5)
                                        .collect(Collectors.toList());
        return filteredBooksList;
    };
    
    //search by title
    public Book searchByTitle(String title) {
        return map.get(title);
    }
    
    //sort by title
    public List<Book> sortByTitle() {
        Collections.sort(books,(a,b)->a.getTitle().compareTo(b.getTitle()));
        return books;
    }
}

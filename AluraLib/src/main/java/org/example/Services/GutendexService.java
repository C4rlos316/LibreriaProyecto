package org.example.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Author;
import org.example.Model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String API_URL = "https://gutendex.com/books";

    public List<Book> searchBooksByTitle(String title) {
        String url = API_URL + "?search=" + title;
        return getBooksFromApi(url);
    }

    public List<Book> getAllBooks() {
        return getBooksFromApi(API_URL);
    }

    public List<Author> getAllAuthors() {
        List<Book> books = getBooksFromApi(API_URL);
        List<Author> authors = new ArrayList<>();
        for (Book book : books) {
            authors.addAll(book.getAuthors());
        }
        return authors;
    }

    public List<Author> getAuthorsByYear(int year) {
        String url = API_URL + "?author_year_start=" + year + "&author_year_end=" + year;
        List<Book> books = getBooksFromApi(url);
        List<Author> authors = new ArrayList<>();
        for (Book book : books) {
            for (Author author : book.getAuthors()) {
                if ((author.getBirthYear() != null && author.getBirthYear() <= year) &&
                        (author.getDeathYear() == null || author.getDeathYear() >= year)) {
                    authors.add(author);
                }
            }
        }
        return authors;
    }

    public List<Book> getBooksByLanguage(String language) {
        String url = API_URL + "?languages=" + language;
        return getBooksFromApi(url);
    }

    private List<Book> getBooksFromApi(String url) {
        List<Book> books = new ArrayList<>();
        try {
            String jsonResponse = restTemplate.getForObject(url, String.class);
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode results = root.path("results");
            for (JsonNode bookNode : results) {
                Book book = objectMapper.treeToValue(bookNode, Book.class);
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
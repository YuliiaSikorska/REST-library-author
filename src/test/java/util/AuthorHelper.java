package util;

import business.model.Author;
import business.model.AuthorName;
import business.model.Birth;

public class AuthorHelper {

    public static Author getTestAuthor(int authorId) {
        Author author = new Author();
        AuthorName authorName = new AuthorName();
        Birth birth = new Birth();
        authorName.setFirst("Lina");
        authorName.setSecond("Sikora");
        birth.setDate("1973-03-28");
        birth.setCountry("USA");
        birth.setCity("Detroit");
        author.setAuthorId(authorId);
        author.setAuthorName(authorName);
        author.setBirth(birth);
        author.setNationality("American");
        return author;
    }
}

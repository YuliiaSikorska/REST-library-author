import business.controllers.AuthorController;
import business.model.Author;
import core.util.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.AuthorHelper;


public class APITest {

    public static int authorID = 65;
    public boolean isDeleted = false;

    private AuthorController authorController;
    private Author author;

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = PropertyReader.getProperty("server.base.url");
    }

    @Test
    public void postAuthorCreated() {
        authorController = new AuthorController();
        Response response = authorController.createAuthor(AuthorHelper.getTestAuthor(authorID));
        isDeleted = true;
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.getBody().as(Author.class).getNationality(), "American");
    }

    @Test
    public void putAuthorDate() {
        authorController = new AuthorController();
        author = AuthorHelper.getTestAuthor(authorID);
        authorController.createAuthor(author);
        isDeleted = true;
        author.setNationality("Ukrainian");
        Assert.assertEquals(authorController.updateAuthor(author).statusCode(), 200);
        Assert.assertEquals(authorController.updateAuthor(author).jsonPath().getString("nationality"), "Ukrainian");
    }

    @Test
    public void getCheckStatusCode() {
        authorController = new AuthorController();
        author = AuthorHelper.getTestAuthor(authorID);
        authorController.createAuthor(author);
        isDeleted = true;
        Assert.assertEquals(authorController.getAuthor(authorID).statusCode(), 200);
    }

    @Test
    public void getCheckResponseHeader() {
        authorController = new AuthorController();
        author = AuthorHelper.getTestAuthor(authorID);
        authorController.createAuthor(author);
        isDeleted = true;
        Assert.assertTrue(authorController.getAuthor(authorID).getHeader("Content-Type").contains("application/json"));
    }

    @Test
    public void deleteAuthor() {
        authorController = new AuthorController();
        author = AuthorHelper.getTestAuthor(authorID);
        authorController.createAuthor(author);
        Assert.assertEquals(authorController.deleteAuthor(author.getAuthorId()).statusCode(), 204);
    }

    @AfterMethod
    public void tearDown() {
        authorController = new AuthorController();
        if (isDeleted) {
            authorController.deleteAuthor(authorID);
            isDeleted = false;
        }
    }
}

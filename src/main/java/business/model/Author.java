package business.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author {
    @JsonProperty("authorId")
    private int authorId;

    @JsonProperty("authorName")
    private AuthorName authorName;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("birth")
    private Birth birth;

    @JsonProperty("authorDescription")
    private String authorDescription;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public AuthorName getAuthorName() {
        return authorName;
    }

    public void setAuthorName(AuthorName authorName) {
        this.authorName = authorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }
}

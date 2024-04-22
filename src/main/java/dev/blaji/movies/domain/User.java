package dev.blaji.movies.domain;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

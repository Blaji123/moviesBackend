package dev.blaji.movies.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
public class JwtResponse {
    private ObjectId id;
    private String email;
    private String token;
    private String type="Bearer";


    public JwtResponse(ObjectId id, String email, String token) {
        this.id = id;
        this.email = email;
        this.token = token;
    }
}

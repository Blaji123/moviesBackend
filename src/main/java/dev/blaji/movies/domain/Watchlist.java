package dev.blaji.movies.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "watchlist")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Watchlist {
    @Id
    private ObjectId watchId;
    private String email;
    private Movie movie;
}

package dev.blaji.movies.repository;

import dev.blaji.movies.domain.Watchlist;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface WatchlistRepository extends MongoRepository<Watchlist, ObjectId> {
    List<Watchlist> findByEmail(String email);

}

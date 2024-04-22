package dev.blaji.movies.repository;

import dev.blaji.movies.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    void deleteByEmail(String email);
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}

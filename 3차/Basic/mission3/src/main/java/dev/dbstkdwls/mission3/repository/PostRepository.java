package dev.dbstkdwls.mission3.repository;

import dev.dbstkdwls.mission3.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}

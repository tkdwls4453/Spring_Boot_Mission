package dev.dbstkdwls.mission3.repository;

import dev.dbstkdwls.mission3.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}

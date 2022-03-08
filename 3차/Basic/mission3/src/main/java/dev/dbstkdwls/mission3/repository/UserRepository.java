package dev.dbstkdwls.mission3.repository;

import dev.dbstkdwls.mission3.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}

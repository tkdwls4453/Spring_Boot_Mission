package dev.dbstkdwls.mission3.dao;

import dev.dbstkdwls.mission3.dto.PostDto;
import dev.dbstkdwls.mission3.entity.PostEntity;
import dev.dbstkdwls.mission3.entity.UserEntity;
import dev.dbstkdwls.mission3.repository.BoardRepository;
import dev.dbstkdwls.mission3.repository.PostRepository;
import dev.dbstkdwls.mission3.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Repository
public class PostDao {
    private static final Logger logger = LoggerFactory.getLogger(PostDao.class);
    private BoardRepository boardRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public PostDao(@Autowired BoardRepository boardRepository,
                   @Autowired UserRepository userRepository,
                   @Autowired PostRepository postRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public void createPost(PostDto dto, Long boardId, Long userId){
        PostEntity postEntity = new PostEntity();
        postEntity.setId(dto.getId());
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setWriter(this.userRepository.findById(userId).get().getName());
        postEntity.setBoardEntity(this.boardRepository.findById(boardId).get());
        postEntity.setUserEntity(this.userRepository.findById(userId).get());

        this.postRepository.save(postEntity);
    }

    public PostEntity readPost(Long boardId, Long id){
        Optional<PostEntity> postEntity = this.postRepository.findById(id);
        if (postEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else if(!Objects.equals(this.boardRepository.findById(boardId).get(),postEntity.get().getBoardEntity())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return postEntity.get();
    }

    public List<PostEntity> readPostAll(Long boardId){
        Iterator<PostEntity> iterator = this.postRepository.findAll().iterator();
        List<PostEntity> postEntityList = new ArrayList<>();
        while( iterator.hasNext()){
            PostEntity postEntity = iterator.next();
            if (postEntity.getBoardEntity() == this.boardRepository.findById(boardId).get()){
                postEntityList.add(postEntity);
            }
        }
        return postEntityList;
    }

    public void updatePost(Long boardId, Long id, PostDto dto) {
        Optional<PostEntity> targetEntity = this.postRepository.findById(id);
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else if (!Objects.equals(targetEntity.get().getBoardEntity().getId(),boardId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        PostEntity postEntity = targetEntity.get();

        postEntity.setTitle(
                dto.getTitle() == null ? postEntity.getTitle() : dto.getTitle()
        );
        postEntity.setContent(
                dto.getContent() == null ? postEntity.getContent() : dto.getContent()
        );
        this.postRepository.save(postEntity);
    }

    public void deletePost(Long boardId, Long id){
        Optional<PostEntity> targetEntity = this.postRepository.findById(id);
        if (targetEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else if (!Objects.equals(targetEntity.get().getBoardEntity().getId(),boardId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.postRepository.delete(targetEntity.get());
    }
}

package dev.dbstkdwls.mission3.service;

import dev.dbstkdwls.mission3.dao.PostDao;
import dev.dbstkdwls.mission3.dto.PostDto;
import dev.dbstkdwls.mission3.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private static Logger logger = LoggerFactory.getLogger(PostService.class);
    private PostDao postDao;

    public PostService(@Autowired PostDao postDao) {
        this.postDao = postDao;
    }

    public void createPost(PostDto dto, Long boardId, Long userId){
        this.postDao.createPost(dto,boardId,userId);
    }

    public PostDto readPost(Long boardId, Long id){
        PostEntity postEntity = this.postDao.readPost(boardId, id);
        PostDto postDto = new PostDto(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity().getId(),
                postEntity.getUserEntity().getId()
        );
        return postDto;
    }

    public List<PostDto> readPostAll(Long boardId){
        List<PostEntity> postEntityList = postDao.readPostAll(boardId);
        List<PostDto> postDtoList = new ArrayList<>();

        for (PostEntity postEntity : postEntityList){
            postDtoList.add(new PostDto(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity().getId(),
                postEntity.getUserEntity().getId()
            ));
        }
        return postDtoList;
    }

    public void updatePost(Long boardId, Long id, PostDto dto){
        this.postDao.updatePost(boardId, id, dto);
    }

    public void deletePost(Long boardId, Long id){
        this.postDao.deletePost(boardId, id);
    }
}

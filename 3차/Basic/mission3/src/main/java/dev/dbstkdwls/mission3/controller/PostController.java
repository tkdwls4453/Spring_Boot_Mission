package dev.dbstkdwls.mission3.controller;

import dev.dbstkdwls.mission3.dto.PostDto;
import dev.dbstkdwls.mission3.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board/{board_id}/post")
public class PostController {
    private static Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(
            @Autowired PostService postService
    ){
        this.postService = postService;
    }

    @PostMapping("user/{user_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(
            @RequestBody PostDto postDto,
            @PathVariable("board_id") Long board_id,
            @PathVariable("user_id") Long user_id)
    {
        this.postService.createPost(postDto, board_id, user_id);
    }
    @GetMapping("{id}")
    public PostDto readPost(
            @PathVariable("board_id") Long board_id,
            @PathVariable("id") Long id)
    {
        return this.postService.readPost(board_id, id);
    }

    @GetMapping()
    public List<PostDto> readPostAll(
            @PathVariable("board_id") Long board_id)
    {
        return this.postService.readPostAll(board_id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("board_id") Long board_id,
            @PathVariable("id") Long id,
            @RequestBody PostDto postDto)
    {
        this.postService.updatePost(board_id, id, postDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("board_id") Long board_id,
            @PathVariable("id") Long id)
    {
        this.postService.deletePost(board_id, id);
    }
}

package dev.dbstkdwls.mission3.controller;

import dev.dbstkdwls.mission3.dto.BoardDto;
import dev.dbstkdwls.mission3.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
public class BoardController {
    private static Logger logger = LoggerFactory.getLogger(PostController.class);
    private final BoardService boardService;

    public BoardController(
            @Autowired BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(
            @RequestBody BoardDto boardDto)
    {
        this.boardService.createBoard(boardDto);
    }
    @GetMapping("{id}")
    public BoardDto readBoard(
            @PathVariable("id") Long id)
    {
        return this.boardService.readBoard(id);
    }

    @GetMapping()
    public List<BoardDto> readBoardAll()
    {
        return this.boardService.readBoardAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoard(
            @PathVariable("id") Long id,
            @RequestBody BoardDto boardDto)
    {
        this.boardService.updateBoard(id, boardDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("id") Long id)
    {
        this.boardService.deleteBoard(id);
    }

}

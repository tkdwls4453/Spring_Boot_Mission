package dev.dbstkdwls.mission3.dto;

public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Long boardId;
    private Long userId;

    public PostDto() {
    }

    public PostDto(Long id, String title, String content, String writer, Long boardId, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", boardId=" + boardId +
                ", userId=" + userId +
                '}';
    }
}

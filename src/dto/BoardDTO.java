package dto;

public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private String boardPass;
    private Long boardHit = 0L;
    private static Long num = 1L;
    public BoardDTO() {
    }

    // 글 조회 할 때 마다
    public BoardDTO(String boardTitle, String boardWriter, String boardContents, String boardPass, Long boardHit) {
        this.id = num++;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
        this.boardPass = boardPass;
        this.boardHit = boardHit;
    }
    // 새로운 게시글을 쓸 때마다 호출
    public BoardDTO(String boardTitle, String boardWriter, String boardContents, String boardPass) {
        this.id =num++;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
        this.boardPass = boardPass;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getBoardPass() {
        return boardPass;
    }

    public void setBoardPass(String boardPass) {
        this.boardPass = boardPass;
    }

    public Long getBoardHit() {
        return boardHit;
    }

    public void setBoardHit(Long boardHit) {
        this.boardHit = boardHit;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", boardTitle='" + boardTitle + '\'' +
                ", boardWriter='" + boardWriter + '\'' +
                ", boardHit=" + boardHit +
                '}';
    }
}

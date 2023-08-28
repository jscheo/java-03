package service;

import dto.BoardDTO;
import repository.BoardRepository;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner scanner = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();
    public void isnert() {
        System.out.print("제목: ");
        String boardTitle = scanner.next();
        System.out.print("작성자명: ");
        String boardWriter = scanner.next();
        System.out.print("내용 입력: ");
        String boardContents = scanner.next();
        System.out.print("비밀번호: ");
        String boardPass = scanner.next();
        //순서에 맞게 차례대로 해야함 알아서 찾아가지 않기 때문에 dto랑 순서가 같게해야함

        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardContents, boardPass);
        boolean result = boardRepository.insert(boardDTO);

        if(result){
            System.out.println("글 등록 성공");
        }else{
            System.out.println("글 작성 실패");
        }
    }

    public void list() {
        List<BoardDTO> boardDTOList = boardRepository.list();
        for(BoardDTO boardDTO: boardDTOList){
            System.out.println(boardDTO.toString());
        }
    }

    public void findById() {
        list();
        System.out.print("검색할 번호 입력:");
        Long id = scanner.nextLong();
        boolean result = boardRepository.boardHits(id);
        if(result){
//        Long i = boardDTO.getBoardHit();
//        i ++;
//        boardDTO.setBoardHit(i);
            BoardDTO boardDTO = boardRepository.findById(id);
            System.out.print("제목: " + boardDTO.getBoardTitle() +"/");
            System.out.print("작성자: " + boardDTO.getBoardWriter() +"/");
            System.out.print("내용: " + boardDTO.getBoardContents() +"/");
            System.out.println("조회수: " + boardDTO.getBoardHit());

        }else{
            System.out.println("아이디가 존재하지 않습니다.");
        }

    }

    public void update() {
        list();
        System.out.print("수정할 글 번호:");
        Long id = scanner.nextLong();
        System.out.println("해당 글 비밀번호:");
        String pass= scanner.next();
        BoardDTO boardDTO = boardRepository.update(id, pass);
        if(boardDTO != null){
            System.out.println("수정할 제목");
            String title = scanner.next();
            System.out.println("수정할 내용");
            String contents = scanner.next();

            boardDTO.setBoardTitle(title);
            boardDTO.setBoardContents(contents);
            System.out.print("제목: " + boardDTO.getBoardTitle() +"/");
            System.out.print("작성자: " + boardDTO.getBoardWriter() +"/");
            System.out.print("내용: " + boardDTO.getBoardContents() +"/");
            System.out.println("조회수: " + boardDTO.getBoardHit());
        }else{
            System.out.println("비밀번호가 틀렸습니다.");
        }

    }
    public void delete() {
        list();
        System.out.print("삭제할 글 번호:");
        Long id = scanner.nextLong();
        System.out.println("해당 글 비밀번호:");
        String pass= scanner.next();
        BoardDTO boardDTO = boardRepository.delete(id, pass);

        if(boardDTO != null){
            System.out.println("삭제완료");
            list();
        }else{
            System.out.println("비밀번호가 틀렸습니다.");
        }
    }

    public void search() {
        System.out.println("검색할 제목 입력하세요");
        String title = scanner.next();
        BoardDTO boardDTO = boardRepository.search(title);
        if(boardDTO != null){
            System.out.print("제목: " + boardDTO.getBoardTitle() +"/");
            System.out.print("작성자: " + boardDTO.getBoardWriter() +"/");
            System.out.print("내용: " + boardDTO.getBoardContents() +"/");
            System.out.println("조회수: " + boardDTO.getBoardHit());
        }else{
            System.out.println("검색내용이 없습니다.");
        }

    }

    public void sampleData() {
        for(int i = 1; i<=10; i++){
            BoardDTO boardDTO =
                    new BoardDTO("title"+i, "writer" + i, "contents"+i, "pass"+i);
            boardRepository.insert(boardDTO);
        }
    }
}

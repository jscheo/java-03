package service;

import dto.BoardDTO;
import repository.BoardRepository;

import java.util.List;
import java.util.Scanner;

public class BoardService {
    Scanner scanner = new Scanner(System.in);
    BoardRepository boardRepository = new BoardRepository();

    public void save() {
        System.out.print("제목: ");
        String boardTitle = scanner.next();
        System.out.print("작성자: ");
        String boardWriter = scanner.next();
        System.out.print("내용: ");
        String boardContents = scanner.next();
        System.out.print("비밀번호: ");
        String boardPass = scanner.next();
        BoardDTO boardDTO = new BoardDTO(boardTitle, boardWriter, boardContents, boardPass);
        boolean result = boardRepository.save(boardDTO);
        if (result) {
            System.out.println("글쓰기 성공");
        } else {
            System.out.println("글쓰기 실패");
        }
    }

    public void findAll() {
        List<BoardDTO> boardDTOList = boardRepository.findAll();
        System.out.println("글목록");
        System.out.println("id\t" + "title\t" + "writer\t" + "hits\t");
        for (BoardDTO boardDTO : boardDTOList) {
            boardDTO.print();
        }
    }

    public void findById() {
        findAll();
        System.out.print("조회할 글번호를 입력해주세요: ");
        long findId = scanner.nextLong();
        // 1. 해당 게시글의 조회수를 하나 증가시킴
        // 2. 해당 게시글 상세내용을 출력함
        boolean result = boardRepository.boardHits(findId);
        if (result) {
            BoardDTO boardDTO = boardRepository.findById(findId);
            System.out.println("boardDTO = " + boardDTO);
        } else {
            System.out.println("요청하신 게시글이 없습니다!");
        }
    }

    public void sampleData() {
        for (int i = 1; i <= 10; i++) {
            BoardDTO boardDTO =
                    new BoardDTO("title"+i, "writer"+i, "contents"+i, "pass"+i);
            boardRepository.save(boardDTO);
        }
    }

    public void update() {
        findAll();
        System.out.print("수정할 글번호를 입력해주세요: ");
        long findId = scanner.nextLong();
        System.out.print("비밀번호를 입력해주세요: ");
        String boardPass = scanner.next();
        BoardDTO boardDTO = boardRepository.findById(findId);
        if (boardDTO != null) {
            if (boardPass.equals(boardDTO.getBoardPass())) {
                // 수정을 위한 제목, 내용 입력
                System.out.print("수정 제목: ");
                String boardTitle = scanner.next();
                System.out.print("수정 내용: ");
                String boardContents = scanner.next();
                boardRepository.update(findId, boardTitle, boardContents);
            } else {
                System.out.println("비밀번호가 일치하지 않습니다!");
            }
        } else {
            System.out.println("요청하신 게시글이 없습니다!");
        }
    }

    public void delete() {
        findAll();
        System.out.print("삭제할 글번호를 입력해주세요: ");
        long findId = scanner.nextLong();
        System.out.print("비밀번호를 입력해주세요: ");
        String boardPass = scanner.next();
        BoardDTO boardDTO = boardRepository.findById(findId);
        if (boardDTO != null) {
            if (boardPass.equals(boardDTO.getBoardPass())) {
                boardRepository.delete(findId);
            } else {
                System.out.println("비밀번호가 일치하지 않습니다!");
            }
        } else {
            System.out.println("요청하신 게시글이 없습니다!");
        }
    }

    public void search() {
        System.out.print("검색어: ");
        String q = scanner.next();
        List<BoardDTO> searchList = boardRepository.search(q);
        if (searchList.size() > 0) {
            // 검색결과 출력
            System.out.println("검색 결과");
            System.out.println("id\t" + "title\t" + "writer\t" + "hits\t");
            for (BoardDTO boardDTO : searchList) {
                boardDTO.print();
            }
        } else {
            System.out.println("검색결과가 없습니다!");
        }
    }
}
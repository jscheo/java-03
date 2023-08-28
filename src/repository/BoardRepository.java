package repository;

import dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardRepository {
    Scanner scanner = new Scanner(System.in);
    List<BoardDTO> boardDTOList = new ArrayList<>();
    public boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public List<BoardDTO> findAll() {
        return boardDTOList;
    }

    public boolean boardHits(long findId) {
        for (BoardDTO boardDTO: boardDTOList) {
            if (findId == boardDTO.getId()) {
                int hits = boardDTO.getBoardHits();
                hits = hits + 1;
                boardDTO.setBoardHits(hits);
                return true;
            }
        }
        return false;
    }

    public BoardDTO findById(long findId) {
        for (BoardDTO boardDTO: boardDTOList) {
            if (findId == boardDTO.getId()) {
                return boardDTO;
            }
        }
        return null;
    }

    public void update(long findId, String boardTitle, String boardContents) {
        for (BoardDTO boardDTO: boardDTOList) {
            if (findId == boardDTO.getId()) {
                boardDTO.setBoardTitle(boardTitle);
                boardDTO.setBoardContents(boardContents);
            }
        }
    }

    public void delete(long findId) {
        for (BoardDTO boardDTO: boardDTOList) {
            if (findId == boardDTO.getId()) {
                boardDTOList.remove(boardDTO);
            }
        }
    }

    public List<BoardDTO> search(String q) {
        // 검색결과를 담을 리스트
        List<BoardDTO> searchList = new ArrayList<>();
        for (BoardDTO boardDTO: boardDTOList) {
            if (q.equals(boardDTO.getBoardTitle())) {
                searchList.add(boardDTO);
            }
        }
        return searchList;
    }
}
package repository;

import dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    List<BoardDTO> boardDTOList = new ArrayList<>();
    public boolean insert(BoardDTO boardDTO) {
       return boardDTOList.add(boardDTO);
    }

    public List<BoardDTO> list() {
        return boardDTOList;
    }


    public BoardDTO findById(Long id) {
        for(BoardDTO boardDTO : boardDTOList){
            if(id == boardDTO.getId()){
                return boardDTO;
            }
        }
        return null;
    }

    public BoardDTO update(Long id, String pass) {
        for(BoardDTO boardDTO: boardDTOList){
            if(id == boardDTO.getId() && pass.equals(boardDTO.getBoardPass())) {
                return boardDTO;
            }
        }
        return null;
    }

    public BoardDTO delete(Long id, String pass) {
        for(BoardDTO boardDTO : boardDTOList){
            if(id == boardDTO.getId() && pass.equals(boardDTO.getBoardPass())) {
                boardDTOList.remove(boardDTO);
                return boardDTO;
            }
        }
        return null;
    }

    public BoardDTO search(String title) {
        for(BoardDTO boardDTO: boardDTOList){
            if(title.equals(boardDTO.getBoardTitle())){
                return boardDTO;
            }
        }
        return null;
    }
}
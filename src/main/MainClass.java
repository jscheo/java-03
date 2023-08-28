package main;

import service.BoardService;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoardService boardService = new BoardService();

        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------------------");
            System.out.println("1.글작성 2.글목록 3.글조회 4.글수정 5.글삭제 6.검색 7.샘플데이터 0.종료");
            System.out.println("------------------------------------------------------");
            System.out.print("메뉴선택> ");
            int sel = scanner.nextInt();

            if (sel == 1) {
                System.out.println("글작성");
                boardService.save();
            } else if (sel == 2) {
                System.out.println("글목록");
                boardService.findAll();
            } else if (sel == 3) {
                System.out.println("글조회");
                boardService.findById();
            } else if (sel == 4) {
                System.out.println("글수정");
                boardService.update();
            } else if (sel == 5) {
                System.out.println("글삭제");
                boardService.delete();
            } else if (sel == 6) {
                System.out.println("검색");
                boardService.search();
            } else if (sel == 7) {
                System.out.println("샘플데이터");
                boardService.sampleData();
            } else if (sel == 0) {
                System.out.println("프로그램 종료");
                run = false;
            } else {
                System.out.println("다시입력");
            }

        }
    }
}

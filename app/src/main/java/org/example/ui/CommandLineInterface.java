package org.example.ui;

import org.example.analyzer.CodeAnalyzer;
import org.example.refactor.CodeRefactorer;
import org.example.optimizer.CodeOptimizer;

import java.util.Scanner;

public class CommandLineInterface {

    private CodeAnalyzer analyzer;
    private CodeRefactorer refactorer;
    private CodeOptimizer optimizer;

    public CommandLineInterface() {
        this.analyzer = new CodeAnalyzer();
        this.refactorer = new CodeRefactorer(analyzer);
        this.optimizer = new CodeOptimizer(analyzer);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== 코드 청소기 명령줄 인터페이스 =====");
            System.out.println("1. 코드 분석");
            System.out.println("2. 리팩토링");
            System.out.println("3. 성능 최적화");
            System.out.println("4. 종료");
            System.out.print("옵션을 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 클리어

            switch (choice) {
                case 1:
                    System.out.print("분석할 디렉토리 경로를 입력하세요: ");
                    String analyzePath = scanner.nextLine();
                    analyzer.analyzeDirectory(analyzePath);
                    break;
                case 2:
                    refactorer.refactor();
                    break;
                case 3:
                    optimizer.optimize();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    public static void main(String[] args) {
        CommandLineInterface cli = new CommandLineInterface();
        cli.start();
    }
}
package org.example.ui;

import org.example.analyzer.CodeAnalyzer;
import org.example.refactor.CodeRefactorer;
import org.example.optimizer.CodeOptimizer;

import java.util.Scanner;

public class Dashboard {

    private CodeAnalyzer analyzer;
    private CodeRefactorer refactorer;
    private CodeOptimizer optimizer;

    public Dashboard() {
        this.analyzer = new CodeAnalyzer();
        this.refactorer = new CodeRefactorer(analyzer);
        this.optimizer = new CodeOptimizer(analyzer);
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== 코드 청소기 대시보드 =====");
            System.out.println("1. 코드 분석");
            System.out.println("2. 리팩토링");
            System.out.println("3. 성능 최적화");
            System.out.println("4. 종료");
            System.out.println("==============================");
            System.out.print("옵션을 선택하세요: ");
            int choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    analyzer.analyzeDirectory("src/main/java/com/codecleaner/");
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
                    break;
            }
        }
    }

public static void main(String[] args) {
    Dashboard dashboard = new Dashboard();
    dashboard.showMenu();
    }
}
package org.example.refactor;

import org.example.analyzer.CodeAnalyzer;

public class CodeRefactorer {

    private CodeAnalyzer codeAnalyzer;
    private MethodInliner methodInliner;
    private MethodExtractor methodExtractor;

    public CodeRefactorer(CodeAnalyzer codeAnalyzer) {
        this.codeAnalyzer = codeAnalyzer;
        this.methodInliner = new MethodInliner();
        this.methodExtractor = new MethodExtractor();
    }

    public void refactor() {
        System.out.println("리팩토링 작업을 시작합니다...");

        // 고급 리팩토링 기법 적용
        inlineSmallMethods();
        extractComplexMethods();

        System.out.println("리팩토링 작업이 완료되었습니다.");
    }

    private void inlineSmallMethods() {
        // 조건에 따라 메서드 인라인화 실행
        methodInliner.inlineMethod("src/main/java/com/codecleaner/Example.java", "smallMethod");
    }

    private void extractComplexMethods() {
        // 조건에 따라 메서드 추출 실행
        methodExtractor.extractMethod("src/main/java/com/codecleaner/Example.java", "complexMethod", "newExtractedMethod");
    }
}
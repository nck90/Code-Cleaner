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

        inlineSmallMethods();
        extractComplexMethods();

        System.out.println("리팩토링 작업이 완료되었습니다.");
    }

    private void inlineSmallMethods() {
        methodInliner.inlineMethod("src/main/java/com/codecleaner/Example.java", "smallMethod");
    }

    private void extractComplexMethods() {
        methodExtractor.extractMethod("src/main/java/com/codecleaner/Example.java", "complexMethod", "newExtractedMethod");
    }
}
package org.example.optimizer;

import org.example.analyzer.CodeAnalyzer;

public class CodeOptimizer {

    private CodeAnalyzer codeAnalyzer;
    private LoopUnrollingOptimizer loopOptimizer;
    private CacheOptimizer cacheOptimizer;

    public CodeOptimizer(CodeAnalyzer codeAnalyzer) {
        this.codeAnalyzer = codeAnalyzer;
        this.loopOptimizer = new LoopUnrollingOptimizer();
        this.cacheOptimizer = new CacheOptimizer();
    }

    public void optimize() {
        System.out.println("성능 최적화 작업을 시작합니다...");

        optimizeLoops();
        optimizeCaching();

        System.out.println("성능 최적화 작업이 완료되었습니다.");
    }

    private void optimizeLoops() {
        loopOptimizer.optimizeLoops("src/main/java/com/codecleaner/Example.java");
    }

    private void optimizeCaching() {
        cacheOptimizer.optimizeCaching("src/main/java/com/codecleaner/Example.java");
    }
}
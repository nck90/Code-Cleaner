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

        // 고급 성능 최적화 기법 적용
        optimizeLoops();
        optimizeCaching();

        System.out.println("성능 최적화 작업이 완료되었습니다.");
    }

    private void optimizeLoops() {
        // 조건에 따라 루프 최적화 실행
        loopOptimizer.optimizeLoops("src/main/java/com/codecleaner/Example.java");
    }

    private void optimizeCaching() {
        // 조건에 따라 캐시 최적화 실행
        cacheOptimizer.optimizeCaching("src/main/java/com/codecleaner/Example.java");
    }
}
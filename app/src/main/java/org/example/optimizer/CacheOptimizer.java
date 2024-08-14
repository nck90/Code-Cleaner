package org.example.optimizer;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class CacheOptimizer {

    private Set<String> cachedMethods;

    public CacheOptimizer() {
        this.cachedMethods = new HashSet<>();
    }

    public void optimizeCaching(String filePath) {
        try {
            // JavaParser 인스턴스 생성
            JavaParser javaParser = new JavaParser();
            CompilationUnit cu = javaParser.parse(new File(filePath)).getResult().orElseThrow();

            cu.findAll(MethodCallExpr.class).forEach(mc -> {
                String methodName = mc.getNameAsString();
                if (shouldCacheMethod(methodName)) {
                    cachedMethods.add(methodName);
                    applyCaching(mc);
                }
            });

            System.out.println("캐시 최적화 완료. 캐싱된 메서드: " + cachedMethods);

        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + filePath);
            e.printStackTrace();
        }
    }

    private boolean shouldCacheMethod(String methodName) {
        // 간단한 캐싱 조건: 예를 들어 메서드 이름에 'get'이 포함된 경우 캐싱
        return methodName.startsWith("get") && !cachedMethods.contains(methodName);
    }

    private void applyCaching(MethodCallExpr mc) {
        // 실제 캐싱 로직 추가 (예: 메서드 호출 결과를 캐시 변수에 저장)
        System.out.println("캐싱 적용: " + mc);
    }
}
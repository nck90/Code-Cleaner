package org.example.analyzer;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.Map;

public class MethodComplexityAnalyzer extends VoidVisitorAdapter<Void> {

    private final Map<String, Integer> methodComplexityMap;

    public MethodComplexityAnalyzer(Map<String, Integer> methodComplexityMap) {
        this.methodComplexityMap = methodComplexityMap;
    }

    @Override
    public void visit(MethodDeclaration md, Void arg) {
        super.visit(md, arg);
        String methodName = md.getNameAsString();
        int complexity = 1;  // 기본 복잡도는 1

        // 메서드 내의 모든 if 문을 분석하여 복잡도를 계산
        for (IfStmt ifStmt : md.findAll(IfStmt.class)) {
            System.out.println("Found if statement: " + ifStmt);
            complexity++;
        }

        methodComplexityMap.put(methodName, complexity);
    }
}
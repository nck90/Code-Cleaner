
package org.example.analyzer;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class CodeAnalyzer {

    private Map<String, MethodUsageInfo> methodUsageMap = new HashMap<>();
    private Map<String, Integer> methodComplexityMap = new HashMap<>();

    public void analyzeDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("유효한 디렉토리 경로가 아닙니다: " + directoryPath);
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".java"));
        if (files != null) {
            for (File file : files) {
                analyzeFile(file);
            }
        }

        printAnalysisReport();
    }

    private void analyzeFile(File file) {
        try {
            JavaParser javaParser = new JavaParser();
            CompilationUnit compilationUnit = javaParser.parse(file).getResult().orElseThrow();
    
            VoidVisitor<Void> methodVisitor = new MethodUsageAnalyzer(methodUsageMap, compilationUnit);
            methodVisitor.visit(compilationUnit, null);
    
            VoidVisitor<Void> complexityVisitor = new MethodComplexityAnalyzer(methodComplexityMap);
            complexityVisitor.visit(compilationUnit, null);
    
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }

    private void printAnalysisReport() {
        System.out.println("==== 코드 분석 보고서 ====");
        methodUsageMap.forEach((methodName, usageInfo) -> {
            System.out.println("메서드 이름: " + methodName);
            System.out.println("정의된 파일: " + usageInfo.getDefinedFile());
            System.out.println("호출 횟수: " + usageInfo.getUsageCount());
            System.out.println("복잡도: " + methodComplexityMap.getOrDefault(methodName, 0));
            System.out.println("--------");
        });
        System.out.println("=========================");
    }

    public Map<String, MethodUsageInfo> getMethodUsageMap() {
        return methodUsageMap;
    }

    public Map<String, Integer> getMethodComplexityMap() {
        return methodComplexityMap;
    }
}
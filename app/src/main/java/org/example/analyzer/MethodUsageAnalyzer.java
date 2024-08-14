package org.example.analyzer;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.CompilationUnit;
import java.util.Map;

public class MethodUsageAnalyzer extends VoidVisitorAdapter<Void> {

    private final Map<String, MethodUsageInfo> methodUsageMap;
    private final CompilationUnit compilationUnit;

    // 생성자
    public MethodUsageAnalyzer(Map<String, MethodUsageInfo> methodUsageMap, CompilationUnit compilationUnit) {
        this.methodUsageMap = methodUsageMap;
        this.compilationUnit = compilationUnit;
    }

    @Override
    public void visit(MethodDeclaration md, Void arg) {
        super.visit(md, arg);
        String methodName = md.getNameAsString();

        // 파일명을 추출하기 위한 코드
        String fileName = compilationUnit.getStorage()
                            .map(storage -> storage.getFileName())
                            .orElse("Unknown");

        // 메서드 이름을 키로 사용하여 methodUsageMap에 MethodUsageInfo를 추가 또는 업데이트합니다.
        methodUsageMap.computeIfAbsent(methodName, k -> new MethodUsageInfo(fileName))
                      .incrementUsage();
    }
}
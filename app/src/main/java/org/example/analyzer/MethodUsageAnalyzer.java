package org.example.analyzer;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.CompilationUnit;
import java.util.Map;

public class MethodUsageAnalyzer extends VoidVisitorAdapter<Void> {

    private final Map<String, MethodUsageInfo> methodUsageMap;
    private final CompilationUnit compilationUnit;

    public MethodUsageAnalyzer(Map<String, MethodUsageInfo> methodUsageMap, CompilationUnit compilationUnit) {
        this.methodUsageMap = methodUsageMap;
        this.compilationUnit = compilationUnit;
    }

    @Override
    public void visit(MethodDeclaration md, Void arg) {
        super.visit(md, arg);
        String methodName = md.getNameAsString();

        String fileName = compilationUnit.getStorage()
                            .map(storage -> storage.getFileName())
                            .orElse("Unknown");

        methodUsageMap.computeIfAbsent(methodName, k -> new MethodUsageInfo(fileName))
                      .incrementUsage();
    }
}

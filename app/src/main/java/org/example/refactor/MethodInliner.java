package org.example.refactor;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

public class MethodInliner {

    public void inlineMethod(String filePath, String methodName) {
        try {
            // JavaParser 인스턴스 생성
            JavaParser javaParser = new JavaParser();
            CompilationUnit cu = javaParser.parse(new File(filePath)).getResult().orElseThrow();

            Optional<MethodDeclaration> methodOpt = cu.findAll(MethodDeclaration.class)
                .stream()
                .filter(m -> m.getNameAsString().equals(methodName))
                .findFirst();

            if (methodOpt.isPresent()) {
                MethodDeclaration method = methodOpt.get();
                System.out.println("인라인화할 메서드: " + methodName);

                // 메서드 바디를 추출하여 인라인화
                for (Statement stmt : method.getBody().get().getStatements()) {
                    System.out.println("인라인 코드: " + stmt);
                    // 실제 인라인화 코드 추가
                }
            } else {
                System.out.println("메서드를 찾을 수 없습니다: " + methodName);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
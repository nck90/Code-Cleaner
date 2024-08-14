package org.example.refactor;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import java.io.File;
import java.io.FileNotFoundException;

public class MethodExtractor {

    public void extractMethod(String filePath, String methodName, String newMethodName) {
        try {
            // JavaParser 인스턴스 생성
            JavaParser javaParser = new JavaParser();
            CompilationUnit cu = javaParser.parse(new File(filePath)).getResult().orElseThrow();

            cu.findAll(MethodDeclaration.class).forEach(md -> {
                if (md.getNameAsString().equals(methodName)) {
                    System.out.println("메서드 추출 중: " + methodName);
                    // 메서드의 일부를 새로운 메서드로 추출
                    // 실제 추출 코드 추가
                    MethodDeclaration newMethod = md.clone();
                    newMethod.setName(newMethodName);
                    System.out.println("새로운 메서드: " + newMethodName);
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
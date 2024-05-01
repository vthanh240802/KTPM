package com.iuh.fit;

import com.github.javaparser.StaticJavaParser;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File projectDir = new File("D:\\Nam4\\HK2\\KienTruc\\KTPM\\Tuan2\\TestTemplate");
        Dictionary dictionary = new Dictionary();
        List<String> requiredComments = List.of("@author", "created-date");
        String packagePattern = "com.iuh";


        DirExplorer dirExplorer = new DirExplorer(
                ((level, path, file) -> path.endsWith(".java")),
                (level, path, file) -> {
                    System.out.println(path);
                    System.out.println("-".repeat(path.length()));

                    try {
                        VoidVisitorAdapterCustom voidVisitorAdapterCustom = new VoidVisitorAdapterCustom();
                        voidVisitorAdapterCustom.setPatternPackage(packagePattern);
                        voidVisitorAdapterCustom.setRequiredComments(requiredComments);
                        voidVisitorAdapterCustom.setDictionary(dictionary);
                        voidVisitorAdapterCustom.visit(StaticJavaParser.parse(file), null);
                        System.out.println();
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                });
        dirExplorer.explore(projectDir);

    }
}
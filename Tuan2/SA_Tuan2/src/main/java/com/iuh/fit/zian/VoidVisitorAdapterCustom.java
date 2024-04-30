package com.iuh.fit.zian;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class VoidVisitorAdapterCustom extends VoidVisitorAdapter<Object> {
    private String patternPackage;
    private List<String> requiredComments;

    private Dictionary dictionary;

    public VoidVisitorAdapterCustom(String patternPackage, List<String> commentClassRequired, Dictionary dictionary) throws IOException {
        this.patternPackage = patternPackage;
        this.requiredComments = commentClassRequired;
        this.dictionary = dictionary;
    }

    public VoidVisitorAdapterCustom() {
    }

    public String getPatternPackage() {
        return patternPackage;
    }

    public List<String> getRequiredComments() {
        return requiredComments;
    }

    public void setPatternPackage(String patternPackage) {
        this.patternPackage = patternPackage;
    }

    public void setRequiredComments(List<String> requiredComments) {
        this.requiredComments = requiredComments;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public void visit(PackageDeclaration n, Object arg) {
        super.visit(n, arg);
        String name = n.getNameAsString();
        if (!name.startsWith(patternPackage)){
            System.out.print(n.getBegin().get().toString() + " ");
            System.out.println("Package [" + name + "] does not follow correct pattern");
        }
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
        super.visit(n, arg);
        String name = n.getNameAsString();
        if (!Utils.isClassCamelCase(name)){
            System.out.print(n.getBegin().get().toString() + " ");
            System.out.println("Class [" + name + "] is not following camel case pattern");
        }

        if (!dictionary.isNoun(name)){
            System.out.print(n.getBegin().get().toString() + " ");
            System.out.println("Class [" + name + "] is not a Noun");
        }

        String comment = n.getComment().toString();
        if (comment.isEmpty()){
            System.out.print(n.getBegin().get().toString() + " ");
            System.out.println("Class [" + name + "] lacks of comment");
        }else {
            requiredComments.forEach(required -> {
                if (!comment.contains(required)) {
                    System.out.print(n.getBegin().get().toString() + " ");
                    System.out.println("Class [" + name + "] lacks of " + required);
                }
            });
        }
    }

    @Override
    public void visit(FieldDeclaration n, Object arg) {
        super.visit(n, arg);
        NodeList<VariableDeclarator> variableDeclarators = n.getVariables();
        NodeList<Modifier> modifiers = n.getModifiers();
        if (modifiers.contains(Modifier.staticModifier())){
            Node parentNode = n.getParentNode().get();
            ClassOrInterfaceDeclaration classDeclaration = (ClassOrInterfaceDeclaration) parentNode;
            if (!classDeclaration.isInterface()){
                System.out.print(n.getBegin().get() + " ");
                System.out.println("Static variable " + variableDeclarators.toString() + " should be placed within the Interface");
            }
        }

        for (VariableDeclarator variableDeclarator : variableDeclarators){
            if (!dictionary.isNoun(variableDeclarator.getNameAsString())){
                System.out.print(variableDeclarator.getBegin().get() + " ");
                System.out.println("Field [" + variableDeclarator.getName() + "] is not a noun");
            }

            if (!Utils.isCamelCase(variableDeclarator.getNameAsString())){
                System.out.print(variableDeclarator.getBegin().get() + " ");
                System.out.println("Field [" + variableDeclarator.getName() + "] does not follow the correct pattern");
            }
        }
    }

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        super.visit(n, arg);
        List<String> ignores = List.of("equals", "toString", "hashCode");
        String name = n.getNameAsString();
        if (ignores.contains(name))
            return;
        String firstWord = Utils.splipByUpperCase(name).get(0);
        if (!dictionary.isVerb(firstWord)){
            System.out.print(n.getBegin().get().toString() + " ");
            System.out.println("Method [" + name + "] not start with a Verb");
        }
        Comment comment = n.getComment().orElse(null);
        if (comment == null) {
            System.out.print(n.getBegin().get().toString() + " ");
            System.out.println("Method [" + name + "] lacks of comment");
        }

    }

    @Override
    public void visit(ConstructorDeclaration n, Object arg) {
        super.visit(n, arg);
        if (n.getParameters().isEmpty()) return;
        Comment comment = n.getComment().orElse(null);
        if (comment == null) {
            System.out.print(n.getBegin().get().toString() + " ");
            System.out.println("Constructor with parameters [" + n.getNameAsString() + "] lacks of comment");
        }
    }
}

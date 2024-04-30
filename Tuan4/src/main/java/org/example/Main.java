package org.example;

import jdepend.xmlui.JDepend;

import java.io.PrintWriter;
public class Main {
    public static void main(String[] args) throws Exception{
        JDepend depend =new JDepend(new PrintWriter("reports/report.xml"));
        depend.addDirectory("E:\\Document-IUH\\Documents\\HK8\\KIENTRUCPHANMEM\\git-clone\\Library-Assistant");
        depend.analyze();
        System.out.println("DONE");
    }
}
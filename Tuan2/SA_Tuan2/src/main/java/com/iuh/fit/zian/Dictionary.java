package com.iuh.fit.zian;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Dictionary {
    private static InputStream modeIn;
    private static POSModel model;
    private static POSTaggerME tagger;
    public Dictionary() throws IOException {
        modeIn = new FileInputStream("src/main/resources/en-pos-maxent.bin");
        model = new POSModel(modeIn);
        tagger = new POSTaggerME(model);
    }



    public boolean isVerb(String input){
        String[] token = SimpleTokenizer.INSTANCE.tokenize(input);
        String[] tags = tagger.tag(token);
        for (String tag : tags){
            if (tag.startsWith("VB"))
                return true;
        }
        return false;
    }

    public boolean isNoun(String input){
        String[] token = SimpleTokenizer.INSTANCE.tokenize(input);
        String[] tags = tagger.tag(token);
        for (String tag : tags){
            if (tag.startsWith("NN"))
                return true;
        }
        return false;
    }
}

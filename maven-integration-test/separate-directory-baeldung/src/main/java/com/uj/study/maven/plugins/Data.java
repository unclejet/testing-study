package com.uj.study.maven.plugins;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/12/2 上午8:51
 * @description：
 */
public class Data {
    List<String> textList = new ArrayList();

    public void addText(String text) {
        textList.add(text);
    }

    public List getTextList() {
        return this.textList;
    }
}

// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.nlp.testnlp.participle;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.JiebaSegmenter.SegMode;
import com.huaban.analysis.jieba.SegToken;
import com.huaban.analysis.jieba.WordDictionary;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * created by zhhgao@mobvoi.com on 2018/12/6
 */
public class TestJieba {

  public static void main(String[] args) {
//    JiebaSegmenter segmenter = new JiebaSegmenter();
//    String[] sentences =
//        new String[] {"但是, 需要注意, 一些通用的词语对于主题并没有太大的作用, 反倒是一些出现频率较少的词才能够表达文章的主题, 所以单纯使用是TF不合适的。权重的设计必须满足：一个词预测主题的能力越强，权重越大，反之，权重越小。所有统计的文章中，一些词只是在其中很少几篇文章中出现，那么这样的词对文章的主题的作用很大，这些词的权重应该设计的较大。IDF就是在完成这样的工作."};
////    for (String sentence : sentences) {
////      System.out.println(segmenter.process(sentence, SegMode.SEARCH).toString());
////    }
//    List<SegToken> list = segmenter.process(sentences[0],SegMode.INDEX);
//    for (SegToken segToken : list){
//      System.out.println(segToken.word);
//    }

    JiebaSegmenter segmenter = new JiebaSegmenter();
    //加载用户词典
    Path path = Paths.get("src/main/resources/userDict/dict.txt");
    WordDictionary.getInstance().loadUserDict(path,StandardCharsets.UTF_8);
    List<String> result = new ArrayList<>();
//    String sentences = "我是醉家男煮饺";
//    String sentences = "我爱喝雀巢咖啡";
    String sentences = "12 月 6 日讯，蘑菇街周四在美国纽交所挂牌交易，代码为 MOGU，首日开盘报 12.25 美元，较 IPO 发行价 14 美元 /ADS 下跌 12.5%。小财注：蘑菇街隶属于美丽联合旗下品牌，2016 年，美丽说与蘑菇街合并后成立美丽联合。挂牌前，蘑菇街的发行价为 14 美元，处于区间下限，计划发行 480 万美国存托凭证（ADS），预计在本次 IPO 最高募集资金 2 亿美元。此外，京东旗下 Windcreek Limited 已经同意买入 3000 万美元的蘑菇街 A 类股。（财联社）";
    long start = System.currentTimeMillis();
    result = segmenter.sentenceProcess(sentences);
    System.out.println("time cost : " + (System.currentTimeMillis() - start));
    for (String s : result){
      System.out.println(s);
    }

  }
}
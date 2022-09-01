package com.lucky.leecode.bloom;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class BloomFilterDemo {
    private static final int insertions = 1000000;//100w

    public void createBloomFilter(){
        //初始化一个存储String数据的布隆过滤器，初始化大小100w
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8)
                ,insertions);
        //初始化一个存储string数据的set，初始化大小100w
        Set<String> sets = new HashSet<>(insertions);
        //初始化一个存储string数据的List，初始化大小100w
        List<String> lists = new ArrayList<>(insertions);

        for(int i=0;i<insertions;i++){
            String uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            sets.add(uuid);
            lists.add(uuid);
        }

        int right =0;
        int wrong=0;
        for (int i=0;i<10000;i++){
            String test=i%100==0?lists.get(i/100):UUID.randomUUID().toString();
            if(bloomFilter.mightContain(test)){
                if(sets.contains(test)){
                    right++;
                }else{
                    wrong++;
                }
            }
        }

        System.out.println("right:"+right);
        System.out.println("wrong:"+wrong);
    }
}

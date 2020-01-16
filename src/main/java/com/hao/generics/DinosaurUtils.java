package com.hao.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * <code>DinosaurUtils</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2019-12-13
 * @version: 1.0
 */
public class DinosaurUtils {

    public static <T extends Dinosaur & Fly<? super T>> T findFlyDinosaur(Collection<? extends T> dinosaurs){
        Iterator<? extends T> iterator = dinosaurs.iterator();
        return iterator.next();
    }

    public static void main(String[] args) throws Exception{
        List<FlyDinosaur> list = new ArrayList<>();
        FlyDinosaur dinosaur1 = new FlyDinosaur("恐龙1");
        FlyDinosaur dinosaur2 = new FlyDinosaur("恐龙2");
        list.add(dinosaur1);
        list.add(dinosaur2);
        Dinosaur dinosaur = findFlyDinosaur(list);
        System.out.println(dinosaur.getName());

        FlyDinosaur flyDinosaur = new FlyDinosaur("恐龙3",100);
        Dinosaur dinosaur3 = flyDinosaur.clone();
        flyDinosaur.setName("恐龙33");
        System.out.println(dinosaur3.getName());
    }
}

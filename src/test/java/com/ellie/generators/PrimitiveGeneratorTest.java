package com.ellie.generators;

import org.junit.Test;
/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/11/8
 */
public class PrimitiveGeneratorTest {
    private static int size = 15;
    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.println(type.getSimpleName() + ":");
            try {
                Generator<?> gen = (Generator<?>)type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.print(gen.next() + " ");
                }
                System.out.println(";");
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void Test(){
        System.out.println("----- Test of primitive generator -----");
        test(PrimitiveGenerator.class);

        System.out.println("----- Test of random primitive generator -----");
        test(PrimitiveRandomGenerator.class);
    }
}

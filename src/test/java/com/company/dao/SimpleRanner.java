package com.company.dao;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SimpleRanner {
    public static void main(String[] args) {
        SimpleRanner sr = new SimpleRanner();

        sr.runTest();
    }

    private void runTest() {
        try {
            Class cl = Class.forName("com.company.dao.DictionaryDaoImplTest");
            Constructor cst = cl.getConstructor();
            Object entity = cst.newInstance();
            Method[] methods = cl.getMethods();
            for (Method m : methods) {
                Test ann = m.getAnnotation(Test.class);
                if (ann != null) {
                    m.invoke(entity);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

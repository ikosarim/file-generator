package ru.generate.sorm1;

import java.lang.reflect.Field;

/**
 * Created by kosarim on 5/15/17.
 */
public interface PrintRow {

    String printString() throws IllegalAccessException;

    StringBuilder addStringFragment(StringBuilder textBuilder, int startCount, int stopCount, Field[] fields, Object obj)
            throws IllegalAccessException;
}

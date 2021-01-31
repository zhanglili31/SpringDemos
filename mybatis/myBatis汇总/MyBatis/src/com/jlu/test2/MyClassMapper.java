package com.jlu.test2;

import java.util.HashMap;
import java.util.List;

import com.jlu.test1.MyClass;

public interface MyClassMapper {
	List<HashMap<String,Object>> selectPersonByClass();
}

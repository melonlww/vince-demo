package com.xima.diveinspringboot.repository;

import com.xima.diveinspringboot.annotation.FirstLevelRepository;
import com.xima.diveinspringboot.annotation.SecondLevelRepository;

@SecondLevelRepository(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {
}

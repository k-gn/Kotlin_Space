package com.lannstark.lec11;

// 코틀린에선 패키지 접근 제어 개념이 빠지고, 모듈 접근 제어 개념이 생겼다.
public abstract class StringUtils {

  private StringUtils() {}

  public boolean isDirectoryPath(String path) {
    return path.endsWith("/");
  }

}


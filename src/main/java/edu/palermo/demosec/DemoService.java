package edu.palermo.demosec;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

  private final String DB_PASSWORD = "123abcDEASD%@#$E";

  public int getNumber() {
    System.out.println(DB_PASSWORD);
    return 10;
  }

}

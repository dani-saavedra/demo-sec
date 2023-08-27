package edu.palermo.demosec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {

  @InjectMocks
  private DemoService demoService;

  @Test
  public void when_invoke_getNumber_then_success() {
    int number = demoService.getNumber();
    Assertions.assertEquals(10, number);
  }
}

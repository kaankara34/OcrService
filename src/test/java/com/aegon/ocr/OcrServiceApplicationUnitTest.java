package com.aegon.ocr;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@ActiveProfiles("unit-test")
public class OcrServiceApplicationUnitTest {



  @Autowired
  private OcrServiceApplicationTestSupport applicationTest;

  
  
  @Test
  void contextLoads() {
    assertNotNull(applicationTest);
    applicationTest.contextLoads();

  }

  @Test
  public void deleteOcrById() throws Exception {
    assertNotNull(applicationTest);
    applicationTest.deleteOcrById();
  }

  @Test
  public void readAllOcr() throws Exception {
    assertNotNull(applicationTest);
    applicationTest.readAllOcrs();
  }


  @Test
  public void testInit() throws Exception {
    assertNotNull(applicationTest);
    applicationTest.testInit();
  }

  @Test
  public void readOcrByName() throws Exception {
    ResultActions resultActons = applicationTest.readOcrByName("demo");
    
  }


  @Test
  public void readOcrById() throws Exception {
    assertNotNull(applicationTest);

    ResultActions resultActons = applicationTest.readOcrById("ABCC1");
  }

  @BeforeAll
  public void setUp() throws Exception {
    applicationTest.setUp();
  }

}

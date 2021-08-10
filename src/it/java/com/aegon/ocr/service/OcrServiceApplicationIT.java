package com.aegon.ocr.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
  @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@ActiveProfiles("integration-test")
class OcrServiceApplicationIT {


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
  public void readAllOcrs() throws Exception {
    assertNotNull(applicationTest);
    applicationTest.readAllOcrs();
  }


  @Test
  public void testInit() throws Exception {
    assertNotNull(applicationTest);
    applicationTest.testInit();
  }

  @Test
  public void readOcrById() throws Exception {
    assertNotNull(applicationTest);
    applicationTest.readOcrById("ABCC1");
  }

  @Test
  public void readOcrByName() throws Exception {

    assertNotNull(applicationTest);
    applicationTest.readOcrByName("demo");

  }

  @BeforeAll
  public void setUp() throws Exception {
    applicationTest.setUp();
  }
}

package com.aegon.ocr;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@Component
@Profile({"unit-test", "integration-test"})
public class OcrServiceApplicationTestSupport {


  @Autowired
  private MockMvc mockMvc;



  void contextLoads() {

    assertNotNull(mockMvc);

  }

  public void deleteOcrById() throws Exception {
    // @formatter:off
    this.mockMvc.perform(delete("/Ocrs/BCX1")).
    andDo(print()).
    andExpect(status().isOk()).
    andExpect(jsonPath("$.header.status", is("SUCCESS")));
    // @formatter:on


  }

  public void readAllOcrs() throws Exception {
    // @formatter:off
     this.mockMvc.perform(get("/Ocrs")).
     andDo(print())
     .andExpect(status().isOk())
     .andExpect(jsonPath("$.header.status", is("SUCCESS")));
    // @formatter:on

  }


  public void testInit() throws Exception {
    // @formatter:off
    this.mockMvc.perform(get("/Ocrs/init")).
    andDo(print())
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.header.status", is("SUCCESS")));
    // @formatter:on

  }

  public ResultActions readOcrById(String OcrId) throws Exception {
    // @formatter:off
    return this.mockMvc.perform(get("/Ocrs/" + OcrId))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.header.status", is("SUCCESS")));
    // @formatter:on


  }

  public ResultActions readOcrByName(String name) throws Exception {

    // @formatter:off
    return this.mockMvc.perform(get("/Ocrs/name/" + name))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.header.status", is("SUCCESS")));
    // @formatter:on


  }



  public void setUp() throws Exception {
    this.mockMvc.perform(get("/Ocrs/init"));
  }

}

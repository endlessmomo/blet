package yuki.blet.adaptor.in.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import yuki.blet.application.port.in.MemberJoinCommand;
import yuki.blet.application.port.in.MemberUseCase;
import yuki.blet.common.IntegrationTest;

@Transactional
class MemberControllerTest extends IntegrationTest {

  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private MemberUseCase memberUseCase;

  public static final String BASE_URL = "/api/member";
  @Test
  @DisplayName("회원 가입 성공")
  public void 회원_가입_테스트() throws Exception {

    //given
    MemberJoinCommand memberJoinCommand = MemberJoinCommand.builder()
        .name("엄수혁")
        .email("soohyuk96@naver.com")
        .password("1234")
        .birth(LocalDate.of(1996,12,16))
        .zipcode("05067")
        .city("서울특별시")
        .district("송파구")
        .detail("거마로 56")
        .phoneNumber("010-3237-4176")
        .build();


    // when & then
    mockMvc.perform(
        post(BASE_URL+"/public/join")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonContent)
    ).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
  }
}
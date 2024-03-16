package kirby.domain;

import kirby.domain.domains.user.repository.PostRepository;
import kirby.domain.domains.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LbmDomainApplicationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    private MultiValueMap<String, String> createUserInfo() {
        MultiValueMap<String, String> info = new LinkedMultiValueMap<>();
        info.add("userId", "testId" + Math.abs(Math.random()));
        // TODO oAuth token 추가
        // info.add("token", "testToken");
        info.add("name", "testName" + Math.abs(Math.random()));
        return info;
    }

    private MultiValueMap<String, String> createPostInfo() {
        MultiValueMap<String, String> info = new LinkedMultiValueMap<>();
        info.add("title", "testTitle" + Math.abs(Math.random()));
        info.add("content", "testContent" + Math.abs(Math.random()));
        //info.add("picture", "testPictureURL");
        //info.add("video", "testVideoURL");
        return info;
    }

    @Test
    public void createUserTest() throws Exception {
        // 무작위 계정 정보 생성
        MultiValueMap<String, String> info = createUserInfo();

        // TODO URL 주소 협의 후 바꾸기
        mockMvc.perform(post("/account/register")
                .params(info))
                // TODO CSRF 사용 협의 후 테스트 코드에서 사용 또는 삭제
                //.with(csrf())
                .andExpect(status().isOk());

        // DB에 추가 되었으면 1개가 나올 것이고, 추가 안되었으면 0이 출력됨.
        assertEquals(1L, userRepository.count());
    }

    @Test
    public void postWriteTest() throws Exception {
        // 무작위 계정 정보 생성
        MultiValueMap<String, String> info = createUserInfo();
        MultiValueMap<String, String> postInfo = createPostInfo();
        mockMvc.perform(post("/account/register")
                        .params(info))
                .andExpect(status().isOk());

        // TODO URL 주소 협의 후 바꾸기
        mockMvc.perform(post("/post/write")
                        .params(postInfo))
                .andExpect(status().isOk());

        assertEquals(1L, postRepository.count());
    }
}

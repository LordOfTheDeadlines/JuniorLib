package com.lod.JuniorLib;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-post-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-post-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@WithMockUser("admin")
@SpringBootTest
class JuniorLibApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		this.mockMvc.perform(get("/articles"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(authenticated())
				.andExpect(content().string(containsString("Список статей")));

		this.mockMvc.perform(get("/article/new"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Добавить новую статью")));
		this.mockMvc.perform(get("/login?logout"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Вы вышли из системы.")));
	}

	@Test
	public void articleDeleteRedirectTest() throws Exception{
		this.mockMvc.perform(get("/article/1/delete"))
				.andExpect(authenticated())
				.andExpect(redirectedUrl("/articles"));
	}

	@Test
	public void articlesListDbTest() throws Exception {
		this.mockMvc.perform(get("/articles"))
				.andDo(print())
				.andExpect(authenticated())
				.andExpect(xpath(".//div[@class='content']/div").nodeCount(2));
	}

	@Test
	public void subjectsListDbTest() throws Exception {
		this.mockMvc.perform(get("/subjects"))
				.andDo(print())
				.andExpect(authenticated())
				.andExpect(xpath(".//div[@class='content']/div").nodeCount(2));
	}
}

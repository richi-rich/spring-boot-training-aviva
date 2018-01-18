package com.aviva.javaprograms.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.aviva.javaprograms.service.JavaProgramsService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = JavaProgramsController.class, secure = false)
public class JavaProgramsControllerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	JavaProgramsService javaProgramsService;

	@Test
	public void testGetFibonacciSeries() throws Exception {
		List<String> verticallist = new ArrayList<>();
		verticallist.add("1");
		verticallist.add("2");
		verticallist.add("fizz");
		verticallist.add("4");
		verticallist.add("buzz");
		verticallist.add("fizz");

		String expectedListStr = "[" + "1" + "," + "2" + "," + "fizz" + "," + "4" + "," + "buzz" + "," + "fizz" + "]";

		Mockito.when(javaProgramsService.getVerticalList("7")).thenReturn(verticallist);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/verticallist/7")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		JSONAssert.assertEquals(expectedListStr, result.getResponse().getContentAsString(), false);
	}

}

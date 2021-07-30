package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.dao.ItemRepository;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RunWith(MockitoJUnitRunner.class)

public class ItemServiceTest {

	@Mock
	ItemRepository repository;

	@InjectMocks
	ItemService service;

	@Test
	public void testWithMock_usingMockitoRunner() {
		List<Item> mockList = Arrays.asList(new Item(1, "Dummy", 10, 5));

		when(repository.findAll()).thenReturn(mockList);

		List<Item> items = service.calculateTotalValue();
		assertEquals(50, items.get(0).getValue());
	}
}
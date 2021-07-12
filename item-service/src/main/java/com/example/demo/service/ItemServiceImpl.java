package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemDao;
import com.example.demo.dto.ItemDto;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.Item;
import com.example.demo.ui.ItemResponseModel;

@Service
public class ItemServiceImpl implements ItemService {
	private ItemDao itemDao;
	private ModelMapper modelMapper;

	@Autowired
	public ItemServiceImpl(ItemDao itemDao, ModelMapper modelMapper) {
		this.itemDao = itemDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public ItemResponseModel createItem(ItemDto itemDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Item item = modelMapper.map(itemDto, Item.class);
		Item item1 = itemDao.save(item);
		return modelMapper.map(item1, ItemResponseModel.class);
	}

	@Override
	public List<ItemResponseModel> getAllItems() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<Item> items=itemDao.findAll();
		List<ItemResponseModel> models=new ArrayList<ItemResponseModel>();
		Iterator<Item> i=items.iterator();
		while(i.hasNext())
		{
			models.add(modelMapper.map(i.next(), ItemResponseModel.class));
		}
		return models;
	}

	@Override
	public ItemResponseModel findByItemNumber(String itemNumber) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Item item=itemDao.findByItemNumber(itemNumber);
		if(item==null)
		{
			throw new ItemNotFoundException("item with "+itemNumber+" not found");
		}
		return modelMapper.map(item, ItemResponseModel.class);
	}

	@Override
	public List<ItemResponseModel> findByItemName(String itemName) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<Item> list=itemDao.findByItemName(itemName);
		if(list.isEmpty())
		{
			throw new ItemNotFoundException("item with "+itemName+" not found");
		}
		List<ItemResponseModel> models=new ArrayList<ItemResponseModel>();
		Iterator<Item> i=list.iterator();
		while(i.hasNext())
		{
			models.add(modelMapper.map(i.next(), ItemResponseModel.class));
		}
		return models;
	}



}
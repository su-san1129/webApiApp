package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Weight;
import com.example.demo.form.WeightForm;
import com.example.demo.repository.WeightRepository;

@Service
public class WeightService {
	
	@Autowired
	private WeightRepository weightRepository;
	
	public void save(WeightForm weightForm) {
		Weight weight = new Weight();
		BeanUtils.copyProperties(weightForm, weight);
		weight.setCreatedAt(LocalDate.now());
		if(weightForm.getId() != null)
			weight.setUpdatedAt(LocalDate.now());
		weightRepository.save(weight);
	}
	
	public List<Weight> weightListById(Integer id){
		return weightRepository.findByUserId(id);
	}

}

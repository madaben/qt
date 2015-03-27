package nz.co.qt.service.impl;

import java.util.List;

import nz.co.qt.domain.Category;
import nz.co.qt.repository.CategoryRepository;
import nz.co.qt.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
}

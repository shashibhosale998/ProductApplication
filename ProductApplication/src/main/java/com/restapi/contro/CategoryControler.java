package com.restapi.contro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.category.Category;
import com.restapi.category.controller.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryControler {

	@Autowired
	CategoryRepository caterepo;

	@GetMapping("/categories")
	public List<Category> getCategory() {
		List<Category> categories = caterepo.findAll();
		return categories;
	}

	@GetMapping("/categories/{di}")
	public Category GetbyId(@PathVariable int di) {
		Category categories = caterepo.findById(di).get();
		return categories;
	}

	@PostMapping("/categories")
	public void CreateCateory(@RequestBody Category categories) {
		caterepo.save(categories);
	}

	@PutMapping("/categories/{di}")
	public Category UpdateCategory(@PathVariable int di) {
		Category categories = caterepo.findById(di).get();
		categories.setCategory_name("Statinary");
		caterepo.save(categories);
		return categories;
	}

	@DeleteMapping("/categories/{di}")
	public void DeleteCategory(@PathVariable int di) {
		Category categories = caterepo.findById(di).get();
		caterepo.delete(categories);
	}

}

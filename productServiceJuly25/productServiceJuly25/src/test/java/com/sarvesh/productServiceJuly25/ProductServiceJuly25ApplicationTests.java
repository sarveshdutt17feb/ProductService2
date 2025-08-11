package com.sarvesh.productServiceJuly25;

import com.sarvesh.productServiceJuly25.model.Category;
import com.sarvesh.productServiceJuly25.model.Product;
import com.sarvesh.productServiceJuly25.repository.CategoryRepository;
import com.sarvesh.productServiceJuly25.repository.ProductRepository;
import com.sarvesh.productServiceJuly25.repository.projections.ProductWithTitleAndPrice;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceJuly25ApplicationTests {


	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void testQuery() {
		ProductWithTitleAndPrice productsWithTitleAndPrice =
				productRepository.getTitleAndPriceById(2L);
		System.out.println(productsWithTitleAndPrice.getTitle());
		System.out.println(productsWithTitleAndPrice.getPrice());

//		for (ProductWithTitleAndPrice productWithTitleAndPrice : productsWithTitleAndPrice) {
//			System.out.println(productWithTitleAndPrice.getTitle());
//			System.out.println(productWithTitleAndPrice.getPrice());
//			System.out.println("-----------");
//		}

//        categoryRepository.deleteById(2L);

//		//T1
//		Optional<Category> optionalCategory = categoryRepository.findById(1L);
//
//		//T2
//		List<Product> products = optionalCategory.get().getProducts();
//
//		for (Product product : products) {
//			System.out.println(product.getTitle());
//		}
//
//		System.out.println("DEBUG");
	}

}

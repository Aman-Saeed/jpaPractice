package com.coding.jpaPractice.Controllers;

import com.coding.jpaPractice.entities.ProductEntity;
import com.coding.jpaPractice.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private static final int PAGE_SIZE = 10;

    public ProductController(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "") String title,
                                            @RequestParam (defaultValue = "id") String sortBy,
                                              @RequestParam (defaultValue = "0") Integer pageNumber
    ) {
       // return productRepository.findByOrderByPrice();

       // return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price", "quantity"));

      //  return productRepository.findBy(Sort.by(
       //         Sort.Order.desc(sortBy)
       //         ,Sort.Order.asc("title")
      //  ));

        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(pageNumber,PAGE_SIZE, Sort.by(sortBy))
        );

       // Pageable page = PageRequest.of(
        //        pageNumber,
        //        PAGE_SIZE,
         //       Sort.by(sortBy));

      //  return productRepository.findAll(page).getContent();
    }

}

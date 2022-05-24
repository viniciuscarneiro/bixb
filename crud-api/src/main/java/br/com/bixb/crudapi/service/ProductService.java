package br.com.bixb.crudapi.service;

import br.com.bixb.crudapi.controller.ProductRequest;
import br.com.bixb.crudapi.controller.ProductResponse;
import br.com.bixb.crudapi.repository.ProductRepository;
import br.com.bixb.crudapi.repository.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record ProductService(ProductRepository productRepository) {
    public ProductResponse create(ProductRequest productRequest) {
        var productToSave = new Product();
        productToSave.setName(productRequest.getName());
        var result = productRepository.save(productToSave);
        return new ProductResponse(result.getId(), result.getName());
    }

    public List<ProductResponse> fetchAll() {
        return productRepository.findAll().stream().map(p -> new ProductResponse(p.getId(), p.getName())).collect(Collectors.toList());
    }
}

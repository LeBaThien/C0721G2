package com.blog.demo.service.Ecommerce;


import com.blog.demo.model.ECommerce;
import com.blog.demo.repository.ECommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ECommerceServiceImpl implements ECommerceService {
    @Autowired
    ECommerceRepository eCommerceRepository;

    @Override
    public List<ECommerce> findAll() {
        return eCommerceRepository.findAll();
    }

    @Override
    public Optional<ECommerce> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(ECommerce eCommerce) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public Page<ECommerce> findById(int id) {
        return null;
    }

    @Override
    public Page<ECommerce> findAllEcommerce() {
        return null;
    }
}

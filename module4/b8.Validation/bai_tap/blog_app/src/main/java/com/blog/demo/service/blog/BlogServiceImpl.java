package com.blog.demo.service.blog;

import com.blog.demo.model.Blog;
import com.blog.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Blog findBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {

        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllBlogByName(String name, Pageable pageable) {
        return blogRepository.findBlogByAuthorContaining(name, pageable);
    }

    @Override
    public Page<Blog> findAllBlogECommerceId(int id, Pageable pageable) {
        return blogRepository.findAllBlogByECommerceId(id, pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public void update(int id, Blog blog) {
//        blogRepository.update(id ,blog);
    }
}

package ru.geekbrains.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.model.Product;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

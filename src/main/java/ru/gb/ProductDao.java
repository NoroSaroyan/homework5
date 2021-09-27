package ru.gb;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductDao {

    private EntityManager entityManager;

    public ProductDao(DataBaseConnection dataBaseConnection) {
        this.entityManager = dataBaseConnection.getEntityManager();
    }

    public Product saveOrUpdate(Product product) {
        return product.getId() == null ? save(product) : update(product);
    }

    private Product save(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }

    private Product update(Product product) {
        Long id = product.getId();
        String title = product.getTitle();
        Integer price = product.getPrice();

        entityManager.getTransaction().begin();
        Product productUpdate = entityManager.find(Product.class, id);
        productUpdate.setTitle(title);
        productUpdate.setPrice(price);
        entityManager.merge(productUpdate);
        entityManager.getTransaction().commit();
        return product;
    }

    public Product findById(Long id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    public List<Product> findAll() {
        List<Product> products = entityManager
                .createQuery("select product from Product as product", Product.class)
                .getResultList();
        return products;
    }

    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Product.class, id));
        entityManager.getTransaction().commit();
    }

}
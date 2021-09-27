package ru.gb;

public class TestProductDaoApp {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        DataBaseConnection dc = new DataBaseConnection();
        ProductDao productDao = new ProductDao(dc);
        productDao.saveOrUpdate(new Product("AAA", 100));
        productDao.saveOrUpdate(new Product("BBB", 200));
        productDao.saveOrUpdate(new Product("CCC", 300));
        productDao.saveOrUpdate(new Product("DDD", 400));
        productDao.saveOrUpdate(new Product("EEE", 500));
        productDao.saveOrUpdate(new Product("FFF", 600));
        System.out.println(productDao.findAll());

        productDao.saveOrUpdate(new Product(9L, "AAA", 1000));
        System.out.println(productDao.findById(9L));

        productDao.deleteById(14L);
        System.out.println(productDao.findAll());

    }

}
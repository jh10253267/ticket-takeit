package com.tickettakeit.domain.category.dao.sqls;

public class CategorySqls {
    public static final String SELECT_ALL_CATEGORIES = "SELECT category.id, category.name, COUNT(*) AS count FROM category JOIN product ON category.id = product.category_id JOIN display_info ON display_info.product_id = product.id GROUP BY category.id";


}

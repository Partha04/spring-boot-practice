package com.example.inventory.specifications;

import com.example.inventory.model.Product;
import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Or({
        @Spec(path = "name", params = "name", spec = LikeIgnoreCase.class,defaultVal = ""),
        @Spec(path = "price", params = {"minPrice", "maxPrice"}, spec = Between.class),
        @Spec(path = "rating", params = {"minRating", "maxRating"}, spec = Between.class),
})
public interface ProductSpecification extends Specification<Product> {
}

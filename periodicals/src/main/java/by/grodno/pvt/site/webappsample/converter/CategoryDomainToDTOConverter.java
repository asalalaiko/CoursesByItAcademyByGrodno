package by.grodno.pvt.site.webappsample.converter;


import by.grodno.pvt.site.webappsample.domain.Category;
import by.grodno.pvt.site.webappsample.dto.CategoryDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryDomainToDTOConverter implements Converter <Category, CategoryDTO> {


    @Override
    public CategoryDTO convert(Category source) {

        CategoryDTO u = new CategoryDTO();
        u.setId(source.getId());
        u.setName(source.getName());

        return u;
    }

}
//    @Override
//    public CategoryDTO convert(Category source) {
//        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        MAPPER.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
//        return MAPPER.convertValue(source, CategoryDTO.class);
//    }
//}


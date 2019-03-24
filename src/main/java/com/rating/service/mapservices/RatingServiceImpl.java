package com.rating.service.mapservices;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rating.domain.Rating;
import com.rating.service.RatingService;

@Service
public class RatingServiceImpl extends AbstractMapService implements RatingService {

	@Override
	public List<?> findAll() {
		return super.listAll();
	}

	@Override
	public Rating getById(Integer id) {
		return (Rating) super.getById(id);
	}

	@Override
	public Rating saveOrUpdate(Rating domainObject) {
		return (Rating) super.saveOrUpdate(domainObject);
	}

	@Override
	public void delete(Integer id) {
		super.delete(id);
	}
	
	protected void loadDomainObjects(){
        domainMap = new HashMap<>();

        domainMap.put(1, new Rating.RatingBuilder(1).product(12)
        				.stars(4).comments("nice product, enjoyed using it")
        				.build());
        
        domainMap.put(2, new Rating.RatingBuilder(2).product(13)
				.stars(2).comments("defective product")
				.build());
        
        domainMap.put(3, new Rating.RatingBuilder(3).product(14)
				.stars(5).comments("excellent product")
				.build());
        
	}

}

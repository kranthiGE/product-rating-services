package com.rating.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rating.domain.Rating;
import com.rating.service.RatingService;

/**
 * Created by kranthi
 */

@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

	private RatingService ratingService;

	@Autowired
	public void setProductService(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		loadRatings();
	}

	private void loadRatings(){

        ratingService.saveOrUpdate(new Rating.RatingBuilder(1).product(12)
        				.productVersion(1.0f)
        				.stars(4).comments("nice product, enjoyed using it")
        				.build());
        
        ratingService.saveOrUpdate(new Rating.RatingBuilder(2).product(13)
        			.productVersion(2.1f)
				.stars(2).comments("defective product")
				.build());
        
        ratingService.saveOrUpdate(new Rating.RatingBuilder(3).product(14)
        			.productVersion(3.2f)
				.stars(5).comments("excellent product")
				.build());
	}
	
}

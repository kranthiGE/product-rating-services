package com.rating.domain;

public class Rating implements DomainObject {

	private Integer id;
	
	private float version;
	
	private Integer productId;
	
	private Integer stars;
	
	private String comments;
	
	private Rating(RatingBuilder ratingBuilder) {
		this.id = ratingBuilder.id;
		this.version = ratingBuilder.productVersion;
		this.productId = ratingBuilder.productId;
		this.stars = ratingBuilder.stars;
		this.comments = ratingBuilder.comments;
	}
	
    public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the stars
	 */
	public Integer getStars() {
		return stars;
	}

	/**
	 * @param stars the stars to set
	 */
	public void setStars(Integer stars) {
		this.stars = stars;
	}

	

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public static class RatingBuilder {
		
		private Integer id;
		private Integer productId;
		private float productVersion;
		private Integer stars;
		private String comments;
		
		public RatingBuilder(Integer id) {
			this.id = id;
		}
		
		public RatingBuilder product(Integer productId) {
			this.productId = productId;
			return this;
		}
		
		public RatingBuilder productVersion(float productVersion) {
			this.productVersion = productVersion;
			return this;
		}
		
		public RatingBuilder stars(Integer stars) {
			if(stars > 5)
				throw new IllegalArgumentException("stars cant be more than 5");
			this.stars = stars;
			return this;
		}
		
		public RatingBuilder comments(String comments) {
			this.comments = comments;
			return this;
		}
		
		public Rating build() {
			Rating rating = new Rating(this);
			return rating;
		}
		
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((stars == null) ? 0 : stars.hashCode());
		result = prime * result + Float.floatToIntBits(version);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (stars == null) {
			if (other.stars != null)
				return false;
		} else if (!stars.equals(other.stars))
			return false;
		if (Float.floatToIntBits(version) != Float.floatToIntBits(other.version))
			return false;
		return true;
	}
	
}

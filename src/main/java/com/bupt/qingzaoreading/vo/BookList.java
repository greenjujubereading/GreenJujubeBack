package com.bupt.qingzaoreading.vo;

import java.util.Date;

public class BookList {

	
	 private Long video_id;
	 
	 private String video_cover_url;
	 
	 private String name;

	 private String short_introduction;
	 
	 private String video_type;

	  private String video_year;
	  
	  private Long number_of_readers;

	    private Date time;

		public Long getVideo_id() {
			return video_id;
		}

		public void setVideo_id(Long video_id) {
			this.video_id = video_id;
		}

		public String getVideo_cover_url() {
			return video_cover_url;
		}

		public void setVideo_cover_url(String video_cover_url) {
			this.video_cover_url = video_cover_url;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getShort_introduction() {
			return short_introduction;
		}

		public void setShort_introduction(String short_introduction) {
			this.short_introduction = short_introduction;
		}

		public String getVideo_type() {
			return video_type;
		}

		public void setVideo_type(String video_type) {
			this.video_type = video_type;
		}

		public String getVideo_year() {
			return video_year;
		}

		public void setVideo_year(String video_year) {
			this.video_year = video_year;
		}

		public Long getNumber_of_readers() {
			return number_of_readers;
		}

		public void setNumber_of_readers(Long number_of_readers) {
			this.number_of_readers = number_of_readers;
		}

		public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}
	    
	    
}
